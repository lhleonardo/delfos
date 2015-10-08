package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pergunta;

public class PerguntaExtractor extends Extractable<Pergunta> {
	
	@Override
	protected Pergunta extractModel(ResultSet rs, Connection con) throws SQLException {
		Pergunta pergunta = new Pergunta();
		
		// TODO revisar
		
		// QuestionarioDAO q1 = new QuestionarioDAO(con);
		// Tipo_campoDAO tcDAO = new Tipo_campoDAO(con);
		// Tipo_PerguntaDAO tpDAO = new Tipo_PerguntaDAO(con);
		
		// pergunta.setId(rs.getInt("id_pergunta"));
		// pergunta.setDescricao(rs.getString("Descricao"));
		// pergunta.setNome(rs.getString("Nome"));
		// pergunta.setQuestionario(q1.get(pergunta.getId()));
		// pergunta.setObservacao(rs.getString("obs"));
		// pergunta.setTipoCampo(tcDAO.get(pergunta.getId()));
		// pergunta.setTipoPergunta(tpDAO.get(pergunta.getId()));
		
		return pergunta;
	}
	
}
