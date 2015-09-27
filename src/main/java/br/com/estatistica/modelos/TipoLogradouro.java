package br.com.estatistica.modelos;

/**
 * Classe responsável por representar um tipo de logradouro para um determinado endereço.
 *
 * EX: Rua, Avenida, etc.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */

public class TipoLogradouro implements Identificator {
	
	private Integer id;
	private String nome;
	private String descricao;
	private String sigla;
	
	public TipoLogradouro(int id, String nome, String sigla, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public TipoLogradouro(String nome, String sigla, String descricao) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public TipoLogradouro(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getSigla() {
		return this.sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public void validate() {
		if (this.nome == null | this.sigla == null) {
			throw new IllegalArgumentException("Os campos Nome e Sigla para o registro de Logradouro são de preenchimento obrigatório.");
		}
		
	}
	
}
