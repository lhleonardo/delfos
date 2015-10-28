package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.dao.LogradouroDAO;
import br.com.estatistica.modelos.Logradouro;
import br.com.estatistica.util.Mensagem;

/**
 * @author Leonardo Braz
 *
 */
public class FrmCadastroLogradouro extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton btnPesquisar;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblSigla;
	private JTextField txtSigla;
	private JLabel lblDescrio;
	private JTextArea txtDescricao;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private LogradouroDAO dao;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroLogradouro frame = new FrmCadastroLogradouro(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmCadastroLogradouro(Connection connection) {
		super("Cadastro de Logradouros", connection);
		this.initComponents();
	}

	private void initComponents() {

		this.setSize(685, 410);

		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblCdigo = new JLabel("Código");
		this.lblCdigo.setBounds(10, 11, 59, 14);
		this.panel.add(this.lblCdigo);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setEditable(false);
		this.txtCodigo.setBounds(10, 26, 46, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);

		this.btnPesquisar = new JButton("");
		this.btnPesquisar.setBounds(56, 25, 27, 23);
		this.panel.add(this.btnPesquisar);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(87, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.txtNome = new JTextField();
		this.txtNome.setBounds(87, 26, 278, 20);
		this.panel.add(this.txtNome);
		this.txtNome.setColumns(10);

		this.lblSigla = new JLabel("Sigla");
		this.lblSigla.setBounds(369, 11, 46, 14);
		this.panel.add(this.lblSigla);

		this.txtSigla = new JTextField();
		this.txtSigla.setBounds(369, 26, 107, 20);
		this.panel.add(this.txtSigla);
		this.txtSigla.setColumns(10);

		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 57, 73, 14);
		this.panel.add(this.lblDescrio);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 73, 466, 226);
		this.panel.add(this.scrollPane);

		this.txtDescricao = new JTextArea();
		this.txtDescricao.setLocation(0, 0);
		this.scrollPane.setViewportView(this.txtDescricao);

		this.panel_1 = new JPanel();
		this.panel_1.setLayout(null);
		this.panel_1.setBounds(10, 310, 466, 43);
		this.panel.add(this.panel_1);

		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(arg0 -> FrmCadastroLogradouro.this.btnNovoActionPerformed(arg0));
		this.btnNovo.setBounds(0, 0, 92, 43);
		this.panel_1.add(this.btnNovo);

		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.addActionListener(arg0 -> FrmCadastroLogradouro.this.btnSalvarActionPerformed(arg0));
		this.btnSalvar.setBounds(91, 0, 92, 43);
		this.panel_1.add(this.btnSalvar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.setBounds(183, 0, 92, 43);
		this.panel_1.add(this.btnExcluir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(374, 0, 92, 43);
		this.panel_1.add(this.btnCancelar);
	}

	protected void btnNovoActionPerformed(ActionEvent arg0) {
		this.limpaCampos(this);

	}

	protected void btnSalvarActionPerformed(ActionEvent arg0) {
		try {
			this.dao = new LogradouroDAO(this.getConnection());
			this.dao.save(this.criaModelo());
		} catch (SQLException ex) {
			Mensagem.erro(this, ex);
		}
	}

	protected Logradouro criaModelo() {
		Logradouro tipoLogradouro = new Logradouro();
		tipoLogradouro.setId(Integer.parseInt((this.txtCodigo.getText().isEmpty()) ? null : this.txtCodigo.getText()));
		tipoLogradouro.setNome(this.txtNome.getText());
		tipoLogradouro.setDescricao(this.txtDescricao.getText());
		tipoLogradouro.setSigla(this.txtSigla.getText());
		return tipoLogradouro;
	}
}
