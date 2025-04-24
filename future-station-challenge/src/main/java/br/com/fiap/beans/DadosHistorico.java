package br.com.fiap.beans;

import java.time.LocalDateTime;

public class DadosHistorico {

    private LocalDateTime dataHora;
    private Estacao estacao;

    public DadosHistorico() {
        super();
    }

    public DadosHistorico(LocalDateTime dataHora, Estacao estacao) {
        super();
        this.dataHora = dataHora;
        this.estacao = estacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    @Override
    public String toString() {
        return "=== Dados Histórico ===" +
                "\nData/Hora: " + dataHora +
                "\nEstação: " + estacao;
    }
}
