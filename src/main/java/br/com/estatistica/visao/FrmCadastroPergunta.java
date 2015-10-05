package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.estatistica.util.ConnectionFactory;

public class FrmCadastroPergunta extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JTextField txtOi;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroPergunta frame = new FrmCadastroPergunta(new ConnectionFactory().getConnection());
				;
				;
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FrmCadastroPergunta(Connection connection) {
		super("Cadastro de Pergunta", connection);

		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		this.txtOi.setHorizontalAlignment(SwingConstants.LEFT);
		this.txtOi.setBounds(29, 57, 451, 20);
		panel.add(this.txtOi);
		this.txtOi.setColumns(10);

		Label label = new Label("Pergunta:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(29, 28, 97, 23);
		panel.add(label);

		JLabel lblObservao = new JLabel("Observação:");
		lblObservao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservao.setBounds(29, 107, 112, 14);
		panel.add(lblObservao);

		this.textField = new JTextField();
		// this.textField.addActionListener(arg0 -> FrmCadastroPergunta.this.textField =
		// PerguntaExtractor);
		this.textField.setHorizontalAlignment(SwingConstants.LEFT);
		this.textField.setColumns(10);
		this.textField.setBounds(29, 57, 409, 23);
		panel.add(this.textField);

		JLabel lblTipoDePergunta = new JLabel("Tipo de Pergunta:");
		lblTipoDePergunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoDePergunta.setBounds(29, 206, 116, 14);
		panel.add(lblTipoDePergunta);

		JComboBox<?> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Coeficiente de Argumentação ", "Coeficiente de Competência" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(29, 232, 197, 20);
		panel.add(comboBox);

		JButton btnSalvar = new JButton("Cancelar");
		btnSalvar.addActionListener(arg0 -> {
		});
		btnSalvar.setBounds(144, 417, 89, 23);
		panel.add(btnSalvar);

		JButton button = new JButton("Salvar");
		button.addActionListener(arg0 -> {

		});
		button.setBounds(29, 417, 89, 23);
		panel.add(button);

		this.textField_1 = new JTextField();
		this.textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		this.textField_1.setColumns(10);
		this.textField_1.setBounds(29, 132, 409, 35);
		panel.add(this.textField_1);
	}
}
