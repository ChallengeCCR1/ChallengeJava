package br.com.fiap.beans;

import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.dao.ViagemDAO;

import javax.swing.*;
import java.time.LocalDateTime;

import static br.com.fiap.main.Main.usuarioLogado;

public class Viagem {

    private int id;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private LocalDateTime hChegadaEstimada;
    private LocalDateTime hPartida;
    private Usuario usuario;

    public Viagem() {
        super();
    }

    public Viagem(int id, LocalDateTime hPartida, LocalDateTime hChegadaEstimada, Estacao estacaoOrigem, Estacao estacaoDestino, Usuario usuario) {
        super();
        this.id = id;
        this.hPartida = hPartida;
        this.hChegadaEstimada = hChegadaEstimada;
        this.estacaoOrigem = estacaoOrigem;
        this.estacaoDestino = estacaoDestino;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estacao getEstacaoOrigem() {
        return estacaoOrigem;
    }

    public void setEstacaoOrigem(Estacao estacaoOrigem) {
        this.estacaoOrigem = estacaoOrigem;
    }

    public Estacao getEstacaoDestino() {
        return estacaoDestino;
    }

    public void setEstacaoDestino(Estacao estacaoDestino) {
        this.estacaoDestino = estacaoDestino;
    }

    public LocalDateTime gethChegadaEstimada() {
        return hChegadaEstimada;
    }

    public void sethChegadaEstimada(LocalDateTime hChegadaEstimada) {
        this.hChegadaEstimada = hChegadaEstimada;
    }

    public LocalDateTime gethPartida() {
        return hPartida;
    }

    public void sethPartida(LocalDateTime hPartida) {
        this.hPartida = hPartida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private static Viagem viagemEmAndamento = null;

    public static void iniciarViagem() {
        try {
            String estacaoOrigem = JOptionPane.showInputDialog("Estação de origem:");
            String estacaoDestino = JOptionPane.showInputDialog("Estação de destino:");

            EstacaoDAO estacaoDAO = new EstacaoDAO();
            Estacao origem = estacaoDAO.buscarPorNome(estacaoOrigem);
            Estacao destino = estacaoDAO.buscarPorNome(estacaoDestino);

            if (origem == null || destino == null) {
                JOptionPane.showMessageDialog(null, "Estação não encontrada.");
                return;
            }

            LocalDateTime hPartida = LocalDateTime.now();
            viagemEmAndamento = new Viagem(0, hPartida, null, origem, destino, usuarioLogado);

            int opcao = JOptionPane.showOptionDialog(null,
                    "Viagem iniciada de " + origem.getNome() + " para " + destino.getNome() + ".",
                    "Viagem em andamento",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new String[]{"Finalizar Viagem", "Cancelar"},
                    "Finalizar Viagem");

            if (opcao == 0) { // Finalizar Viagem
                finalizarViagem();
            } else {
                JOptionPane.showMessageDialog(null, "Viagem ainda em andamento.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar viagem: " + e.getMessage());
        }
    }

    public static void finalizarViagem() {
        if (viagemEmAndamento == null) {
            JOptionPane.showMessageDialog(null, "Nenhuma viagem em andamento.");
            return;
        }

        try {
            LocalDateTime hChegada = LocalDateTime.now();
            viagemEmAndamento.sethChegadaEstimada(hChegada);

            ViagemDAO viagemDAO = new ViagemDAO();
            String msg = viagemDAO.inserir(viagemEmAndamento);

            JOptionPane.showMessageDialog(null, msg);
            viagemEmAndamento = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar viagem: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "=== Viagem ===" +
                "\nid: " + id +
                "\nestacao Origem: " + estacaoOrigem +
                "\nestacao Destino: " + estacaoDestino +
                "\nhChegada Estimada: " + hChegadaEstimada +
                "\nPartida: " + hPartida +
                "\nusuario: " + usuario;
    }
}
