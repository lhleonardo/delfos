package br.com.estatistica.modelos;

public class Questionario {

	private int id;
	private String descricao;
	private Pesquisa pesquisa;
	private TemaQuestionario tema;

	public Questionario(int id, String descricao, Pesquisa pesquisa, TemaQuestionario tema) {
		this.id = id;
		this.descricao = descricao;
		this.pesquisa = pesquisa;
		this.tema = tema;
	}

	public Questionario(String descricao, Pesquisa pesquisa, TemaQuestionario tema) {
		this.descricao = descricao;
		this.pesquisa = pesquisa;
		this.tema = tema;
	}

	public Questionario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public TemaQuestionario getTema() {
		return tema;
	}

	public void setTema(TemaQuestionario tema) {
		this.tema = tema;
	}

}
