package br.com.estatistica.util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.text.JTextComponent;

public class ManipuladorDeComponentes {

	public static Container limpaTextComponent(Container painel) {
		for (Component component : painel.getComponents()) {
			if (component instanceof JTextComponent) {
				((JTextComponent) component).setText("");
			}
		}

		return painel;
	}

}
