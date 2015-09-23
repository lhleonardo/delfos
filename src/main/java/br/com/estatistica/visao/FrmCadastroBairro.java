package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrmCadastroBairro extends GenericFormCadastro {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JButton btnPesquisar;
	private JLabel lblNome;
	private JTextField textField;
	private JLabel lblDescrio;
	private JTextArea textArea;
	private JPanel panel_1;
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnExcluir;
	private JButton btnCancelar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroBairro frame = new FrmCadastroBairro(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public FrmCadastroBairro(Connection connection) {
		// TODO Refazer a tela.
		super("Cadastro de Bairros");
		this.initComponents();
	}

	private void initComponents() {
		
		this.panel = new JPanel();
		this.getContentPane().add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
		this.lblCdigo = new JLabel("Código");
		this.lblCdigo.setBounds(10, 11, 46, 14);
		this.panel.add(this.lblCdigo);
		
		this.txtCodigo = new JTextField();
		this.txtCodigo.setEditable(false);
		this.txtCodigo.setBounds(10, 25, 46, 20);
		this.panel.add(this.txtCodigo);
		this.txtCodigo.setColumns(10);
		
		this.btnPesquisar = new JButton("");
		this.btnPesquisar.setBounds(58, 24, 33, 23);
		this.panel.add(this.btnPesquisar);
		
		this.lblNome = new JLabel("Nome");
		this.lblNome.setBounds(101, 11, 46, 14);
		this.panel.add(this.lblNome);
		
		this.textField = new JTextField();
		this.textField.setBounds(101, 25, 363, 20);
		this.panel.add(this.textField);
		this.textField.setColumns(10);
		
		this.lblDescrio = new JLabel("Descrição");
		this.lblDescrio.setBounds(10, 51, 46, 14);
		this.panel.add(this.lblDescrio);
		
		this.textArea = new JTextArea();
		this.textArea.setLineWrap(true);
		this.textArea.setBounds(10, 65, 454, 219);
		this.panel.add(this.textArea);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBounds(10, 295, 454, 43);
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(null);

		this.btnNovo = new JButton("Novo");
		this.btnNovo.setBounds(0, 0, 92, 43);
		this.panel_1.add(this.btnNovo);

		this.btnSalvar = new JButton("Salvar");
		this.btnSalvar.setBounds(91, 0, 92, 43);
		this.panel_1.add(this.btnSalvar);

		this.btnExcluir = new JButton("Excluir");
		this.btnExcluir.setBounds(183, 0, 92, 43);
		this.panel_1.add(this.btnExcluir);

		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(362, 0, 92, 43);
		this.panel_1.add(this.btnCancelar);
	}
}
