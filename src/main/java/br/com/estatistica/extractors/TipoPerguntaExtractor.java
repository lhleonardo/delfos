package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelos.TipoPergunta;

public class TipoPerguntaExtractor extends Extractable<TipoPergunta>{
	
	public TipoPergunta extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}

	@Override
	protected TipoPergunta extractModel(ResultSet rs, Connection con) throws SQLException{
	TipoPergunta tipopergunta = new TipoPergunta();
	tipopergunta.setId(rs.getInt("id_tipopergunta"));
	tipopergunta.setDescricao(rs.getString("Descricao"));

	return tipopergunta;
	
}

public List<TipoPergunta> extractAll(ResultSet rs, Connection con) throws SQLException {
	List<TipoPergunta> tipoperguntas = new ArrayList<TipoPergunta>();

	while (rs.next() && con != null) {
		tipoperguntas.add(extractModel(rs, con));
	}

	return tipoperguntas;
}


}

