package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.dao.QuestionarioDAO;
import br.com.estatistica.modelos.Questionario;
import br.com.estatistica.modelos.table.TableModelQuestionario;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

public class FrmCadastroQuestionario extends GenericFormCadastro {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTable table;
	private JButton btnPesquisar;
	private JButton btnSelecionarPesquisa;
	private TableModelQuestionario tmQuestionario;
	private QuestionarioDAO questionarioDAO;
	private JTextArea descricaoField;
	private JScrollPane scrollPane_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroQuestionario frame = new FrmCadastroQuestionario(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public FrmCadastroQuestionario(Connection connection) {
		super("Cadastro de Pesquisa", connection);
		this.setTitle("Cadastro de Questionario");
		
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(11, 11, 17, 14);
		panel.add(lblId);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(e -> FrmCadastroQuestionario.this.btnSalvarActionPerformed(e));
		btnSalvar.setBounds(10, 428, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 428, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 270, 64, 14);
		panel.add(lblDescrio);
		
		this.codigoField = new JTextField();
		this.codigoField.setEditable(false);
		this.codigoField.setBounds(13, 36, 34, 20);
		panel.add(this.codigoField);
		this.codigoField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(71, 11, 46, 14);
		panel.add(lblNome);
		
		this.nomeField = new JTextField();
		this.nomeField.setBounds(68, 36, 305, 20);
		panel.add(this.nomeField);
		this.nomeField.setColumns(10);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(11, 381, 34, 14);
		panel.add(lblTema);
		
		JComboBox temaBox = new JComboBox();
		temaBox.setBounds(45, 378, 127, 20);
		panel.add(temaBox);
		
		JButton button = new JButton("+");
		button.setBounds(182, 377, 41, 23);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 67, 302, 139);
		panel.add(scrollPane);
		
		this.table = new JTable();
		scrollPane.setViewportView(this.table);
		this.table.setModel(this.getTableModelTodos());
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(e -> FrmCadastroQuestionario.this.btnPesquisarActionPerformed(e));
		this.btnPesquisar.setBounds(383, 35, 111, 23);
		panel.add(this.btnPesquisar);
		
		this.btnSelecionarPesquisa = new JButton("Selecionar Pesquisa");
		this.btnSelecionarPesquisa.setBounds(71, 217, 222, 23);
		panel.add(this.btnSelecionarPesquisa);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(11, 295, 282, 75);
		panel.add(this.scrollPane_1);

		this.descricaoField = new JTextArea();
		this.scrollPane_1.setViewportView(this.descricaoField);
	}
	
	private TableModelQuestionario getTableModelTodos() {
		try {
			this.questionarioDAO = new QuestionarioDAO(super.getConnection());
			this.tmQuestionario = new TableModelQuestionario(this.questionarioDAO.getAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.tmQuestionario;
	}
	
	private TableModelQuestionario getTableModelPesquisa() {
		try {
			this.questionarioDAO = new QuestionarioDAO(super.getConnection());
			this.tmQuestionario = new TableModelQuestionario(this.questionarioDAO.get(this.nomeField.getText()));
			// modeloTabelaPesquisa.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.tmQuestionario;
	}
	
	protected void btnPesquisarActionPerformed(ActionEvent e) {
		this.table.setModel(this.getTableModelPesquisa());
	}
	
	protected void btnSalvarActionPerformed(ActionEvent e) {
		try {
			
			this.questionarioDAO = new QuestionarioDAO(super.getConnection());
			Questionario q1 = new Questionario(this.nomeField.getText(), this.descricaoField.getText());

			int valorCodigo = this.questionarioDAO.save(q1);

			this.codigoField.setText(String.valueOf(valorCodigo));
			this.table.setModel(this.getTableModelTodos());

		} catch (NumberFormatException e1) {
			Mensagem.erro(this, e1);
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}

	}
}
