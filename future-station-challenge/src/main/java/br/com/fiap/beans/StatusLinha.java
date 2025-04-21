package br.com.fiap.beans;

import br.com.fiap.service.StatusLinhaService;

import javax.swing.*;

public class StatusLinha {

    private String nome;
    private String status;
    private String estacao;

    public StatusLinha() {
        super();
    }

    public StatusLinha(String nome, String status, String estacao) {
        super();
        this.nome = nome;
        this.status = status;
        this.estacao = estacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public static void menuInformacoesLinhas() {
        String[] opcoes = {"Linha 4 - Amarela", "Linha 8 - Diamante", "Linha 9 - Esmeralda", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Selecione a linha:", "Informações das Linhas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0 -> StatusLinhaService.mostrarStatusPorLinha("Linha 4 Amarela");
            case 1 -> StatusLinhaService.mostrarStatusPorLinha("Linha 8 Diamante");
            case 2 -> StatusLinhaService.mostrarStatusPorLinha("Linha 9 Esmeralda");
            case 3, -1 -> {
                return;
            }
            default -> menuInformacoesLinhas();
        }

        menuInformacoesLinhas();
    }

    @Override
    public String toString() {
        return "=== Status da Linha ===" +
                "Nome: " + nome +
                "Status:" + status +
                "Estação: " + estacao;
    }
}
