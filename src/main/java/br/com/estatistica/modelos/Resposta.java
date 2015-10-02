package br.com.estatistica.modelos;

public class Resposta implements Identificator {
	private int id;
	private String descricao;
	private String observacao;
	private Pergunta pergunta;
	private Pessoa pessoa;
	private String nome;

	public Resposta(int id, String descricao, String observacao, Pergunta pergunta, Pessoa pessoa, String nome) {
		this.id = id;
		this.descricao = descricao;
		this.observacao = observacao;
		this.pergunta = pergunta;
		this.pessoa = pessoa;
		this.nome = nome;
		
	}

	public Resposta(String descricao, Pergunta pergunta, Pessoa pessoa, String nome) {
		this.descricao = descricao;
		this.pergunta = pergunta;
		this.pessoa = pessoa;
		this.nome = nome;
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
	
	public String getNome() {
		return nome;
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

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void validate() {
		if (this.nome == null || this.descricao == null || this.observacao == null ) {
			throw new NullPointerException("O nome não pode ser nulo.");
	
}
	}
		
	}


