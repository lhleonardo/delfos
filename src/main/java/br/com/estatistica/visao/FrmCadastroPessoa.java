package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.util.ManipuladorDeComponentes;

public class FrmCadastroPessoa extends GenericFormCadastro {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCpfCnpj;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTextField txtLogradouro;
	private JTextField txtNumeroEndereco;
	private JTextField txtCepEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;

	private JTextArea txtDescricao;

	private JScrollPane scrollPane;
	private JButton btnPesquisaPessoa;
	private JTextArea txtDescricaoEndereco;
	private JScrollPane scrollPaneEndereco;
	private JButton btnNovo;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private Component chckbxPesquisador;
	private Component chckbxEspecialista;
	private Component btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroPessoa frame = new FrmCadastroPessoa(null);
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
	public FrmCadastroPessoa(Connection connection) {
		super("Cadastro de Pessoa", connection);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 26, 39, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(87, 11, 46, 14);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(87, 26, 436, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF/CNPJ");
		lblCpf.setBounds(10, 57, 56, 14);
		panel.add(lblCpf);

		txtCpfCnpj = new JTextField();
		txtCpfCnpj.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

			}
		});
		txtCpfCnpj.setBounds(10, 71, 96, 20);
		panel.add(txtCpfCnpj);
		txtCpfCnpj.setColumns(10);

		txtRg = new JTextField();
		txtRg.setBounds(116, 71, 104, 20);
		panel.add(txtRg);
		txtRg.setColumns(10);

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(116, 57, 46, 14);
		panel.add(lblRg);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(225, 57, 46, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(225, 71, 298, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(10, 120, 46, 14);
		panel.add(lblDescricao);

		txtDescricao = new JTextArea();
		txtDescricao.setLineWrap(true);
		scrollPane = new JScrollPane(txtDescricao);
		scrollPane.setBounds(10, 135, 513, 68);
		panel.add(scrollPane);

		panel.add(scrollPane);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 214, 513, 188);
		panel.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Endereço", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNome_1 = new JLabel("Logradouro");
		lblNome_1.setBounds(10, 11, 60, 14);
		panel_1.add(lblNome_1);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(10, 25, 336, 20);
		panel_1.add(txtLogradouro);
		txtLogradouro.setColumns(10);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(351, 11, 46, 14);
		panel_1.add(lblNumero);

		txtNumeroEndereco = new JTextField();
		txtNumeroEndereco.setBounds(351, 25, 60, 20);
		panel_1.add(txtNumeroEndereco);
		txtNumeroEndereco.setColumns(10);

		JLabel lblCep = new JLabel("Cep");
		lblCep.setBounds(417, 11, 46, 14);
		panel_1.add(lblCep);

		txtCepEndereco = new JTextField();
		txtCepEndereco.setBounds(417, 25, 86, 20);
		panel_1.add(txtCepEndereco);
		txtCepEndereco.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 49, 46, 14);
		panel_1.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setBounds(10, 62, 230, 20);
		panel_1.add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(271, 49, 46, 14);
		panel_1.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setBounds(271, 62, 203, 20);
		panel_1.add(txtCidade);
		txtCidade.setColumns(10);

		JButton btnPesquisaBairro = new JButton("New button");
		btnPesquisaBairro.setBounds(242, 61, 26, 23);
		panel_1.add(btnPesquisaBairro);

		JButton btnPesquisaCidade = new JButton("New button");
		btnPesquisaCidade.setBounds(477, 61, 26, 23);
		panel_1.add(btnPesquisaCidade);

		JLabel lblDescricao_1 = new JLabel("Descricao");
		lblDescricao_1.setBounds(10, 86, 46, 14);
		panel_1.add(lblDescricao_1);

		txtDescricaoEndereco = new JTextArea();
		txtDescricaoEndereco.setLineWrap(true);
		scrollPaneEndereco = new JScrollPane(txtDescricaoEndereco);
		scrollPaneEndereco.setBounds(10, 103, 488, 46);
		panel_1.add(scrollPaneEndereco);
		tabbedPane.addTab("[...]", null, panel_2, null);

		btnPesquisaPessoa = new JButton("...");
		btnPesquisaPessoa.setBounds(52, 25, 25, 23);
		panel.add(btnPesquisaPessoa);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 412, 513, 42);
		panel.add(panel_3);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(btnNovoActionPerformed());
		btnNovo.setBounds(0, 0, 89, 42);
		panel_3.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(88, 0, 89, 42);
		panel_3.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(176, 0, 89, 42);
		panel_3.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(405, 0, 108, 42);
		panel_3.add(btnCancelar);

		chckbxEspecialista = new JCheckBox("Especialista");
		chckbxEspecialista.setBounds(10, 98, 97, 23);
		panel.add(chckbxEspecialista);

		chckbxPesquisador = new JCheckBox("Pesquisador");
		chckbxPesquisador.setBounds(116, 98, 97, 23);
		panel.add(chckbxPesquisador);
	}

	public ActionListener btnNovoActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManipuladorDeComponentes.limpaTextComponent(getContentPane());
			}
		};
	}
}
