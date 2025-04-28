package br.com.fiap.dto;

public class ViagemResponseDTO {

    private int id;
    private String estacaoOrigem;
    private String estacaoDestino;
    private String hPartida;
    private String hChegadaEstimada;
    private String usuarioNome;

    // Construtor
    public ViagemResponseDTO(int id, String estacaoOrigem, String estacaoDestino, String hPartida, String hChegadaEstimada, String usuarioNome) {
        this.id = id;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.hPartida = hPartida;
        this.hChegadaEstimada = hChegadaEstimada;
        this.usuarioNome = usuarioNome;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstacaoOrigem() {
        return estacaoOrigem;
    }

    public void setEstacaoOrigem(String estacaoOrigem) {
        this.estacaoOrigem = estacaoOrigem;
    }

    public String getEstacaoDestino() {
        return estacaoDestino;
    }

    public void setEstacaoDestino(String estacaoDestino) {
        this.estacaoDestino = estacaoDestino;
    }

    public String gethPartida() {
        return hPartida;
    }

    public void sethPartida(String hPartida) {
        this.hPartida = hPartida;
    }

    public String gethChegadaEstimada() {
        return hChegadaEstimada;
    }

    public void sethChegadaEstimada(String hChegadaEstimada) {
        this.hChegadaEstimada = hChegadaEstimada;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}