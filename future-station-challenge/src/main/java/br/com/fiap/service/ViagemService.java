package br.com.fiap.service;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.dao.ViagemDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ViagemService {

    private Viagem viagemEmandamento = null;

    public Viagem iniciarViagem(String estacaoOrigem, String estacaoDestino, Usuario usuario) throws Exception {
        EstacaoDAO estacaoDAO = new EstacaoDAO();
        Estacao origem = estacaoDAO.buscarPorNome(estacaoOrigem);
        Estacao destino = estacaoDAO.buscarPorNome(estacaoDestino);

        if (origem == null || destino == null) {
            throw new Exception("Estação não encontrada");
        }

        if (usuario == null || usuario.getId() == 0) {
            throw new Exception("Usuário inválido");
        }

        LocalDateTime hPartida = LocalDateTime.now();
        viagemEmandamento = new Viagem(0, hPartida, null, origem, destino, usuario);

        return viagemEmandamento;
    }


    public String finalizarViagem() throws SQLException, ClassNotFoundException {
        if (viagemEmandamento == null) {
            return "Nenhuma viagem encontrada";
        }

        viagemEmandamento.sethChegadaEstimada(LocalDateTime.now());
        ViagemDAO viagemDAO = new ViagemDAO();
        String resultado = viagemDAO.inserir(viagemEmandamento);
        viagemEmandamento = null;
        return resultado;
    }

}
