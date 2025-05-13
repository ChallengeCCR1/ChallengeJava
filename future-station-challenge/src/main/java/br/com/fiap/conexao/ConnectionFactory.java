package br.com.fiap.conexao;

import org.jboss.resteasy.reactive.common.providers.serialisers.jsonp.JsonpUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // metodo de conexao
    public Connection conexao() throws SQLException, ClassNotFoundException {

        // driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                "rm561178",
                "200905"
        );
    }
}