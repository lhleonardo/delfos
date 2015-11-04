package br.com.estatistica.visao;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class FrmConsultaPesquisa extends GenericDialogConsulta<Pesquisa, PesquisaDAO, TableModelPesquisa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;

	public FrmConsultaPesquisa(Frame owner, String title, Connection connection) {
		super(owner, title, connection);
		// TODO Auto-generated constructor stub
		initComponents();
	}
	private void initComponents() {
		
		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
	}

	@Override
	protected void initializeTableModel() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
