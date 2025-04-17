package br.com.fiap.model;

public class PrevisaoPicoModel {

    private String estacao;
    private String horario;
    private String graficoBase64;

    public PrevisaoPicoModel() {
        super();
    }

    public PrevisaoPicoModel(String estacao, String horario, String graficoBase64) {
        super();
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

    public String getGraficoBase64() {
        return graficoBase64;
    }

    public void setGraficoBase64(String graficoBase64) {
        this.graficoBase64 = graficoBase64;
    }

    @Override
    public String toString() {
        return "PrevisaoPico{" +
                "estacao='" + estacao + '\'' +
                ", horario='" + horario + '\'' +
                ", graficoBase64='" + graficoBase64 + '\'' +
                '}';
    }
}
