package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarUsuario {

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
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();

        String nomeAntigo = text("Informe o NOME atual do usuário que deseja atualizar:");
        objUsuario.setNome(text("Informe o nome do usuário que deseja atualizar: "));
        objUsuario.setEmail(text("Informe o e-mail do usuário que deseja atualizar: "));
        objUsuario.setSenha(text("Informe a senha do usuário: "));

        System.out.println(objUsuarioDAO.atualizar(objUsuario, nomeAntigo));

    }

}
