package br.com.fiap.service;

import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.ViagemDAO;
import br.com.fiap.dto.RelatorioResponseDTO;
import br.com.fiap.dto.ViagemResponseDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioService {

    public RelatorioResponseDTO gerarRelatorio(int usuarioId, String nomeUsuario) throws SQLException, ClassNotFoundException {
        ViagemDAO viagemDAO = new ViagemDAO();
        List<Viagem> viagens = viagemDAO.buscarPorUsuarioSimples(usuarioId);

        List<ViagemResponseDTO> listaDTO = new ArrayList<>();

        for (Viagem v : viagens) {
            ViagemResponseDTO dto = new ViagemResponseDTO(
                    v.getId(),
                    v.getEstacaoOrigem().getNome(),
                    v.getEstacaoDestino().getNome(),
                    v.gethPartida() != null ? v.gethPartida().toString() : null,
                    v.gethChegadaEstimada() != null ? v.gethChegadaEstimada().toString() : null,
                    nomeUsuario
            );
            listaDTO.add(dto);
        }

        return new RelatorioResponseDTO(usuarioId, nomeUsuario, listaDTO);
    }
}
