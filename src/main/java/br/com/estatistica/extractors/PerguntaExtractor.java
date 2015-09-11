package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.dao.PerfilAcessoDAO;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.modelos.Usuario;

public class PerguntaExtractor extends Extractable<Pergunta> {
	
	public Pergunta extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			return extractModel(rs, con);
		} else
			return null;
	}
	//arrumar questionario, tipo pergunta, tipo campo
	@Override
	protected Pergunta extractModel(ResultSet rs, Connection con){
	Pergunta pergunta = new Pergunta();
	pergunta.setId(rs.getInt("id_usuario"));
	try {
		pergunta.setDescricao(rs.getString("Descricao"));
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	

	
return pergunta;
}

	}


