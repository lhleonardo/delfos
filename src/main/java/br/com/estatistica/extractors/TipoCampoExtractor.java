package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.estatistica.modelos.TipoCampo;

public class TipoCampoExtractor extends Extractable<TipoCampo> {
	
	public TipoCampo extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}
//não sei o erro do null- arrumar
	@Override
	protected TipoCampo extractModel(ResultSet rs, Connection con) throws SQLException{
		TipoCampo tipocampo = new TipoCampo(null);
		tipocampo.setId(rs.getInt("id_usuario"));
		tipocampo.setDescricao(rs.getString("Descricao"));


		
	return tipocampo;
	}
	;
	public List<TipoCampo> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<TipoCampo> tiposcampos = new ArrayList<TipoCampo>();

		while (rs.next() && con != null) {
			tiposcampos.add(extractModel(rs, con));
		}

		return tiposcampos;
	}


	}


