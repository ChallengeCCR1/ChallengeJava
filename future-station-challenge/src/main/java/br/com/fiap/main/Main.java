package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.model.PrevisaoPicoModel;
import br.com.fiap.service.MapaLinhaService;
import br.com.fiap.service.PrevisaoPicoService;
import br.com.fiap.util.UtilImagem;

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

    private static PrevisaoPicoService previsaoService = new PrevisaoPicoService();

    // menu principal
    private static void menuPrincipal() throws SQLException, ClassNotFoundException {
        String[] opcoes;

        if (viagemEmAndamento == null) {
            opcoes = new String[]{
                    "Ver Mapa da Linha 9",
                    "Registrar Viagem",
                    "Relatório",
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
                MapaLinhaService.mostrarMapaLinha9();
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
                menuPrevisaoPico();
                break;
            case 4:
                atualizarPerfil();
                menuPrincipal();
                break;
            case 5:
                deletarConta();
                break;
            case 6:
                usuarioLogado = null;
                menuInicial();
                break;
            default:
                menuPrincipal();
                break;
        }
    }

    private static void menuPrevisaoPico() throws SQLException, ClassNotFoundException {
        String[] opcoes = {
                "Pico horário atual",            // Opção para pico horário atual
                "Pico em um horário determinado", // Opção para pico em horário específico
                "Gerar gráfico",                 // Opção para gerar gráfico
                "Voltar ao menu principal"       // Opção para voltar ao menu principal
        };

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Previsão de Pico", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                // Lógica para obter pico no horário atual
                obterPicoHorarioAtual();
                menuPrevisaoPico();
                break;
            case 1:
                // Lógica para obter pico em um horário determinado
                obterPicoEmHorarioDeterminado();
                menuPrevisaoPico();
                break;
            case 2:
                // Lógica para gerar gráfico
                gerarGrafico();
                menuPrevisaoPico();
                break;
            case 3:
                menuPrincipal();
                break;
            default:
                menuPrevisaoPico();
                break;
        }
    }

    private static void obterPicoHorarioAtual() {
        String estacao = JOptionPane.showInputDialog("Informe a estação:");
        if (estacao != null && !estacao.isEmpty()) {
            // Chama o serviço para obter o pico no horário atual
            PrevisaoPicoModel picoAtual = previsaoService.obterPrevisaoPico(estacao, null);
            if (picoAtual != null) {
                JOptionPane.showMessageDialog(null, "Previsão de pico na estação " + picoAtual.getEstacao() + " no horário atual: " + picoAtual.getHorario());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao obter a previsão de pico.");
            }
        }
    }

    private static void obterPicoEmHorarioDeterminado() {
        String estacao = JOptionPane.showInputDialog("Informe a estação:");
        String horario = JOptionPane.showInputDialog("Informe o horário (ex: 14:00):");
        if (estacao != null && !estacao.isEmpty() && horario != null && !horario.isEmpty()) {
            // Chama o serviço para obter o pico no horário determinado
            PrevisaoPicoModel picoHorario = previsaoService.obterPrevisaoPico(estacao, horario);
            if (picoHorario != null) {
                JOptionPane.showMessageDialog(null, "Previsão de pico na estação " + picoHorario.getEstacao() + " às " + picoHorario.getHorario());
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao obter a previsão de pico.");
            }
        }
    }

    private static void gerarGrafico() {
        // Pergunta ao usuário qual estação ele quer consultar
        String estacao = JOptionPane.showInputDialog("Digite o nome da estação para gerar o gráfico de pico:");

        if (estacao != null && !estacao.isEmpty()) {
            // Chama o serviço para gerar o gráfico
            PrevisaoPicoService service = new PrevisaoPicoService();
            String base64Grafico = service.gerarGrafico(estacao);

            // Converte a base64 em imagem
            ImageIcon imagem = UtilImagem.converterBase64ParaImageIcon(base64Grafico);

            // Exibe a imagem em um JOptionPane
            if (imagem != null) {
                JOptionPane.showMessageDialog(null, "", "Gráfico de Pico - " + estacao, JOptionPane.INFORMATION_MESSAGE, imagem);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o gráfico.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Estação não informada.");
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
