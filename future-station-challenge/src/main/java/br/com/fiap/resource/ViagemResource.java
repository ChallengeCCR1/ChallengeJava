package br.com.fiap.resource;

import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dto.ViagemDTO;
import br.com.fiap.dto.ViagemResponseDTO;
import br.com.fiap.service.ViagemService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("api/viagem")
public class ViagemResource {

    private final ViagemService service = new ViagemService();

    @POST
    @Path("/iniciar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ViagemResponseDTO iniciarViagem(ViagemDTO dto) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorId(dto.getIdUsuario());
        Viagem viagem = service.iniciarViagem(dto.getEstacaoOrigem(), dto.getEstacaoDestino(), usuario);

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
