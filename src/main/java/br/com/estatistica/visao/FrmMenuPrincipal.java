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
		
		this.aplicaRegraDePermissao(ConnectionFactory.getUsuarioConectado(), mnCadastro);
		
		this.setContentPane(this.contentPane);
	}
	
	private void aplicaRegraDePermissao(Usuario usuario, JMenu jMenuBar) {
		List<JMenuItem> items = this.getMenuItems(jMenuBar);
		
		Map<Funcionalidade, Boolean> permissoes = usuario.getPerfilAcesso().getPermissoes();
		
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
		
		JMenu mnCadastro = new JMenu("Cadastro");
		
		JMenuItem mnItemCadastroPessoa = new JMenuItem("Cadastro de Pessoa");
		this.addFuncao(mnItemCadastroPessoa, FrmCadastroPessoa.class.getSimpleName());
		mnItemCadastroPessoa.addActionListener(e -> FrmMenuPrincipal.this.mnItemCadastroPessoaActionPerformed(e));
		mnCadastro.add(mnItemCadastroPessoa);
		
		JMenuItem mnItemCadastroPesquisa = new JMenuItem("Cadastro de Pesquisa");
		// mnItemCadastroPessoa.addActionListener(this.chamaTelaParaItemDeMenu(FrmCadastroPesquisa.class));
		mnCadastro.add(mnItemCadastroPesquisa);
		this.addFuncao(mnItemCadastroPesquisa, FrmCadastroPesquisa.class.getSimpleName());
		
		JMenuItem mnItemCadastroQuestionario = new JMenuItem("Cadastro de Questionários");
		// mnItemCadastroPessoa.addActionListener(this.chamaTelaParaItemDeMenu(FrmCadastroQuestionario.class));
		mnCadastro.add(mnItemCadastroQuestionario);
		this.addFuncao(mnItemCadastroQuestionario, FrmCadastroQuestionario.class.getSimpleName());
		
		JMenuItem mnItemCadastroUsuario = new JMenuItem("Cadastro de Usuário");
		// mnItemCadastroPessoa.addActionListener(this.chamaTelaParaItemDeMenu(FrmCadastroUsuario.class));
		mnCadastro.add(mnItemCadastroUsuario);
		this.addFuncao(mnItemCadastroUsuario, FrmCadastroUsuario.class.getSimpleName());
		
		JMenuItem mnItemCadastroPerfil = new JMenuItem("Cadastro de Perfil de Acesso");
		// mnItemCadastroPessoa.addActionListener(this.chamaTelaParaItemDeMenu(FrmCadastroPerfilAcesso.class));
		mnCadastro.add(mnItemCadastroPerfil);
		this.addFuncao(mnItemCadastroPerfil, FrmCadastroPerfilAcesso.class.getSimpleName());
		
		JMenuItem mnItemCadastroFuncionalidade = new JMenuItem("Cadastro de Funcionalidade");
		// mnItemCadastroPessoa.addActionListener(this.chamaTelaParaItemDeMenu(FrmCadastroFuncionalidade.class));
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
		this.addFuncao(mntmCadastroDeBairros, FrmCadastroBairro.class.getSimpleName());
		
		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this.mnItemSairActionPerformed());
		mnCadastro.add(mntmSair);
		
		return mnCadastro;
	}
	
	protected void mnItemCadastroPessoaActionPerformed(ActionEvent e) {
		FrmCadastroPessoa pessoa = new FrmCadastroPessoa();
		pessoa.setVisible(true);
	}
	
	protected ActionListener chamaTelaParaItemDeMenu(Class<? extends GenericFormCadastro> classe) {
		return arg0 -> {
			try {
				JFrame frame = classe.newInstance();
				frame.setVisible(true);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	private void addFuncao(JMenuItem chave, String valor) {
		this.funcoes.put(chave, valor);
	}
	
	protected ActionListener mnItemSairActionPerformed() {
		return e -> Mensagem.confirmaSaidaDoPrograma();
	}
	
	public void configPermissoes(Usuario usuario) {
		// cria os menus a partir da permissão do usuário.
	}
	
}
