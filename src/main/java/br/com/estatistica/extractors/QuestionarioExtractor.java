package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.Questionario;

public class QuestionarioExtractor extends Extractable<Questionario> {

	@Override
	protected Questionario extractModel(ResultSet rs, Connection con)
			throws SQLException {
		Questionario quest = new Questionario();
		quest.setId(rs.getInt("id_questionario"));
		quest.setNome(rs.getString("nome"));
		quest.setDescricao(rs.getString("descricao"));

		return quest;
	}

}
