package br.com.fiap.beans;

import br.com.fiap.model.PrevisaoPicoModel;
import br.com.fiap.service.PrevisaoPicoService;
import br.com.fiap.util.UtilImagem;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static br.com.fiap.main.Main.menuPrincipal;

public class PrevisaoPico {

    private int id;
    private LocalDateTime horarioPicoPrevisto;
    private Estacao estacao;

    public PrevisaoPico() {
        super();
    }

    public PrevisaoPico(int id, LocalDateTime horarioPicoPrevisto, Estacao estacao) {
        super();
        this.id = id;
        this.horarioPicoPrevisto = horarioPicoPrevisto;
        this.estacao = estacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getHorarioPicoPrevisto() {
        return horarioPicoPrevisto;
    }

    public void setHorarioPicoPrevisto(LocalDateTime horarioPicoPrevisto) {
        this.horarioPicoPrevisto = horarioPicoPrevisto;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    private static PrevisaoPicoService previsaoService = new PrevisaoPicoService();

    public static void menuPrevisaoPico() throws SQLException, ClassNotFoundException {
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

    @Override
    public String toString() {
        return "PrevisaoPico{" +
                "id=" + id +
                ", horarioPicoPrevisto=" + horarioPicoPrevisto +
                ", estacao=" + estacao +
                '}';
    }
}
