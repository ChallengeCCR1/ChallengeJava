package br.com.fiap;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.EstacaoDAO;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dto.ViagemDTO;
import br.com.fiap.dto.ViagemResponseDTO;
import br.com.fiap.service.ViagemService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;

@Path("/api/viagem")
public class ViagemResource {

    private final ViagemService service = new ViagemService();

    @POST
    @Path("/iniciar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response iniciarViagem(ViagemDTO dto) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            EstacaoDAO estacaoDAO = new EstacaoDAO();

            Usuario usuario = usuarioDAO.buscarPorId(dto.getUsuarioId());
            Estacao origem = estacaoDAO.buscarPorId(dto.getEstacaoOrigemId());
            Estacao destino = estacaoDAO.buscarPorId(dto.getEstacaoDestinoId());

            // Validações com retorno apropriado
            if (usuario == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Usuário não encontrado com ID: " + dto.getUsuarioId())
                        .build();
            }

            if (origem == null || destino == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Estação de origem ou destino não encontrada.")
                        .build();
            }

            LocalDateTime hPartida = LocalDateTime.parse(dto.gethPartida());

            Viagem viagem = service.iniciarViagem(origem, destino, hPartida, usuario);

            ViagemResponseDTO responseDTO = new ViagemResponseDTO(
                    viagem.getId(),
                    viagem.getEstacaoOrigem().getNome(),
                    viagem.getEstacaoDestino().getNome(),
                    viagem.gethPartida().toString(),
                    viagem.gethChegadaEstimada() != null ? viagem.gethChegadaEstimada().toString() : null,
                    viagem.getUsuario().getNome()
            );

            return Response.ok(responseDTO).build();

        } catch (Exception e) {
            // Log (poderia usar um Logger real aqui)
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro interno ao iniciar a viagem: " + e.getMessage())
                    .build();
        }
    }


    @POST
    @Path("/finalizar")
    @Produces(MediaType.APPLICATION_JSON)
    public String finalizarViagem() throws Exception {
        return service.finalizarViagem();
    }
}