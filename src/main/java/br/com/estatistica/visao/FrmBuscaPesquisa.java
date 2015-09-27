package br.com.estatistica.visao;

import javax.swing.JFrame;
import javax.swing.JTable;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		initComponents();
	}
	private void initComponents() {
		setTitle("Busca Pesquisa");
		setAutoRequestFocus(false);
		
		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 42, 269, 120);
		this.panel.add(this.scrollPane);
		
		this.table = new JTable();
		this.scrollPane.setViewportView(this.table);
		this.table.setModel(getTableModelTodos());
		
		this.textField = new JTextField();
		this.textField.setBounds(10, 11, 173, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPesquisarActionPerformed(arg0);
			}
		});
		this.btnPesquisar.setBounds(193, 8, 88, 23);
		this.panel.add(this.btnPesquisar);
	}
	
	private TableModelPesquisa getTableModelTodos() {
        if (modeloTabelaPesquisa == null) {
            try {
            	pesquisaDAO = new PesquisaDAO(super.getConnection());
            	modeloTabelaPesquisa = new TableModelPesquisa(pesquisaDAO.getAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return modeloTabelaPesquisa;
    }
	
	private TableModelPesquisa getTableModelPesquisa() {
            try {
            	pesquisaDAO = new PesquisaDAO(super.getConnection());
            	modeloTabelaPesquisa = new TableModelPesquisa(pesquisaDAO.get(textField.getText()));
            	//modeloTabelaPesquisa.fireTableDataChanged();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return modeloTabelaPesquisa;
    }
	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		this.table.setModel(getTableModelPesquisa());
		
	}
}
