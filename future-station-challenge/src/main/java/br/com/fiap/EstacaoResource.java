package br.com.fiap;

import br.com.fiap.beans.Estacao;
import br.com.fiap.dao.EstacaoDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;
import java.util.List;

@Path("/api/estacao")
@Produces(MediaType.APPLICATION_JSON)
public class EstacaoResource {

    private final EstacaoDAO estacaoDAO = new EstacaoDAO();

    public EstacaoResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Path("/todas")
    public List<Estacao> listarTodasEstacoes() throws SQLException, ClassNotFoundException {
        return estacaoDAO.listar(); // Certifique-se de que o metodo listar() retorna List<Estacao>
    }

}
