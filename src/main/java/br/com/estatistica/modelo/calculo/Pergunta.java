package br.com.estatistica.modelo.calculo;

public abstract class Pergunta {

	private String nome;

	public Pergunta(String nome) {
		super();
		this.nome = nome;
	}

	public abstract double getValorDaResposta(Resposta resposta);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
