package br.com.estatistica.visao.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmConsultaBairroDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton btnPesquisar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmConsultaBairroDialog dialog = new FrmConsultaBairroDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public FrmConsultaBairroDialog() {
		this.setBounds(100, 100, 498, 354);
		this.getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setLayout(new FlowLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNome = new JLabel("Nome");
			this.contentPanel.add(lblNome);
		}
		{
			this.textField = new JTextField();
			this.contentPanel.add(this.textField);
			this.textField.setColumns(10);
		}
		{
			this.btnPesquisar = new JButton("New button");
			this.contentPanel.add(this.btnPesquisar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				this.getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
}
