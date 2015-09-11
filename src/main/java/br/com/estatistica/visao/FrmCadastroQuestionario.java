package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class FrmCadastroQuestionario extends GenericFormCadastro  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroQuestionario frame = new FrmCadastroQuestionario();
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
	public FrmCadastroQuestionario() {
		super();
		setTitle("Cadastro de Pesquisas");

		setResizable(false);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
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
	}

}
