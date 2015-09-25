package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmMenuPrincipal frame = new FrmMenuPrincipal();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmMenuPrincipal() {
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

		this.aplicaRegraDePermissao(ConnectionFactory.getUsuarioConectado(),
				mnCadastro);

		this.setContentPane(this.contentPane);
	}

	private void aplicaRegraDePermissao(Usuario usuario, JMenu jMenuBar) {
		List<JMenuItem> items = this.getMenuItems(jMenuBar);

		Map<Funcionalidade, Boolean> permissoes = usuario.getPerfilAcesso()
				.getPermissoes();

		for (JMenuItem jMenu : items) {

			for (Funcionalidade funcionalidade : permissoes.keySet()) {
				if (funcionalidade.getChave() == this.funcoes.get(jMenu)) {
					jMenu.setVisible(permissoes.get(funcionalidade));
				}
			}

		}
	}

	private List<JMenuItem> getMenuItems(Object obj) {
		List<JMenuItem> menus = new ArrayList<JMenuItem>();

		if (obj instanceof JMenu) {
			for (Component c : ((JMenu) obj).getMenuComponents()) {
				if (c instanceof JMenuItem) {
					menus.add((JMenuItem) c);
				}
			}
		}

		return menus;

	}

	private JMenu criaMenuCadastro() {

		this.mnCadastro = new JMenu("Cadastro");

		this.mnItemCadastroPessoa = this.criaMenu("Cadastro de Pessoa",
				FrmCadastroPessoa.class);

		// this.mnItemCadastroPesquisa = this.criaMenu("Cadastro de Pesquisa",
		// FrmCadastroPesquisa.class);

		this.mnItemCadastroPesquisa = new JMenuItem("Cadastro de Pesquisa");
		this.addFuncao(mnItemCadastroPesquisa, FrmCadastroPesquisa.class.getSimpleName());
		mnItemCadastroPesquisa.addActionListener(e -> FrmMenuPrincipal.this
				.chamaTelaActionPerformed(e));
		this.mnCadastro.add(mnItemCadastroPesquisa);

		this.mnItemCadastroQuestionario = this.criaMenu(
				"Cadastro de Questionários", FrmCadastroQuestionario.class);

		this.mnItemCadastroUsuario = this.criaMenu("Cadastro de Usuário",
				FrmCadastroUsuario.class);

		this.mnItemCadastroPerfil = this.criaMenu(
				"Cadastro de Perfis de Acesso", FrmCadastroPerfilAcesso.class);

		this.mnItemCadastroFuncionalidade = this.criaMenu(
				"Cadastro de Funcionalidades", FrmCadastroFuncionalidade.class);

		JMenu mnLocalizao = new JMenu("Localização");
		this.mnCadastro.add(mnLocalizao);

		this.mnItemCadastroDeCidades = this.criaMenu("Cadastro de Cidades",
				FrmCadastroCidade.class);

		this.mnItemCadastroDeEstados = this.criaMenu("Cadastro de Estados",
				FrmCadastroEstado.class);

		this.mnItemCadastroDeBairros = this.criaMenu("Cadastro de Bairros",
				FrmCadastroBairro.class);

		JSeparator separator = new JSeparator();
		this.mnCadastro.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this.mnItemSairActionPerformed());
		this.mnCadastro.add(mntmSair);

		return this.mnCadastro;
	}

	private JMenuItem criaMenu(String texto,
			Class<? extends GenericFormCadastro> clazz) {
		JMenuItem mnItem = new JMenuItem(texto);
		this.addFuncao(mnItem, clazz.getSimpleName());
		mnItem.addActionListener(e -> FrmMenuPrincipal.this
				.chamaTelaActionPerformed(e));
		this.mnCadastro.add(mnItem);
		return mnItem;

	}

	private void chamaTelaActionPerformed(ActionEvent e) {
		try {
			for (JMenuItem menu : this.funcoes.keySet()) {
				if (menu.getText().equals(e.getActionCommand())) {

					Class<?> class1 = Class.forName("br.com.estatistica.visao."
							+ this.funcoes.get(menu));
					JFrame frame = (JFrame) class1.newInstance();
					frame.setVisible(true);
				}
			}
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e1) {
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
