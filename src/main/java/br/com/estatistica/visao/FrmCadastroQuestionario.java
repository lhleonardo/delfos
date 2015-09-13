package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FrmCadastroQuestionario extends GenericFormCadastro {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroQuestionario frame = new FrmCadastroQuestionario(null);
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
	public FrmCadastroQuestionario(Connection connection) {
		super("Cadastro de questionários", connection);

		setResizable(false);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(11, 11, 17, 14);
		panel.add(lblId);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 428, 89, 23);
		panel.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 428, 89, 23);
		panel.add(btnCancelar);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 58, 64, 14);
		panel.add(lblDescrio);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		editorPane.setBounds(10, 84, 282, 75);
		panel.add(editorPane);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(13, 36, 34, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(71, 11, 46, 14);
		panel.add(lblNome);

		textField_1 = new JTextField();
		textField_1.setBounds(68, 36, 378, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(11, 170, 46, 14);
		panel.add(lblTema);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(71, 167, 127, 20);
		panel.add(comboBox);

		JLabel lblPesquisa = new JLabel("Pesquisa");
		lblPesquisa.setBounds(11, 204, 46, 14);
		panel.add(lblPesquisa);

		JButton btnNewButton = new JButton("Lupa");
		btnNewButton.setBounds(68, 200, 89, 23);
		panel.add(btnNewButton);

		JButton button = new JButton("+");
		button.setBounds(208, 166, 41, 23);
		panel.add(button);
	}
}
