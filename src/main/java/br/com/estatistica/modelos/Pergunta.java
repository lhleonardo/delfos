package br.com.estatistica.modelos;

public class Pergunta implements Identificator {

	private Integer id;
	private String descricao;
	private String observacao;
	private Questionario questionario;
	private TipoPergunta tipoPergunta;
	private TipoCampo tipoCampo;

	public Pergunta(int id, String descricao, String observacao, Questionario questionario, TipoPergunta tipoPergunta, TipoCampo tipoCampo) {
		this.id = id;
		this.descricao = descricao;
		this.observacao = observacao;
		this.questionario = questionario;
		this.tipoPergunta = tipoPergunta;
		this.tipoCampo = tipoCampo;
	}

	public Pergunta(String descricao, String observacao, Questionario questionario, TipoPergunta tipoPergunta, TipoCampo tipoCampo) {
		this.descricao = descricao;
		this.observacao = observacao;
		this.questionario = questionario;
		this.tipoPergunta = tipoPergunta;
		this.tipoCampo = tipoCampo;
	}

	public Pergunta(String descricao, Questionario questionario, TipoPergunta tipoPergunta, TipoCampo tipoCampo) {
		this.descricao = descricao;
		this.questionario = questionario;
		this.tipoPergunta = tipoPergunta;
		this.tipoCampo = tipoCampo;
	}
	

	public Pergunta() {
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

	public void setTipoPergunta(TipoPergunta tipoPergunta) {
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
		if (this.getId() == null || this.descricao == null || this.observacao == null || this.questionario == null || this.tipoCampo == null || this.tipoPergunta == null) {
			throw new NullPointerException("ID, login, descrição ou perfil de acesso não podem ser nulo.");
		}		
	}

}
