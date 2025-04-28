package br.com.fiap.service;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.ViagemDAO;

import java.time.LocalDateTime;

public class ViagemService {

    private static Viagem viagemEmAndamento = null;

    public Viagem iniciarViagem(Estacao origem, Estacao destino, LocalDateTime hPartida, Usuario usuario) {
        viagemEmAndamento = new Viagem(0, hPartida, null, origem, destino, usuario);
        return viagemEmAndamento;
    }

    public String finalizarViagem() throws Exception {
        if (viagemEmAndamento == null) {
            throw new Exception("Nenhuma viagem em andamento");
        }

        LocalDateTime hChegada = LocalDateTime.now();
        viagemEmAndamento.sethChegadaEstimada(hChegada);

        ViagemDAO viagemDAO = new ViagemDAO();
        String msg = viagemDAO.inserir(viagemEmAndamento);

        viagemEmAndamento = null; // limpar a viagem atual
        return msg;
    }
}