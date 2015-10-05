package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrmResposta extends GenericFormCadastro {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmResposta frame = new FrmResposta();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public FrmResposta() {

		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		this.textField = new JTextField();
		this.textField.setBounds(96, 102, 152, 20);
		panel.add(this.textField);
		this.textField.setColumns(10);

		JButton btnPreencher = new JButton("Pesquisar");
		btnPreencher.addActionListener(arg0 -> {
			// Instancia respostaDAO
			// USAR o método GET
			// textField.setText("Funcionou" nomePergunta.getNome);
			// Resposta resposta = new Resposta();
			    
		    });
		btnPreencher.setBounds(258, 101, 89, 23);
		panel.add(btnPreencher);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(40, 105, 46, 14);
		panel.add(lblNewLabel);

		this.table = new JTable();
		this.table.setBounds(96, 134, 152, 100);
		panel.add(this.table);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(258, 197, 89, 23);
		panel.add(btnSelecionar);
	}
	
	@Override
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
}
