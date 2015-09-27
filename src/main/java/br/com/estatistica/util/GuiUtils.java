package br.com.estatistica.util;

import br.com.estatistica.el.annotation.AnnotationResolver;
import br.com.estatistica.modelos.Identificator;
import br.com.estatistica.swing.ObjectTableModel;

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
}
