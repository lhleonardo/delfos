package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Logradouro;

public class TipoLogradouroExtractor extends Extractable<Logradouro> {
	
	@Override
	protected Logradouro extractModel(ResultSet rs, Connection con) throws SQLException {
		Logradouro logradouro = new Logradouro();
		logradouro.setId(rs.getInt("id_tipo_logradouro"));
		logradouro.setNome(rs.getString("nome"));
		logradouro.setSigla(rs.getString("sigla"));
		logradouro.setDescricao(rs.getString("descricao"));
		return logradouro;
	}
	
}
