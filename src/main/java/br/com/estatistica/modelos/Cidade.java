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
	private String codigoIbge;

	private Estado estado;

	public Cidade(int id, String nome, String descricao, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public void validate() {
		if (this.getNome().isEmpty() || this.getEstado() == null) {
			throw new IllegalArgumentException("O campo nome e as informações do estado são de preenchimento obrigatório.");
		}
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

}
