package br.com.fiap.beans;

public class Alerta {

    private int id;
    private String mensagem;
    private String tipo;
    private Estacao estacao;

    public Alerta() {
        super();
    }

    public Alerta(int id, String mensagem, String tipo, Estacao estacao) {
        super();
        this.id = id;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.estacao = estacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    @Override
    public String toString() {
        return "=== Alerta ===" +
                "\nid: " + id +
                "\nmensagem: " + mensagem +
                "\ntipo: " + tipo +
                "\nestacao: " + estacao;
    }
}