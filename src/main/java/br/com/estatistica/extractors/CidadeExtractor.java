package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.modelos.Cidade;

public class CidadeExtractor extends Extractable<Cidade> {
	
	private EstadoDAO eDao;

	@Override
	protected Cidade extractModel(ResultSet rs, Connection con) throws SQLException {
		
		Cidade cidade = new Cidade();
		cidade.setId(rs.getInt("id_cidade"));
		cidade.setNome(rs.getString("nome"));
		cidade.setDescricao(rs.getString("descricao"));
		cidade.setCodIbge(rs.getString("cod_ibge"));
		
		this.eDao = new EstadoDAO(con);
		cidade.setEstado(this.eDao.get(rs.getInt("id_estado")));
		
		return cidade;
	}
	
}
