package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.estatistica.dao.GenericDAO;

/**
 * Classe responsável por ser um molde de telas de consulta, fazendo uma espera
 * até a confirmação do usuário.
 *
 * @author lhleonardo
 * @version 1.0
 * @since 1.6
 * @see javax.swing.JDialog
 *
 */
public abstract class GenericDialogConsulta extends JDialog {

	private static final long serialVersionUID = 1L;

	private Connection connection;

	private boolean btnOkPressed;

	public static void main(String[] args) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GenericDialogConsulta(Frame owner, String title, Connection connection) {
		super(owner, title);
		this.connection = connection;
		this.initComponents();
	}

	private void initComponents() {
		this.setBounds(100, 100, 643, 477);
		this.getContentPane().setLayout(new BorderLayout());
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(e -> {
			this.btnOkActionPerformed(e);
		});
		buttonPane.add(okButton);
		this.getRootPane().setDefaultButton(okButton);
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		this.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 110, 30, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 23, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);

		JLabel lblIcon = new JLabel();
		lblIcon.setForeground(new Color(220, 220, 220));
		lblIcon.setIcon(new ImageIcon(GenericDialogConsulta.class
				.getResource("/br/com/estatistica/util/icons/logo/Logo-vers-1(16-09)min.png")));
		lblIcon.setFont(new Font("Calibri Light", Font.BOLD, 20));
		lblIcon.setBounds(13, 11, 143, 81);
		panel_1.add(lblIcon);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(3, 103, 187, 1);
		panel_1.add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);
	}

	/**
	 * @param e
	 */
	protected abstract void btnOkActionPerformed(ActionEvent e);

	/**
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

	public boolean execute() {
		this.btnOkPressed = false;
		this.setModal(true);
		this.setVisible(true);
		return this.btnOkPressed;
	}

	protected GenericDAO<?> initializeDAO(GenericDAO<?> dao) throws SQLException {
		if (dao.getConnection().isClosed() || dao.getConnection() == null) {
			dao.setConnection(this.getConnection());
		}

		return dao;
	}

}
