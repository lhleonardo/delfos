package br.com.estatistica.visao;


import java.awt.EventQueue;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class FrmCadastroPergunta extends GenericFormCadastro {

	
	private static final long serialVersionUID = 1L;
	private JTextField txtOi;
	private JTextField textField;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroPergunta frame = new FrmCadastroPergunta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FrmCadastroPergunta() {
		super();
		setTitle("Cadastro de Pergunta");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtOi = new JTextField();
		txtOi.setHorizontalAlignment(SwingConstants.LEFT);
		txtOi.setBounds(29, 57, 451, 20);
		panel.add(txtOi);
		txtOi.setColumns(10);
		
		Label label = new Label("Pergunta:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(29, 28, 97, 23);
		panel.add(label);
		
		JLabel lblObservao = new JLabel("Observação:");
		lblObservao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservao.setBounds(29, 107, 112, 14);
		panel.add(lblObservao);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(29, 132, 451, 53);
		panel.add(textField);
		
		JLabel lblTipoDePergunta = new JLabel("Tipo de Pergunta:");
		lblTipoDePergunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipoDePergunta.setBounds(29, 206, 116, 14);
		panel.add(lblTipoDePergunta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Coeficiente de Argumentação ", "Coeficiente de Competência"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(29, 231, 197, 20);
		panel.add(comboBox);
	}
}
