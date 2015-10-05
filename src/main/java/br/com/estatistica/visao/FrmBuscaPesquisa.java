package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;

public class FrmBuscaPesquisa extends GenericFormCadastro {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private TableModelPesquisa modeloTabelaPesquisa;
	private PesquisaDAO pesquisaDAO;
	private JPanel panel;
	private JTable table;
	private JTextField textField;
	private JButton btnPesquisar;
	private JScrollPane scrollPane;
	private JButton btnSelecionar;
	private Pesquisa pesquisa;
	
	public Pesquisa getPesquisa() {
		return this.pesquisa;
	}
	
	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmBuscaPesquisa frame = new FrmBuscaPesquisa(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmBuscaPesquisa(Connection connection) throws SQLException {
		super("Busca Pesquisa", connection);
		this.initComponents();
		this.setSize(600, 361);
	}

	public FrmBuscaPesquisa() {
		this.initComponents();
	}
	
	private void initComponents() {
		
		this.setTitle("Busca Pesquisa");
		this.setAutoRequestFocus(false);

		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 42, 269, 120);
		this.panel.add(this.scrollPane);

		this.table = new JTable();
		this.table.setCellSelectionEnabled(true);
		this.scrollPane.setViewportView(this.table);
		this.table.setModel(this.getTableModelTodos());

		this.textField = new JTextField();
		this.textField.setBounds(10, 11, 173, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);

		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(arg0 -> FrmBuscaPesquisa.this.btnPesquisarActionPerformed(arg0));
		this.btnPesquisar.setBounds(193, 8, 88, 23);
		this.panel.add(this.btnPesquisar);

		this.btnSelecionar = new JButton("Selecionar");
		this.btnSelecionar.addActionListener(e -> FrmBuscaPesquisa.this.btnSelecionarActionPerformed(e));
		this.btnSelecionar.setBounds(10, 205, 89, 23);
		this.panel.add(this.btnSelecionar);
	}

	private TableModelPesquisa getTableModelTodos() {
		if (this.modeloTabelaPesquisa == null) {
			try {
				this.pesquisaDAO = new PesquisaDAO(super.getConnection());
				this.modeloTabelaPesquisa = new TableModelPesquisa(this.pesquisaDAO.getAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.modeloTabelaPesquisa;
	}

	private TableModelPesquisa getTableModelPesquisa() {
		try {
			this.pesquisaDAO = new PesquisaDAO(super.getConnection());
			this.modeloTabelaPesquisa = new TableModelPesquisa(this.pesquisaDAO.get(this.textField.getText()));
			// modeloTabelaPesquisa.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.modeloTabelaPesquisa;
	}
	
	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		this.table.setModel(this.getTableModelPesquisa());

	}

	protected void btnSelecionarActionPerformed(ActionEvent e) {
		this.pesquisa = this.modeloTabelaPesquisa.getPesquisa(this.table.getSelectedRow());
		System.out.println(this.pesquisa.getNome());
	}
}
