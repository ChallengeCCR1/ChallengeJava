package br.com.fiap.model;

import java.util.List;

public class MapaLinha {

    // visibilidade, tipo de dados e atributos
    private String linha;
    private List<String> estacoes;

    public MapaLinha() {
        super();
    }

    public MapaLinha(String linha, List<String> estacoes) {
        super();
        this.linha = linha;
        this.estacoes = estacoes;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public List<String> getEstacoes() {
        return estacoes;
    }

    public void setEstacoes(List<String> estacoes) {
        this.estacoes = estacoes;
    }

    @Override
    public String toString() {
        return "=== Mapa da Linha ===" +
                "Linha:" + linha +
                "\nEstações: " + estacoes;
    }
}
