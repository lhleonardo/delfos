package br.com.estatistica.modelos;

public class Funcionalidade implements Identificator {

	private Integer id;
	private String nome;
	private String descricao;

	public Funcionalidade(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Funcionalidade(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Funcionalidade() {
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

	@Override
	public void validate() {
		if (this.getNome() == null || this.getId() == null) {
			throw new NullPointerException("Os campos ID e Nome são de preenchimento obrigatório.");
		}
	}

}
