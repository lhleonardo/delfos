package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.estatistica.dao.PerguntaDAO;

import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.modelos.table.TableModelPergunta;

import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmCadastroPergunta extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JTextField pergunta;
	private JTextField idPergunta;
	private JTextField desc;
	private JTextField obs;
	private PerguntaDAO dao;
	private JTable table;
	private TableModelPergunta modeloTabelaPergunta;

	public FrmCadastroPergunta(Connection connection) {
		super("Cadastro de Perguntas", connection);

		JPanel coeficientes = new JPanel();
		this.getContentPane().add(coeficientes, BorderLayout.CENTER);
		coeficientes.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pergunta");
		lblNewLabel.setBounds(60, 11, 75, 14);
		coeficientes.add(lblNewLabel);

		this.pergunta = new JTextField();
		this.pergunta.setBounds(60, 26, 495, 20);
		coeficientes.add(this.pergunta);
		this.pergunta.setColumns(10);

		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(e -> {
			btnSalvarActionPerformed();

		});
		salvar.setBounds(17, 404, 89, 23);
		coeficientes.add(salvar);

		this.idPergunta = new JTextField();
		this.idPergunta.setEditable(false);
		this.idPergunta.setBounds(17, 26, 35, 20);
		coeficientes.add(this.idPergunta);
		this.idPergunta.setColumns(10);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(17, 11, 25, 14);
		coeficientes.add(lblId);

		this.desc = new JTextField();
		this.desc.setBounds(10, 200, 538, 32);
		coeficientes.add(this.desc);
		this.desc.setColumns(10);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(10, 186, 75, 14);
		coeficientes.add(lblDescrio);

		this.obs = new JTextField();
		this.obs.setBounds(10, 254, 538, 32);
		coeficientes.add(this.obs);
		this.obs.setColumns(10);

		JLabel lblObservao = new JLabel("Observação");
		lblObservao.setBounds(10, 239, 96, 14);
		coeficientes.add(lblObservao);

		JLabel lblTipoDePergunta = new JLabel("Tipo de Pergunta");
		lblTipoDePergunta.setBounds(10, 296, 89, 14);
		coeficientes.add(lblTipoDePergunta);

		JComboBox tppergunta = new JComboBox();
		tppergunta.setModel(new DefaultComboBoxModel(new String[] {
				"Coeficiente de Argumentação", "Coeficiente de Competência" }));
		tppergunta.setToolTipText("");
		tppergunta.setBounds(10, 314, 215, 20);
		coeficientes.add(tppergunta);

		JButton NovaPergunta = new JButton("Nova Pergunta");
		NovaPergunta.addActionListener(e -> {
			FrmCadastroPergunta.this.idPergunta.setText(" ");
			FrmCadastroPergunta.this.pergunta.setText(null);
			FrmCadastroPergunta.this.desc.setText(null);
			FrmCadastroPergunta.this.obs.setText(null);

		});
		NovaPergunta.setBounds(565, 25, 129, 23);
		coeficientes.add(NovaPergunta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 57, 495, 118);
		coeficientes.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(getTableModelTodos());
	}
	private TableModelPergunta getTableModelTodos() {
		try {
			this.dao = new PerguntaDAO(super.getConnection());
			this.modeloTabelaPergunta = new TableModelPergunta(this.dao.getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.modeloTabelaPergunta;
	}

	private TableModelPergunta getTableModelPergunta() {
		try {
			this.dao = new PerguntaDAO(super.getConnection());
			this.modeloTabelaPergunta = new TableModelPergunta(this.dao.get(this.pergunta.getText()));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return this.modeloTabelaPergunta;
	}
	

	private void btnSalvarActionPerformed() {
		Pergunta p1 = new Pergunta(FrmCadastroPergunta.this.pergunta.getText(),
				FrmCadastroPergunta.this.desc.getText(),
				FrmCadastroPergunta.this.obs.getText(), null, null, null);
		try {
			dao = new PerguntaDAO(getConnection());
			Integer idNovaPesquisa = dao.save(p1);
			System.out.println(idNovaPesquisa);
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
	}

	public static void main(String[] args) {
		FrmCadastroPergunta frame = new FrmCadastroPergunta(
				new ConnectionFactory().getConnection());
		frame.setVisible(true);

	}
}
