package br.com.fiap.resource;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.dto.ViagemDTO;
import br.com.fiap.dto.ViagemResponseDTO;
import br.com.fiap.service.ViagemService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.LocalDateTime;

@Path("/api/viagem")
public class ViagemResource {

    private final ViagemService service = new ViagemService();

    @POST
    @Path("/iniciar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ViagemResponseDTO iniciarViagem(ViagemDTO dto) {
        Usuario usuario = new Usuario(dto.getUsuarioId(), "Usuário Exemplo");
        Estacao origem = new Estacao(dto.getEstacaoOrigemId(), "Estação Origem Exemplo");
        Estacao destino = new Estacao(dto.getEstacaoDestinoId(), "Estação Destino Exemplo");

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