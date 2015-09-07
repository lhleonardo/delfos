package br.com.estatistica.modelos;

public class TipoPergunta {

	private int id;
	private String nome;
	private String descricao;

	public TipoPergunta(String nome) {
		this.nome = nome;
	}

	public TipoPergunta(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoPergunta(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoPergunta() {

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
