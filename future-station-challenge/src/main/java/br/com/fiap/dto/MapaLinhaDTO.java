package br.com.fiap.dto;

import java.util.List;

public class MapaLinhaDTO {

    private String linha;
    private List<String> estacoes;

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
        return "Linha: " + linha + "\nEstações: " + estacoes;
    }
}
