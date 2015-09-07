package br.com.estatistica.modelos;

/**
 * Interface <b>Documento</b> responsável por realizar um contrato entre os documentos
 * que uma {@link Pessoa} pode ter.
 * 
 * @author lhleonardo
 *
 */
public interface Documento {
	/**
	 * Método responsável por informar o conteúdo do documento.
	 * 
	 * @return valor do Documento
	 */
	String getValor();

	/**
	 * Método responsável por validar os Dígitos Verificadores de um documento.
	 * 
	 * @return ...
	 */
	boolean isValido();

	/**
	 * Método responsável por mascarar um documento.
	 * 
	 * @return Documento com sua máscara específica.
	 */
	String imprime();

}
