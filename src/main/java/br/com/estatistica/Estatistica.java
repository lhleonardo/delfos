package br.com.estatistica;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.estatistica.visao.FrmMenuPrincipal;

public class Estatistica {
	public static void main(String[] args) {
		try {
			FrmMenuPrincipal principal = new FrmMenuPrincipal();
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			principal.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
