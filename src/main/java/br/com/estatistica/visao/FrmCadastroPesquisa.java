package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmCadastroPesquisa extends GenericFormCadastro {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroPesquisa frame = new FrmCadastroPesquisa();
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
	public FrmCadastroPesquisa() {
		super();

		setResizable(false);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 17, 14);
		panel.add(lblId);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 27, 34, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 11, 46, 14);
		panel.add(lblNome);

		textField_1 = new JTextField();
		textField_1.setBounds(50, 27, 354, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
