package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.dao.QuestionarioDAO;
import br.com.estatistica.dao.TemaQuestionarioDAO;
import br.com.estatistica.dao.Tipo_PerguntaDAO;
import br.com.estatistica.dao.Tipo_campoDAO;
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
		Tipo_campoDAO tcDAO = new Tipo_campoDAO(con);
		Tipo_PerguntaDAO tpDAO = new Tipo_PerguntaDAO (con);
		
		pergunta.setId(rs.getInt("id_pergunta"));
		pergunta.setDescricao(rs.getString("Descricao"));
		pergunta.setNome(rs.getString("Nome"));
	    pergunta.setQuestionario(q1.get(pergunta.getId()));
	    pergunta.setObservacao(rs.getString("obs"));
	    pergunta.setTipoCampo(tcDAO.get(pergunta.getId()));
	    pergunta.setTipoPergunta(tpDAO.get(pergunta.getId()));
		
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
