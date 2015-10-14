package br.com.estatistica.modelos;

public class Pergunta implements Identificator {

	private Integer id;
	private String nome;
	private String descricao;
	private String observacao;
	private Questionario questionario;
	private TipoPergunta tipoPergunta;
	private TipoCampo tipoCampo;

	public Pergunta(Integer id, String nome, String descricao, String observacao, Questionario questionario, TipoPergunta tipoPergunta, TipoCampo tipoCampo) {
		this.id = id;
		this.nome= nome;
		this.descricao = descricao;
		this.observacao = observacao;
		this.questionario = questionario;
		this.tipoPergunta = tipoPergunta;
		this.tipoCampo = tipoCampo;
	}

	public Pergunta(String descricao,String nome, String observacao, Questionario questionario, TipoPergunta tipoPergunta, TipoCampo tipoCampo) {
		this.descricao = descricao;
		this.nome= nome;
		this.observacao = observacao;
		this.questionario = questionario;
		this.tipoPergunta = tipoPergunta;
		this.tipoCampo = tipoCampo;
	}

	public Pergunta(String nome, String descricao, Questionario questionario, TipoPergunta tipoPergunta, TipoCampo tipoCampo) {
		this.descricao = descricao;
		this.nome= nome;
		this.questionario = questionario;
		this.tipoPergunta = tipoPergunta;
		this.tipoCampo = tipoCampo;
	}
	

	public Pergunta() {
				
	}

	public Pergunta(int id, String nome,String descricao, String observacao) {
		this.id = id;
		this.nome= nome;
		this.descricao = descricao;
		this.observacao = observacao;

	}
	public Pergunta( String nome,String descricao, String observacao) {
		
		this.nome= nome;
		this.descricao = descricao;
		this.observacao = observacao;
	}

	public Integer getId() {
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public TipoPergunta getTipoPergunta() {
		return tipoPergunta;
	}

	public void setTipoPergunta(String aValue) {
		this.tipoPergunta = tipoPergunta;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

	public void setTipoCampo(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}		
	


	@Override
	public void validate() {
		if (this.nome == null || this.descricao == null || this.observacao == null ) {
			throw new NullPointerException("nome, descrição, tipo de campo ou tipo de pergunta não podem ser nulo.");
	
}
	}
}