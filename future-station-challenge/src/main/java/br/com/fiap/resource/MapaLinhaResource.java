package br.com.fiap.resource;

import br.com.fiap.dto.MapaLinhaDTO;
import br.com.fiap.service.MapaLinhaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;

@Provider
@Path("api/mapa/linha9")
public class MapaLinhaResource {

    private final MapaLinhaService service = new MapaLinhaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MapaLinhaDTO mostrarMapaLinha9() {
        return service.mostrarMapaLinha9();
    }
}
