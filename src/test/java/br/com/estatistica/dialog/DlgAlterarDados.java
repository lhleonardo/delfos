package br.com.estatistica.dialog;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 */
public class DlgAlterarDados extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lblNome = null;
	private JComboBox cmbNome = null;
	private JLabel lblIdade = null;
	private JTextField txtIdade = null;
	private JPanel pnlButtons = null;
	private JButton btnOk = null;
	private JButton btnCancelar = null;
	protected boolean okSelecionado;

	/**
	 * @param owner
	 */
	public DlgAlterarDados(Frame owner) {
		super(owner);
		this.initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(411, 151);
		this.setTitle("Alterar dados do usu�rio");
		this.setContentPane(this.getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (this.jContentPane == null) {
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 1;
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.gridy = 2;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints7.gridy = 1;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.anchor = GridBagConstraints.WEST;
			gridBagConstraints7.ipadx = 30;
			gridBagConstraints7.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints7.gridx = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.anchor = GridBagConstraints.EAST;
			gridBagConstraints5.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints5.gridy = 1;
			this.lblIdade = new JLabel();
			this.lblIdade.setText("Idade:");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints1.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.anchor = GridBagConstraints.EAST;
			gridBagConstraints.insets = new Insets(3, 3, 3, 3);
			gridBagConstraints.gridy = 0;
			this.lblNome = new JLabel();
			this.lblNome.setText("Nome do usu�rio:");
			this.jContentPane = new JPanel();
			this.jContentPane.setLayout(new GridBagLayout());
			this.jContentPane.add(this.lblNome, gridBagConstraints);
			this.jContentPane.add(this.getCmbNome(), gridBagConstraints1);
			this.jContentPane.add(this.lblIdade, gridBagConstraints5);
			this.jContentPane.add(this.getTxtIdade(), gridBagConstraints7);
			this.jContentPane.add(this.getPnlButtons(), gridBagConstraints9);
		}
		return this.jContentPane;
	}

	/**
	 * This method initializes cmbNome
	 *
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getCmbNome() {
		if (this.cmbNome == null) {
			this.cmbNome = new JComboBox(new String[] { "Ana", "Beto", "Lucas", "Tavares", "Vin�cius" });
		}
		return this.cmbNome;
	}

	/**
	 * This method initializes txtIdade
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtIdade() {
		if (this.txtIdade == null) {
			this.txtIdade = new JTextField();
		}
		return this.txtIdade;
	}

	/**
	 * This method initializes pnlButtons
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getPnlButtons() {
		if (this.pnlButtons == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			flowLayout.setVgap(0);
			flowLayout.setHgap(3);
			this.pnlButtons = new JPanel();
			this.pnlButtons.setLayout(flowLayout);
			this.pnlButtons.add(this.getBtnOk(), null);
			this.pnlButtons.add(this.getBtnCancelar(), null);
		}
		return this.pnlButtons;
	}

	/**
	 * This method initializes btnOk
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnOk() {
		if (this.btnOk == null) {
			this.btnOk = new JButton();
			this.btnOk.setText("Ok");
			this.btnOk.addActionListener(e -> {
				// Um pouco de valida��o, para n�o aceitar uma idade textual.
				try {
					Integer.parseInt(DlgAlterarDados.this.txtIdade.getText());
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(DlgAlterarDados.this, "A idade deve ser um n�mero!");
				}

				DlgAlterarDados.this.okSelecionado = true; // Dizemos que o ok foi
				                                               // selecionado.
				DlgAlterarDados.this.setVisible(false);
			});
		}
		return this.btnOk;
	}

	/**
	 * This method initializes btnCancelar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getBtnCancelar() {
		if (this.btnCancelar == null) {
			this.btnCancelar = new JButton();
			this.btnCancelar.setText("Cancelar");
			this.btnCancelar.addActionListener(e -> DlgAlterarDados.this.setVisible(false));
		}
		return this.btnCancelar;
	}

	public boolean alterarDados() {
		this.okSelecionado = false;  // Marcamos que o ok n�o foi selecionado
		this.setModal(true);         // A dialog tem que ser modal. S� pode retornar do
		// setVisible ap�s ficar invis�vel.
		this.setVisible(true);       // Mostramos a dialog e esperamos o usu�rio escolher
		// alguma coisa.
		return this.okSelecionado;   // Retornamos true, se ele pressionou ok.
	}

	public int getIdade() {
		return Integer.parseInt(this.txtIdade.getText());
	}

	public String getNome() {
		return this.cmbNome.getSelectedItem().toString();
	}

}  // @jve:decl-index=0:visual-constraint="10,10"
