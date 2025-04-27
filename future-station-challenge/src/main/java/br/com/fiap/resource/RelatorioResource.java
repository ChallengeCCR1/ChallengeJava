package br.com.fiap.resource;

import br.com.fiap.beans.Relatorio;
import br.com.fiap.dto.RelatorioDTO;
import br.com.fiap.service.RelatorioService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("api/relatorio")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RelatorioResource {

    private final RelatorioService service = new RelatorioService();

    @POST
    @Path("/gerar")
    public Relatorio gerarRelatorio(RelatorioDTO dto) throws Exception {
        return service.gerarRelatorio(dto.getIdUsuario(), dto.getIdViagens());
    }
}
