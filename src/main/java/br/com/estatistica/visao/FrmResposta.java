package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import br.com.estatistica.modelos.Resposta;
import br.com.estatistica.modelos.Resposta;
import br.com.estatistica.modelos.Resposta;
import br.com.estatistica.modelos.Resposta;
import javax.swing.JLabel;
import javax.swing.JTable;

public class FrmResposta extends GenericFormCadastro {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmResposta frame = new FrmResposta();
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
	public FrmResposta() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(96, 102, 152, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnPreencher = new JButton("Pesquisar");
		btnPreencher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Instancia respostaDAO
				//USAR o método GET
				//textField.setText("Funcionou" nomePergunta.getNome);
				Resposta resposta = new Resposta();
				
				
					
			}
		});
		btnPreencher.setBounds(258, 101, 89, 23);
		panel.add(btnPreencher);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(40, 105, 46, 14);
		panel.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(96, 134, 152, 100);
		panel.add(table);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(258, 197, 89, 23);
		panel.add(btnSelecionar);
	}
}
