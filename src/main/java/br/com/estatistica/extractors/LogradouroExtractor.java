package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Logradouro;

/**
 * @author Leonardo Braz
 *
 */
public class LogradouroExtractor extends Extractable<Logradouro> {

	@Override
	protected Logradouro extractModel(ResultSet rs, Connection con) throws SQLException {
		Logradouro logradouro = new Logradouro(rs.getString("nome"), rs.getString("sigla"));
		logradouro.setId(rs.getInt("id_tipo_logradouro"));
		logradouro.setDescricao(rs.getString("descricao"));
		return logradouro;
	}

}
