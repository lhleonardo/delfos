package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.ConnectionFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.JTable;

public class FrmCadastroPesquisa extends GenericFormCadastro {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	private JTextField textField_4;
	private JLabel lblResponsveis;
	private JLabel lblEspecialistas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroPesquisa frame = new FrmCadastroPesquisa();
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
	public FrmCadastroPesquisa() {
		super();
		setTitle("Cadastro de Pesquisas");

		setResizable(false);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(11, 11, 17, 14);
		panel.add(lblId);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 27, 34, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 11, 46, 14);
		panel.add(lblNome);

		textField_1 = new JTextField();
		textField_1.setBounds(50, 27, 354, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Limite de Especialistas");
		lblNewLabel.setBounds(11, 170, 187, 14);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(11, 195, 46, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = new ConnectionFactory().getConnection();
				Integer valor = 0;
				try{
					valor = Integer.parseInt(textField_2.getText());
					System.out.println(valor);
				}
				catch( NumberFormatException e1){
					e1.getMessage();
					System.out.println(e1);
				}
				try (PesquisaDAO pesquisaDAO = new PesquisaDAO(con)){
					
					Pesquisa p1 = new Pesquisa(textField_1.getText(), valor);
					pesquisaDAO.insert(p1);
				}
				catch(Exception e1){
					
				}
				Toolkit.getDefaultToolkit().beep();

			}
		});
		btnSalvar.setBounds(10, 428, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(109, 428, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 58, 64, 14);
		panel.add(lblDescrio);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		editorPane.setBounds(10, 84, 282, 75);
		panel.add(editorPane);
		
		this.textField_3 = new JTextField();
		this.textField_3.setBounds(11, 242, 281, 20);
		panel.add(this.textField_3);
		this.textField_3.setColumns(10);
		
		this.table = new JTable();
		this.table.setBounds(11, 273, 282, 142);
		panel.add(this.table);
		
		this.table_1 = new JTable();
		this.table_1.setBounds(302, 273, 282, 142);
		panel.add(this.table_1);
		
		this.textField_4 = new JTextField();
		this.textField_4.setColumns(10);
		this.textField_4.setBounds(303, 242, 281, 20);
		panel.add(this.textField_4);
		
		this.lblResponsveis = new JLabel("Responsáveis:");
		this.lblResponsveis.setBounds(11, 228, 85, 14);
		panel.add(this.lblResponsveis);
		
		this.lblEspecialistas = new JLabel("Especialistas:");
		this.lblEspecialistas.setBounds(302, 228, 64, 14);
		panel.add(this.lblEspecialistas);
	}
}
