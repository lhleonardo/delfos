package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.estatistica.modelos.TemaQuestionario;

public class TemaQuestionarioExtractor extends Extractable<TemaQuestionario> {

	@Override
	protected TemaQuestionario extractModel(ResultSet rs, Connection con)
			throws SQLException {
		TemaQuestionario tema = new TemaQuestionario();
		tema.setId(rs.getInt("id_tema_questionario"));
		tema.setNome(rs.getString("nome"));
		tema.setDescricao(rs.getString("descricao"));
		return tema;
	}

}
