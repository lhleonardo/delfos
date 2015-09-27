package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pesquisa;

public class PesquisaExtractor extends Extractable<Pesquisa> {
	
	@Override
	protected Pesquisa extractModel(ResultSet rs, Connection con) throws SQLException {
		Pesquisa pesq = new Pesquisa();
		pesq.setId(rs.getInt("id_pesquisa"));
		pesq.setNome(rs.getString("nome"));
		pesq.setDescricao(rs.getString("descricao"));
		pesq.setData(rs.getDate("data"));
		pesq.setLimiteDeEspecialistas(rs.getInt("limite_de_especialistas"));

		return pesq;
	}

}
