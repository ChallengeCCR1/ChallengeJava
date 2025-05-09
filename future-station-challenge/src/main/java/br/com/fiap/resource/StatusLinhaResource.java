package br.com.fiap.resource;

import br.com.fiap.dto.StatusLinhaResponseDTO;
import br.com.fiap.model.StatusLinhaModel;
import br.com.fiap.service.StatusLinhaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Provider
@Path("/status-linhas")
public class StatusLinhaResource {

    @GET
    @Path("/{nomeLinha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusPorLinha(@PathParam("nomeLinha") String nomeLinha) {
        try {
            List<StatusLinhaModel> statusList = StatusLinhaService.buscarTodosStatus();
            List<StatusLinhaResponseDTO> filtrados = statusList.stream()
                    .filter(l -> l.getNome().toLowerCase().contains(nomeLinha.toLowerCase()))
                    .map(l -> new StatusLinhaResponseDTO(l.getNome(), l.getStatus()))
                    .collect(Collectors.toList());

            if (filtrados.isEmpty()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Linha não encontrada").build();
            }

            return Response.ok(filtrados).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar status das linhas: " + e.getMessage()).build();
        }
    }
}
