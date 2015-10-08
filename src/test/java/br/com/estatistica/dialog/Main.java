package br.com.estatistica.dialog;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JDesktopPane dskPane = null;
	
	/**
	 * This method initializes dskPane
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getDskPane() {
		if (this.dskPane == null) {
			FrmInformacao internalFrame = new FrmInformacao();
			
			this.dskPane = new JDesktopPane();
			this.dskPane.add(internalFrame);
			
			internalFrame.setVisible(true);
		}
		return this.dskPane;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			Main thisClass = new Main();
			thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			thisClass.setVisible(true);
		});
	}
	
	/**
	 * This is the default constructor
	 */
	public Main() {
		super();
		this.initialize();
	}
	
	/**
	 * This method initializes this
	 *
	 */
	private void initialize() {
		this.setSize(534, 340);
		this.setContentPane(this.getJContentPane());
		this.setTitle("JFrame");
	}
	
	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (this.jContentPane == null) {
			this.jContentPane = new JPanel();
			this.jContentPane.setLayout(new BorderLayout());
			this.jContentPane.add(this.getDskPane(), BorderLayout.CENTER);
		}
		return this.jContentPane;
	}
	
}  // @jve:decl-index=0:visual-constraint="10,10"
