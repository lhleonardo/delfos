package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.dao.QuestionarioDAO;
import br.com.estatistica.modelos.Pergunta;

public class PerguntaExtractor extends Extractable<Pergunta> {
	
	@Override
	public Pergunta extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return this.extractModel(rs, con);
		} else {
			return null;
		}
	};
	
	@Override
	protected Pergunta extractModel(ResultSet rs, Connection con) throws SQLException {
		Pergunta pergunta = new Pergunta();
		QuestionarioDAO q1 = new QuestionarioDAO(con);
		pergunta.setId(rs.getInt("id_pergunta"));
		pergunta.setDescricao(rs.getString("Descricao"));
		pergunta.setNome(rs.getString("Nome"));
		// TODO Erro na lógica... (lhleonardo)
		pergunta.setQuestionario(rs.getInt(pergunta.getQuestionario().getId()));
		pergunta.setObservacao(rs.getString("obs"));
		pergunta.setTipo_campo(rs.getInt(1));
		pergunta.setTipoPergunta.getInt(rs.getInt(1));
		
		return pergunta;
	}
	
	@Override
	public List<Pergunta> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		
		while (rs.next() && con != null) {
			perguntas.add(this.extractModel(rs, con));
		}
		
		return perguntas;
	}
	
}
