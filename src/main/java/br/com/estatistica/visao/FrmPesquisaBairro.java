package br.com.estatistica.visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.dao.BairroDAO;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.BairroTableModel;
import br.com.estatistica.util.Mensagem;

public class FrmPesquisaBairro extends GenericFormPesquisa<Bairro> {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblParmetro;
	private JTextField textField;
	private JButton btnPesquisar;
	private JTable table;
	private BairroTableModel tableModel = new BairroTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPesquisaBairro frame = new FrmPesquisaBairro(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmPesquisaBairro(Connection connection) {
		super("Pesquisar Bairro", connection);
		initComponents();
	}

	private void initComponents() {

		this.panel = new JPanel();
		getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblParmetro = new JLabel("Nome");
		this.lblParmetro.setBounds(10, 11, 37, 14);
		this.panel.add(this.lblParmetro);

		this.textField = new JTextField();
		this.textField.setBounds(10, 26, 385, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);

		this.btnPesquisar = new JButton("Vai");
		this.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPesquisarActionPerformed(arg0);
			}
		});
		this.btnPesquisar.setBounds(405, 25, 47, 23);
		this.panel.add(this.btnPesquisar);

		this.table = new JTable();
		this.table.setModel(tableModel);
		this.table.setBounds(10, 385, 442, -327);
		this.panel.add(this.table);
	}

	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		try (BairroDAO bDao = new BairroDAO(getConnection())) {
			List<Bairro> bairros = bDao.get(textField.getText());
			tableModel.addAll(bairros);
		} catch (SQLException e) {
			Mensagem.erro(this, e);
		}
	}
}
