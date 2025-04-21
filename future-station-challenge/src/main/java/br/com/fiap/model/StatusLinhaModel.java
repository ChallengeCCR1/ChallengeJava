package br.com.fiap.model;

public class StatusLinhaModel {

    private String nome;
    private String status;

    public StatusLinhaModel() {
         super();
    }

    public StatusLinhaModel(String nome, String status) {
        super();
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

    @Override
    public String toString() {
        return "=== Status da Linha === " +
                "Nome: " + nome +
                "Status: " + status;
    }
}
