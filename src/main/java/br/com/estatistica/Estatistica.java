package br.com.estatistica;

import java.awt.EventQueue;

import br.com.estatistica.visao.FrmLoginUsuario;

public class Estatistica {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FrmLoginUsuario frame = new FrmLoginUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
