package br.com.estatistica.util;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Mensagem {
	
	public static void informa(Component parent, String texto) {
		JOptionPane.showMessageDialog(null, texto, "Informações do sistema.", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void aviso(Component parent, String texto) {
		JOptionPane.showMessageDialog(parent, "Opa, o sistema encontrou uma coisa estranha...\nInformações: " + texto, "Aviso...",
		        JOptionPane.WARNING_MESSAGE);
	}
	
	public static void erro(Component parent, Throwable causa) {
		Mensagem.erro(parent, causa.getClass() + ":" + causa.getMessage());
	}
	
	public static void erro(Component parent, String causa) {
		JOptionPane.showMessageDialog(parent, "Um erro inesperado foi encontrado :(\nCausa: " + causa, "Falha interna",
		        JOptionPane.ERROR_MESSAGE);
	}
	
	public static String entrada(Component parent, String texto) {
		return JOptionPane.showInputDialog(parent, "Precisamos de sua ajuda, não sabemos como resolver :/\n\n" + texto, "Entrada de dados",
		        JOptionPane.QUESTION_MESSAGE);
	}
	
	public static int confirma(Component parent, String texto) {
		return confirma(parent, texto, JOptionPane.YES_NO_OPTION);
	}
	
	public static int confirma(Component parent, String texto, int tipoDeMensagem) {
		return JOptionPane.showConfirmDialog(parent, texto, "Confirmação", tipoDeMensagem);
	}
	
	public static void confirmaSaidaDoPrograma() {
		int confirmDialog = confirma(null, "Deseja realmente sair?");
		if (confirmDialog == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
}
