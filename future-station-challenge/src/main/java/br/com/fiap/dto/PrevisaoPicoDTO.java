package br.com.fiap.dto;

public class PrevisaoPicoDTO {

    public String estacao;
    public String horario;
    public String status;

    public PrevisaoPicoDTO() {
        super();
    }

    public PrevisaoPicoDTO(String estacao, String horario, String status) {
        super();
        this.estacao = estacao;
        this.horario = horario;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
