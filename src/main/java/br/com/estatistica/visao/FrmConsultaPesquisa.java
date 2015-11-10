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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class FrmConsultaPesquisa extends GenericDialogConsulta<Pesquisa, PesquisaDAO, TableModelPesquisa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNome;
	private JTextField textField_1;
	private JButton btnIr;
	private JScrollPane scrollPane;

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
		
		this.textField = new JTextField();
		this.textField.setBounds(10, 25, 70, 20);
		this.panel_1.add(this.textField);
		this.textField.setColumns(10);
		
		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(92, 11, 46, 14);
		this.panel_1.add(this.lblNome);
		
		this.textField_1 = new JTextField();
		this.textField_1.setBounds(90, 25, 260, 20);
		this.panel_1.add(this.textField_1);
		this.textField_1.setColumns(10);
		
		this.btnIr = new JButton("Ir");
		this.btnIr.setBounds(401, 24, 46, 23);
		this.panel_1.add(this.btnIr);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 56, 447, 338);
		this.panel_1.add(this.scrollPane);
	}

	@Override
	protected void initializeTableModel() throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
