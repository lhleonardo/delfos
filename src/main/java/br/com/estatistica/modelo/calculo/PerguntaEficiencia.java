package br.com.estatistica.modelo.calculo;

public class PerguntaEficiencia extends Pergunta {

	private double valorGrauAlto = 0.0;
	private double valorGrauMedio = 0.0;
	private double valorGrauBaixo = 0.0;

	public PerguntaEficiencia(String nome, double valorGrauAlto, double valorGrauMedio, double valorGrauBaixo) {
		super(nome);
		this.valorGrauAlto = valorGrauAlto;
		this.valorGrauMedio = valorGrauMedio;
		this.valorGrauBaixo = valorGrauBaixo;
	}

	public double getValorGrauAlto() {
		return valorGrauAlto;
	}

	public double getValorGrauMedio() {
		return valorGrauMedio;
	}

	public double getValorGrauBaixo() {
		return valorGrauBaixo;
	}

	@Override
	public double getValorDaResposta(Resposta resposta) {
		switch (resposta) {
		case ALTO:
			return getValorGrauAlto();
		case MEDIO:
			return getValorGrauMedio();
		case BAIXO:
			return getValorGrauBaixo();
		default:
			return 0.0;
		}

	}

	@Override
	public String toString() {
		return "Pergunta: [" + super.getNome() + "] \nValores: [ALTO=" + valorGrauAlto + ", MEDIO=" + valorGrauMedio + ", BAIXO="
		        + valorGrauBaixo + "]";
	}

}
