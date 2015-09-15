package br.com.estatistica.modelos;

/**
 * Classe responsável por representar uma cidade para um determinado endereço.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Cidade implements Identificator {
	
	private String codigoIbge;
	private String descricao;
	private Estado estado;
	private Integer id;
	
	private String nome;
	
	public Cidade() {
	}
	
	public Cidade(int id, String nome, String descricao, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}
	
	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
	}
	
	public Cidade(String nome, String descricao, Estado estado) {
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}
	
	public String getCodigoIbge() {
		return this.codigoIbge;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void validate() {
		if (this.getNome().isEmpty() || this.getEstado() == null) {
			throw new IllegalArgumentException("O campo nome e as informações do estado são de preenchimento obrigatório.");
		}
	}
	
}
