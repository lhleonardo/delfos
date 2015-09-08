package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Funcionalidade;

public class FuncionalidadeExtractor extends Extractable<Funcionalidade> {

	protected Funcionalidade extractModel(ResultSet rs, Connection con) throws SQLException {
		Funcionalidade funcionalidade = new Funcionalidade();
		funcionalidade.setId(rs.getInt("id_funcionalidade"));
		funcionalidade.setNome(rs.getString("nome"));
		funcionalidade.setDescricao(rs.getString("descricao"));
		funcionalidade.setChave(rs.getString("chave"));
		return funcionalidade;
	}

}
