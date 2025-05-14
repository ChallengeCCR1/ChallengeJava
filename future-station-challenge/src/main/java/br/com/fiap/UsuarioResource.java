package br.com.fiap;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("api/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public UsuarioResource() throws SQLException, ClassNotFoundException {
    }

    @GET
    @Path("/todos")
    public List<Usuario> listarTodosUsuarios() throws SQLException, ClassNotFoundException{
        return usuarioDAO.listar();
    }
}
