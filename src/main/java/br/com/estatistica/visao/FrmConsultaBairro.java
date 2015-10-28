package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.estatistica.dao.BairroDAO;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.table.TableModelBairro;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

/**
 * @author Leonardo Braz
 *
 */
public class FrmConsultaBairro extends GenericDialogConsulta<Bairro, BairroDAO, TableModelBairro> {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel label;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JLabel label_1;
	private JButton btnPesquisar;
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

	@Override
	protected TableModelBairro getTableModel() {
		TableModelBairro model = super.getTableModel();
		model.addAll(this.resultados);
		return model;
	}

	private void initComponents() throws SQLException {

		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.label = new JLabel("Código");
		this.label.setBounds(10, 11, 46, 14);
		this.panel.add(this.label);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setColumns(10);
		this.txtCodigo.setBounds(10, 25, 56, 20);
		this.panel.add(this.txtCodigo);

		this.txtNome = new JTextField();
		this.txtNome.setColumns(10);
		this.txtNome.setBounds(76, 25, 275, 20);
		this.panel.add(this.txtNome);

		this.label_1 = new JLabel("Nome");
		this.label_1.setBounds(78, 11, 46, 14);
		this.panel.add(this.label_1);

		this.btnPesquisar = new JButton("Ir");
		this.btnPesquisar.setBounds(358, 24, 43, 23);
		this.btnPesquisar.addActionListener(arg0 -> this.btnPesquisarActionPerformed(arg0));
		this.panel.add(this.btnPesquisar);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 56, 391, 338);

		this.tbResultados = this.getTbResultados();
		this.scrollPane.setViewportView(this.tbResultados);
		this.panel.add(this.scrollPane);
	}

	private void btnPesquisarActionPerformed(ActionEvent arg0) {
		try {
			Bairro bairro = new Bairro();
			bairro.setId((this.txtCodigo.getText().isEmpty() ? 0 : Integer.parseInt(this.txtCodigo.getText())));
			bairro.setNome((this.txtNome.getText().isEmpty()) ? null : this.txtNome.getText());

			this.dao = new BairroDAO(this.getConnection());
			List<Bairro> list = this.dao.get(bairro);

			this.preencheTabela(list);

		} catch (NumberFormatException | SQLException e) {
			Mensagem.erro(this, e);
		}
	}

	/**
	 * @param registros
	 */
	private void preencheTabela(List<Bairro> registros) {
		this.dao = new BairroDAO(this.getConnection());
		this.resultados = registros;
		this.tableModel.clear();
		this.tableModel.addAll(registros);
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
