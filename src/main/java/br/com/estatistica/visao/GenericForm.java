package br.com.estatistica.visao;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GenericForm extends JFrame {

	private JPanel contentPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenericForm frame = new GenericForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenericForm() {
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(181, 0, 389, 500);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 181, 523);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDelfos = new JLabel("Delfos");
		lblDelfos.setForeground(new Color(255, 255, 255));
		lblDelfos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDelfos.setBounds(79, 51, 74, 44);
		panel_1.add(lblDelfos);

		JLabel label = new JLabel("\u058D");
		label.setForeground(new Color(220, 220, 220));
		label.setFont(new Font("Arial", Font.BOLD, 44));
		label.setBounds(29, 39, 56, 52);
		panel_1.add(label);

	}

}
