package br.com.fiap.resource;

import br.com.fiap.service.PrevisaoPicoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/api/previsao")
public class PrevisaoPicoResource {

    private final PrevisaoPicoService service = new PrevisaoPicoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object obterPrevisaoPico(@QueryParam("estacao") String estacao, @QueryParam("horario") String horario) {
        return service.obterPrevisaoPico(estacao, horario);
    }

    @GET
    @Path("/grafico")
    @Produces(MediaType.TEXT_PLAIN)
    public String gerarGrafico(@QueryParam("estacao")String estacao) {
        return service.gerarGrafico(estacao);
    }
}
