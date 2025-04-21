package br.com.fiap.beans;

import br.com.fiap.dao.ViagemDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

import static br.com.fiap.main.Main.usuarioLogado;

public class Relatorio {

    private int id;
    private List<Viagem> viagens;
    private StatusLinha dadosHistorico;
    private Estacao estacao;
    private Usuario usuario;

    public Relatorio() {
        super();
    }

    public Relatorio(int id, List<Viagem> viagens, StatusLinha dadosHistorico, Estacao estacao, Usuario usuario) {
        super();
        this.id = id;
        this.viagens = viagens;
        this.dadosHistorico = dadosHistorico;
        this.estacao = estacao;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(List<Viagem> viagens) {
        this.viagens = viagens;
    }

    public StatusLinha getDadosHistorico() {
        return dadosHistorico;
    }

    public void setDadosHistorico(StatusLinha dadosHistorico) {
        this.dadosHistorico = dadosHistorico;
    }

    public Estacao getEstacao() {
        return estacao;
    }

    public void setEstacao(Estacao estacao) {
        this.estacao = estacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // relatorio
    public static void exibirRelatorioViagens() throws SQLException, ClassNotFoundException {
        ViagemDAO viagemDAO = new ViagemDAO();
        List<Viagem> viagens = viagemDAO.buscarPorUsuarioSimples(usuarioLogado.getId());

        if (viagens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem encontrada.");
            return;
        }

        StringBuilder relatorio = new StringBuilder("RELATÓRIO DE VIAGENS:\n\n");

        for (Viagem v : viagens) {
            relatorio.append("Origem: ").append(v.getEstacaoOrigem().getNome()).append("\n")
                    .append("Destino: ").append(v.getEstacaoDestino().getNome()).append("\n")
                    .append("Partida: ").append(v.gethPartida()).append("\n")
                    .append("Chegada: ").append(v.gethChegadaEstimada()).append("\n")
                    .append("----------------------------------------\n");
        }

        JOptionPane.showMessageDialog(null, relatorio.toString());
    }

    @Override
    public String toString() {
        return "=== Relatório ===" +
                "id: " + id +
                "\nviagen: " + viagens +
                "\ndadosHistoric: " + dadosHistorico +
                "\nestacao: " + estacao +
                "\nusuario: " + usuario;
    }
}
