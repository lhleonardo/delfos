package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.modelos.Estado;
import br.com.estatistica.modelos.table.TableModelEstado;
import br.com.estatistica.util.ConnectionFactory;

public class FrmConsultaEstado extends GenericDialogConsulta {
	
	private static final long serialVersionUID = 1L;
	private TableModelEstado tableModel;
	
	@SuppressWarnings("unused")
	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JLabel lblNome;
	private JTextField txtUf;
	private JLabel lblUf;
	private JButton btnNewButton;
	private JTable tbResultados;
	private EstadoDAO eDao;
	
	private List<Estado> resultados;
	
	public FrmConsultaEstado(Frame owner, Connection connection) throws SQLException {
		super(owner, "Consulta de Estados", connection);
		initComponents();
	}
	
	private void initComponents() throws SQLException {
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.lblNewLabel = new JLabel("Código");
		this.lblNewLabel.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblNewLabel);
		
		this.txtCodigo = new JTextField();
		this.txtCodigo.setBounds(10, 25, 46, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);
		
		this.txtNome = new JTextField();
		this.txtNome.setColumns(10);
		this.txtNome.setBounds(66, 25, 285, 20);
		this.panel.add(this.txtNome);
		
		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(66, 11, 46, 14);
		this.panel.add(this.lblNome);
		
		this.txtUf = new JTextField();
		this.txtUf.setColumns(10);
		this.txtUf.setBounds(361, 25, 46, 20);
		this.panel.add(this.txtUf);
		
		this.lblUf = new JLabel("UF");
		this.lblUf.setBounds(361, 11, 46, 14);
		this.panel.add(this.lblUf);
		
		this.btnNewButton = new JButton("Pesquisar");
		this.btnNewButton.addActionListener(e -> btnNewButtonActionPerformed(e));
		this.btnNewButton.setBounds(421, 24, 46, 23);
		this.panel.add(this.btnNewButton);
		
		this.tbResultados = new JTable();
		this.tableModel = new TableModelEstado(inicializaTabela());
		this.tbResultados.setBounds(463, 395, -451, -333);
		this.panel.add(this.tbResultados);
	}
	
	public static void main(String[] args) {
		try {
			FrmConsultaEstado dialog = new FrmConsultaEstado(null, new ConnectionFactory().getConnection());
			dialog.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<Estado> inicializaTabela() throws SQLException {
		eDao = new EstadoDAO(getConnection());
		return eDao.getAll();
	}
	
	@Override
	protected void btnOkActionPerformed(ActionEvent e) {
		
	}
	
	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		// TODO Implementar lógica para o método gerado automaticamente.
	}
	
}
