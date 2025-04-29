package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public Connection minhaConexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    // inserir
    public String inserir(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario_Challenge (id_usuario, nome, email, senha) VALUES (gerador_id_chall.NEXTVAL, ?, ?, ?)";

        // Preparando o statement
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());

        // Executando a inserção
        int affectedRows = stmt.executeUpdate();

        // Verificando se a inserção foi bem-sucedida
        if (affectedRows > 0) {
            return "Usuário cadastrado com sucesso!";
        } else {
            return "Erro ao cadastrar o usuário.";
        }
    }

    // delete
    public String deletar(String nome) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "Delete from Usuario_Challenge where nome = ?"
        );

        stmt.setString(1, nome);

        stmt.execute();
        stmt.close();

        return "Usuário deletado com sucesso!";
    }

    // update
    public String atualizar(Usuario usuario, String nomeAntigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE Usuario_Challenge SET NOME = ?, EMAIL = ?, SENHA = ? WHERE NOME = ?"
        );

        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.setString(4, nomeAntigo);

        int linhasAfetadas = stmt.executeUpdate();
        stmt.close();

        return linhasAfetadas > 0 ? "Usuário atualizado com sucesso!" : "Nenhum usuário foi atualizado.";
    }

    // select
    public Usuario selecionar(String email, String senha) throws SQLException {
        String sql = "SELECT id_usuario, nome, email, senha FROM Usuario_Challenge WHERE email = ? AND senha = ?";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Usuario(
                    rs.getInt("id_usuario"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
            );
        }

        stmt.execute();
        stmt.close();

        return null;
    }

    // buscarPorId
    public Usuario buscarPorId(int id) throws SQLException, ClassNotFoundException {
        Usuario usuario = null;

        String sql = "SELECT * FROM Usuario_Challenge WHERE id_usuario = ?";

        try (Connection con = new ConnectionFactory().conexao();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }

            rs.close();
        }

        return usuario;
    }
}