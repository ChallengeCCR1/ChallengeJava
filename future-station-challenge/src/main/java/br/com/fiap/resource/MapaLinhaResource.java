package br.com.fiap.resource;

import br.com.fiap.service.MapaLinhaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/mapa/linha9")
public class MapaLinhaResource {

    private final MapaLinhaService service = new MapaLinhaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object mostrarMapaLinha9(@QueryParam("estacao") String estacao, @QueryParam("linha") String linha) {
        return service.mostrarMapaLinha9();
    }
}
