package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteDeletarUsuario {

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

        Usuario objUsuario = new Usuario();
        UsuarioDAO objUsuarioDao = new UsuarioDAO();

        objUsuario.setNome(text("Informe o nome do usuário que deseja deletar: "));

        System.out.println(objUsuarioDao.deletar(objUsuario.getNome()));
    }
}
