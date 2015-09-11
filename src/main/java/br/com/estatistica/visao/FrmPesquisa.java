package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmPesquisa extends GenericFormCadastro {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPesquisa frame = new FrmPesquisa();
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
	
//	
	public FrmPesquisa() {
		super.initComponents("Cadastro de pesquisas");
	}
	
	@Override
	protected void initComponents(String nameFrame) {
		// aqui estão as config padrões
		super.initComponents(nameFrame);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
