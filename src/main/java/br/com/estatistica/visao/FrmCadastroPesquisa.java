package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.ConnectionFactory;

import java.awt.event.ActionListener;

public class FrmCadastroPesquisa extends GenericFormCadastro {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroPesquisa frame = new FrmCadastroPesquisa(null);
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
	public FrmCadastroPesquisa(Connection connection) {
		super("Cadastro de Pesquisas", connection);

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
		textField_2.setBounds(11, 195, 64, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = new ConnectionFactory().getConnection();
				
				try (PesquisaDAO pesquisaDAO = new PesquisaDAO(con)){
					
					Pesquisa p1 = new Pesquisa(textField_1.getText(), null, null);
					pesquisaDAO.insert(p1);
				}
				catch(Exception e1){
					
				}
				Toolkit.getDefaultToolkit().beep();
			}
		});
		btnSalvar.setBounds(10, 428, 89, 23);
		panel.add(btnSalvar);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 58, 64, 14);
		panel.add(lblDescrio);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		editorPane.setBounds(10, 84, 282, 75);
		panel.add(editorPane);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Toolkit.getDefaultToolkit().beep();
				
			}
		});
		btnCancelar.setBounds(109, 428, 89, 23);
		panel.add(btnCancelar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
