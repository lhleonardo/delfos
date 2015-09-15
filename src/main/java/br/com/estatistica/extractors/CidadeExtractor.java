package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.modelos.Cidade;

public class CidadeExtractor extends Extractable<Cidade> {

	@Override
	protected Cidade extractModel(ResultSet rs, Connection con) throws SQLException {

		Cidade cidade = new Cidade();
		cidade.setId(rs.getInt("id_cidade"));
		cidade.setNome(rs.getString("nome"));
		cidade.setDescricao(rs.getString("descricao"));
		cidade.setCodigoIbge(rs.getString("cod_ibge"));

		try (EstadoDAO eDao = new EstadoDAO(con)) {
			cidade.setEstado(eDao.get(rs.getInt("id_estado")));
		}

		return cidade;
	}

}
