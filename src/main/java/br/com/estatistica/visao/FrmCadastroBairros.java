package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmCadastroBairros extends GenericFormCadastro {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroBairros frame = new FrmCadastroBairros(null);
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
	public FrmCadastroBairros(Connection connection) {
		super("Cadastro de Bairros", connection);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 292, 499, 42);
		panel.add(panel_1);

		JButton button = new JButton("Novo");
		button.setBounds(0, 0, 89, 42);
		panel_1.add(button);

		JButton button_1 = new JButton("Salvar");
		button_1.setBounds(88, 0, 89, 42);
		panel_1.add(button_1);

		JButton button_2 = new JButton("Excluir");
		button_2.setBounds(176, 0, 89, 42);
		panel_1.add(button_2);

		JButton button_3 = new JButton("Cancelar");
		button_3.setBounds(391, 0, 108, 42);
		panel_1.add(button_3);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel.add(lblCdigo);

		textField = new JTextField();
		textField.setBounds(10, 26, 46, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(56, 25, 25, 23);
		panel.add(btnNewButton);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(91, 11, 46, 14);
		panel.add(lblNome);

		textField_1 = new JTextField();
		textField_1.setBounds(91, 26, 418, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(10, 57, 46, 14);
		panel.add(lblDescrio);

	}
}
