package br.com.fiap.dao;

import br.com.fiap.beans.Estacao;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstacaoDAO {

    private Connection conexao;

    public EstacaoDAO() throws ClassNotFoundException, SQLException {
        conexao = new ConnectionFactory().conexao();
    }

    // select
    public Estacao buscarPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Estacao WHERE nome = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Estacao estacao = new Estacao();
            estacao.setId(rs.getInt("id_estacao"));
            estacao.setNome(rs.getString("nome"));
            estacao.setLocalizacao(rs.getString("localizacao"));
            estacao.setPassageirosSimulados(rs.getInt("passageirosSimulados"));
            // Supondo que a linhaMetro seja null por enquanto
            return estacao;
        }

        conexao.close();

        return null;
    }

    // select
    public Estacao buscarPorId(int idEstacao) {
        String sql = "SELECT * FROM estacao WHERE id_estacao = ?";

        try (Connection conn = new ConnectionFactory().conexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idEstacao);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Estacao(
                        rs.getInt("id_estacao"),
                        rs.getString("nome"),
                        rs.getString("localizacao"),
                        rs.getInt("passageirosSimulados"),
                        null
                );
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Estacao> listar() throws SQLException {
        List<Estacao> estacoes = new ArrayList<>();
        String sql = "SELECT * FROM ESTACAO";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estacao estacao = new Estacao();
                estacao.setId(rs.getInt("id"));
                estacao.setNome(rs.getString("nome"));
                estacao.setLocalizacao(rs.getString("localizacao"));
                estacao.setPassageirosSimulados(rs.getInt("passageirosSimulados"));
                estacoes.add(estacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao listar estações", e);
        }
        return estacoes;
    }
}
