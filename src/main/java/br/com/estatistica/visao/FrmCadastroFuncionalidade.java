package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.dao.FuncionalidadeDAO;
import br.com.estatistica.modelos.Funcionalidade;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

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
	private JLabel lblNewLabel;
	private JTextField txtChave;

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
		lblDescricao.setBounds(10, 99, 46, 14);
		panel.add(lblDescricao);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBounds(10, 300, 499, 42);
		panel.add(panelBotoes);
		panelBotoes.setLayout(null);

		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(btnNovoActionPerformed());
		btnNovo.setBounds(0, 0, 89, 42);
		panelBotoes.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(btnSalvarActionPerformed());
		btnSalvar.setBounds(88, 0, 89, 42);
		panelBotoes.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(btnExcluirActionPerformed());
		btnExcluir.setBounds(176, 0, 89, 42);
		panelBotoes.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(391, 0, 108, 42);
		panelBotoes.add(btnCancelar);

		btnPesquisar = new JButton("...");
		btnPesquisar.setToolTipText("Pesquisar registro existente");
		btnPesquisar.setBounds(71, 27, 26, 20);
		panel.add(btnPesquisar);

		txtDescricao = new JTextArea();
		txtDescricao.setLineWrap(true);
		scroll = new JScrollPane(txtDescricao);
		scroll.setBounds(10, 113, 499, 176);
		panel.add(scroll);

		lblNewLabel = new JLabel("Chave");
		lblNewLabel.setBounds(10, 53, 46, 14);
		panel.add(lblNewLabel);

		txtChave = new JTextField();
		txtChave.setBounds(10, 68, 498, 20);
		panel.add(txtChave);
		txtChave.setColumns(10);

		setLocationRelativeTo(null);
	}

	public ActionListener btnExcluirActionPerformed() {
		Funcionalidade funcionalidade = criaFuncionalidade();

		try (FuncionalidadeDAO fdDao = new FuncionalidadeDAO(getConnection())) {
			return new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						fdDao.delete(funcionalidade);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						Mensagem.erro(null, e1);
					}
				}
			};
		} catch (SQLException e) {
			Mensagem.erro(this, e);
		}
		return null;
	}

	protected ActionListener btnSalvarActionPerformed() {
		Funcionalidade func = criaFuncionalidade();

		try (FuncionalidadeDAO fDao = new FuncionalidadeDAO(getConnection())) {
			return new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						fDao.save(func);
					} catch (SQLException e) {
						Mensagem.erro(null, e);
					}
				}
			};
		} catch (SQLException e) {
			Mensagem.erro(this, e);
		}

		return null;
	}

	public Funcionalidade criaFuncionalidade() {
		Funcionalidade func = new Funcionalidade();
		func.setId(Integer.parseInt(this.txtCodigo.getText()));
		func.setNome(this.txtNome.getText());
		func.setDescricao(this.txtDescricao.getText());
		func.setChave(this.txtChave.getText());
		return func;
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
