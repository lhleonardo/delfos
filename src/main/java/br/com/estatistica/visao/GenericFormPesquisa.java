package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.estatistica.modelos.Identificator;

public class GenericFormPesquisa<T extends Identificator> extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JPanel panel_2;
	private JPanel panel_3;

	private Connection connection;

	private T obj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenericFormPesquisa(String nameFrame, Connection connection) {
		this.connection = connection;
		initComponents(nameFrame);
	}

	public GenericFormPesquisa() {
		initComponents("Search pattern");
	}

	private void initComponents(String nameFrame) {
		setTitle(nameFrame);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 451);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panel = new JPanel();
		this.panel.setBackground(Color.DARK_GRAY);
		this.contentPane.add(this.panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 21, 83, 21, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 23, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		this.panel.setLayout(gbl_panel);

		this.panel_1 = new JPanel();
		this.panel_1.setLayout(null);
		this.panel_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		this.panel.add(this.panel_1, gbc_panel_1);

		this.label = new JLabel("֍");
		this.label.setForeground(new Color(220, 220, 220));
		this.label.setFont(new Font("Arial", Font.PLAIN, 46));
		this.label.setBounds(20, 35, 53, 52);
		this.panel_1.add(this.label);

		this.label_1 = new JLabel("Delfos");
		this.label_1.setForeground(new Color(220, 220, 220));
		this.label_1.setFont(new Font("Calibri Light", Font.BOLD, 20));
		this.label_1.setBounds(67, 52, 60, 40);
		this.panel_1.add(this.label_1);

		this.panel_2 = new JPanel();
		this.panel_2.setBounds(3, 103, 124, 1);
		this.panel_1.add(this.panel_2);

		this.panel_3 = new JPanel();
		this.panel_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		this.panel.add(this.panel_3, gbc_panel_3);
	}

	public Connection getConnection() {
		return connection;
	}

}
