package br.com.fiap.service;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dto.UsuarioRequestDTO;
import br.com.fiap.dto.UsuarioResponseDTO;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() throws Exception {
        dao = new UsuarioDAO();
    }

    public String cadastrarUsuario(UsuarioRequestDTO dto) throws Exception {
        Usuario usuario = new Usuario(0, dto.getNome(), dto.getEmail(), dto.getSenha());
        return dao.inserir(usuario);
    }

    public UsuarioResponseDTO fazerLogin(String email, String senha) throws Exception {
        Usuario usuario = dao.selecionar(email, senha);
        if (usuario != null) {
            return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
        }
        return null; // Ou lançar uma exceção customizada
    }
}
