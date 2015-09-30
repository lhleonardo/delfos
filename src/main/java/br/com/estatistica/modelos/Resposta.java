package br.com.estatistica.modelos;

public class Resposta implements Identificator {
	private int id;
	private String descricao;
	private String observacao;
	private Pergunta pergunta;
	private Pessoa pessoa;

	public Resposta(int id, String descricao, String observacao, Pergunta pergunta, Pessoa pessoa) {
		this.id = id;
		this.descricao = descricao;
		this.observacao = observacao;
		this.pergunta = pergunta;
		this.pessoa = pessoa;
	}

	public Resposta(String descricao, Pergunta pergunta, Pessoa pessoa) {
		this.descricao = descricao;
		this.pergunta = pergunta;
		this.pessoa = pessoa;
	}

	public Resposta() {
	}

	@Override
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
