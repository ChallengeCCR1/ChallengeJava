package br.com.fiap;

import br.com.fiap.dto.RelatorioResponseDTO;
import br.com.fiap.service.RelatorioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import java.sql.SQLException;

@Provider
@Path("/relatorio")
public class RelatorioResource {

    private RelatorioService service = new RelatorioService();

    @GET
    @Path("/usuario/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RelatorioResponseDTO buscarRelatorio(@PathParam("id") int usuarioId,
                                                @QueryParam("nome") String nomeUsuario) throws SQLException, ClassNotFoundException {
        return service.gerarRelatorio(usuarioId, nomeUsuario);
    }
}
