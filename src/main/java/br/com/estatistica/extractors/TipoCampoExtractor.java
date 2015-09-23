package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.estatistica.modelos.Tipo_campo;

public class TipoCampoExtractor extends Extractable<Tipo_campo> {
	
	public Tipo_campo extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}
//não sei o erro do null- arrumar
	@Override
	protected Tipo_campo extractModel(ResultSet rs, Connection con) throws SQLException{
		Tipo_campo tipocampo = new Tipo_campo(null);
		tipocampo.setId(rs.getInt("id_usuario"));
		tipocampo.setDescricao(rs.getString("Descricao"));


		
	return tipocampo;
	}
	;
	public List<Tipo_campo> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<Tipo_campo> tiposcampos = new ArrayList<Tipo_campo>();

		while (rs.next() && con != null) {
			tiposcampos.add(extractModel(rs, con));
		}

		return tiposcampos;
	}


	}


