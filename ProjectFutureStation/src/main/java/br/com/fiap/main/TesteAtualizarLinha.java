package br.com.fiap.main;

import br.com.fiap.beans.LinhaMetro;
import br.com.fiap.dao.LinhaMetroDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarLinha {

    // string
    public static String text(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    public static int integer(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    // double
    public static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        LinhaMetro objLinha = new LinhaMetro();
        LinhaMetroDAO objLinhaDAO = new LinhaMetroDAO();

        objLinha.setNome(text("Informe o nome da linha que deseja atualizar: "));
        objLinha.setNumero(integer("Informe o número da linha: "));
        objLinha.setTipo(text("Informe o tipo da linha: "));
        objLinha.setExtensao(real("Informe extensão da linha (em KM): "));
        objLinha.setDescricao(text("Dê uma descrição nova a essa linha: "));
        objLinha.setResponsavel(text("Informe o responsável da linha: "));

        System.out.println(objLinhaDAO.atualizar(objLinha));

    }

}
