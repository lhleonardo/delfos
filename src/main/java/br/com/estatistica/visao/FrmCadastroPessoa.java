package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.bean.LogradouroFormatter;
import br.com.estatistica.dao.LogradouroDAO;
import br.com.estatistica.dao.PessoaDAO;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.Cidade;
import br.com.estatistica.modelos.Cnpj;
import br.com.estatistica.modelos.Cpf;
import br.com.estatistica.modelos.Endereco;
import br.com.estatistica.modelos.Especialista;
import br.com.estatistica.modelos.Logradouro;
import br.com.estatistica.modelos.Pesquisador;
import br.com.estatistica.modelos.PesquisadorEspecialista;
import br.com.estatistica.modelos.Pessoa;
import br.com.estatistica.modelos.table.ObjectComboBoxModel;
import br.com.estatistica.util.Mensagem;

public class FrmCadastroPessoa extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton txtPesquisar;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblCpfcnpj;
	private JLabel lblRgie;
	private JFormattedTextField txtEmail;
	private JFormattedTextField txtRgIe;
	private JFormattedTextField txtCpfCnpj;
	private JLabel lblEmail;
	private JCheckBox cbEspecialista;
	private JCheckBox cbPesquisador;
	private JLabel lblDescrio;
	private JTextArea txtDescricao;
	private JScrollPane scrollPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblLogradouro;
	private JTextField txtLogradouro;

	@SuppressWarnings("rawtypes")
	private JComboBox cbLogradouro;

	private JLabel lblNmero;
	private JTextField txtEnderecoNumero;
	private JLabel lblCep;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JFormattedTextField txtEnderecoCep;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JButton btnPesquisaBairro;
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JButton btnPesquisaCidade;
	private JLabel lblDescrio_1;
	private JTextArea txtEnderecoDescricao;
	private JScrollPane scrollPane_1;
	private ObjectComboBoxModel<Logradouro> comboBoxModel;
	private LogradouroDAO tDao;

	private Bairro bairro = null;
	private Logradouro tipoLogradouro = null;
	private Cidade cidade = null;
	private PessoaDAO pDao;
	private Integer idEndereco;

	public FrmCadastroPessoa(Connection connection) {
		super("Cadastro de Pessoa", connection);
		this.initComponents();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initComponents() {
		this.setSize(664, 479);

		this.setResizable(false);

		this.panel = new JPanel();
		
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblCdigo = new JLabel("Código");
		this.lblCdigo.setBounds(10, 11, 67, 14);
		this.panel.add(this.lblCdigo);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setEditable(false);
		this.txtCodigo.setBounds(10, 25, 46, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);

		this.txtPesquisar = new JButton("");
		this.txtPesquisar.addActionListener(e -> FrmCadastroPessoa.this.txtPesquisarActionPerformed(e));
		this.txtPesquisar.setBounds(56, 24, 27, 23);
		this.panel.add(this.txtPesquisar);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(89, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.txtNome = new JTextField();
		this.txtNome.setBounds(89, 25, 380, 20);
		this.panel.add(this.txtNome);
		this.txtNome.setColumns(10);

		this.lblCpfcnpj = new JLabel("CPF/CNPJ");
		this.lblCpfcnpj.setBounds(10, 47, 73, 14);
		this.panel.add(this.lblCpfcnpj);

		this.lblRgie = new JLabel("RG/IE");
		this.lblRgie.setBounds(121, 47, 64, 14);
		this.panel.add(this.lblRgie);

		this.txtEmail = new JFormattedTextField();
		this.txtEmail.setBounds(234, 64, 235, 20);
		this.panel.add(this.txtEmail);

		this.txtRgIe = new JFormattedTextField();
		this.txtRgIe.setBounds(121, 64, 101, 20);
		this.panel.add(this.txtRgIe);

		this.txtCpfCnpj = new JFormattedTextField();
		this.txtCpfCnpj.setBounds(10, 64, 103, 20);
		this.panel.add(this.txtCpfCnpj);

		this.lblEmail = new JLabel("E-mail");
		this.lblEmail.setBounds(234, 47, 46, 14);
		this.panel.add(this.lblEmail);

		this.cbEspecialista = new JCheckBox("Especialista");
		this.cbEspecialista.setBounds(10, 91, 125, 23);
		this.panel.add(this.cbEspecialista);

		this.cbPesquisador = new JCheckBox("Pesquisador");
		this.cbPesquisador.setBounds(153, 92, 122, 23);
		this.panel.add(this.cbPesquisador);

		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 118, 73, 14);
		this.panel.add(this.lblDescrio);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 133, 459, 51);
		this.panel.add(this.scrollPane);

		this.txtDescricao = new JTextArea();
		this.txtDescricao.setLocation(10, 0);
		this.txtDescricao.setLineWrap(true);
		this.scrollPane.setViewportView(this.txtDescricao);

		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBounds(10, 193, 459, 195);
		this.panel.add(this.tabbedPane);

		this.panel_1 = new JPanel();
		this.panel_1.setLocation(10, 25);
		this.tabbedPane.addTab("Endereço", null, this.panel_1, "Informações sobre localização.");
		this.panel_1.setLayout(null);

		this.lblLogradouro = new JLabel("Logradouro");
		this.lblLogradouro.setBounds(10, 11, 95, 14);
		this.panel_1.add(this.lblLogradouro);

		this.txtLogradouro = new JTextField();
		this.txtLogradouro.setBounds(68, 26, 218, 20);
		this.panel_1.add(this.txtLogradouro);
		this.txtLogradouro.setColumns(10);

		this.comboBoxModel = new ObjectComboBoxModel<Logradouro>();
		this.comboBoxModel.setFormatter(new LogradouroFormatter());
		this.preencheComboBox();
		this.cbLogradouro = new JComboBox(this.comboBoxModel);
		this.cbLogradouro.setBounds(10, 26, 57, 20);
		this.panel_1.add(this.cbLogradouro);

		this.lblNmero = new JLabel("Número");
		this.lblNmero.setBounds(291, 11, 57, 14);
		this.panel_1.add(this.lblNmero);

		this.txtEnderecoNumero = new JTextField();
		this.txtEnderecoNumero.setBounds(291, 26, 57, 20);
		this.panel_1.add(this.txtEnderecoNumero);
		this.txtEnderecoNumero.setColumns(10);

		this.lblCep = new JLabel("CEP");
		this.lblCep.setBounds(355, 11, 80, 14);
		this.panel_1.add(this.lblCep);

		this.txtEnderecoCep = new JFormattedTextField();
		this.txtEnderecoCep.setBounds(355, 26, 89, 20);
		this.panel_1.add(this.txtEnderecoCep);

		this.lblBairro = new JLabel("Bairro");
		this.lblBairro.setBounds(10, 46, 80, 14);
		this.panel_1.add(this.lblBairro);

		this.txtBairro = new JTextField();
		this.txtBairro.setEditable(false);
		this.txtBairro.setBounds(10, 62, 209, 20);
		this.panel_1.add(this.txtBairro);
		this.txtBairro.setColumns(10);

		this.btnPesquisaBairro = new JButton("");
		this.btnPesquisaBairro.setBounds(220, 61, 27, 23);
		this.panel_1.add(this.btnPesquisaBairro);

		this.lblCidade = new JLabel("Cidade");
		this.lblCidade.setBounds(255, 46, 73, 14);
		this.panel_1.add(this.lblCidade);

		this.txtCidade = new JTextField();
		this.txtCidade.setBounds(255, 62, 165, 20);
		this.panel_1.add(this.txtCidade);
		this.txtCidade.setColumns(10);

		this.btnPesquisaCidade = new JButton("");
		this.btnPesquisaCidade.setBounds(420, 61, 27, 23);
		this.panel_1.add(this.btnPesquisaCidade);

		this.lblDescrio_1 = new JLabel("Descrição");
		this.lblDescrio_1.setBounds(10, 87, 80, 14);
		this.panel_1.add(this.lblDescrio_1);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 102, 434, 54);
		this.panel_1.add(this.scrollPane_1);

		this.txtEnderecoDescricao = new JTextArea();
		this.txtEnderecoDescricao.setLocation(10, 0);
		this.scrollPane_1.setViewportView(this.txtEnderecoDescricao);

		this.panel_2 = new JPanel();
		this.tabbedPane.addTab("...", null, this.panel_2, null);

		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(arg0 -> FrmCadastroPessoa.this.btnNovoActionPerformed(arg0));
		this.btnNovo.setBounds(10, 399, 89, 30);
		this.panel.add(this.btnNovo);

		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.addActionListener(e -> FrmCadastroPessoa.this.btnSalvarActionPerformed(e));
		this.btnSalvar.setBounds(new Rectangle(0, 0, 0, 30));
		this.btnSalvar.setBounds(98, 399, 89, 30);
		this.panel.add(this.btnSalvar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(e -> FrmCadastroPessoa.this.btnExcluirActionPerformed(e));
		this.btnExcluir.setBounds(new Rectangle(0, 0, 0, 30));
		this.btnExcluir.setBounds(186, 399, 89, 30);
		this.panel.add(this.btnExcluir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(new Rectangle(0, 0, 0, 30));
		this.btnCancelar.setBounds(380, 399, 89, 30);
		this.panel.add(this.btnCancelar);
	}

	private void preencheComboBox() {
		try {
			this.tDao = new LogradouroDAO(this.getConnection());
			List<Logradouro> all = this.tDao.getAll();

			this.comboBoxModel.add(null);

			for (Logradouro tipoLogradouro : all) {
				this.comboBoxModel.add(tipoLogradouro);
			}
		} catch (SQLException e) {
			Mensagem.erro(this, e);
		}
	}

	protected void btnNovoActionPerformed(ActionEvent arg0) {
		super.limpaCampos(this.getContentPane());
		this.bairro = null;
		this.cidade = null;
		this.tipoLogradouro = null;
		this.idEndereco = null;
		this.txtNome.requestFocus();
	}

	protected void btnSalvarActionPerformed(ActionEvent e) {

		try {
			Pessoa p = this.retornaTipoDePessoa();

			p.setId(Integer.parseInt((this.txtCodigo.getText().isEmpty()) ? null : this.txtCodigo.getText()));
			p.setNome(this.txtNome.getText());
			p.setTipoDocumento((this.txtCpfCnpj.getText().length() == 7) ? new Cpf(this.txtCpfCnpj.getText()) : new Cnpj(this.txtCpfCnpj
					.getText()));
			p.setRg(this.txtRgIe.getText());
			p.setEmail(this.txtEmail.getText());
			p.setDescricao(this.txtDescricao.getText());

			Endereco end = new Endereco();
			end.setId(this.idEndereco);
			end.setLogradouro(this.txtLogradouro.getText());
			end.setCep(this.txtEnderecoCep.getText());
			end.setNumero(this.txtEnderecoNumero.getText());
			end.setBairro(this.bairro);
			end.setTipoLogradouro(this.tipoLogradouro);
			end.setCidade(this.cidade);

			p.setEndereco(end);

			this.pDao = new PessoaDAO(this.getConnection());
			this.pDao.save(p);
		} catch (SQLException ex) {
			Mensagem.erro(this, ex);
		}
	}

	/**
	 * @return
	 */
	private Pessoa retornaTipoDePessoa() {
		// caso seja um pesquisador e poderá ser um especialista, ele será um
		// PesquisadorEspecialista
		// para os outros casos, ele será um pesquisador ou especialista.
		if (this.cbPesquisador.isSelected() && this.cbEspecialista.isSelected()) {
			return new PesquisadorEspecialista();
		} else if (this.cbPesquisador.isSelected() && !this.cbEspecialista.isSelected()) {
			return new Pesquisador();
		} else if (!this.cbPesquisador.isSelected() && this.cbEspecialista.isSelected()) {
			return new Especialista();
		} else {
			return null;
		}

	}

	protected void txtPesquisarActionPerformed(ActionEvent e) {
		String informacao = "Informe o tipo de consulta que deseja fazer\n1-codigo / 2-nome";
		Integer valor = Integer.parseInt(Mensagem.entrada(this, informacao));

		switch (valor) {
			case 1:
				try {
					this.pDao = new PessoaDAO(this.getConnection());
					this.posicionaRegistro(this.buscaPorCodigo());

					break;
				} catch (NumberFormatException | SQLException ex) {
					Mensagem.erro(this, ex);
					break;
				}

			case 2:
				try {
					this.pDao = new PessoaDAO(this.getConnection());

					this.posicionaRegistro(this.buscaPorNome());

				} catch (SQLException ex) {
					Mensagem.erro(this, ex);
				}
			default:
				break;
		}

	}

	protected Pessoa buscaPorCodigo() throws SQLException {
		return this.pDao.get(Integer.parseInt(Mensagem.entrada(this, "Informe o código do cliente que deseja encontrar")));
	}

	protected Pessoa buscaPorNome() throws SQLException {
		List<Pessoa> list = this.pDao.get(Mensagem.entrada(this, "Informe o parâmetro da pesquisa: "));

		for (Pessoa pessoa : list) {
			Mensagem.informa(this, pessoa.toString());
		}

		return this.buscaPorCodigo();
	}

	/**
	 * @param pessoa
	 */
	private void posicionaRegistro(Pessoa pessoa) {
		// TODO Implementar lógica para o método gerado automaticamente.
		// posicionar os valores nos seus determinados campos.

	}

	protected void btnExcluirActionPerformed(ActionEvent e) {
		if (!this.txtCodigo.getText().isEmpty()) {
			try {
				Pessoa p = new Pessoa(Integer.parseInt(this.txtCodigo.getText()));

				this.pDao = new PessoaDAO(this.getConnection());
				this.pDao.delete(p);
			} catch (SQLException ex) {
				Mensagem.erro(this, ex);
			}
		} else {
			Mensagem.aviso(this, "Nenhum registro está aberto para ser excluído.");
		}
	}
}
