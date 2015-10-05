package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FrmRespostas extends GenericFormCadastro {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmRespostas frame = new FrmRespostas();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRespostas() {
		super();
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 714, 461);
		panel.add(scrollPane);
	}
}
