package br.com.estatistica.modelos;

/**
 * Classe responsável por representar uma cidade para um determinado endereço.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Cidade implements Identificator {
	
	private Integer id;
	private String nome;
	private String descricao;
	private String codIbge;
	
	private Estado estado;
	
	public Cidade(Integer id, String nome, String descricao, String codIbge, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.codIbge = codIbge;
		this.estado = estado;
	}
	
	public Cidade(String nome, String descricao, Estado estado) {
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}
	
	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
	}
	
	public Cidade() {
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
	
	public String getCodIbge() {
		return this.codIbge;
	}
	
	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public void validate() {
		if (this.nome == null || this.estado == null) {
			throw new IllegalArgumentException("É necessário informar o nome e o estado dessa cidade.");
		}
	}
	
}
