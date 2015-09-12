package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.estatistica.dao.FuncionalidadeDAO;
import br.com.estatistica.modelos.Funcionalidade;

public class PermissoesAcessoExtractor extends Extractable<Map<Funcionalidade, Boolean>> {

	public Map<Funcionalidade, Boolean> extract(ResultSet resultSet, Connection con) throws SQLException {
		Map<Funcionalidade, Boolean> extracted = new HashMap<Funcionalidade, Boolean>();

		System.out.println("PermissoesAcessoExtractor.extract()");
		try (FuncionalidadeDAO fDao = new FuncionalidadeDAO(con)) {

			System.out.println("PermissoesAcessoExtractor.extract(vai entrar no while)");
			while (resultSet.next()) {
				System.out.println("PermissoesAcessoExtractor.extract(entrou no while)");
				Funcionalidade func = fDao.get(resultSet.getInt("id_funcionalidade"));
				extracted.put(func, resultSet.getBoolean("acesso"));
			}

		}

		return extracted;
	}

	@Override
	public List<Map<Funcionalidade, Boolean>> extractAll(ResultSet rs, Connection con) {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Override
	protected Map<Funcionalidade, Boolean> extractModel(ResultSet rs, Connection con) throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

}
