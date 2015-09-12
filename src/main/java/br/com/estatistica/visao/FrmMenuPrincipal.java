package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import br.com.estatistica.modelos.Usuario;
import br.com.estatistica.util.Mensagem;

public class FrmMenuPrincipal extends JFrame {

	private JPanel contentPane;

	private Map<JMenuItem, String> funcoes = new HashMap<JMenuItem, String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMenuPrincipal() {
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

		setContentPane(contentPane);
	}

	private JMenu criaMenuCadastro() {
		JMenu mnCadastro = new JMenu("Cadastro");

		JMenuItem mnItemCadastroPessoa = new JMenuItem("Cadastro de Pessoa");
		mnCadastro.add(mnItemCadastroPessoa);
		this.addFuncao(mnItemCadastroPessoa, FrmCadastroPessoa.class.getSimpleName());

		JMenuItem mnItemCadastroPesquisa = new JMenuItem("Cadastro de Pesquisa");
		mnCadastro.add(mnItemCadastroPesquisa);
		this.addFuncao(mnItemCadastroPesquisa, FrmCadastroPesquisa.class.getSimpleName());

		JMenuItem mnItemCadastroQuestionario = new JMenuItem("Cadastro de Questionários");
		mnCadastro.add(mnItemCadastroQuestionario);
		this.addFuncao(mnItemCadastroQuestionario, FrmCadastroQuestionario.class.getSimpleName());

		JMenuItem mnItemCadastroUsuario = new JMenuItem("Cadastro de Usuário");
		mnCadastro.add(mnItemCadastroUsuario);
		this.addFuncao(mnItemCadastroUsuario, FrmCadastroUsuario.class.getSimpleName());

		JMenuItem mntmCadastroDePerfil = new JMenuItem("Cadastro de Perfil de Acesso");
		mnCadastro.add(mntmCadastroDePerfil);

		JMenuItem mntmCadastroDeFuncionalidade = new JMenuItem("Cadastro de Funcionalidade");
		mnCadastro.add(mntmCadastroDeFuncionalidade);

		JMenu mnLocalizao = new JMenu("Localização");
		mnCadastro.add(mnLocalizao);

		JMenuItem mntmCadastroDeCidades = new JMenuItem("Cadastro de Cidades");
		mnLocalizao.add(mntmCadastroDeCidades);

		JMenuItem mntmCadastroDeEstados = new JMenuItem("Cadastro de Estados");
		mnLocalizao.add(mntmCadastroDeEstados);

		JMenuItem mntmCadastroDeBairros = new JMenuItem("Cadastro de Bairros");
		mnLocalizao.add(mntmCadastroDeBairros);

		JSeparator separator = new JSeparator();
		mnCadastro.add(separator);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(mnItemSairActionPerformed());
		mnCadastro.add(mntmSair);

		return mnCadastro;
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
