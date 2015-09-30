package br.com.estatistica.modelos;

public class Questionario implements Identificator {

	private int id;
	private String nome;
	private String descricao;
	private Pesquisa pesquisa;
	private TemaQuestionario tema;

	public Questionario(int id, String nome, String descricao, Pesquisa pesquisa, TemaQuestionario tema) {
		this.id = id;
		this.setNome(nome);
		this.descricao = descricao;
		this.pesquisa = pesquisa;
		this.tema = tema;
	}

	public Questionario(String nome, Pesquisa pesquisa, TemaQuestionario tema) {
		this.setNome(nome);
		this.pesquisa = pesquisa;
		this.tema = tema;
	}
	
	public Questionario(String nome, String descricao){
		this.nome = nome;
		this.descricao = descricao;
	}
	public Questionario(int id){
		this.id = id;
		
	}

	public Questionario() {

	}

	public Integer getId() {
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

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
