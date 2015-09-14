package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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

	private Connection connection;

	private JMenu mnCadastro;

	public Map<JMenuItem, String> getFuncoes() {
		return funcoes;
	}

	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmMenuPrincipal(Connection connection) {
		this.connection = connection;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnCadastro = criaMenuCadastro();

		menuBar.add(mnCadastro);

		setContentPane(contentPane);

		setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	private void aplicaRegraDePermissao(Usuario usuario, JMenu jMenuBar) {
		List<JMenuItem> items = getMenuItems(jMenuBar);

		Map<Funcionalidade, Boolean> permissoes = usuario.getPerfilAcesso().getPermissoes();

		for (JMenuItem jMenu : items) {

			for (Funcionalidade funcionalidade : permissoes.keySet()) {
				if (funcionalidade.getChave() == funcoes.get(jMenu)) {
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

		JMenu mnCadastro = new JMenu("Cadastro");

		JMenuItem mnItemCadastroPessoa = new JMenuItem("Cadastro de Pessoa");
		mnItemCadastroPessoa.addActionListener(abreForm(new FrmCadastroPessoa(getConnection())));
		mnCadastro.add(mnItemCadastroPessoa);
		this.addFuncao(mnItemCadastroPessoa, FrmCadastroPessoa.class.getSimpleName());

		JMenuItem mnItemCadastroPesquisa = new JMenuItem("Cadastro de Pesquisa");
		mnItemCadastroPesquisa.addActionListener(abreForm(new FrmCadastroPesquisa(getConnection())));
		mnCadastro.add(mnItemCadastroPesquisa);
		this.addFuncao(mnItemCadastroPesquisa, FrmCadastroPesquisa.class.getSimpleName());

		JMenuItem mnItemCadastroQuestionario = new JMenuItem("Cadastro de Questionários");
		mnItemCadastroQuestionario.addActionListener(abreForm(new FrmCadastroQuestionario(getConnection())));
		mnCadastro.add(mnItemCadastroQuestionario);
		this.addFuncao(mnItemCadastroQuestionario, FrmCadastroQuestionario.class.getSimpleName());

		JMenuItem mnItemCadastroUsuario = new JMenuItem("Cadastro de Usuário");
		mnItemCadastroUsuario.addActionListener(abreForm(new FrmCadastroUsuario(getConnection())));
		mnCadastro.add(mnItemCadastroUsuario);
		this.addFuncao(mnItemCadastroUsuario, FrmCadastroUsuario.class.getSimpleName());

		JMenuItem mnItemCadastroPerfil = new JMenuItem("Cadastro de Perfil de Acesso");
		mnCadastro.add(mnItemCadastroPerfil);
		this.addFuncao(mnItemCadastroPerfil, FrmCadastroPerfilAcesso.class.getSimpleName());

		JMenuItem mnItemCadastroFuncionalidade = new JMenuItem("Cadastro de Funcionalidade");
		mnCadastro.add(mnItemCadastroFuncionalidade);
		this.addFuncao(mnItemCadastroFuncionalidade, FrmCadastroFuncionalidade.class.getSimpleName());

		JMenu mnLocalizao = new JMenu("Localização");
		mnCadastro.add(mnLocalizao);

		JMenuItem mntmCadastroDeCidades = new JMenuItem("Cadastro de Cidades");
		mnLocalizao.add(mntmCadastroDeCidades);
		this.addFuncao(mntmCadastroDeCidades, FrmCadastroCidade.class.getSimpleName());

		JMenuItem mntmCadastroDeEstados = new JMenuItem("Cadastro de Estados");
		mnLocalizao.add(mntmCadastroDeEstados);
		this.addFuncao(mntmCadastroDeEstados, FrmCadastroEstado.class.getSimpleName());

		JMenuItem mntmCadastroDeBairros = new JMenuItem("Cadastro de Bairros");
		mntmCadastroDeBairros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mntmCadastroDeBairrosActionPerformed(arg0);
			}
		});
		mnLocalizao.add(mntmCadastroDeBairros);
		this.addFuncao(mntmCadastroDeBairros, FrmCadastroBairro.class.getSimpleName());

		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(mnItemSairActionPerformed());
		mnCadastro.add(mntmSair);

		return mnCadastro;
	}

	private ActionListener abreForm(JFrame form) {
		// TODO Auto-generated method stub
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				form.setVisible(true);
			}
		};
	}

	private void addFuncao(JMenuItem chave, String valor) {
		funcoes.put(chave, valor);
	}

	protected ActionListener mnItemSairActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mensagem.confirmaSaidaDoPrograma();
			}
		};
	}

	public void configPermissoes(Usuario usuario) {
		// cria os menus a partir da permissão do usuário.
		aplicaRegraDePermissao(usuario, mnCadastro);
	}

	protected void mntmCadastroDeBairrosActionPerformed(ActionEvent arg0) {
		FrmCadastroBairro bairro = new FrmCadastroBairro(new ConnectionFactory().getConnection());
		bairro.setVisible(true);

	}
}
