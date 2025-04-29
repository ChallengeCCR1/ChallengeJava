package br.com.fiap.dao;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Usuario;
import br.com.fiap.beans.Viagem;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO {

    private Connection minhaConexao;

    public ViagemDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    // Inserção segura
    public String inserir(Viagem viagem) throws SQLException, ClassNotFoundException {
        if (viagem.getUsuario() == null || viagem.getUsuario().getId() <= 0) {
            throw new IllegalArgumentException("Usuário inválido! Verifique se o ID está setado corretamente.");
        }

        Connection con = new ConnectionFactory().conexao();
        con.setAutoCommit(false);

        // Gera novo ID via sequence
        PreparedStatement stmtSeq = con.prepareStatement("SELECT gerador_id_chall.NEXTVAL FROM dual");
        ResultSet rsSeq = stmtSeq.executeQuery();

        int novoId = 0;
        if (rsSeq.next()) {
            novoId = rsSeq.getInt(1);
        }

        rsSeq.close();
        stmtSeq.close();

        // Query de inserção
        String sql = "INSERT INTO viagem (id_viagem, hpartida, hchegada, estacao_origem, estacao_destino, id_usuario) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, novoId);
        stmt.setTimestamp(2, Timestamp.valueOf(viagem.gethPartida()));
        stmt.setTimestamp(3, Timestamp.valueOf(viagem.gethChegadaEstimada()));
        stmt.setInt(4, viagem.getEstacaoOrigem().getId());
        stmt.setInt(5, viagem.getEstacaoDestino().getId());
        stmt.setInt(6, viagem.getUsuario().getId());

        int rows = stmt.executeUpdate();

        String resultado;
        if (rows > 0) {
            viagem.setId(novoId);
            resultado = "Viagem inserida com sucesso! ID: " + novoId;
        } else {
            resultado = "Erro ao inserir viagem.";
        }

        con.commit();
        stmt.close();
        con.close();

        return resultado;
    }

    // Busca viagens por usuário (completando com dados reais)
    public List<Viagem> buscarPorUsuarioSimples(int idUsuario) {
        List<Viagem> lista = new ArrayList<>();

        String sql = "SELECT * FROM viagem WHERE id_usuario = ? ORDER BY hpartida DESC";

        try (Connection conn = new ConnectionFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idViagem = rs.getInt("id_viagem");
                LocalDateTime hPartida = rs.getTimestamp("hpartida").toLocalDateTime();
                LocalDateTime hChegada = rs.getTimestamp("hchegada").toLocalDateTime();

                int idOrigem = rs.getInt("estacao_origem");
                int idDestino = rs.getInt("estacao_destino");
                int idUsuarioViagem = rs.getInt("id_usuario");

                EstacaoDAO estacaoDAO = new EstacaoDAO();
                Estacao origem = estacaoDAO.buscarPorId(idOrigem);
                Estacao destino = estacaoDAO.buscarPorId(idDestino);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(idUsuarioViagem);

                Viagem v = new Viagem(idViagem, hPartida, hChegada, origem, destino, usuario);
                lista.add(v);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }
}