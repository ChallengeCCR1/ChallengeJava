package br.com.fiap.resource;

import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dto.ViagemDTO;
import br.com.fiap.service.ViagemService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

@Path("api/viagem")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ViagemResource {

    private final ViagemService service = new ViagemService();

    @POST
    @Path("/iniciar")
    public Viagem iniciarViagem(ViagemDTO dto) throws Exception {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarPorId(dto.getIdUsuario());
        return service.iniciarViagem(dto.getEstacaoOrigem(), dto.getEstacaoDestino(), usuario);
    }

    @POST
    @Path("/finalizar")
    public String finalizarViagem() throws Exception {
        return service.finalizarViagem();
    }

    // POST BASE_URL = http:localhost:8080/api/viagem/iniciar
    // POST BASE_URL = http:localhost:8080/api/viagem/finalizar

}
