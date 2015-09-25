package br.com.estatistica.dao;

import java.sql.Connection;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.Usuario;
import br.com.estatistica.util.ConnectionFactory;

public class UsuarioTest {

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		try (UsuarioDAO usuarioDAO = new UsuarioDAO(con)) {

			List<Usuario> resultado = usuarioDAO.get("lhleonardo");
			for (Usuario usuario : resultado) {
				System.out.println(usuario);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
