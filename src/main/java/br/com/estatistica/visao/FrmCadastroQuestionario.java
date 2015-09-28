package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.dao.QuestionarioDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.Questionario;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.modelos.table.TableModelQuestionario;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FrmCadastroQuestionario extends GenericFormCadastro  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroQuestionario frame = new FrmCadastroQuestionario(new ConnectionFactory().getConnection());
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
	public FrmCadastroQuestionario(Connection connection) {
		super("Cadastro de Pesquisa", connection);
		setTitle("Cadastro de Questionario");

		setResizable(false);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(11, 11, 17, 14);
		panel.add(lblId);



		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvarActionPerformed(e);
			}
		});
		btnSalvar.setBounds(10, 428, 89, 23);
		panel.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 428, 89, 23);
		panel.add(btnCancelar);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 270, 64, 14);
		panel.add(lblDescrio);

		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setBounds(13, 36, 34, 20);
		panel.add(codigoField);
		codigoField.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(71, 11, 46, 14);
		panel.add(lblNome);

		nomeField = new JTextField();
		nomeField.setBounds(68, 36, 305, 20);
		panel.add(nomeField);
		nomeField.setColumns(10);

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
		this.table.setModel(getTableModelTodos());

		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPesquisarActionPerformed(e);
			}
		});
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
			questionarioDAO = new QuestionarioDAO(super.getConnection());
			tmQuestionario = new TableModelQuestionario(questionarioDAO.getAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tmQuestionario;
	}

	private TableModelQuestionario getTableModelPesquisa() {
		try {
			questionarioDAO = new QuestionarioDAO(super.getConnection());
			tmQuestionario = new TableModelQuestionario(questionarioDAO.get(nomeField.getText()));
			//modeloTabelaPesquisa.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tmQuestionario;
	}

	protected void btnPesquisarActionPerformed(ActionEvent e) {
		this.table.setModel(getTableModelPesquisa());
	}
	protected void btnSalvarActionPerformed(ActionEvent e) {
		try {

			this.questionarioDAO = new QuestionarioDAO(super.getConnection());
			Questionario q1 = new Questionario(nomeField.getText(), descricaoField.getText());
			
			int valorCodigo = this.questionarioDAO.save(q1);
			
			this.codigoField.setText(String.valueOf(valorCodigo));
			table.setModel(getTableModelTodos());
			
		} catch (NumberFormatException e1) {
			Mensagem.erro(this, e1);
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
		
	}
}
