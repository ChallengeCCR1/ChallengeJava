package br.com.fiap.dto;

public class StatusLinhaResponseDTO {
    private String nome;
    private String status;

    public StatusLinhaResponseDTO() {}

    public StatusLinhaResponseDTO(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
