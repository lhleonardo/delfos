package br.com.estatistica.modelos;


/**
 * Classe responsável por representar um endereço que reside determinada pessoa, contendo
 * suas informações para localização.
 * 
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Endereco {

	private int id;
	private String logradouro;
	private String descricao;
	private int numero;
	private String cep;

	private TipoLogradouro tipoLogradouro;
	private Bairro bairro;
	private Cidade cidade;

	public Endereco(int id, String logradouro, TipoLogradouro tipoLogradouro, String descricao, int numero, String cep, Bairro bairro,
	        Cidade cidade) {
		this.id = id;
		this.logradouro = logradouro;
		this.tipoLogradouro = tipoLogradouro;
		this.descricao = descricao;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Endereco() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
