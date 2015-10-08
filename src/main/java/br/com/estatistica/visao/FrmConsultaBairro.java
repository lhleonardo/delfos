package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.dao.BairroDAO;
import br.com.estatistica.util.ConnectionFactory;

public class FrmConsultaBairro extends GenericFormConsulta {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel lblNome;
	private JTextField textField;
	private JButton btnPesquisar;
	private JButton btnCancelar;
	private JButton btnOk;
	private JPanel panel_1;
	private JTable table;
	private JLabel lblResultados;
	
	protected BairroDAO dao;
	
	public FrmConsultaBairro(Connection connection) {
		super("Pesquisa de Bairros", connection);
		this.dao = new BairroDAO(this.getConnection());
		this.initComponents();
	}
	
	private void initComponents() {
		
		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblNome);
		
		this.textField = new JTextField();
		this.textField.setBounds(10, 26, 357, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.setBounds(375, 25, 79, 23);
		this.panel.add(this.btnPesquisar);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(10, 380, 89, 36);
		this.panel.add(this.btnCancelar);
		
		this.btnOk = new JButton("Ok");
		this.btnOk.setBounds(375, 380, 79, 36);
		this.panel.add(this.btnOk);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBounds(10, 75, 444, 301);
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new BorderLayout(0, 0));
		
		this.table = new JTable();
		this.table.setLocation(10, 0);
		this.panel_1.add(this.table);
		
		this.lblResultados = new JLabel("Resultados");
		this.lblResultados.setBounds(10, 57, 70, 14);
		this.panel.add(this.lblResultados);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			FrmConsultaBairro frame = new FrmConsultaBairro(new ConnectionFactory().getConnection());
			frame.setVisible(true);
		});
	}
}
