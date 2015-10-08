package br.com.estatistica.dialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmInformacao extends JInternalFrame {
	private JPanel jContentPane = null;
	private JLabel lblNome = null;
	private JLabel lblNomeSelecionado = null;
	private JTextField txtNomeSelecionado = null;
	private JLabel lblIdade = null;
	private JTextField txtIdade = null;
	private JButton btnAbrir = null;

	/**
	 * This is the xxx default constructor
	 */
	public FrmInformacao() {
		super();
		this.initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(364, 146);
		this.setTitle("Exibir informa��es");
		this.setContentPane(this.getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (this.jContentPane == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 1;
			gridBagConstraints4.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints4.anchor = GridBagConstraints.EAST;
			gridBagConstraints4.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints2.anchor = GridBagConstraints.EAST;
			gridBagConstraints2.gridy = 1;
			this.lblIdade = new JLabel();
			this.lblIdade.setText("Idade digitada:");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			this.lblNomeSelecionado = new JLabel();
			this.lblNomeSelecionado.setText("JLabel");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.gridy = 0;
			this.lblNome = new JLabel();
			this.lblNome.setText("Nome selecionado:");
			this.jContentPane = new JPanel();
			this.jContentPane.setLayout(new GridBagLayout());
			this.jContentPane.add(this.lblNome, gridBagConstraints);
			this.jContentPane.add(this.getTxtNomeSelecionado(), gridBagConstraints11);
			this.jContentPane.add(this.lblIdade, gridBagConstraints2);
			this.jContentPane.add(this.getTxtIdade(), gridBagConstraints3);
			this.jContentPane.add(this.getBtnAbrir(), gridBagConstraints4);
			this.jContentPane.add(this.lblNomeSelecionado, gridBagConstraints1);
		}
		return this.jContentPane;
	}

	/**
	 * This method initializes txtNomeSelecionado
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtNomeSelecionado() {
		if (this.txtNomeSelecionado == null) {
			this.txtNomeSelecionado = new JTextField();
			this.txtNomeSelecionado.setEditable(false);
		}
		return this.txtNomeSelecionado;
	}

	/**
	 * This method initializes txtIdade
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtIdade() {
		if (this.txtIdade == null) {
			this.txtIdade = new JTextField();
			this.txtIdade.setEditable(false);
		}
		return this.txtIdade;
	}

	/**
	 * This method initializes btnAbrir
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnAbrir() {
		if (this.btnAbrir == null) {
			this.btnAbrir = new JButton();
			this.btnAbrir.setText("Alterar");
			this.btnAbrir.addActionListener(e -> FrmInformacao.this.onAlterarDados());
		}
		return this.btnAbrir;
	}

	protected void onAlterarDados() {
		DlgAlterarDados dialog = new DlgAlterarDados(null);
		if (dialog.alterarDados()) {
			this.txtNomeSelecionado.setText(dialog.getNome());
			this.txtIdade.setText(String.valueOf(dialog.getIdade()));
		}
		dialog.dispose();
	}

}  // @jve:decl-index=0:visual-constraint="10,10"
