package br.com.estatistica.modelos;

/**
 * Classe responsável por representar um endereço que reside determinada pessoa, contendo
 * suas informações para localização.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Endereco implements Identificator {
	
	private Integer id;
	private String logradouro;
	private String descricao;
	private String numero;
	private String cep;
	
	private TipoLogradouro tipoLogradouro;
	private Bairro bairro;
	private Cidade cidade;
	
	public Endereco(Integer id, String logradouro, TipoLogradouro tipoLogradouro, String descricao, String numero, String cep,
	        Bairro bairro, Cidade cidade) {
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
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogradouro() {
		return this.logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public TipoLogradouro getTipoLogradouro() {
		return this.tipoLogradouro;
	}
	
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Bairro getBairro() {
		return this.bairro;
	}
	
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public Cidade getCidade() {
		return this.cidade;
	}
	
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public void validate() {
		// TODO implementar validação de estado.
		
	}
	
}
