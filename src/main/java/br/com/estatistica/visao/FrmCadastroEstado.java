package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JPanel;

public class FrmCadastroEstado extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroEstado frame = new FrmCadastroEstado(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmCadastroEstado(Connection connection) {
		super("Cadastro de Estados", connection);
		this.initComponents();
	}

	private void initComponents() {
		
		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
	}

}
