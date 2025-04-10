package br.com.fiap.dao;

import br.com.fiap.beans.LinhaMetro;
import br.com.fiap.conexao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinhaMetroDAO {

    public Connection minhaConexao2;

    // method constructor with parameter empty
    public LinhaMetroDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao2 = new ConnectionFactory().conexao();
    }

    // insert
    public String inserir(LinhaMetro linha) throws SQLException {
        PreparedStatement stmt = minhaConexao2.prepareStatement(
                "Insert into LinhaMetro (id_linhaMetro, nome, extensao, numero, descricao, tipo, responsavel) VALUES (gerador_id_chall.NEXTVAL, ?, ?, ?, ?, ?, ?)"
        );

        stmt.setString(1, linha.getNome());
        stmt.setDouble(2, linha.getExtensao());
        stmt.setInt(3, linha.getNumero());
        stmt.setString(4, linha.getDescricao());
        stmt.setString(5, linha.getTipo());
        stmt.setString(6, linha.getResponsavel());

        stmt.execute();
        stmt.close();

        return "Linha inserida com sucesso!";
    }

    // delete
    public String deletar(String nome) throws SQLException {
        PreparedStatement stmt = minhaConexao2.prepareStatement(
                "Delete from LinhaMetro where nome = ?"
        );

        stmt.setString(1, nome);

        stmt.execute();
        stmt.close();

        return "Linha deletada com sucesso!";
    }

    // update
    public String atualizar(LinhaMetro linha) throws SQLException {
        PreparedStatement stmt = minhaConexao2.prepareStatement(
                "Update LinhaMetro set NOME = ?, EXTENSAO = ?, NUMERO = ?, DESCRICAO = ?, TIPO = ?, RESPONSAVEL = ? where id_linhametro = ?"
        );

        stmt.setString(1, linha.getNome());
        stmt.setDouble(2, linha.getExtensao());
        stmt.setInt(3, linha.getNumero());
        stmt.setString(4, linha.getDescricao());
        stmt.setString(5, linha.getTipo());
        stmt.setString(6, linha.getResponsavel());
        stmt.setInt(7, linha.getId());

        stmt.execute();
        stmt.close();

        return "Linha de metrô atualizada com sucesso!";
    }

    // select
    public List<LinhaMetro> selecionar() throws SQLException {
        List<LinhaMetro> listaLinhaMetro = new ArrayList<LinhaMetro>();
        PreparedStatement stmt = minhaConexao2.prepareStatement(
                "select * from LinhaMetro"
        );

        ResultSet rs = stmt.executeQuery();

        // -- id, nome, extensao, numero, descricao, tipo, responsavel

        while (rs.next()) {
            LinhaMetro objLinha = new LinhaMetro();
            objLinha.setId(rs.getInt(1));
            objLinha.setNome(rs.getString(2));
            objLinha.setExtensao(rs.getDouble(3));
            objLinha.setNumero(rs.getInt(4));
            objLinha.setDescricao(rs.getString(5));
            objLinha.setTipo(rs.getString(6));
            objLinha.setResponsavel(rs.getString(7));
            listaLinhaMetro.add(objLinha);
        }
        return listaLinhaMetro;
    }
}