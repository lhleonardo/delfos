package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.bean.EstadoFormatter;
import br.com.estatistica.dao.CidadeDAO;
import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.modelos.Cidade;
import br.com.estatistica.modelos.Estado;
import br.com.estatistica.modelos.table.ObjectComboBoxModel;
import br.com.estatistica.modelos.table.TableModelCidade;
import br.com.estatistica.util.ConnectionFactory;

/**
 * @author Leonardo Braz
 *
 */
public class FrmConsultaCidade extends GenericDialogConsulta<Cidade, CidadeDAO, TableModelCidade> {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtNome;
	private JLabel lblNome;
	private JComboBox<Object> cbUf;
	private JTable table;
	private JScrollPane scrollPane;
	private ObjectComboBoxModel<Estado> comboBoxModel;
	private EstadoDAO eDao;

	public FrmConsultaCidade(Frame owner, Connection connection) throws SQLException {
		super(owner, "Consulta de Cidades", connection);
		this.initComponents();
	}

	private void initComponents() throws SQLException {

		this.setSize(595, 450);
		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblNewLabel = new JLabel("Nome");
		this.lblNewLabel.setBounds(10, 11, 57, 14);
		this.panel.add(this.lblNewLabel);

		this.txtNome = new JTextField();
		this.txtNome.setBounds(10, 27, 326, 20);
		this.panel.add(this.txtNome);
		this.txtNome.setColumns(10);

		this.lblNome = new JLabel("UF");
		this.lblNome.setBounds(346, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.comboBoxModel = new ObjectComboBoxModel<Estado>();
		this.comboBoxModel.setFormatter(new EstadoFormatter());
		this.preencheComboBox();
		this.cbUf = new JComboBox<Object>();
		this.cbUf.setBounds(346, 27, 52, 20);
		this.panel.add(this.cbUf);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 58, 388, 309);
		this.panel.add(this.scrollPane);

		this.table = new JTable();
		this.scrollPane.setViewportView(this.table);
	}

	/**
	 * @throws SQLException
	 *
	 */
	private void preencheComboBox() throws SQLException {
		this.eDao = new EstadoDAO(this.getConnection());
		List<Estado> all = this.eDao.getAll();

		for (Estado estado : all) {
			this.comboBoxModel.add(estado);
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmConsultaCidade frame = new FrmConsultaCidade(null, new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	@Override
	protected void initializeTableModel() throws SQLException {
		this.dao = new CidadeDAO(this.getConnection());
		this.resultados = this.dao.getAll();
	}

	@Override
	protected TableModelCidade getTableModel() {
		TableModelCidade model = super.getTableModel();
		model.addAll(this.resultados);
		return model;
	}
}
