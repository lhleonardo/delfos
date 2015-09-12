package br.com.estatistica.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class FrmCadastroFuncionalidade extends GenericFormCadastro {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroFuncionalidade frame = new FrmCadastroFuncionalidade();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCadastroFuncionalidade() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
