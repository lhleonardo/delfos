package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmMenuPrincipal extends JFrame {

	private JPanel contentPane;

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
		super("Software Delfos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setExtendedState(MAXIMIZED_BOTH);

		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(menuSairActionPerformed());
		mnArquivo.add(mntmSair);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		JMenuItem mntmCadastroDePessoa = new JMenuItem("Cadastro de Pessoa");
		mnCadastro.add(mntmCadastroDePessoa);

		JMenuItem mntmCadastroDeQuestionrios = new JMenuItem("Cadastro de Questionários");
		mnCadastro.add(mntmCadastroDeQuestionrios);

		JMenu mnQuestionrios = new JMenu("Questionários");
		menuBar.add(mnQuestionrios);

		JMenuItem mntmResponder = new JMenuItem("Responder ");
		mnQuestionrios.add(mntmResponder);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private ActionListener menuSairActionPerformed() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		};
	}

}
