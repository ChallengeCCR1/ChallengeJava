package br.com.fiap.beans;

import java.time.LocalDateTime;

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

    @Override
    public String toString() {
        return "PrevisaoPico{" +
                "id=" + id +
                ", horarioPicoPrevisto=" + horarioPicoPrevisto +
                ", estacao=" + estacao +
                '}';
    }
}
