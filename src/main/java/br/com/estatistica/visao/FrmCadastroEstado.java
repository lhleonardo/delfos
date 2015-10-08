package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.modelos.Estado;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

public class FrmCadastroEstado extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton btnPesquisar;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblUf;
	private JTextField txtUf;
	private JLabel lblDescrio;
	private JTextArea txtDescricao;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JScrollPane scrollPane_1;
	private EstadoDAO eDao;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroEstado frame = new FrmCadastroEstado(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmCadastroEstado(Connection connection) {
		super("Cadastro de Estados", connection);
		this.initComponents();
	}

	private void initComponents() {
		this.setSize(567, 386);

		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblCdigo = new JLabel("Código");
		this.lblCdigo.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblCdigo);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setEditable(false);
		this.txtCodigo.setBounds(10, 25, 46, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);

		this.btnPesquisar = new JButton("");
		this.btnPesquisar.addActionListener(e -> FrmCadastroEstado.this.btnPesquisarActionPerformed(e));
		this.btnPesquisar.setBounds(56, 24, 33, 23);
		this.panel.add(this.btnPesquisar);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(97, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.txtNome = new JTextField();
		this.txtNome.setBounds(99, 25, 218, 20);
		this.panel.add(this.txtNome);
		this.txtNome.setColumns(10);

		this.lblUf = new JLabel("UF");
		this.lblUf.setBounds(321, 11, 46, 14);
		this.panel.add(this.lblUf);

		this.txtUf = new JTextField();
		this.txtUf.setBounds(321, 25, 46, 20);
		this.panel.add(this.txtUf);
		this.txtUf.setColumns(10);

		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 56, 46, 14);
		this.panel.add(this.lblDescrio);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 71, 357, 213);
		this.panel.add(this.scrollPane_1);

		this.txtDescricao = new JTextArea();
		this.txtDescricao.setLineWrap(true);
		this.scrollPane_1.setViewportView(this.txtDescricao);

		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(e -> FrmCadastroEstado.this.btnNovoActionPerformed(e));
		this.btnNovo.setBounds(10, 295, 68, 31);
		this.panel.add(this.btnNovo);

		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.addActionListener(e -> FrmCadastroEstado.this.btnSalvarActionPerformed(e));
		this.btnSalvar.setBounds(77, 295, 68, 31);
		this.panel.add(this.btnSalvar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(e -> FrmCadastroEstado.this.btnExcluirActionPerformed(e));
		this.btnExcluir.setBounds(147, 295, 68, 31);
		this.panel.add(this.btnExcluir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.addActionListener(e -> FrmCadastroEstado.this.btnCancelarActionPerformed(e));
		this.btnCancelar.setBounds(284, 295, 83, 31);
		this.panel.add(this.btnCancelar);
	}

	protected void btnPesquisarActionPerformed(ActionEvent e) {
		// this.eDao = new EstadoDAO(this.getConnection());
		//
		// int valor = Integer.parseInt(Mensagem.entrada(this, informacao));
		//
		// switch (valor) {
		// case 1: {
		// this.abreRegistro(this.pesquisaPorCodigo());
		// break;
		// }
		// case 2: {
		// this.abreRegistro(this.pesquisaPorNome());
		// break;
		// }
		// default:
		// throw new IllegalArgumentException("Valor inválido.");
		// }
		// } catch (SQLException | RuntimeException e1) {
		// Mensagem.erro(this, e1);
		// }

		// FrmConsultaEstado consulta = new FrmConsultaEstado(this.getConnection(),
		// null);
		
		// if (consulta.alterarDados()) {
		// System.out.println("Tela de consulta acabou de ser fechada.");
		// }

	}

	private void abreRegistro(Estado estado) {
		if (estado != null) {
			if (estado.getId() != null) {
				this.txtCodigo.setText(String.valueOf(estado.getId()));
				this.txtNome.setText(estado.getNome());
				this.txtUf.setText(estado.getUf());
				this.txtDescricao.setText(estado.getDescricao());
			} else {
				throw new NullPointerException("Registro sem identificador.");
			}
		} else {
			throw new NullPointerException("Registro inválido.");
		}
	}

	protected Estado pesquisaPorNome() throws SQLException {
		List<Estado> list = this.eDao.get(Mensagem.entrada(this, "Informe o Nome do registro"));
		if (!list.isEmpty()) {
			Mensagem.informa(this,
					"Parece que foram encontrados vários registros... Vamos imprimi-los!\nApós isso, informe o código do registro que deseja.");
			for (Estado b : list) {
				Mensagem.informa(this, b.toString());
			}
		}
		return this.pesquisaPorCodigo();
	}

	protected Estado pesquisaPorCodigo() throws SQLException {
		return this.eDao.get(Integer.parseInt(Mensagem.entrada(this, "Informe o código do registro")));
	}

	protected void btnNovoActionPerformed(ActionEvent e) {
		super.limpaCampos(this.getContentPane());
		this.txtCodigo.requestFocus();
	}

	protected void btnSalvarActionPerformed(ActionEvent e) {
		this.eDao = new EstadoDAO(this.getConnection());
		try {
			Estado estado = this.montaEstado();

			this.txtCodigo.setText(String.valueOf(this.eDao.save(estado)));

		} catch (SQLException | RuntimeException e1) {
			Mensagem.erro(this, e1);
		}
	}

	private Estado montaEstado() {
		Estado estado = new Estado();
		estado.setId(this.txtCodigo.getText().isEmpty() ? null : Integer.parseInt(this.txtCodigo.getText()));
		estado.setNome(this.txtNome.getText());
		estado.setUf(this.txtUf.getText());
		estado.setDescricao(this.txtDescricao.getText());

		return estado;
	}

	protected void btnExcluirActionPerformed(ActionEvent e) {
		this.eDao = new EstadoDAO(this.getConnection());
		try {
			if (!this.txtCodigo.getText().isEmpty()) {
				Estado b = new Estado();
				b.setId(Integer.parseInt(this.txtCodigo.getText()));

				this.eDao = new EstadoDAO(this.getConnection());
				this.eDao.delete(b);
			} else {
				Mensagem.erro(this, "É necessário que seja informado o código do registro antes de realizar a exclusão.");
			}
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
	}

	protected void btnCancelarActionPerformed(ActionEvent e) {
		this.dispose();
	}
}
