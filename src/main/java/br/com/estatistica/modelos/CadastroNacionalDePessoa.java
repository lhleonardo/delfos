package br.com.estatistica.modelos;

/**
 * Classe responsável por validar e mascarar os documentos do Cadastro Nacional de
 * Pessoa, sendo Física ou Juridica. <br>
 * Algumas classes que representam: {@code Cpf}, {@code Cnpj} e etc.
 * 
 * @author lhleonardo
 * @since 1.0
 * @version 1.0
 *
 */
public abstract class CadastroNacionalDePessoa implements Documento {

	protected String valor;

	public CadastroNacionalDePessoa(String valor) {
		super();
		this.valor = valor;
	}

	public CadastroNacionalDePessoa() {
	}

	/**
	 * 
	 * @param str
	 *            valor do documento recebido.
	 * @param peso
	 *            do tipo de documento.
	 * @return 0 se o resultado da soma for maior que nove, senão o próprio valor.
	 */
	protected static int calcularDigito(String str, int[] peso) {
		int soma = 0;
		for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
			digito = Integer.parseInt(str.substring(indice, indice + 1));
			soma += digito * peso[peso.length - str.length() + indice];
		}
		soma = 11 - soma % 11;
		return soma > 9 ? 0 : soma;
	}

	/**
	 * Método responsável por fazer a verificação dos digitos.
	 * 
	 */
	public boolean isValido() {
		return verifica();
	}

	protected abstract boolean verifica();

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}