package br.com.estatistica.visao;

import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;

public class FrmCadastroUsuario extends GenericFormCadastro {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroUsuario frame = new FrmCadastroUsuario(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param connection
	 */
	public FrmCadastroUsuario(Connection connection) {
		super("Cadastro de Usuários", connection);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
