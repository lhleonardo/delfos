package br.com.estatistica.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class FrmCadastroUsuario extends GenericFormCadastro {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroUsuario frame = new FrmCadastroUsuario();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FrmCadastroUsuario() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
