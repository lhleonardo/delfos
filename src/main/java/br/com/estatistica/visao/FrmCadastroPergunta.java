package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.estatistica.dao.PerguntaDAO;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.table.TableModelPergunta;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.util.Mensagem;

public class FrmCadastroPergunta extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;
	private JTextField pergunta;
	private JTextField idPergunta;
	private JTextField desc;
	private JTextField quest;
	private PerguntaDAO dao;
	private JTable table;
	private TableModelPergunta modeloTabelaPergunta;
	private JComboBox tppergunta;
	private JTextField obs;

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
			this.btnSalvarActionPerformed();

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
		this.desc.setBounds(10, 200, 545, 32);
		coeficientes.add(this.desc);
		this.desc.setColumns(10);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(10, 186, 75, 14);
		coeficientes.add(lblDescrio);

		this.quest = new JTextField();
		quest.setEditable(false);
		this.quest.setBounds(10, 361, 545, 23);
		coeficientes.add(this.quest);
		this.quest.setColumns(10);

		JLabel lblObservao = new JLabel("Observação");
		lblObservao.setBounds(10, 239, 96, 14);
		coeficientes.add(lblObservao);

		JLabel questionario = new JLabel("Questionário");
		questionario.setBounds(10, 346, 80, 14);
		coeficientes.add(questionario);

		tppergunta = new JComboBox();
		tppergunta.setModel(new DefaultComboBoxModel(new String[] {  }));
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

		this.table = new JTable();
		scrollPane.setViewportView(this.table);
		this.table.setModel(this.getTableModelTodos());
		
		JLabel label = new JLabel("Tipo de Pergunta");
		label.setBounds(17, 296, 89, 14);
		coeficientes.add(label);
		
		obs = new JTextField();
		obs.setColumns(10);
		obs.setBounds(10, 253, 545, 32);
		coeficientes.add(obs);
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

	protected void btnPesquisarActionPerformed(ActionEvent arg0) {
		this.table.setModel(this.getTableModelPergunta());

	}

	protected void excluir() {
		try {
			if (this.idPergunta.getText() != null) {
				Integer idPerguntaDeletar = Integer.parseInt(this.idPergunta.getText());
				// Pergunta p1 = new Pergunta(idPerguntaDeletar);
				// this.dao.delete(p1);
				this.table.setModel(this.getTableModelTodos());
				this.idPergunta.setText(" ");
				this.pergunta.setText(null);
				this.desc.setText(null);

				// setTamanhoColunas();

			}

		} catch (NumberFormatException e) {
			Mensagem.erro(this, e);
		}
	}

	private void btnSalvarActionPerformed() {
		Pergunta p1 = new Pergunta(FrmCadastroPergunta.this.pergunta.getText(), FrmCadastroPergunta.this.desc.getText(),
				FrmCadastroPergunta.this.quest.getText(), null, null, null);

		try {
			this.dao = new PerguntaDAO(this.getConnection());
			Integer idNovaPergunta = this.dao.save(p1);
			System.out.println(idNovaPergunta);
		} catch (SQLException e1) {
			Mensagem.erro(this, e1);
		}
	}

	public static void main(String[] args) {
		FrmCadastroPergunta frame = new FrmCadastroPergunta(new ConnectionFactory().getConnection());
		frame.setVisible(true);


	}
	protected void salvar(){
		if (this.idPergunta.getText().equals(" ")) {
			try {

				Pergunta p1 = new Pergunta(null, this.pergunta.getText(), this.desc.getText(), this.obs.getText() , tppergunta.getSelectedItem(), );
				Integer idNovaPergunta = this.dao.save(p1);
				this.idPergunta.setText(Integer.toString(idNovaPergunta));
			} catch (SQLException e1) {
				System.out.println("Erro SQL");
			}
		}

		 else {
			try {
				Integer idPerguntaSelecionada = Integer.parseInt(this.idPergunta.getText());
				
				Pergunta p1 = new Pergunta(idPerguntaSelecionada, this.pergunta.getText(), this.desc.getText(), 
						);
				this.dao.save(p1);
			} catch (SQLException e1) {
				System.out.println("Erro SQL");
			} catch (NumberFormatException e2) {
				javax.swing.JOptionPane.showMessageDialog(null, "É necessário informar o Limite de Especialistas.");
			}

		}

		
		
	}
}
