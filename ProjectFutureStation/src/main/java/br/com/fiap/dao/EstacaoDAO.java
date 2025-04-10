package br.com.fiap.dao;

import br.com.fiap.beans.Estacao;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
