package br.com.fiap.main;

import br.com.fiap.beans.LinhaMetro;
import br.com.fiap.dao.LinhaMetroDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirLinha {

    // String
    public static String text(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // Int
    public static int integer(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    // Double
    public static double real(String j) {
        return Double.parseDouble(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        LinhaMetro objLinha = new LinhaMetro();
        LinhaMetroDAO objLinhaDAO = new LinhaMetroDAO();

        objLinha.setNome(text("Nome da linha: "));
        objLinha.setNumero(integer("Número da linha: "));
        objLinha.setDescricao(text("Descrição da linha: "));
        objLinha.setExtensao(real("Qual a extensão da linha? Em KM."));
        objLinha.setTipo(text("Qual é o tipo da linha?"));
        objLinha.setResponsavel(text("Qual empresa é responsável pela linha?"));

        System.out.println(objLinhaDAO.inserir(objLinha));

    }

}
