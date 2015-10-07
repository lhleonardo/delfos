package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.modelos.Resposta;

public class RespostaExtractor extends Extractable<Resposta> {
	
	@Override
	protected Resposta extractModel(ResultSet rs, Connection con) throws SQLException {
		Resposta resposta = new Resposta();
		resposta.setId(rs.getInt("id_resposta"));
		resposta.setDescricao(rs.getString("descricao"));
		resposta.setObservacao(rs.getString("observacao"));
		return resposta;
	}
}