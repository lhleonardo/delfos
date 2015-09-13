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

import br.com.estatistica.dao.BairroDAO;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.util.Mensagem;

public class FrmCadastroBairro extends GenericFormCadastro {
	private static final long serialVersionUID = 1L;

	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextArea txtDescricao;

	private JScrollPane scrollPane;

	private JPanel canvas;
	private JPanel pnlBotoes;

	private JButton btnPesquisar;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroBairro frame = new FrmCadastroBairro(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmCadastroBairro(Connection connection) {
		super("Cadastro de Bairros", null);

		initComponents();

	}

	private void initComponents() {
		canvas = new JPanel();
		getContentPane().add(canvas, BorderLayout.CENTER);
		canvas.setLayout(null);

		pnlBotoes = new JPanel();
		pnlBotoes.setLayout(null);
		pnlBotoes.setBounds(10, 292, 499, 42);
		canvas.add(pnlBotoes);

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(0, 0, 89, 42);
		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNovoActionPerformed(e);
			}
		});
		pnlBotoes.add(btnNovo);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
			}
		});
		btnSalvar.setBounds(88, 0, 89, 42);
		pnlBotoes.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(176, 0, 89, 42);
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnExcluirActionPerformed(e);
			}
		});
		pnlBotoes.add(btnExcluir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(391, 0, 108, 42);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCancelarActionPerformed(e);
			}
		});
		pnlBotoes.add(btnCancelar);

		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setBounds(10, 11, 46, 14);
		canvas.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 26, 46, 20);
		canvas.add(txtCodigo);
		txtCodigo.setColumns(10);

		btnPesquisar = new JButton("...");
		btnPesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnPesquisarActionPerformed(e);
			}
		});

		btnPesquisar.setBounds(56, 25, 25, 23);
		canvas.add(btnPesquisar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(91, 11, 46, 14);
		canvas.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(91, 26, 418, 20);
		canvas.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(10, 57, 46, 14);
		canvas.add(lblDescrio);

		txtDescricao = new JTextArea();
		txtDescricao.setLineWrap(true);
		scrollPane = new JScrollPane(txtDescricao);
		scrollPane.setBounds(10, 73, 496, 208);
		canvas.add(scrollPane);
	}

	protected void btnPesquisarActionPerformed(ActionEvent e) {

	}

	protected void btnCancelarActionPerformed(ActionEvent e) {
		limpaCampos();
	}

	protected void btnExcluirActionPerformed(ActionEvent e) {
		try (BairroDAO bDao = new BairroDAO(getConnection())) {
			Bairro bairro = criaModelo();
			if (bairro.getId() != null) {
				bDao.delete(bairro);
			} else {
				Mensagem.aviso(this, "É necessário que informe o código do Bairro para realizar a exclusão.");
			}
		} catch (SQLException ex) {
			Mensagem.erro(this, ex);
		}
	}

	protected void btnSalvarActionPerformed(ActionEvent e) {
		try (BairroDAO bDao = new BairroDAO(getConnection())) {
			Bairro bairro = criaModelo();
			Integer codigo = bDao.save(bairro);
			txtCodigo.setText(String.valueOf(codigo));
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
	}

	private Bairro criaModelo() {
		Bairro bairro = new Bairro();
		bairro.setId((txtCodigo.getText().isEmpty()) ? null : Integer.parseInt(txtCodigo.getText()));
		bairro.setNome(txtNome.getText());
		bairro.setDescricao(txtNome.getText());
		return bairro;
	}

	protected void btnNovoActionPerformed(ActionEvent e) {
		limpaCampos();
		txtNome.requestFocus();
	}

	private void limpaCampos() {
		txtCodigo.setText("");
		txtNome.setText("");
		txtDescricao.setText("");
	}
}
