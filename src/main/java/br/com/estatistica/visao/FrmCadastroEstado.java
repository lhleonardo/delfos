package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrmCadastroEstado extends GenericFormCadastro {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblNome;
	private JTextField textField_1;
	private JLabel lblUf;
	private JTextField textField_2;
	private JLabel lblDescrio;
	private JTextArea textArea;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	private JScrollPane scrollPane_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroEstado frame = new FrmCadastroEstado(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public FrmCadastroEstado(Connection connection) {
		super("Cadastro de Estados", connection);
		this.initComponents();
	}
	
	private void initComponents() {

		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);

		this.lblCdigo = new JLabel("Código");
		this.lblCdigo.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblCdigo);

		this.textField = new JTextField();
		this.textField.setEditable(false);
		this.textField.setBounds(10, 25, 46, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);

		this.btnNewButton = new JButton("");
		this.btnNewButton.setBounds(56, 24, 33, 23);
		this.panel.add(this.btnNewButton);

		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(97, 11, 46, 14);
		this.panel.add(this.lblNome);

		this.textField_1 = new JTextField();
		this.textField_1.setBounds(99, 25, 218, 20);
		this.panel.add(this.textField_1);
		this.textField_1.setColumns(10);

		this.lblUf = new JLabel("UF");
		this.lblUf.setBounds(321, 11, 46, 14);
		this.panel.add(this.lblUf);

		this.textField_2 = new JTextField();
		this.textField_2.setBounds(321, 25, 46, 20);
		this.panel.add(this.textField_2);
		this.textField_2.setColumns(10);

		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 56, 46, 14);
		this.panel.add(this.lblDescrio);
		this.scrollPane = new ScrollPane(this.textArea);

		this.scrollPane_1 = new JScrollPane();
		this.scrollPane_1.setBounds(10, 71, 357, 213);
		this.panel.add(this.scrollPane_1);

		this.textArea = new JTextArea();
		this.textArea.setLineWrap(true);
		this.scrollPane_1.setViewportView(this.textArea);

		this.btnNovo = new JButton("Novo");
		this.btnNovo.addActionListener(e -> FrmCadastroEstado.this.btnNovoActionPerformed(e));
		this.btnNovo.setBounds(10, 295, 68, 31);
		this.panel.add(this.btnNovo);

		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(77, 295, 68, 31);
		this.panel.add(this.btnSalvar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.setBounds(147, 295, 68, 31);
		this.panel.add(this.btnExcluir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(284, 295, 83, 31);
		this.panel.add(this.btnCancelar);
	}
	
	protected void btnNovoActionPerformed(ActionEvent e) {
	}
}
