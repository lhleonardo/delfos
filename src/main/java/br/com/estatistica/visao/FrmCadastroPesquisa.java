package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

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

public class FrmCadastroPesquisa extends GenericFormCadastro {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField limiteField;
	private PesquisaDAO pesquisaDAO;
	private JTextArea descricaoField;
	private TableModelPesquisa modeloTabelaPesquisa;
	private JButton btnPesquisar;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JButton novaPesquisaBotao;
	private JButton btnExcluir;
	private JScrollPane scrollPane;

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
	 *
	 * @throws SQLException
	 */
	public FrmCadastroPesquisa(Connection connection) throws SQLException {
		super("Cadastro de Pesquisa", connection);
		this.initComponents();
		this.setSize(952, 588);
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
		this.codigoField.setText(" ");
		this.codigoField.setBounds(10, 27, 34, 20);
		panel.add(this.codigoField);
		this.codigoField.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(50, 11, 46, 14);
		panel.add(lblNome);

		this.nomeField = new JTextField();
		this.nomeField.setBounds(50, 27, 491, 20);
		panel.add(this.nomeField);
		this.nomeField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Limite de Especialistas");
		lblNewLabel.setBounds(12, 449, 187, 14);
		panel.add(lblNewLabel);

		this.limiteField = new JTextField();
		this.limiteField.setBounds(12, 465, 46, 20);
		panel.add(this.limiteField);
		this.limiteField.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(e -> FrmCadastroPesquisa.this.btnSalvarActionPerformed(e));

		btnSalvar.setBounds(11, 506, 89, 23);
		panel.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> FrmCadastroPesquisa.this.dispose());
		btnCancelar.setBounds(110, 506, 89, 23);
		panel.add(btnCancelar);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(11, 303, 64, 14);
		panel.add(lblDescrio);

		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(arg0 -> FrmCadastroPesquisa.this.btnPesquisarActionPerformed(arg0));
		this.btnPesquisar.setBounds(551, 26, 130, 23);
		panel.add(this.btnPesquisar);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmCadastroPesquisa.this.scrollPane_1MouseClicked(arg0);
			}
		});
		this.scrollPane_1.setBounds(50, 58, 491, 201);
		panel.add(this.scrollPane_1);

		this.table = new JTable();

		this.table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				FrmCadastroPesquisa.this.tableKeyPressed(e);
			}
		});
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmCadastroPesquisa.this.tableMouseClicked(e);
			}
		});
		this.table.setCellSelectionEnabled(true);
		this.scrollPane_1.setViewportView(this.table);
		this.table.setModel(this.getTableModelTodos());

		this.btnNewButton = new JButton("Selecionar Pesquisa");
		this.btnNewButton.addActionListener(arg0 -> FrmCadastroPesquisa.this.btnNewButtonActionPerformed(arg0));
		this.btnNewButton.setBounds(50, 269, 187, 23);
		panel.add(this.btnNewButton);

		this.novaPesquisaBotao = new JButton("Nova Pesquisa");
		this.novaPesquisaBotao.addActionListener(arg0 -> FrmCadastroPesquisa.this.novaPesquisaBotaoActionPerformed(arg0));
		this.novaPesquisaBotao.setBounds(551, 55, 130, 23);
		panel.add(this.novaPesquisaBotao);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.addActionListener(arg0 -> FrmCadastroPesquisa.this.btnExcluirActionPerformed(arg0));
		this.btnExcluir.setBounds(209, 506, 89, 23);
		panel.add(this.btnExcluir);

		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(11, 324, 434, 114);
		panel.add(this.scrollPane);

		this.descricaoField = new JTextArea();
		this.scrollPane.setViewportView(this.descricaoField);
		this.descricaoField.setLineWrap(true);
		this.descricaoField.setWrapStyleWord(true);
	}

	private TableModelPesquisa getTableModelTodos() {
		try {
			this.pesquisaDAO = new PesquisaDAO(super.getConnection());
			this.modeloTabelaPesquisa = new TableModelPesquisa(this.pesquisaDAO.getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.modeloTabelaPesquisa;
	}

	private TableModelPesquisa getTableModelPesquisa() {
		try {
			this.pesquisaDAO = new PesquisaDAO(super.getConnection());
			this.modeloTabelaPesquisa = new TableModelPesquisa(this.pesquisaDAO.get(this.nomeField.getText()));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.modeloTabelaPesquisa;
	}

	protected void btnSalvarActionPerformed(ActionEvent e) {
		if (this.codigoField.getText().equals(" ")) {
			try {
				Integer limiteEspecialistas = Integer.parseInt(this.limiteField.getText());
				Pesquisa p1 = new Pesquisa(null, this.nomeField.getText(), this.descricaoField.getText(), limiteEspecialistas);
				Integer idNovaPesquisa = this.pesquisaDAO.save(p1);
				this.codigoField.setText(Integer.toString(idNovaPesquisa));
			} catch (SQLException e1) {
				System.out.println("Erro SQL");
			} catch (NumberFormatException e2) {
				javax.swing.JOptionPane.showMessageDialog(null, "É necessário informar o Limite de Especialistas.");
			}

		} else {
			try {
				Integer idPesquisaSelecionada = Integer.parseInt(this.codigoField.getText());
				Integer limiteEspecialistas = Integer.parseInt(this.limiteField.getText());
				Pesquisa p1 = new Pesquisa(idPesquisaSelecionada, this.nomeField.getText(), this.descricaoField.getText(),
						limiteEspecialistas);
				this.pesquisaDAO.save(p1);
			} catch (SQLException e1) {
				System.out.println("Erro SQL");
			} catch (NumberFormatException e2) {
				javax.swing.JOptionPane.showMessageDialog(null, "É necessário informar o Limite de Especialistas.");
			}

		}

		this.table.setModel(this.getTableModelTodos());
		Toolkit.getDefaultToolkit().beep();
	}

	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		this.table.setModel(this.getTableModelPesquisa());
	}

	protected void selecionaPesquisa() {
		this.codigoField.setText(Integer.toString(this.modeloTabelaPesquisa.getPesquisa(this.table.getSelectedRow()).getId()));
		this.nomeField.setText(this.modeloTabelaPesquisa.getPesquisa(this.table.getSelectedRow()).getNome());
		this.descricaoField.setText(this.modeloTabelaPesquisa.getPesquisa(this.table.getSelectedRow()).getDescricao());
		this.limiteField.setText(Integer.toString(this.modeloTabelaPesquisa.getPesquisa(this.table.getSelectedRow())
				.getLimiteDeEspecialistas()));

	}

	protected void btnNewButtonActionPerformed(ActionEvent arg0) {
		this.selecionaPesquisa();
	}

	protected void novaPesquisaBotaoActionPerformed(ActionEvent e) {
		this.table.setModel(this.getTableModelTodos());
		this.codigoField.setText(" ");
		this.nomeField.setText(null);
		this.descricaoField.setText(null);
		this.limiteField.setText(null);
	}

	protected void btnExcluirActionPerformed(ActionEvent arg0) {
		try {
			if (this.codigoField.getText() != null) {
				Integer idPesquisaDeletar = Integer.parseInt(this.codigoField.getText());
				Pesquisa p1 = new Pesquisa(idPesquisaDeletar);
				this.pesquisaDAO.delete(p1);
				this.table.setModel(this.getTableModelTodos());
				this.codigoField.setText(" ");
				this.nomeField.setText(null);
				this.descricaoField.setText(null);
				this.limiteField.setText(null);
			}

		} catch (NumberFormatException | SQLException e) {
			Mensagem.erro(this, e);
		}
	}

	protected void scrollPane_1MouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			this.selecionaPesquisa();
		}
	}

	protected void tableMouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			this.selecionaPesquisa();
		}

	}

	protected void tableKeyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.selecionaPesquisa();
		}
	}
}
