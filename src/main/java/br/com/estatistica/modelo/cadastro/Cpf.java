package br.com.estatistica.modelo.cadastro;

public class Cpf extends CadastroNacionalDePessoa {
	/**
	 * 
	 * Método de inicialização da classe CPF
	 * 
	 * @param valor
	 *            - Numeração do CPF sem máscara.
	 */
	public Cpf(String valor) {
		super(valor);
	}

	/**
	 * 
	 * Método de inicialização da classe CPF sem receber parametros para inicialização.
	 */

	public Cpf() {
	}

	/**
	 * Constante que representa o peso relacionado ao CPF. <br>
	 * Para mais informações, acesse o método {@link #verifica()}
	 */
	private static final int[] peso = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	/**
	 * Método responsável por fazer a verificação dos dígitos validadores de um CPF a
	 * partir da função {@link #calcularDigito(String, int[])} encontrado na classe
	 * {@code CadastroNacionalDePessoa}.
	 * 
	 * @return true para CPF válido a partir do validador e false para CPF inválido.
	 */
	@Override
	protected boolean verifica() {
		if ((valor == null) || (valor.length() != 11)) return false;

		Integer digito1 = calcularDigito(valor.substring(0, 9), peso);
		Integer digito2 = calcularDigito(valor.substring(0, 9) + digito1, peso);
		return valor.equals(valor.substring(0, 9) + digito1.toString() + digito2.toString());
	}

	/**
	 * Método responsável por concatenar o CPF a partir de sua máscara padrão.
	 * 
	 * @return CPF já mascarado.
	 */
	@Override
	public String imprime() {
		// TODO Auto-generated method stub
		return (getValor().substring(0, 3) + "." + getValor().substring(3, 6) + "."
				+ getValor().substring(6, 9) + "-" + getValor().substring(9, 11));
	}

}
