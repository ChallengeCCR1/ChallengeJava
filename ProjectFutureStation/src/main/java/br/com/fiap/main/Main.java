package br.com.fiap.main;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.ViagemDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    private static Usuario usuarioLogado = null;
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

    // menu principal
    private static void menuPrincipal() throws SQLException, ClassNotFoundException {
        String[] opcoes;

        if (viagemEmAndamento == null) {
            opcoes = new String[]{"Registrar Viagem", "Relatório", "Atualizar Perfil", "Deletar Conta", "Logout"};
        } else {
            opcoes = new String[]{"Finalizar Viagem", "Relatório", "Atualizar Perfil", "Deletar Conta", "Logout"};
        }

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "Menu Principal", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:
                if (viagemEmAndamento == null) {
                    iniciarViagem();
                } else {
                    finalizarViagem();
                }
                menuPrincipal();
                break;
            case 1:
                exibirRelatorioViagens();
                menuPrincipal();
                break;
            case 2:
                atualizarPerfil();
                menuPrincipal();
                break;
            case 3:
                deletarConta();
                break;
            case 4:
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

    // viagem
    private static Viagem viagemEmAndamento = null;

    private static void iniciarViagem() {
        try {
            String estacaoOrigem = JOptionPane.showInputDialog("Estação de origem:");
            String estacaoDestino = JOptionPane.showInputDialog("Estação de destino:");

            EstacaoDAO estacaoDAO = new EstacaoDAO();
            Estacao origem = estacaoDAO.buscarPorNome(estacaoOrigem);
            Estacao destino = estacaoDAO.buscarPorNome(estacaoDestino);

            if (origem == null || destino == null) {
                JOptionPane.showMessageDialog(null, "Estação não encontrada.");
                return;
            }

            LocalDateTime hPartida = LocalDateTime.now();
            viagemEmAndamento = new Viagem(0, hPartida, null, origem, destino, usuarioLogado);

            int opcao = JOptionPane.showOptionDialog(null,
                    "Viagem iniciada de " + origem.getNome() + " para " + destino.getNome() + ".",
                    "Viagem em andamento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Finalizar Viagem", "Cancelar"},
                    "Finalizar Viagem");

            if (opcao == 0) { // Finalizar Viagem
                finalizarViagem();
            } else {
                JOptionPane.showMessageDialog(null, "Viagem ainda em andamento.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar viagem: " + e.getMessage());
        }
    }

    private static void finalizarViagem() {
        if (viagemEmAndamento == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem em andamento.");
            return;
        }

        try {
            LocalDateTime hChegada = LocalDateTime.now();
            viagemEmAndamento.sethChegadaEstimada(hChegada);

            ViagemDAO viagemDAO = new ViagemDAO();
            String msg = viagemDAO.inserir(viagemEmAndamento);

            JOptionPane.showMessageDialog(null, msg);
            viagemEmAndamento = null; // limpar após salvar
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar viagem: " + e.getMessage());
        }
    }


    // relatorio
    private static void exibirRelatorioViagens() throws SQLException, ClassNotFoundException {
        ViagemDAO viagemDAO = new ViagemDAO();
        List<Viagem> viagens = viagemDAO.buscarPorUsuarioSimples(usuarioLogado.getId());

        if (viagens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem encontrada.");
            return;
        }

        StringBuilder relatorio = new StringBuilder("RELATÓRIO DE VIAGENS:\n\n");

        for (Viagem v : viagens) {
            relatorio.append("Origem: ").append(v.getEstacaoOrigem().getNome()).append("\n")
                    .append("Destino: ").append(v.getEstacaoDestino().getNome()).append("\n")
                    .append("Partida: ").append(v.gethPartida()).append("\n")
                    .append("Chegada: ").append(v.gethChegadaEstimada()).append("\n")
                    .append("----------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

}
