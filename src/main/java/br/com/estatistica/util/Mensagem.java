package br.com.estatistica.util;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Mensagem {

	public static void informa(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}

	public static String entrada(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

	public static String entradaComBotoesPersonalizados(String titulo,
			String texto, ArrayList<Object> opcoes) {
		return (String) JOptionPane.showInputDialog(null, texto, titulo,
				JOptionPane.QUESTION_MESSAGE, null, opcoes.toArray(), null);
	}

}
