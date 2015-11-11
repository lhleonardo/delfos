
package br.com.estatistica.visao;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;

public class FrmConsultaPesquisa extends GenericDialogConsulta<Pesquisa, PesquisaDAO, TableModelPesquisa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField codigo_textField;
	private JLabel lblNome;
	private JTextField nome_textField;
	private JButton btnIr;
	private JScrollPane scrollPane;

	public FrmConsultaPesquisa(Frame owner, Connection connection) throws SQLException {
		super(owner, "Consulta Pesquisa", connection);
		this.initComponents();
	}
	
	private void initComponents() throws SQLException {
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
		
		this.codigo_textField = new JTextField();
		this.codigo_textField.setBounds(10, 25, 70, 20);
		this.panel_1.add(this.codigo_textField);
		this.codigo_textField.setColumns(10);
		
		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(92, 11, 46, 14);
		this.panel_1.add(this.lblNome);
		
		this.nome_textField = new JTextField();
		this.nome_textField.setBounds(90, 25, 260, 20);
		this.panel_1.add(this.nome_textField);
		this.nome_textField.setColumns(10);
		
		this.btnIr = new JButton("Ir");
		this.btnIr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnIrActionPerformed(arg0);
			}
		});
		this.btnIr.setBounds(401, 24, 46, 23);
		this.panel_1.add(this.btnIr);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 56, 447, 338);
		this.panel_1.add(this.scrollPane);
		
		this.tbResultados = this.getTbResultados();
		this.scrollPane.setViewportView(this.tbResultados);
	}

	@Override
	protected void initializeTableModel() throws SQLException {
		this.dao = new PesquisaDAO(this.getConnection());
		this.resultados = this.dao.getAll();
	}
	
	@Override
	protected TableModelPesquisa getTableModel() {
		TableModelPesquisa model = super.getTableModel();
		model.addAll(this.resultados);
		return model;
	}

protected void preencheTabela(Pesquisa pesquisa) throws SQLException {
	this.dao = new PesquisaDAO(this.getConnection());
	this.resultados = this.dao.get(pesquisa);
	this.tableModel.clear();
	this.tableModel.addAll(this.resultados);
	}

	public static void main(String[] args) {
		try {
			FrmConsultaPesquisa dialog = new FrmConsultaPesquisa(null, new ConnectionFactory().getConnection());
			dialog.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void btnIrActionPerformed(ActionEvent arg0) {
		try {
			Pesquisa pesquisa = new Pesquisa();
			pesquisa.setId((this.codigo_textField.getText().isEmpty() ? 0 : Integer.parseInt(this.codigo_textField.getText())));
			pesquisa.setNome((this.nome_textField.getText().isEmpty()) ? null : this.nome_textField.getText());
			this.preencheTabela(pesquisa);

		} catch (NumberFormatException | SQLException ex) {
			Mensagem.erro(this, ex);
		}
	}
}
