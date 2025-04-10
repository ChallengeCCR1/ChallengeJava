package br.com.fiap.beans;

import java.util.List;

public class Relatorio {

    private int id;
    private List<Viagem> viagens;
    private DadosHistorico dadosHistorico;
    private Estacao estacao;
    private Usuario usuario;

    public Relatorio() {
        super();
    }

    public Relatorio(int id, List<Viagem> viagens, DadosHistorico dadosHistorico, Estacao estacao, Usuario usuario) {
        super();
        this.id = id;
        this.viagens = viagens;
        this.dadosHistorico = dadosHistorico;
        this.estacao = estacao;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public DadosHistorico getDadosHistorico() {
        return dadosHistorico;
    }

    public void setDadosHistorico(DadosHistorico dadosHistorico) {
        this.dadosHistorico = dadosHistorico;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "id=" + id +
                ", viagens=" + viagens +
                ", dadosHistorico=" + dadosHistorico +
                ", estacao=" + estacao +
                ", usuario=" + usuario +
                '}';
    }
}
