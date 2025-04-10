package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirUsuario {

    // Methods statics
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException, SQLException {

        Usuario objUsuario = new Usuario();

        UsuarioDAO dao = new UsuarioDAO();

        objUsuario.setNome(text("Nome: "));
        objUsuario.setEmail(text("E-mail: "));
        objUsuario.setSenha(text("Senha: "));

        System.out.println(dao.inserir(objUsuario));

    }

}
