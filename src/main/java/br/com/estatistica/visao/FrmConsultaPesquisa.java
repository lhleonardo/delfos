package br.com.estatistica.visao;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class FrmConsultaPesquisa extends GenericDialogConsulta<Pesquisa, PesquisaDAO, TableModelPesquisa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;

	public FrmConsultaPesquisa(Frame owner, Connection connection) {
		super(owner, "Consulta Pesquisa", connection);
		this.initComponents();
	}
	
	private void initComponents() {
		setTitle("Consulta de Pesquisa");
		
		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBounds(0, 0, 457, 405);
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(null);
		
		this.lblNewLabel = new JLabel("Código");
		this.lblNewLabel.setBounds(10, 11, 63, 14);
		this.panel_1.add(this.lblNewLabel);
	}

	@Override
	protected void initializeTableModel() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
