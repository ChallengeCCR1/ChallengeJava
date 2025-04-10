package br.com.fiap.beans;

import java.time.LocalDateTime;

public class Viagem {

    private int id;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private LocalDateTime hChegadaEstimada;
    private LocalDateTime hPartida;
    private Usuario usuario;

    public Viagem() {
        super();
    }

    public Viagem(int id, LocalDateTime hPartida, LocalDateTime hChegadaEstimada, Estacao estacaoOrigem, Estacao estacaoDestino, Usuario usuario) {
        super();
        this.id = id;
        this.hPartida = hPartida;
        this.hChegadaEstimada = hChegadaEstimada;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estacao getEstacaoOrigem() {
        return estacaoOrigem;
    }

    public void setEstacaoOrigem(Estacao estacaoOrigem) {
        this.estacaoOrigem = estacaoOrigem;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public void setEstacaoDestino(Estacao estacaoDestino) {
        this.estacaoDestino = estacaoDestino;
    }

    public LocalDateTime gethChegadaEstimada() {
        return hChegadaEstimada;
    }

    public void sethChegadaEstimada(LocalDateTime hChegadaEstimada) {
        this.hChegadaEstimada = hChegadaEstimada;
    }

    public LocalDateTime gethPartida() {
        return hPartida;
    }

    public void sethPartida(LocalDateTime hPartida) {
        this.hPartida = hPartida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "=== Viagem ===" +
                "\nid: " + id +
                "\nestacao Origem: " + estacaoOrigem +
                "\nestacao Destino: " + estacaoDestino +
                "\nhChegada Estimada: " + hChegadaEstimada +
                "\nPartida: " + hPartida +
                "\nusuario: " + usuario;
    }
}
