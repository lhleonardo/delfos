package br.com.estatistica.util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class ManipuladorDeComponentes {

	public static void limpaTextComponent(Container painel) {
		for (Component component : painel.getComponents()) {
			if (component instanceof JTextField) {
				((JTextComponent) component).setText("");
			}

			if (component instanceof JTextArea) {
				((JTextArea) component).setText("");
			}

		}

	}

}
