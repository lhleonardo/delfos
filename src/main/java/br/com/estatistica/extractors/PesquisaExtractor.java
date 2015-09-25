package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pesquisa;

public class PesquisaExtractor extends Extractable<Pesquisa> {

	public Pesquisa extract(ResultSet rs, Connection con) throws SQLException {
		System.out.println("PesquisaExtractor.extract()");
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			System.out.println("PesquisaExtractor.extract(return null)");
			return null;
	}
	
	@Override
	protected Pesquisa extractModel(ResultSet rs, Connection con)
			throws SQLException {
		Pesquisa pesq = new Pesquisa();
		pesq.setId(rs.getInt("id_pesquisa"));
		pesq.setDescricao(rs.getString("descricao"));
		pesq.setData(rs.getDate("data"));
		pesq.setLimiteDeEspecialistas(rs.getInt("limite_de_especialistas"));

		return pesq;
	}

}
