package br.com.estatistica.modelo.calculo;

import java.util.HashMap;
import java.util.Map;

public class Questionario {

	private Map<Pergunta, Resposta> questoes = new HashMap<>();

	public void responder(Pergunta pergunta, Resposta resposta) {

		if ((pergunta != null) && (resposta != null)) {
			questoes.put(pergunta, resposta);
		}

	}

	public double calculaCoeficienteDeArgumentacao() {
		double resultado = 0;

		if (verificaDependencias()) {
			for (Pergunta pergunta : questoes.keySet()) {
				resultado += pergunta.getValorDaResposta(questoes.get(pergunta));
			}
		} else {
			throw new IllegalArgumentException("Informe os valores necessários para gerar o cálculo (questões, valores, etc.)");
		}

		return resultado;
	}

	public void imprimeQuestoes() {
		for (Pergunta pergunta : questoes.keySet()) {
			System.out.println(pergunta);
			System.out.println("Resposta da questão: " + questoes.get(pergunta));
			System.out.println("Valor da questão respondida: " + pergunta.getValorDaResposta(questoes.get(pergunta)));
			System.out.println("");
		}
	}

	private boolean verificaDependencias() {
		if ((questoes.size() > 0))
			return true;

		return false;
	}

}
