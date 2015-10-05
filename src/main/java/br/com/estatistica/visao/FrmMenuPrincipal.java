package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import br.com.estatistica.modelos.Funcionalidade;
import br.com.estatistica.modelos.Usuario;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

public class FrmMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private Map<JMenuItem, String> funcoes = new HashMap<JMenuItem, String>();

	private JMenu mnCadastro;

	protected JMenuItem mnItemCadastroPessoa;
	protected JMenuItem mnItemCadastroPesquisa;
	protected JMenuItem mnItemCadastroQuestionario;
	protected JMenuItem mnItemCadastroUsuario;
	protected JMenuItem mnItemCadastroPerfil;
	protected JMenuItem mnItemCadastroFuncionalidade;
	protected JMenuItem mnItemCadastroDeCidades;
	protected JMenuItem mnItemCadastroDeEstados;
	protected JMenuItem mnItemCadastroDeBairros;

	private Connection connection;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmMenuPrincipal frame = new FrmMenuPrincipal(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmMenuPrincipal(Connection connection) {
		this.connection = connection;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		this.setExtendedState(Frame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mnCadastro = this.criaMenuCadastro();

		menuBar.add(mnCadastro);

		this.setContentPane(this.contentPane);
	}

	private JMenuItem aplicaRegraDePermissao(Usuario usuario, JMenuItem menuItem) {
		Map<Funcionalidade, Boolean> permissoes = usuario.getPerfilAcesso().getPermissoes();

		for (Funcionalidade funcionalidade : permissoes.keySet()) {
			if (funcionalidade.getChave() == this.funcoes.get(menuItem)) {
				menuItem.setVisible(permissoes.get(funcionalidade));
			}

		}

		return menuItem;
	}

	private JMenu criaMenuCadastro() {

		this.mnCadastro = new JMenu("Cadastro");

		this.mnItemCadastroPessoa = this.criaMenu("Cadastro de Pessoa", FrmCadastroPessoa.class);

		this.mnItemCadastroPesquisa = this.criaMenu("Cadastro de Pesquisa", FrmCadastroPesquisa.class);

		this.mnItemCadastroQuestionario = this.criaMenu("Cadastro de Questionários", FrmCadastroQuestionario.class);

		this.mnItemCadastroUsuario = this.criaMenu("Cadastro de Usuário", FrmCadastroUsuario.class);

		this.mnItemCadastroPerfil = this.criaMenu("Cadastro de Perfis de Acesso", FrmCadastroPerfilAcesso.class);

		this.mnItemCadastroFuncionalidade = this.criaMenu("Cadastro de Funcionalidades", FrmCadastroFuncionalidade.class);

		JMenu mnLocalizao = new JMenu("Localização");
		this.mnCadastro.add(mnLocalizao);

		this.mnItemCadastroDeCidades = this.criaMenu("Cadastro de Cidades", FrmCadastroCidade.class);

		this.mnItemCadastroDeEstados = this.criaMenu("Cadastro de Estados", FrmCadastroEstado.class);

		this.mnItemCadastroDeBairros = this.criaMenu("Cadastro de Bairros", FrmCadastroBairro.class);

		JSeparator separator = new JSeparator();
		this.mnCadastro.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this.mnItemSairActionPerformed());
		this.mnCadastro.add(mntmSair);

		return this.mnCadastro;
	}

	private JMenuItem criaMenu(String texto, Class<? extends GenericFormCadastro> clazz) {
		JMenuItem mnItem = new JMenuItem(texto);
		this.addFuncao(mnItem, clazz.getSimpleName());
		mnItem.addActionListener(e -> FrmMenuPrincipal.this.chamaTelaActionPerformed(e));
		// mnItem = this.aplicaRegraDePermissao(ConnectionFactory.getUsuarioConectado(),
		// mnItem);
		this.mnCadastro.add(mnItem);
		return mnItem;

	}

	private void chamaTelaActionPerformed(ActionEvent e) {
		try {
			for (JMenuItem menu : this.funcoes.keySet()) {
				if (menu.getText().equals(e.getActionCommand())) {
					Class<?> clazz = Class.forName("br.com.estatistica.visao." + this.funcoes.get(menu));

					Constructor<?> constructor = clazz.getConstructor(Connection.class);

					GenericFormCadastro form = (GenericFormCadastro) constructor.newInstance(this.connection);
					form.setVisible(true);
				}
			}
		} catch (Exception e1) {
			Mensagem.erro(this, e1);
		}
	}

	private void addFuncao(JMenuItem chave, String valor) {
		this.funcoes.put(chave, valor);
	}

	protected ActionListener mnItemSairActionPerformed() {
		return e -> Mensagem.confirmaSaidaDoPrograma();
	}

}
