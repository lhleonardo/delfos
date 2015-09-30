package br.com.estatistica.visao;


import java.awt.EventQueue;

import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Label;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import br.com.estatistica.dao.PerguntaDAO;
import br.com.estatistica.extractors.PerguntaExtractor;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.util.Mensagem;
import br.com.estatistica.util.ConnectionFactory;

import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;



public class FrmCadastroPergunta extends GenericFormCadastro {

	
	private static final long serialVersionUID = 1L;
	private JTextField txtOi;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroPergunta frame = new FrmCadastroPergunta(new ConnectionFactory().getConnection());;;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrmCadastroPergunta(Connection connection) {
		super("Cadastro de Pergunta", connection);
				
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
					
		txtOi.setHorizontalAlignment(SwingConstants.LEFT);
		txtOi.setBounds(29, 57, 451, 20);
		panel.add(txtOi);
		txtOi.setColumns(10);
		
		Label label = new Label("Pergunta:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(29, 28, 97, 23);
		panel.add(label);
		
		JLabel lblObservao = new JLabel("Observação:");
		lblObservao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservao.setBounds(29, 107, 112, 14);
		panel.add(lblObservao);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField = PerguntaExtractor
			}
		});
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(29, 57, 409, 23);
		panel.add(textField);
		
		JLabel lblTipoDePergunta = new JLabel("Tipo de Pergunta:");
		lblTipoDePergunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoDePergunta.setBounds(29, 206, 116, 14);
		panel.add(lblTipoDePergunta);
		
		JComboBox<?> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Coeficiente de Argumentação ", "Coeficiente de Competência"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(29, 232, 197, 20);
		panel.add(comboBox);
		
		JButton btnSalvar = new JButton("Cancelar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSalvar.setBounds(144, 417, 89, 23);
		panel.add(btnSalvar);
		
		JButton button = new JButton("Salvar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		button.setBounds(29, 417, 89, 23);
		panel.add(button);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		textField_1.setBounds(29, 132, 409, 35);
		panel.add(textField_1);
	}
						}


