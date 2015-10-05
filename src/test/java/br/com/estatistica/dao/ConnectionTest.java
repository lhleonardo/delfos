package br.com.estatistica.dao;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;

public class ConnectionTest extends JFrame {
	
	// Connection con = new ConnectionFactory().getConnection();
	// PesquisaDAO pesqDAO = new PesquisaDAO(con);
	// try {
	// List<Pesquisa> listaDePesquisas = pesqDAO.getAll();
	// for(int i = 0; i<listaDePesquisas.size(); i++){
	// System.out.println(listaDePesquisas.get(i).getNome());
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblSocios;
	private TableModelPesquisa tableModel;
	private Connection con = new ConnectionFactory().getConnection();
	private PesquisaDAO pesquisaDAO = new PesquisaDAO(this.con);
	
	public ConnectionTest() {
		super("SocioTableModelTest");
		this.initialize();
	}
	
	private void initialize() {
		this.setSize(400, 150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(this.getTblSocios()));
	}
	
	private JTable getTblSocios() {
		if (this.tblSocios == null) {
			this.tblSocios = new JTable();
			this.tblSocios.setModel(this.getTableModel());
		}
		return this.tblSocios;
	}
	
	private TableModelPesquisa getTableModel() {
		if (this.tableModel == null) {
			try {
				this.tableModel = new TableModelPesquisa(this.pesquisaDAO.getAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.tableModel;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new ConnectionTest().setVisible(true));
	}
	
}
