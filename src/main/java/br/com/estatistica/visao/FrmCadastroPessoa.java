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

import br.com.estatistica.dao.TipoLogradouroDAO;
import br.com.estatistica.modelos.TipoLogradouro;
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
	private ObjectComboBoxModel<TipoLogradouro> comboBoxModel;

	public FrmCadastroPessoa(Connection connection) {
		super("Cadastro de Pessoa", connection);
		this.initComponents();
	}
	
	private void initComponents() {
		this.setSize(664, 479);
		
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
		this.cbEspecialista.setBounds(10, 91, 97, 23);
		this.panel.add(this.cbEspecialista);
		
		this.cbPesquisador = new JCheckBox("Pesquisador");
		this.cbPesquisador.setBounds(121, 91, 97, 23);
		this.panel.add(this.cbPesquisador);
		
		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 118, 73, 14);
		this.panel.add(this.lblDescrio);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 133, 459, 51);
		this.panel.add(this.scrollPane);
		
		this.txtDescricao = new JTextArea();
		this.txtDescricao.setLineWrap(true);
		this.scrollPane.setViewportView(this.txtDescricao);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setBounds(10, 193, 459, 195);
		this.panel.add(this.tabbedPane);
		
		this.panel_1 = new JPanel();
		this.tabbedPane.addTab("Endereço", null, this.panel_1, "Informações sobre localização.");
		this.panel_1.setLayout(null);
		
		this.lblLogradouro = new JLabel("Logradouro");
		this.lblLogradouro.setBounds(10, 11, 95, 14);
		this.panel_1.add(this.lblLogradouro);
		
		this.txtLogradouro = new JTextField();
		this.txtLogradouro.setBounds(68, 26, 218, 20);
		this.panel_1.add(this.txtLogradouro);
		this.txtLogradouro.setColumns(10);
		
		this.comboBoxModel = new ObjectComboBoxModel<TipoLogradouro>();
		this.comboBoxModel.setFormatter(new TipoLogradouroFormatter());
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
		this.scrollPane_1.setViewportView(this.txtEnderecoDescricao);

		this.panel_2 = new JPanel();
		this.tabbedPane.addTab("...", null, this.panel_2, null);
		
		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(arg0 -> FrmCadastroPessoa.this.btnNovoActionPerformed(arg0));
		this.btnNovo.setBounds(10, 399, 89, 30);
		this.panel.add(this.btnNovo);
		
		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(new Rectangle(0, 0, 0, 30));
		this.btnSalvar.setBounds(98, 399, 89, 30);
		this.panel.add(this.btnSalvar);
		
		this.btnExcluir = new JButton("Excluir");
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
			TipoLogradouroDAO dao = new TipoLogradouroDAO(this.getConnection());
			List<TipoLogradouro> all = dao.getAll();
			
			this.comboBoxModel.add(null);
			
			for (TipoLogradouro tipoLogradouro : all) {
				this.comboBoxModel.add(tipoLogradouro);
			}
		} catch (SQLException e) {
			Mensagem.erro(this, e);
		}
	}
	
	protected void btnNovoActionPerformed(ActionEvent arg0) {
		super.limpaCampos(this.getContentPane());
	}
}
