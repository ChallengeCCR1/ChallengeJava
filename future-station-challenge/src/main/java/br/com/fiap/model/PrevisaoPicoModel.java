package br.com.fiap.model;

import com.google.gson.annotations.SerializedName;

public class PrevisaoPicoModel {

    private String estacao;
    private String horario;
    private int passageiros;

    @SerializedName("grafico_base64")
    private String graficoBase64;

    public PrevisaoPicoModel() {
        super();
    }

    public PrevisaoPicoModel(String estacao, String horario, int passageiros, String graficoBase64) {
        super();
        this.passageiros = passageiros;
        this.estacao = estacao;
        this.horario = horario;
        this.graficoBase64 = graficoBase64;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(int passageiros) {
        this.passageiros = passageiros;
    }

    public String getGraficoBase64() {
        return graficoBase64;
    }

    public void setGraficoBase64(String graficoBase64) {
        this.graficoBase64 = graficoBase64;
    }

    @Override
    public String toString() {
        return "PrevisaoPicoModel{" +
                "estacao='" + estacao + '\'' +
                ", horario='" + horario + '\'' +
                ", passageiros=" + passageiros +
                ", graficoBase64='" + graficoBase64 + '\'' +
                '}';
    }
}
