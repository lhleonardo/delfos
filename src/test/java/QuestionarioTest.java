import br.com.estatistica.modelo.calculo.PerguntaEficiencia;
import br.com.estatistica.modelo.calculo.Questionario;
import br.com.estatistica.modelo.calculo.Resposta;

public class QuestionarioTest {

	public static void main(String[] args) {
		Questionario questionario = criaQuestionarioComSeisPerguntas();

		double resultado = questionario.calculaCoeficienteDeArgumentacao();

		questionario.imprimeQuestoes();

		System.out.println("Coeficiente de Argumentação do questionário: " + resultado);
	}

	private static Questionario criaQuestionarioComSeisPerguntas() {
		// cria as perguntas e define os valores de grau alto, medio e baixo
		// respectivamente
		PerguntaEficiencia p1 = new PerguntaEficiencia("Analises teórico realizado por você", 0.3, 0.2, 0.1);
		PerguntaEficiencia p2 = new PerguntaEficiencia("Sua experiência", 0.5, 0.4, 0.2);
		PerguntaEficiencia p3 = new PerguntaEficiencia("Conhecimento de trabalhos referenciados por autores nacionais.", 0.05, 0.05, 0.05);
		PerguntaEficiencia p4 = new PerguntaEficiencia("Conhecimento de trabalhos referenciados por autores estrangeiros.", 0.05, 0.05,
		        0.05);
		PerguntaEficiencia p5 = new PerguntaEficiencia("Seu próprio conhecimento acerca dos temas.", 0.05, 0.05, 0.05);
		PerguntaEficiencia p6 = new PerguntaEficiencia("Sua intuição", 0.05, 0.05, 0.05);

		// relaciona as perguntas com o questionário, onde o mesmo pode conter várias
		// questões
		Questionario questionario = new Questionario();
		questionario.responder(p1, Resposta.ALTO);
		questionario.responder(p2, Resposta.BAIXO);
		questionario.responder(p3, Resposta.MEDIO);
		questionario.responder(p4, Resposta.BAIXO);
		questionario.responder(p5, Resposta.ALTO);
		questionario.responder(p6, Resposta.BAIXO);
		return questionario;
	}

}
