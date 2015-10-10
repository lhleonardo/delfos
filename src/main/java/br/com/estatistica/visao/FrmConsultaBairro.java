package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.estatistica.dao.BairroDAO;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.table.TableModelBairro;
import br.com.estatistica.util.ConnectionFactory;

/**
 * @author Leonardo Braz
 *
 */
public class FrmConsultaBairro extends GenericDialogConsulta<Bairro, BairroDAO, TableModelBairro> {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label_1;
	private JButton button;
	private JScrollPane scrollPane;
	
	@Override
	protected void initializeTableModel() throws SQLException {
		this.dao = new BairroDAO(this.getConnection());
		this.resultados = this.dao.getAll();
	}
	
	public FrmConsultaBairro(Frame owner, Connection connection) throws SQLException {
		super(owner, "Consulta de Bairros", connection);
		this.initComponents();
	}
	
	private void initComponents() throws SQLException {
		
		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.label = new JLabel("Código");
		this.label.setBounds(10, 11, 46, 14);
		this.panel.add(this.label);
		
		this.textField = new JTextField();
		this.textField.setColumns(10);
		this.textField.setBounds(10, 25, 56, 20);
		this.panel.add(this.textField);
		
		this.textField_1 = new JTextField();
		this.textField_1.setColumns(10);
		this.textField_1.setBounds(76, 25, 275, 20);
		this.panel.add(this.textField_1);
		
		this.label_1 = new JLabel("Nome");
		this.label_1.setBounds(78, 11, 46, 14);
		this.panel.add(this.label_1);
		
		this.button = new JButton("Ir");
		this.button.setBounds(361, 24, 43, 23);
		this.panel.add(this.button);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 56, 391, 338);
		
		this.tbResultados = this.getTbResultados();
		this.scrollPane.setViewportView(this.tbResultados);
		this.panel.add(this.scrollPane);
	}
	
	public static void main(String[] args) {
		try {
			FrmConsultaBairro consulta = new FrmConsultaBairro(null, new ConnectionFactory().getConnection());
			consulta.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
