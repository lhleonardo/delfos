package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelos.Tipo_Pergunta;

public class TipoPerguntaExtractor extends Extractable<Tipo_Pergunta>{
	
	public Tipo_Pergunta extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}

	@Override
	protected Tipo_Pergunta extractModel(ResultSet rs, Connection con) throws SQLException{
	Tipo_Pergunta tipopergunta = new Tipo_Pergunta();
	tipopergunta.setId(rs.getInt("id_tipopergunta"));
	tipopergunta.setDescricao(rs.getString("Descricao"));
	tipopergunta.setNome(rs.getString("nome"));

	return tipopergunta;
	
}

public List<Tipo_Pergunta> extractAll(ResultSet rs, Connection con) throws SQLException {
	List<Tipo_Pergunta> tipoperguntas = new ArrayList<Tipo_Pergunta>();

	while (rs.next() && con != null) {
		tipoperguntas.add(extractModel(rs, con));
	}

	return tipoperguntas;
}


}

