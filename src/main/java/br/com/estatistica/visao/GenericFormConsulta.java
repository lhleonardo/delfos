package br.com.estatistica.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.estatistica.util.ConnectionFactory;

public abstract class GenericFormConsulta<Target> extends JFrame {
	
	private Target object;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panel_2;
	private Connection connection;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				GenericFormCadastro frame = new GenericFormCadastro();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public GenericFormConsulta(String nameFrame, Connection connection) {
		this.initComponents(nameFrame);
		this.connection = connection;
	}
	
	public GenericFormConsulta() {
		this.initComponents("Pesquisa");
		this.connection = new ConnectionFactory().getConnection();
	}
	
	protected void initComponents(String nameFrame) {
		this.setTitle(nameFrame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 828, 460);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		this.contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 110, 30, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 23, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		this.panel_2 = new JPanel();
		this.panel_2.setBackground(Color.DARK_GRAY);
		this.panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(this.panel_2, gbc_panel_2);
		
		JLabel label_1 = new JLabel();
		label_1.setIcon(new ImageIcon(GenericFormCadastro.class
		        .getResource("/br/com/estatistica/util/icons/logo/Logo-vers-1(16-09)min.png")));
		label_1.setForeground(new Color(220, 220, 220));
		label_1.setFont(new Font("Calibri Light", Font.BOLD, 20));
		label_1.setBounds(13, 11, 143, 81);
		this.panel_2.add(label_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(3, 103, 187, 1);
		this.panel_2.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.gridwidth = 3;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	protected Connection getConnection() {
		return this.connection;
	}
	
	public Target getObject() {
		return this.object;
	}
	
}
