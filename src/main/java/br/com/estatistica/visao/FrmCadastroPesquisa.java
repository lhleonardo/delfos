package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;
import java.awt.event.ActionListener;

public class FrmCadastroPesquisa extends GenericFormCadastro {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField limiteField;
	private PesquisaDAO pesquisaDAO;
	private JScrollPane scrollPane;
	private JTextArea descricaoField;
	private TableModelPesquisa modeloTabelaPesquisa;
	private JButton btnPesquisar;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton novaPesquisaBotao;
	private JButton btnExcluir;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroPesquisa frame = new FrmCadastroPesquisa(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FrmCadastroPesquisa(Connection connection) throws SQLException {
		super("Cadastro de Pesquisa", connection);
		this.initComponents();
		this.setSize(658, 469);
	}
	
	private void initComponents() {
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(11, 11, 17, 14);
		panel.add(lblId);
		
		this.codigoField = new JTextField();
		this.codigoField.setEditable(false);
		this.codigoField.setText(" ");
		this.codigoField.setBounds(10, 27, 34, 20);
		panel.add(this.codigoField);
		this.codigoField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 11, 46, 14);
		panel.add(lblNome);
		
		this.nomeField = new JTextField();
		this.nomeField.setBounds(50, 27, 260, 20);
		panel.add(this.nomeField);
		this.nomeField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Limite de Especialistas");
		lblNewLabel.setBounds(11, 329, 187, 14);
		panel.add(lblNewLabel);
		
		this.limiteField = new JTextField();
		this.limiteField.setBounds(11, 345, 46, 20);
		panel.add(this.limiteField);
		this.limiteField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(e -> FrmCadastroPesquisa.this.btnSalvarActionPerformed(e));
		
		btnSalvar.setBounds(10, 386, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> FrmCadastroPesquisa.this.dispose());
		btnCancelar.setBounds(109, 386, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(10, 221, 64, 14);
		panel.add(lblDescrio);
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPesquisarActionPerformed(arg0);
			}
		});
		this.btnPesquisar.setBounds(315, 26, 130, 23);
		panel.add(this.btnPesquisar);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 246, 393, 72);
		panel.add(this.scrollPane);
		
		this.descricaoField = new JTextArea();
		this.scrollPane.setViewportView(this.descricaoField);
		this.descricaoField.setLineWrap(true);
		this.descricaoField.setWrapStyleWord(true);
		
		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(50, 58, 260, 118);
		panel.add(this.scrollPane_1);
		
		this.table = new JTable();
		this.table.setCellSelectionEnabled(true);
		this.scrollPane_1.setViewportView(this.table);
		this.table.setModel(getTableModelTodos());
		
		this.btnNewButton = new JButton("Selecionar Pesquisa");
		this.btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButtonActionPerformed(arg0);
			}
		});
		this.btnNewButton.setBounds(50, 187, 187, 23);
		panel.add(this.btnNewButton);
		
		this.novaPesquisaBotao = new JButton("Nova Pesquisa");
		this.novaPesquisaBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novaPesquisaBotaoActionPerformed(arg0);
			}
		});
		this.novaPesquisaBotao.setBounds(315, 55, 130, 23);
		panel.add(this.novaPesquisaBotao);
		
		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnExcluirActionPerformed(arg0);
			}
		});
		this.btnExcluir.setBounds(208, 386, 89, 23);
		panel.add(this.btnExcluir);
	}
	
	private TableModelPesquisa getTableModelTodos() {
		try {
			pesquisaDAO = new PesquisaDAO(super.getConnection());
			modeloTabelaPesquisa = new TableModelPesquisa(pesquisaDAO.getAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modeloTabelaPesquisa;
	}
	
	private TableModelPesquisa getTableModelPesquisa() {
		try {
			pesquisaDAO = new PesquisaDAO(super.getConnection());
			modeloTabelaPesquisa = new TableModelPesquisa(pesquisaDAO.get(nomeField.getText()));
			// modeloTabelaPesquisa.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modeloTabelaPesquisa;
	}
	
	protected void btnSalvarActionPerformed(ActionEvent e) {
		// Integer limiteDeEspecialistas = 0;
		// Integer id = 0;
		// try {
		// limiteDeEspecialistas = Integer.parseInt(this.limiteField.getText());
		// id = Integer.parseInt(this.codigoField.getText());
		// System.out.println(limiteDeEspecialistas);
		// this.pesquisaDAO = new PesquisaDAO(super.getConnection());
		// Pesquisa p1 = new Pesquisa(this.nomeField.getText(),
		// this.descricaoField.getText(), limiteDeEspecialistas);
		// this.pesquisaDAO.save(p1);
		//
		//
		// table.setModel(getTableModelTodos());
		//
		// } catch (NumberFormatException e1) {
		// Mensagem.erro(this, e1);
		// } catch (SQLException e1) {
		// Mensagem.erro(this, e1);
		// }
		if (codigoField.getText().equals(" ")) {
			try {
				Integer limiteEspecialistas = Integer.parseInt(limiteField.getText());
				Pesquisa p1 = new Pesquisa(null, nomeField.getText(), descricaoField.getText(), limiteEspecialistas);
				Integer idNovaPesquisa = pesquisaDAO.save(p1);
				codigoField.setText(Integer.toString(idNovaPesquisa));
			} catch (SQLException e1) {
				System.out.println("Erro SQL");
			} catch (NumberFormatException e2) {
				javax.swing.JOptionPane.showMessageDialog(null, "É necessário informar o Limite de Especialistas.");
			}
			
		} else {
			try {
				Integer idPesquisaSelecionada = Integer.parseInt(codigoField.getText());
				Integer limiteEspecialistas = Integer.parseInt(limiteField.getText());
				Pesquisa p1 = new Pesquisa(idPesquisaSelecionada, nomeField.getText(), descricaoField.getText(), limiteEspecialistas);
				pesquisaDAO.save(p1);
			} catch (SQLException e1) {
				System.out.println("Erro SQL");
			} catch (NumberFormatException e2) {
				javax.swing.JOptionPane.showMessageDialog(null, "É necessário informar o Limite de Especialistas.");
			}
			
		}
		
		this.table.setModel(getTableModelTodos());
		Toolkit.getDefaultToolkit().beep();
	}
	
	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		table.setModel(getTableModelPesquisa());
	}
	
	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		codigoField.setText(Integer.toString(modeloTabelaPesquisa.getPesquisa(table.getSelectedRow()).getId()));
		nomeField.setText(modeloTabelaPesquisa.getPesquisa(table.getSelectedRow()).getNome());
		descricaoField.setText(modeloTabelaPesquisa.getPesquisa(table.getSelectedRow()).getDescricao());
		limiteField.setText(Integer.toString(modeloTabelaPesquisa.getPesquisa(table.getSelectedRow()).getLimiteDeEspecialistas()));
	}
	
	protected void novaPesquisaBotaoActionPerformed(ActionEvent e) {
		table.setModel(getTableModelTodos());
		codigoField.setText(" ");
		nomeField.setText(null);
		descricaoField.setText(null);
		limiteField.setText(null);
	}
	
	protected void btnExcluirActionPerformed(ActionEvent arg0) {
		try {
			if (codigoField.getText() != null) {
				Integer idPesquisaDeletar = Integer.parseInt(codigoField.getText());
				Pesquisa p1 = new Pesquisa(idPesquisaDeletar);
				pesquisaDAO.delete(p1);
				table.setModel(getTableModelTodos());
				codigoField.setText(" ");
				nomeField.setText(null);
				descricaoField.setText(null);
				limiteField.setText(null);
			}
			
		} catch (NumberFormatException | SQLException e) {
			
		}
	}
}
