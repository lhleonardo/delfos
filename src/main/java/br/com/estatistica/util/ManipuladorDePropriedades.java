package br.com.estatistica.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe responsável por manipular os arquivos de propriedades
 * 
 * @author Leonardo Braz
 * @since 5.0
 */
public class ManipuladorDePropriedades {

	/**
	 * Atributo responsável por armazenar o caminho que se encontra o arquivo de
	 * manipulação.
	 */
	private String arquivo;

	/**
	 * Construtor que recebe o caminho de onde se encontra o arquivo de propriedades
	 * 
	 * @param arquivo
	 *            localização do arquivo
	 */
	public ManipuladorDePropriedades(String arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * Método responsável por preparar o arquivo para sua manipulação.
	 * 
	 * @return Properties instância de Properties pronta para manipulação.
	 * @throws IOException
	 *             caso o caminho do arquivo informado no construtor não for encontrado ou
	 *             válido
	 * @author Leonardo Braz
	 */

	public Properties getProp() throws IOException {
		Properties properties = new Properties();
		// indica um caminho da localização do arquivo
		FileInputStream file = new FileInputStream(this.arquivo);
		// instancia esse arquivo
		properties.load(file);
		return properties;
	}

}
