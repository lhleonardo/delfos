package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.extractors.Extractable;
import br.com.estatistica.modelos.Bairro;

public class BairroExtractor extends Extractable<Bairro> {

	@Override
	protected Bairro extractModel(ResultSet rs, Connection con) throws SQLException {

		return null;
	}

}
