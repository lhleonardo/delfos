package br.com.estatistica;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.estatistica.visao.FrmLoginUsuario;

public class Estatistica {

	public static void main(String[] args) {
		
		try {
			// define a aplicação com look and feel do sistema.
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			FrmLoginUsuario login = new FrmLoginUsuario();
			login.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
