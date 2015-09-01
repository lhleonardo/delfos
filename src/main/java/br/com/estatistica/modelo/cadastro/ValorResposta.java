package br.com.estatistica.modelo.cadastro;

public class ValorResposta {

	private int id;
	private double valor;
	private Pergunta pergunta;
	private Resposta resposta;
	private TipoReposta tipo;

	public ValorResposta(double valor, Pergunta pergunta, Resposta resposta, TipoReposta tipo) {
		this.valor = valor;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.tipo = tipo;
	}

	public ValorResposta(int id, double valor, Pergunta pergunta, Resposta resposta, TipoReposta tipo) {
		this.id = id;
		this.valor = valor;
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.tipo = tipo;
	}

	public ValorResposta() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public TipoReposta getTipo() {
		return tipo;
	}

	public void setTipo(TipoReposta tipo) {
		this.tipo = tipo;
	}

}
