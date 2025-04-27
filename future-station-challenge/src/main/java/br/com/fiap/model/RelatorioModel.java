package br.com.fiap.model;

import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;

import java.time.LocalDateTime;
import java.util.List;

public class RelatorioModel {

    private int idRelatorio;
    private Usuario usuario;
    private List<Viagem> viagens;
    private LocalDateTime dataGeracao;

    // Construtores, getters e setters
    public RelatorioModel(int idRelatorio, Usuario usuario, List<Viagem> viagens, LocalDateTime dataGeracao) {
        this.idRelatorio = idRelatorio;
        this.usuario = usuario;
        this.viagens = viagens;
        this.dataGeracao = dataGeracao;
    }

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(LocalDateTime dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    @Override
    public String toString() {
        return "Relatorio [idRelatorio=" + idRelatorio + ", usuario=" + usuario.getNome() + ", dataGeracao=" + dataGeracao + "]";
    }
}
