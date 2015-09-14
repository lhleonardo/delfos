package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JPanel;

public class FrmCadastroEstado extends GenericFormCadastro {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroEstado frame = new FrmCadastroEstado(null);
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
	public FrmCadastroEstado(Connection connection) {
		super("Cadastro de Estados", connection);

		initComponents();
	}

	private void initComponents() {

		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.CENTER);
	}

}
