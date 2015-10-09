package br.com.estatistica.visao;

import java.sql.Connection;
import java.util.function.Supplier;

import br.com.estatistica.dao.PerguntaDAO;
import br.com.estatistica.dao.PesquisaDAO;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.util.ConnectionFactory;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class FrmCadastroPergunta extends GenericFormCadastro {
	
	private static final long serialVersionUID = 1L;
	private JTextField pergunta;
	private JTextField idPergunta;
	private JTextField desc;
	private JTextField obs;

	public FrmCadastroPergunta( Connection connection) {
		super("Cadastro de Perguntas", connection);
		
		JPanel coeficientes = new JPanel();
		getContentPane().add(coeficientes, BorderLayout.CENTER);
		coeficientes.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pergunta");
		lblNewLabel.setBounds(60, 11, 75, 14);
		coeficientes.add(lblNewLabel);
		
		pergunta = new JTextField();
		pergunta.setBounds(60, 26, 495, 20);
		coeficientes.add(pergunta);
		pergunta.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pergunta p1 = new Pergunta(pergunta.getText(),desc.getText(),obs.getText(),null,null,null);
				Integer idNovaPesquisa  = PerguntaDAO.insert(p1);
				
			}
		
		});
		salvar.setBounds(17, 404, 89, 23);
		coeficientes.add(salvar);
		
		idPergunta = new JTextField();
		idPergunta.setEditable(false);
		idPergunta.setBounds(17, 26, 35, 20);
		coeficientes.add(idPergunta);
		idPergunta.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(17, 11, 25, 14);
		coeficientes.add(lblId);
		
		desc = new JTextField();
		desc.setBounds(17, 80, 538, 84);
		coeficientes.add(desc);
		desc.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(17, 65, 75, 14);
		coeficientes.add(lblDescrio);
		
		obs = new JTextField();
		obs.setBounds(17, 191, 538, 32);
		coeficientes.add(obs);
		obs.setColumns(10);
		
		JLabel lblObservao = new JLabel("Observação");
		lblObservao.setBounds(17, 175, 96, 14);
		coeficientes.add(lblObservao);
		
		JLabel lblTipoDePergunta = new JLabel("Tipo de Pergunta");
		lblTipoDePergunta.setBounds(17, 234, 89, 14);
		coeficientes.add(lblTipoDePergunta);
		
		JComboBox tppergunta = new JComboBox();
		tppergunta.setModel(new DefaultComboBoxModel(new String[] {"Coeficiente de Argumentação", "Coeficiente de Competência"}));
		tppergunta.setToolTipText("");
		tppergunta.setBounds(17, 259, 215, 20);
		coeficientes.add(tppergunta);
		
		JButton NovaPergunta = new JButton("Nova Pergunta");
		NovaPergunta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				idPergunta.setText(" ");
				pergunta.setText(null);
				desc.setText(null);
				obs.setText(null);
			
			}
			
		});
		NovaPergunta.setBounds(565, 25, 129, 23);
		coeficientes.add(NovaPergunta);
	}

	
	public static void main(String[] args) {
		FrmCadastroPergunta frame = new FrmCadastroPergunta(new ConnectionFactory().getConnection());
		frame.setVisible(true);
		
	}
}

