package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.util.ConnectionFactory;

public class FrmCadastroFuncionalidade extends GenericFormCadastro {
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextArea txtDescricao;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnPesquisar;
	private JButton btnCancelar;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroFuncionalidade frame = new FrmCadastroFuncionalidade(null);
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

	public FrmCadastroFuncionalidade() {
		super("Cadastro de Funcionalidade", new ConnectionFactory().getConnection());
		preparaTela();
	}

	public FrmCadastroFuncionalidade(Connection con) {
		super("Cadastro de Funcionalidade", con);
		preparaTela();

	}

	protected void preparaTela() {
		setBounds(100, 100, 670, 399);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(10, 11, 46, 14);
		panel.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 27, 62, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(101, 11, 46, 14);
		panel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(101, 27, 408, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(10, 51, 46, 14);
		panel.add(lblDescricao);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 300, 499, 42);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(btnNovoActionPerformed());
		btnNovo.setBounds(0, 0, 89, 42);
		panel_1.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(btnSalvarActionPerformed());
		btnSalvar.setBounds(88, 0, 89, 42);
		panel_1.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(176, 0, 89, 42);
		panel_1.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(391, 0, 108, 42);
		panel_1.add(btnCancelar);

		btnPesquisar = new JButton("...");
		btnPesquisar.setToolTipText("Pesquisar registro existente");
		btnPesquisar.setBounds(71, 27, 26, 20);
		panel.add(btnPesquisar);

		txtDescricao = new JTextArea();
		txtDescricao.setLineWrap(true);
		scroll = new JScrollPane(txtDescricao);
		scroll.setBounds(10, 76, 499, 213);
		panel.add(scroll);

		setLocationRelativeTo(null);
	}

	protected ActionListener btnSalvarActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		};
	}

	protected ActionListener btnNovoActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent param) {
				limpaComponentesDeTexto();
			}
		};
	}

	protected void limpaComponentesDeTexto() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtDescricao.setText("");

	}

}
