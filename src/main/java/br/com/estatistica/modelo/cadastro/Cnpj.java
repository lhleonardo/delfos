package br.com.estatistica.modelo.cadastro;

public class Cnpj extends CadastroNacionalDePessoa {

	/**
	 * 
	 * Método de inicialização da classe Cnpj sem receber parametros para inicialização.
	 */

	public Cnpj() {
		super();
	}

	/**
	 * 
	 * Método de inicialização da classe Cnpj
	 * 
	 * @param valor
	 *            - Numeração do CNPJ sem mascara.
	 */
	public Cnpj(String valor) {
		super(valor);
	}

	/**
	 * Constante que representa o peso relacionado ao CNPJ. <br>
	 * Para mais informações, acesse o método {@link #verifica()}
	 */
	private static final int[] peso = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

	/**
	 * Método responsável por fazer a verificação dos dígitos validadores de um CNPJ a
	 * partir da função {@link #calcularDigito(String, int[])} encontrado na classe
	 * {@code CadastroNacionalDePessoa}.
	 * 
	 * @return true para CNPJ válido a partir do validador e false para CNPJ inválido.
	 */
	@Override
	protected boolean verifica() {
		if ((super.valor == null) || (super.valor.length() != 14)) return false;

		Integer digito1 = calcularDigito(super.valor.substring(0, 12), peso);
		Integer digito2 = calcularDigito(super.valor.substring(0, 12) + digito1, peso);
		return super.valor.equals(super.valor.substring(0, 12) + digito1.toString() + digito2.toString());
	}

	/**
	 * Método responsável por concatenar o CNPJ a partir de sua máscara padrão.
	 * 
	 * @return CNPJ já mascarado.
	 */
	@Override
	public String imprime() {
		return (getValor().substring(0, 2) + "." + getValor().substring(2, 5) + "."
				+ getValor().substring(5, 8) + "." + getValor().substring(8, 12) + "-" + getValor()
				.substring(12, 14));

	}
}
