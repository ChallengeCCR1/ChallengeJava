package br.com.fiap.service;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.ViagemDAO;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class ViagemService {

    private static Viagem viagemEmAndamento = null;

    public Viagem iniciarViagem(Estacao origem, Estacao destino, LocalDateTime hPartida, Usuario usuario) throws SQLException, ClassNotFoundException {

        if (usuario == null || usuario.getId() <= 0) {
            throw new IllegalArgumentException("Usuário inválido! O ID deve estar setado corretamente.");
        }

        LocalDateTime hChegada = hPartida.plusMinutes(15);

        Viagem viagem = new Viagem(0, hPartida, hChegada, origem, destino, usuario);

        ViagemDAO viagemDAO = new ViagemDAO();
        String resultado = viagemDAO.inserir(viagem); // <- aqui o DAO preenche o ID via setId

        System.out.println("Resultado do DAO: " + resultado);
        System.out.println("ID da viagem após inserção: " + viagem.getId());

        return viagem;
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