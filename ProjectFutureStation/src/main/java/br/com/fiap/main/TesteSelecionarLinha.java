package br.com.fiap.main;

import br.com.fiap.beans.LinhaMetro;
import br.com.fiap.dao.LinhaMetroDAO;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteSelecionarLinha {

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

        LinhaMetroDAO objLinhaDAO = new LinhaMetroDAO();

        List<LinhaMetro> listaLinhaMetro = (ArrayList<LinhaMetro>) objLinhaDAO.selecionar();

        if (listaLinhaMetro != null) {
            // foreach
            for (LinhaMetro linha : listaLinhaMetro) { // id, nome, extensao, numero, descricao, tipo, responsavel
                System.out.println(
                        "=== INFORMAÇÕES DA LINHA ===" +
                        "\n\nID da linha: " + linha.getId() +
                        "\nNome da linha: " + linha.getNome() +
                        "\nExtensão: " + linha.getExtensao() +
                        "\nNúmero: " + linha.getNumero() +
                        "\nDescrição: " + linha.getDescricao() +
                        "\nTipo: " + linha.getTipo() +
                        "\nResponsável: " + linha.getResponsavel()
                );
            }
        }
    }
}