package br.com.fiap.resource;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dto.ViagemDTO;
import br.com.fiap.dto.ViagemResponseDTO;
import br.com.fiap.service.ViagemService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Path("/api/viagem")
public class ViagemResource {

    private final ViagemService service = new ViagemService();

    @POST
    @Path("/iniciar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ViagemResponseDTO iniciarViagem(ViagemDTO dto) throws SQLException, ClassNotFoundException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        EstacaoDAO estacaoDAO = new EstacaoDAO();

        // Buscar objetos REAIS do banco de dados
        Usuario usuario = usuarioDAO.buscarPorId(dto.getUsuarioId());
        Estacao origem = estacaoDAO.buscarPorId(dto.getEstacaoOrigemId());
        Estacao destino = estacaoDAO.buscarPorId(dto.getEstacaoDestinoId());

        // Validações opcionais
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + dto.getUsuarioId());
        }

        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Estação de origem ou destino não encontrada.");
        }

        LocalDateTime hPartida = LocalDateTime.parse(dto.gethPartida());

        Viagem viagem = service.iniciarViagem(origem, destino, hPartida, usuario);

        return new ViagemResponseDTO(
                viagem.getId(),
                viagem.getEstacaoOrigem().getNome(),
                viagem.getEstacaoDestino().getNome(),
                viagem.gethPartida().toString(),
                viagem.gethChegadaEstimada() != null ? viagem.gethChegadaEstimada().toString() : null,
                viagem.getUsuario().getNome()
        );
    }


    @POST
    @Path("/finalizar")
    @Produces(MediaType.APPLICATION_JSON)
    public String finalizarViagem() throws Exception {
        return service.finalizarViagem();
    }
}