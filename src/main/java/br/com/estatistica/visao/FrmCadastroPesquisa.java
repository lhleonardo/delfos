package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPesquisa;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;
import java.awt.event.ActionListener;

public class FrmCadastroPesquisa extends GenericFormCadastro {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField limiteField;
	private PesquisaDAO pesquisaDAO;
	private JScrollPane scrollPane;
	private JTextArea descricaoField;
	private TableModelPesquisa modeloTabelaPesquisa;
	private JButton btnGetall;
	private PreparedStatement stmt;
	private JButton btnPesquisar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroPesquisa frame = new FrmCadastroPesquisa(new ConnectionFactory().getConnection());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FrmCadastroPesquisa(Connection connection) throws SQLException {
		super("Cadastro de Pesquisa", connection);
		this.initComponents();
		this.setSize(600, 408);
	}
	
	
	private void initComponents() {
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(11, 11, 17, 14);
		panel.add(lblId);
		
		this.codigoField = new JTextField();
		this.codigoField.setEditable(false);
		this.codigoField.setBounds(10, 27, 34, 20);
		panel.add(this.codigoField);
		this.codigoField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 11, 46, 14);
		panel.add(lblNome);
		
		this.nomeField = new JTextField();
		this.nomeField.setBounds(50, 27, 260, 20);
		panel.add(this.nomeField);
		this.nomeField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Limite de Especialistas");
		lblNewLabel.setBounds(11, 212, 187, 14);
		panel.add(lblNewLabel);
		
		this.limiteField = new JTextField();
		this.limiteField.setBounds(11, 237, 46, 20);
		panel.add(this.limiteField);
		this.limiteField.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(e -> FrmCadastroPesquisa.this.btnSalvarActionPerformed(e));
		
		btnSalvar.setBounds(11, 274, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> FrmCadastroPesquisa.this.dispose());
		btnCancelar.setBounds(110, 274, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 58, 64, 14);
		panel.add(lblDescrio);
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(11, 83, 393, 118);
		panel.add(this.scrollPane);
		
		this.descricaoField = new JTextArea();
		this.scrollPane.setViewportView(this.descricaoField);
		this.descricaoField.setLineWrap(true);
		this.descricaoField.setWrapStyleWord(true);
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPesquisarActionPerformed(arg0);
			}
		});
		this.btnPesquisar.setBounds(315, 26, 89, 23);
		panel.add(this.btnPesquisar);
	}
	
	private TableModelPesquisa getTableModel() {
        if (modeloTabelaPesquisa == null) {
            try {
            	pesquisaDAO = new PesquisaDAO(super.getConnection());
            	modeloTabelaPesquisa = new TableModelPesquisa(pesquisaDAO.getAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return modeloTabelaPesquisa;
    }
	
	
	
	protected void btnSalvarActionPerformed(ActionEvent e) {
		Integer valor = 0;
		try {
			valor = Integer.parseInt(this.limiteField.getText());
			System.out.println(valor);
			this.pesquisaDAO = new PesquisaDAO(super.getConnection());
			Pesquisa p1 = new Pesquisa(this.nomeField.getText(), this.descricaoField.getText(), valor);
			
			int valorCodigo = this.pesquisaDAO.save(p1);
			
			this.codigoField.setText(String.valueOf(valorCodigo));
			
		} catch (NumberFormatException e1) {
			Mensagem.erro(this, e1);
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
		
		Toolkit.getDefaultToolkit().beep();
	}

	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		FrmBuscaPesquisa buscaPesquisa;
		try {
			buscaPesquisa = new FrmBuscaPesquisa(super.getConnection());
			buscaPesquisa.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	public JTextField getCodigoField() {
		return codigoField;
	}

	public void setCodigoField(JTextField codigoField) {
		this.codigoField = codigoField;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getLimiteField() {
		return limiteField;
	}

	public void setLimiteField(JTextField limiteField) {
		this.limiteField = limiteField;
	}

	public JTextArea getDescricaoField() {
		return descricaoField;
	}

	public void setDescricaoField(JTextArea descricaoField) {
		this.descricaoField = descricaoField;
	}

	
}
