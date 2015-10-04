package br.com.estatistica;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.com.estatistica.visao.FrmLoginUsuario;

public class Estatistica {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			FrmLoginUsuario login = new FrmLoginUsuario();
			login.setVisible(true);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}
