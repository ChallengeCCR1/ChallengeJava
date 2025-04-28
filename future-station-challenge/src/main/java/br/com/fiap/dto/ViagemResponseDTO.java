package br.com.fiap.dto;

public class ViagemResponseDTO {

    private int id;
    private String estacaoOrigem;
    private String estacaoDestino;
    private String horarioPartida;
    private String horarioChegadaEstimada;
    private String nomeUsuario;

    public ViagemResponseDTO() {
    }

    public ViagemResponseDTO(int id, String estacaoOrigem, String estacaoDestino, String horarioPartida, String horarioChegadaEstimada, String nomeUsuario) {
        this.id = id;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.horarioPartida = horarioPartida;
        this.horarioChegadaEstimada = horarioChegadaEstimada;
        this.nomeUsuario = nomeUsuario;
    }

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

    public String getHorarioPartida() {
        return horarioPartida;
    }

    public void setHorarioPartida(String horarioPartida) {
        this.horarioPartida = horarioPartida;
    }

    public String getHorarioChegadaEstimada() {
        return horarioChegadaEstimada;
    }

    public void setHorarioChegadaEstimada(String horarioChegadaEstimada) {
        this.horarioChegadaEstimada = horarioChegadaEstimada;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
