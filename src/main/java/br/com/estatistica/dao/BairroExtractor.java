package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.extractors.Extractable;
import br.com.estatistica.modelos.Bairro;

public class BairroExtractor extends Extractable<Bairro> {

	@Override
	protected Bairro extractModel(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			Bairro bairro = new Bairro();
			bairro.setId(rs.getInt("id_bairro"));
			bairro.setNome(rs.getString("nome"));
			bairro.setDescricao(rs.getString("descricao"));
			return bairro;
		} else {
			return null;
		}
	}

}
