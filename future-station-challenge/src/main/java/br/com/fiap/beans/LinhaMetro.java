package br.com.fiap.beans;

import java.util.List;

public class LinhaMetro {

    private int id;
    private String nome;
    private double extensao;
    private List<Estacao> estacoes;
    private int numero;
    private String tipo;
    private String responsavel;
    private String descricao;

    public LinhaMetro() {
        super();
    }

    public LinhaMetro(int id, String nome, double extensao, List<Estacao> estacoes, int numero, String tipo, String responsavel, String descricao) {
        super();
        this.id = id;
        this.nome = nome;
        this.extensao = extensao;
        this.estacoes = estacoes;
        this.numero = numero;
        this.tipo = tipo;
        this.responsavel = responsavel;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getExtensao() {
        return extensao;
    }

    public void setExtensao(double extensao) {
        this.extensao = extensao;
    }

    public List<Estacao> getEstacoes() {
        return estacoes;
    }

    public void setEstacoes(List<Estacao> estacoes) {
        this.estacoes = estacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "=== Linha de Metro ===" +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nExtensão: " + extensao +
                "\nEstaõe: " + estacoes +
                "\nNúmero: " + numero +
                "\nTipo: " + tipo +
                "\nResponsável: " + responsavel +
                "\nDescrição: " + descricao;
    }
}
