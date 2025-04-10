package br.com.fiap.beans;

import java.time.LocalDateTime;

public class DadosHistorico {

    private int id;
    private LocalDateTime dataHora;
    private Estacao estacao;

    public DadosHistorico() {
        super();
    }

    public DadosHistorico(int id, LocalDateTime dataHora, Estacao estacao) {
        super();
        this.id = id;
        this.dataHora = dataHora;
        this.estacao = estacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "DadosHistorico{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", estacao=" + estacao +
                '}';
    }
}
