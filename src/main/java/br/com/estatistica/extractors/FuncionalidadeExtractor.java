package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelos.Funcionalidade;

public class FuncionalidadeExtractor implements Extractable<Funcionalidade> {

	@Override
	public Funcionalidade extract(ResultSet rs, Connection con) throws SQLException {
		Funcionalidade funcionalidade = new Funcionalidade();

		if (rs.next()) {
			funcionalidade.setId(rs.getInt("id_funcionalidade"));
			funcionalidade.setNome(rs.getString("nome"));
			funcionalidade.setDescricao(rs.getString("descricao"));
			funcionalidade.setChave(rs.getString("chave"));

			return funcionalidade;
		} else {
			return null;
		}

	}

	@Override
	public List<Funcionalidade> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();

		while (rs.next()) {
			Funcionalidade funcionalidade = this.extract(rs, null);
			if (funcionalidade != null) {
				funcionalidades.add(funcionalidade);

			}
		}

		return funcionalidades;
	}

}
