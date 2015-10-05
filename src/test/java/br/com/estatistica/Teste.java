/**
 * Classe Teste.java
 *
 * @author Leonardo Braz
 */
package br.com.estatistica;

import javax.swing.JFrame;

/**
 * @author Leonardo Braz
 *
 */
public class Teste {
	
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName(Teste.class.getPackage().getName() + ".FrmCadastroPessoa");
			JFrame frame = (JFrame) clazz.newInstance();
			frame.setVisible(true);
		} catch (Exception ex) {
			// TODO Implementar o tratamento de exceções
			ex.printStackTrace();
		}
	}
}
