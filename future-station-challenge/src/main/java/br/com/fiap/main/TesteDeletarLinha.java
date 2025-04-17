package br.com.fiap.main;

import br.com.fiap.beans.LinhaMetro;
import br.com.fiap.dao.LinhaMetroDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarLinha {

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

        objLinha.setNome(text("Informe o nome da linha que deseja deletar: "));

        System.out.println(objLinhaDAO.deletar(objLinha.getNome()));
    }
}
