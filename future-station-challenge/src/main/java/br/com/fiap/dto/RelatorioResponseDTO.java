package br.com.fiap.dto;

import java.util.List;

public class RelatorioResponseDTO {

    private int usuarioId;
    private String nomeUsuario;
    private List<ViagemResponseDTO> viagens;

    // Construtor completo
    public RelatorioResponseDTO(int usuarioId, String nomeUsuario, List<ViagemResponseDTO> viagens) {
        this.usuarioId = usuarioId;
        this.nomeUsuario = nomeUsuario;
        this.viagens = viagens;
    }

    // Getters e Setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<ViagemResponseDTO> getViagens() {
        return viagens;
    }

    public void setViagens(List<ViagemResponseDTO> viagens) {
        this.viagens = viagens;
    }
}
