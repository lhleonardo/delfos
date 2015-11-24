package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.ConnectionFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

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
		this.table.setBounds(96, 134, 203, 139);
		panel.add(this.table);

		
		//MUDAR AQUI OS DADOS
		JButton btnSelecionar = new JButton("Selecionar");
		FrmConsultaQuestionario consulta= null;
		try {
			consulta = new FrmConsultaQuestionario(null, new ConnectionFactory().getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (consulta.execute()) {
			List<Pesquisa> selecionadas = consulta.getSelecionadas();
			Pesquisa pesquisa = selecionadas.get(0);
			this.codigoField.setText(Integer.toString(pesquisa.getId()));
			this.nomeField.setText(pesquisa.getNome());
			this.descricaoField.setText(pesquisa.getDescricao());
			this.limiteField.setText(Integer.toString(pesquisa.getLimiteDeEspecialistas()));
			SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
			this.txtData.setText(formatadorData.format(pesquisa.getData()));
			//this.textField_1.setText(new DateFormatter().format(pesquisa.getData()));
			
		}
	}
	
	
	@Override
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
}
