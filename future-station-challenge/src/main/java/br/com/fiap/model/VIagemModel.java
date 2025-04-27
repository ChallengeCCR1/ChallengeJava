package br.com.fiap.model;

public class ViagemModel {

    private String estacaoOrigem;
    private String estacaoDestino;
    private int idUsuario;

    public ViagemModel() {
        super();
    }

    public ViagemModel(String estacaoOrigem, String estacaoDestino, int idUsuario) {
        super();
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "ViagemModel{" +
                "estacaoOrigem='" + estacaoOrigem + '\'' +
                ", estacaoDestino='" + estacaoDestino + '\'' +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
