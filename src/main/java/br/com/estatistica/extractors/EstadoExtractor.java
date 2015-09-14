package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Estado;

public class EstadoExtractor extends Extractable<Estado> {

	@Override
	protected Estado extractModel(ResultSet rs, Connection con) throws SQLException {

		Estado estado = new Estado();

		estado.setId(rs.getInt("id_estado"));
		estado.setNome(rs.getString("nome"));
		estado.setDescricao(rs.getString("descricao"));
		estado.setUf(rs.getString("uf"));
		estado.setCodIbge(rs.getString("cod_ibge"));

		return estado;
	}

}
