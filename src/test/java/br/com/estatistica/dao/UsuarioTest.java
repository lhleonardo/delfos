package br.com.estatistica.dao;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.Usuario;
import br.com.estatistica.util.ConnectionFactory;

public class UsuarioTest {

	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		try (UsuarioDAO usuarioDAO = new UsuarioDAO(con)) {

			Usuario resultado = (Usuario) usuarioDAO.get("lhleonardo");
			System.out.println(resultado);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
