package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Cidade;

public class CidadeExtractor extends Extractable<Cidade> {

	@Override
	protected Cidade extractModel(ResultSet rs, Connection con) throws SQLException {
		return null;
	}

}
