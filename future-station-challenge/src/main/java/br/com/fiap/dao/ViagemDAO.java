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
    public String inserir(Viagem viagem) throws SQLException {
        String sql = "INSERT INTO viagem (id_viagem, hpartida, hchegada, estacao_origem, estacao_destino, id_usuario) " +
                "VALUES (gerador_id_chall.NEXTVAL, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = minhaConexao.prepareStatement(sql);

        stmt.setTimestamp(1, Timestamp.valueOf(viagem.gethPartida()));
        stmt.setTimestamp(2, Timestamp.valueOf(viagem.gethChegadaEstimada()));
        stmt.setInt(3, viagem.getEstacaoOrigem().getId());
        stmt.setInt(4, viagem.getEstacaoDestino().getId());
        stmt.setInt(5, viagem.getUsuario().getId());

        // Log para verificar os dados antes de inserir
        System.out.println("Inserindo viagem com os seguintes dados: ");
        System.out.println("ID Usuário: " + viagem.getUsuario().getId());
        System.out.println("ID Estação Origem: " + viagem.getEstacaoOrigem().getId());
        System.out.println("ID Estação Destino: " + viagem.getEstacaoDestino().getId());
        System.out.println("Data Partida: " + viagem.gethPartida());
        System.out.println("Data Chegada Estimada: " + viagem.gethChegadaEstimada());

        if (viagem.getUsuario() == null || viagem.getUsuario().getId() == 0) {
            throw new SQLException("Usuário inválido para registrar viagem.");
        }

        int rows = stmt.executeUpdate();

        // Verificação se o número de linhas afetadas é maior que 0
        if (rows > 0) {
            System.out.println("Viagem registrada com sucesso!");
            return "Viagem registrada com sucesso!";
        } else {
            System.out.println("Falha ao registrar viagem.");
            return "Falha ao registrar viagem.";
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

