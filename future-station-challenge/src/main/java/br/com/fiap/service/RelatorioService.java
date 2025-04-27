package br.com.fiap.service;

import br.com.fiap.beans.Relatorio;
import br.com.fiap.beans.Viagem;
import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.ViagemDAO;
import br.com.fiap.dao.UsuarioDAO;

import java.time.LocalDateTime;
import java.util.List;

public class RelatorioService {

    public Relatorio gerarRelatorio(int idUsuario, List<Integer> idViagens) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorId(idUsuario);

        if (usuario == null) {
            throw new Exception("Usuário não encontrado");
        }

        ViagemDAO viagemDAO = new ViagemDAO();
        List<Viagem> viagens = viagemDAO.buscarPorIds(idViagens);

        if (viagens == null || viagens.isEmpty()) {
            throw new Exception("Nenhuma viagem encontrada");
        }

        // Gerando relatório
        LocalDateTime dataGeracao = LocalDateTime.now();
        Relatorio relatorio = new Relatorio(0, usuario, viagens, dataGeracao);

        return relatorio;
    }
}
