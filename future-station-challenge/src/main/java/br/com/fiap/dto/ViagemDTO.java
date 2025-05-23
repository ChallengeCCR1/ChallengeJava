package br.com.fiap.dto;

public class ViagemDTO {

    private int usuarioId;
    private int estacaoOrigemId;
    private int estacaoDestinoId;
    private String hPartida;

    public ViagemDTO() {}

    public ViagemDTO(int usuarioId, int estacaoOrigemId, int estacaoDestinoId, String hPartida) {
        super();
        this.usuarioId = usuarioId;
        this.estacaoOrigemId = estacaoOrigemId;
        this.estacaoDestinoId = estacaoDestinoId;
        this.hPartida = hPartida;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEstacaoOrigemId() {
        return estacaoOrigemId;
    }

    public void setEstacaoOrigemId(int estacaoOrigemId) {
        this.estacaoOrigemId = estacaoOrigemId;
    }

    public int getEstacaoDestinoId() {
        return estacaoDestinoId;
    }

    public void setEstacaoDestinoId(int estacaoDestinoId) {
        this.estacaoDestinoId = estacaoDestinoId;
    }

    public String gethPartida() {
        return hPartida;
    }

    public void sethPartida(String hPartida) {
        this.hPartida = hPartida;
    }
}