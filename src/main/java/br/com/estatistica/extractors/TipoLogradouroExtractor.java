package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.TipoLogradouro;

public class TipoLogradouroExtractor extends Extractable<TipoLogradouro> {

	@Override
	protected TipoLogradouro extractModel(ResultSet rs, Connection con) throws SQLException {
		TipoLogradouro logradouro = new TipoLogradouro();
		logradouro.setId(rs.getInt("id_tipo_logradouro"));
		logradouro.setNome(rs.getString("nome"));
		logradouro.setDescricao(rs.getString("descricao"));

		return logradouro;
	}

}
