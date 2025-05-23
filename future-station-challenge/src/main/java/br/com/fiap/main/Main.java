package br.com.fiap.main;

import br.com.fiap.beans.PrevisaoPico;
import br.com.fiap.beans.StatusLinha;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dto.MapaLinhaDTO;
import br.com.fiap.service.MapaLinhaService;

import javax.swing.*;
import java.sql.SQLException;

import static br.com.fiap.beans.Relatorio.exibirRelatorioViagens;
import static br.com.fiap.beans.Viagem.finalizarViagem;
import static br.com.fiap.beans.Viagem.iniciarViagem;

public class Main {

    public static Usuario usuarioLogado = null;
    private static UsuarioDAO usuarioDAO;

    public static void main(String[] args) {

        try {
            usuarioDAO = new UsuarioDAO();
            menuInicial();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar: " + e.getMessage());
        }
    }

    // menu inicial, antes da aplicação em si
    private static void menuInicial() {
        String[] opcoes = {"Login", "Cadastrar", "Sair"};
        int escolha = JOptionPane.showOptionDialog(null, "Bem-vindo!\nEscolha uma opção:",
                "Sistema CCR", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0 -> realizarLogin();
            case 1 -> realizarCadastro();
            case 2 -> System.exit(0);
            default -> menuInicial();
        }
    }

    // realizar cadastro
    private static void realizarCadastro() {
        try {
            String nome = JOptionPane.showInputDialog("Digite seu nome:");
            String email = JOptionPane.showInputDialog("Digite seu email:");
            String senha = JOptionPane.showInputDialog("Digite sua senha:");

            Usuario novoUsuario = new Usuario(0, nome, email, senha);
            String msg = usuarioDAO.inserir(novoUsuario);
            JOptionPane.showMessageDialog(null, msg);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro: " + e.getMessage());
        }

        menuInicial();
    }

    // realizar login
    private static void realizarLogin() {
        try {
            String email = JOptionPane.showInputDialog("Digite seu email:");
            String senha = JOptionPane.showInputDialog("Digite sua senha:");

            usuarioLogado = usuarioDAO.selecionar(email, senha);

            if (usuarioLogado != null) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!\nBem-vindo, " + usuarioLogado.getNome());
                menuPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha inválidos.");
                menuInicial();
            }

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro no login: " + e.getMessage());
            menuInicial();
        }
    }

    // chamando 'viagemEmAndamento' da classe Viagem
    private static Viagem viagemEmAndamento = null;

    // menu principal
    public static void menuPrincipal() throws SQLException, ClassNotFoundException {
        String[] opcoes;

        if (viagemEmAndamento == null) {
            opcoes = new String[]{
                    "Ver Mapa da Linha 9",
                    "Registrar Viagem",
                    "Relatório",
                    "Status da Linha",
                    "Previsão de Pico",
                    "Atualizar Perfil",
                    "Deletar Conta",
                    "Logout"
            };
        } else {
            opcoes = new String[]{
                    "Ver Mapa da Linha 9",
                    "Finalizar viagem",
                    "Relatório",
                    "Status da Linha",
                    "Previsão de Pico",
                    "Atualizar Perfil",
                    "Deletar Conta",
                    "Logout"
            };
        }

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                MapaLinhaService service = new MapaLinhaService();
                MapaLinhaDTO dto = service.mostrarMapaLinha9();

                if (dto != null) {
                    System.out.println("Linha: " + dto.getLinha());
                    System.out.println("Estações: " + dto.getEstacoes());
                } else {
                    System.out.println("❌ Não foi possível obter o mapa da linha 9.");
                }

                menuPrincipal();
                break;
            case 1:
                if (viagemEmAndamento == null) {
                    iniciarViagem();
                } else {
                    finalizarViagem();
                }
                menuPrincipal();
                break;
            case 2:
                exibirRelatorioViagens();
                menuPrincipal();
                break;
            case 3:
                StatusLinha.menuInformacoesLinhas();
                menuPrincipal();
                break;
            case 4:
                PrevisaoPico.menuPrevisaoPico();
                break;
            case 5:
                atualizarPerfil();
                menuPrincipal();
                break;
            case 6:
                deletarConta();
                break;
            case 7:
                usuarioLogado = null;
                menuInicial();
                break;
            default:
                menuPrincipal();
                break;
        }
    }

    // atualizar perfil
    private static void atualizarPerfil() {
        if (usuarioLogado == null) {
            JOptionPane.showMessageDialog(null, "Você precisa estar logado.");
            return;
        }

        try {
            String nomeAntigo = usuarioLogado.getNome();

            String novoNome = JOptionPane.showInputDialog("Novo nome:", nomeAntigo);
            String novoEmail = JOptionPane.showInputDialog("Novo email:", usuarioLogado.getEmail());
            String novaSenha = JOptionPane.showInputDialog("Nova senha:");

            usuarioLogado.setNome(novoNome);
            usuarioLogado.setEmail(novoEmail);
            usuarioLogado.setSenha(novaSenha);

            String msg = usuarioDAO.atualizar(usuarioLogado, nomeAntigo);

            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        }
    }

    // deletar conta
    private static void deletarConta() throws SQLException, ClassNotFoundException {
        if (usuarioLogado == null) {
            JOptionPane.showMessageDialog(null, "Você precisa estar logado.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar sua conta?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String msg = usuarioDAO.deletar(usuarioLogado.getNome());
                JOptionPane.showMessageDialog(null, msg);
                usuarioLogado = null;
                menuInicial();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
            }
        } else {
            menuPrincipal();
        }
    }
}
