package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.estatistica.dao.BairroDAO;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.GuiUtils;
import br.com.estatistica.util.Mensagem;

public class FrmCadastroBairro extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton btnPesquisar;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblDescrio;
	private JTextArea txtDescricao;
	private JPanel panel_1;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private BairroDAO bDao;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				FrmCadastroBairro frame = new FrmCadastroBairro(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmCadastroBairro(Connection connection) {
		super("Cadastro de Bairros", connection);
		this.initComponents();
	}

	private void initComponents() {
		this.setResizable(false);
		this.setSize(662, 382);
		this.setLocation(GuiUtils.centralizaTela(this));

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
		this.btnPesquisar.addActionListener(e -> FrmCadastroBairro.this.btnPesquisarActionPerformed(e));
		this.btnPesquisar.setBounds(58, 24, 33, 23);
		this.panel.add(this.btnPesquisar);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(101, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.txtNome = new JTextField();
		this.txtNome.setBounds(101, 25, 363, 20);
		this.panel.add(this.txtNome);
		this.txtNome.setColumns(10);

		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 51, 46, 14);
		this.panel.add(this.lblDescrio);

		this.txtDescricao = new JTextArea();
		this.scrollPane = new JScrollPane(this.txtDescricao);
		this.txtDescricao.setLineWrap(true);
		this.scrollPane.setBounds(10, 65, 454, 219);
		this.panel.add(this.scrollPane);

		this.panel_1 = new JPanel();
		this.panel_1.setBounds(10, 295, 454, 43);
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(null);

		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(arg0 -> FrmCadastroBairro.this.btnNovoActionPerformed(arg0));
		this.btnNovo.setBounds(0, 0, 92, 43);
		this.panel_1.add(this.btnNovo);

		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.addActionListener(e -> FrmCadastroBairro.this.btnSalvarActionPerformed(e));
		this.btnSalvar.setBounds(91, 0, 92, 43);
		this.panel_1.add(this.btnSalvar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(e -> FrmCadastroBairro.this.btnExcluirActionPerformed(e));
		this.btnExcluir.setBounds(183, 0, 92, 43);
		this.panel_1.add(this.btnExcluir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(362, 0, 92, 43);
		this.btnCancelar.addActionListener(arg0 -> this.btnCancelarActionPerformed(arg0));
		this.panel_1.add(this.btnCancelar);
	}

	private void btnCancelarActionPerformed(ActionEvent arg0) {
		this.dispose();
	}

	protected void btnNovoActionPerformed(ActionEvent arg0) {
		this.limpaCampos(this.getContentPane());
		this.txtNome.requestFocus();
	}

	protected void btnSalvarActionPerformed(ActionEvent e) {
		try {
			this.bDao = new BairroDAO(this.getConnection());
			Integer chaveGerada = this.bDao.save(this.montaBairro());
			if (chaveGerada != null) {
				this.txtCodigo.setText(String.valueOf(chaveGerada));
			}
		} catch (SQLException ex) {
			Mensagem.erro(this, ex);
		}

	}

	/**
	 * @return
	 */
	private Bairro montaBairro() {
		Bairro bairro = new Bairro();
		bairro.setNome(this.txtNome.getText());
		bairro.setDescricao(this.txtDescricao.getText());
		bairro.setId((this.txtCodigo.getText().isEmpty()) ? null : Integer.parseInt(this.txtCodigo.getText()));
		return bairro;
	}

	protected void btnExcluirActionPerformed(ActionEvent e) {
		try {
			if (Mensagem.confirma(this, "Deseja realmente excluir esse registro?") == JOptionPane.YES_OPTION) {
				if (!this.txtCodigo.getText().isEmpty()) {
					Bairro b = new Bairro();
					b.setId(Integer.parseInt(this.txtCodigo.getText()));

					this.bDao = new BairroDAO(this.getConnection());
					if (this.bDao.delete(b)) {
						this.btnNovoActionPerformed(null);
					}
				} else {
					Mensagem.erro(this, "É necessário que seja informado o código do registro antes de realizar a exclusão.");
				}
			}
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
	}

	protected void btnPesquisarActionPerformed(ActionEvent e) {
		try {
			FrmConsultaBairro consulta = new FrmConsultaBairro(this, this.getConnection());

			if (consulta.execute()) {
				if (consulta.getSelecionadas().size() == 1) {
					this.abreRegistro(consulta.getSelecionadas().get(0));
				} else {
					Mensagem.aviso(this,
							"Você selecionou vários registros!\nPor gentileza, repita a operação e selecione apenas um registro.");
				}
			}

		} catch (SQLException ex) {
			Mensagem.erro(this, ex);

		}
	}

	/**
	 * @param bairro
	 */
	private void abreRegistro(Bairro bairro) {
		this.limpaCampos(this.getContentPane());
		this.txtCodigo.setText(String.valueOf(bairro.getId()));
		this.txtNome.setText(bairro.getNome());
		this.txtDescricao.setText(bairro.getDescricao());
	}

}
