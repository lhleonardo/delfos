package br.com.estatistica.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

import br.com.estatistica.el.annotation.AnnotationResolver;
import br.com.estatistica.modelos.Identificator;
import br.com.estatistica.visao.ObjectTableModel;

public class GuiUtils {
	/**
	 * Método responsável por criar um modelo de tabela para determinada classe
	 *
	 * @param clazz
	 *            Classe que terá suas informações gerenciadas pelo Table Model
	 * @param cols
	 *            colunas que serão criadas pela classe
	 * @return ObjectTableModel
	 */
	public static <T extends Identificator> ObjectTableModel<? extends Identificator> criaTableModel(Class<? extends Identificator> clazz,
			String cols) {
		AnnotationResolver resolver = new AnnotationResolver(clazz);
		return new ObjectTableModel<T>(resolver, cols);
	}

	/**
	 * Método responsável por definir um ponto para o centro da tela.
	 *
	 * @param frmLoginUsuario
	 * @return ponto para posicionamento no centro da tela
	 */
	public static Point centralizaTela(JFrame frame) {
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dw = frame.getSize();
		return new Point((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
	}
}
