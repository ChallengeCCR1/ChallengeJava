package br.com.fiap.dto;

import java.util.List;

public class RelatorioDTO {

    private int idUsuario;
    private List<Integer> idViagens;

    // Construtores, getters e setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Integer> getIdViagens() {
        return idViagens;
    }

    public void setIdViagens(List<Integer> idViagens) {
        this.idViagens = idViagens;
    }
}