package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmCadastroPessoa extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton txtPesquisar;
	private JLabel lblNome;
	private JTextField textField;

	public FrmCadastroPessoa(Connection connection) {
		super("Cadastro de Pessoa", connection);
		this.initComponents();
	}
	
	private void initComponents() {
		this.setResizable(false);

		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblCdigo = new JLabel("Código");
		this.lblCdigo.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblCdigo);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setBounds(10, 25, 46, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);

		this.txtPesquisar = new JButton("");
		this.txtPesquisar.setBounds(56, 24, 27, 23);
		this.panel.add(this.txtPesquisar);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(89, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.textField = new JTextField();
		this.textField.setBounds(89, 25, 360, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);
	}

}
