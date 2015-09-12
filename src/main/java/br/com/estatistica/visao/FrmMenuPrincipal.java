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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setExtendedState(Frame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = criaMenuCadastro();

		menuBar.add(mnCadastro);

		aplicaRegraDePermissao(ConnectionFactory.getUsuarioConectado(), mnCadastro);

		setContentPane(contentPane);
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
		// if (obj instanceof JMenuBar) {
		// for (Component c : ((JMenuBar) obj).getComponents()) {
		// getMenuItems(c);
		// }
		// }
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
		mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroPessoa.class));
		mnCadastro.add(mnItemCadastroPessoa);
		this.addFuncao(mnItemCadastroPessoa, FrmCadastroPessoa.class.getSimpleName());

		JMenuItem mnItemCadastroPesquisa = new JMenuItem("Cadastro de Pesquisa");
		mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroPesquisa.class));
		mnCadastro.add(mnItemCadastroPesquisa);
		this.addFuncao(mnItemCadastroPesquisa, FrmCadastroPesquisa.class.getSimpleName());

		JMenuItem mnItemCadastroQuestionario = new JMenuItem("Cadastro de Questionários");
		mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroQuestionario.class));
		mnCadastro.add(mnItemCadastroQuestionario);
		this.addFuncao(mnItemCadastroQuestionario, FrmCadastroQuestionario.class.getSimpleName());

		JMenuItem mnItemCadastroUsuario = new JMenuItem("Cadastro de Usuário");
		mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroUsuario.class));
		mnCadastro.add(mnItemCadastroUsuario);
		this.addFuncao(mnItemCadastroUsuario, FrmCadastroUsuario.class.getSimpleName());

		JMenuItem mnItemCadastroPerfil = new JMenuItem("Cadastro de Perfil de Acesso");
		mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroPerfilAcesso.class));
		mnCadastro.add(mnItemCadastroPerfil);
		this.addFuncao(mnItemCadastroPerfil, FrmCadastroPerfilAcesso.class.getSimpleName());

		JMenuItem mnItemCadastroFuncionalidade = new JMenuItem("Cadastro de Funcionalidade");
		mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroFuncionalidade.class));
		mnCadastro.add(mnItemCadastroFuncionalidade);
		this.addFuncao(mnItemCadastroFuncionalidade, FrmCadastroFuncionalidade.class.getSimpleName());

		JMenu mnLocalizao = new JMenu("Localização");
		mnCadastro.add(mnLocalizao);

		JMenuItem mntmCadastroDeCidades = new JMenuItem("Cadastro de Cidades");
		// mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroPessoa.class));
		mnLocalizao.add(mntmCadastroDeCidades);
		this.addFuncao(mntmCadastroDeCidades, FrmCadastroCidades.class.getSimpleName());

		JMenuItem mntmCadastroDeEstados = new JMenuItem("Cadastro de Estados");
		// mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroPessoa.class));
		mnLocalizao.add(mntmCadastroDeEstados);
		this.addFuncao(mntmCadastroDeEstados, FrmCadastroEstados.class.getSimpleName());

		JMenuItem mntmCadastroDeBairros = new JMenuItem("Cadastro de Bairros");
		// mnItemCadastroPessoa.addActionListener(chamaTelaParaItemDeMenu(FrmCadastroPessoa.class));
		mnLocalizao.add(mntmCadastroDeBairros);
		this.addFuncao(mntmCadastroDeBairros, FrmCadastroBairros.class.getSimpleName());

		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(mnItemSairActionPerformed());
		mnCadastro.add(mntmSair);

		return mnCadastro;
	}

	protected ActionListener chamaTelaParaItemDeMenu(Class<? extends JFrame> classe) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JFrame frame = classe.newInstance();
					frame.setVisible(true);
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	}

}
