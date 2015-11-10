package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.modelos.Estado;
import br.com.estatistica.modelos.table.TableModelEstado;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

public class FrmConsultaEstado extends GenericDialogConsulta<Estado, EstadoDAO, TableModelEstado> {

	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtUf;
	private JButton btnPesquisar;

	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNome;
	private JLabel lblNewLabel_1;

	public FrmConsultaEstado(Frame owner, Connection connection) throws SQLException {
		super(owner, "Consulta de Estados", connection);
		this.initComponents();
	}

	private void initComponents() throws SQLException {

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setBounds(10, 25, 56, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);

		this.txtNome = new JTextField();
		this.txtNome.setColumns(10);
		this.txtNome.setBounds(76, 25, 275, 20);
		this.panel.add(this.txtNome);

		this.txtUf = new JTextField();
		this.txtUf.setColumns(10);
		this.txtUf.setBounds(361, 25, 46, 20);
		this.panel.add(this.txtUf);

		this.btnPesquisar = new JButton("Ir");
		this.btnPesquisar.addActionListener(e -> this.btnPesquisarActionPerformed(e));
		this.btnPesquisar.setBounds(417, 24, 43, 23);
		this.panel.add(this.btnPesquisar);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 61, 452, 333);
		this.panel.add(this.scrollPane);

		this.tbResultados = this.getTbResultados();
		this.scrollPane.setViewportView(this.tbResultados);

		this.lblNewLabel = new JLabel("Código");
		this.lblNewLabel.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblNewLabel);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(78, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.lblNewLabel_1 = new JLabel("UF");
		this.lblNewLabel_1.setBounds(361, 11, 46, 14);
		this.panel.add(this.lblNewLabel_1);

	}

	@Override
	protected void initializeTableModel() throws SQLException {
		this.dao = new EstadoDAO(this.getConnection());
		this.resultados = this.dao.getAll();
	}

	@Override
	protected TableModelEstado getTableModel() {
		TableModelEstado model = super.getTableModel();
		model.addAll(this.resultados);
		return model;
	}

	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		try {
			Estado estado = new Estado();
			estado.setId((this.txtCodigo.getText().isEmpty() ? 0 : Integer.parseInt(this.txtCodigo.getText())));
			estado.setNome((this.txtNome.getText().isEmpty()) ? null : this.txtNome.getText());
			estado.setUf((this.txtUf.getText().isEmpty()) ? null : this.txtUf.getText());

			this.preencheTabela(estado);

		} catch (NumberFormatException | SQLException ex) {
			Mensagem.erro(this, ex);
		}
	}

protected void preencheTabela(Estado estado) throws SQLException {
	this.dao = new EstadoDAO(this.getConnection());
	this.resultados = this.dao.get(estado);
	this.tableModel.clear();
	this.tableModel.addAll(this.resultados);
	}

	public static void main(String[] args) {
		try {
			FrmConsultaEstado dialog = new FrmConsultaEstado(null, new ConnectionFactory().getConnection());
			dialog.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
