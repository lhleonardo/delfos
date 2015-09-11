package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pergunta;

public class PerguntaExtractor extends Extractable<Pergunta> {
	
	public Pergunta extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}
	;
	//arrumar questionario, tipo pergunta, tipo campo
	@Override
	protected Pergunta extractModel(ResultSet rs, Connection con) throws SQLException{
	Pergunta pergunta = new Pergunta();
	pergunta.setId(rs.getInt("id_usuario"));
	pergunta.setDescricao(rs.getString("Descricao"));


	
return pergunta;
}

	}


