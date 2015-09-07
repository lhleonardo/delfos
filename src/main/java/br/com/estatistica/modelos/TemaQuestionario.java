package br.com.estatistica.modelos;

public class TemaQuestionario {

	private int id;
	private String nome;
	private String descricao;

	public TemaQuestionario(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public TemaQuestionario(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public TemaQuestionario(String nome) {
		this.nome = nome;
	}

	public TemaQuestionario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
