package br.com.fiap;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.dto.UsuarioRequestDTO;
import br.com.fiap.dto.UsuarioResponseDTO;
import br.com.fiap.service.UsuarioService;
import jakarta.ws.rs.core.Response;

@Path("api/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {

//    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
//
//    public UsuarioResource() throws SQLException, ClassNotFoundException {
//    }
//
//    @GET
//    @Path("/todos")
//    public List<Usuario> listarTodosUsuarios() throws SQLException, ClassNotFoundException{
//        return usuarioDAO.listar();
//    }

    private UsuarioService service;

    public UsuarioResource() {
        try {
            service = new UsuarioService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response cadastrar(UsuarioRequestDTO dto) {
        try {
            String msg = service.cadastrarUsuario(dto);
            return Response.status(Response.Status.CREATED).entity(msg).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao cadastrar usuário").build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UsuarioRequestDTO dto) {
        try {
            UsuarioResponseDTO usuario = service.fazerLogin(dto.getEmail(), dto.getSenha());
            if (usuario != null) {
                return Response.ok(usuario).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Usuário ou senha inválidos").build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao realizar login").build();
        }
    }


}
