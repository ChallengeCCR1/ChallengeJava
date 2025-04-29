package br.com.fiap.dao;

import br.com.fiap.beans.Estacao;
import br.com.fiap.beans.Viagem;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO {

    public Connection minhaConexao;

    public ViagemDAO() throws ClassNotFoundException, SQLException {
        this.minhaConexao = new ConnectionFactory().conexao();
    }

    // insert
    public String inserir(Viagem viagem) throws SQLException, ClassNotFoundException {
        Connection con = new ConnectionFactory().conexao();

        // IMPORTANTE: utilizamos RETURN_GENERATED_KEYS aqui apenas se o banco suportar retorno do ID.
        // Em Oracle, você pode usar RETURNING INTO com CallableStatement OU buscar com SELECT.
        String sql = "INSERT INTO viagem (id, h_partida, h_chegada, estacao_origem_id, estacao_destino_id, usuario_id) " +
                "VALUES (gerador_id_chall.NEXTVAL, ?, ?, ?, ?, ?)";

        // Primeiro, recupera o próximo valor da sequência manualmente
        PreparedStatement stmtSeq = con.prepareStatement("SELECT gerador_id_chall.NEXTVAL FROM dual");
        ResultSet rsSeq = stmtSeq.executeQuery();

        int novoId = 0;
        if (rsSeq.next()) {
            novoId = rsSeq.getInt(1);
        }

        rsSeq.close();
        stmtSeq.close();

        // Agora sim, insere usando o ID recuperado
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setTimestamp(1, Timestamp.valueOf(viagem.gethPartida()));
        stmt.setTimestamp(2, Timestamp.valueOf(viagem.gethChegadaEstimada()));
        stmt.setInt(3, viagem.getEstacaoOrigem().getId());
        stmt.setInt(4, viagem.getEstacaoDestino().getId());
        stmt.setInt(5, viagem.getUsuario().getId());

        int rows = stmt.executeUpdate();

        stmt.close();
        con.close();

        if (rows > 0) {
            viagem.setId(novoId); // Atualiza o objeto com o ID gerado manualmente
            return "Viagem inserida com sucesso! ID: " + novoId;
        } else {
            return "Erro ao inserir viagem.";
        }
    }

    // select
    public List<Viagem> buscarPorUsuarioSimples(int idUsuario) {
        List<Viagem> lista = new ArrayList<>();

        String sql = "SELECT * FROM viagem WHERE id_usuario = ? ORDER BY hpartida DESC";

        try (Connection conn = new ConnectionFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idOrigem = rs.getInt("estacao_origem");
                int idDestino = rs.getInt("estacao_destino");

                EstacaoDAO estacaoDAO = new EstacaoDAO();
                Estacao origem = estacaoDAO.buscarPorId(idOrigem);
                Estacao destino = estacaoDAO.buscarPorId(idDestino);

                Viagem v = new Viagem(
                        rs.getInt("id_viagem"),
                        rs.getTimestamp("hpartida").toLocalDateTime(),
                        rs.getTimestamp("hchegada").toLocalDateTime(),
                        origem,
                        destino,
                        null
                );

                lista.add(v);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return lista;
    }
}