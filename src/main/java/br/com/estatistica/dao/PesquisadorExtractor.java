package br.com.estatistica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.estatistica.modelo.Cpf;
import br.com.estatistica.modelo.Pesquisador;

public class PesquisadorExtractor {

	public Pesquisador extract(ResultSet rs) throws SQLException {
		int id = rs.getInt("idPesquisador");
		String nome = rs.getString("nome");
		Cpf cpf = new Cpf(rs.getString("cpf"));
		String rg = rs.getString("rg");
		Date dataNascimento = rs.getDate("dataNascimento");
		String descricao = rs.getString("descricao");

		return new Pesquisador(id, nome, cpf, rg, dataNascimento, descricao);
	}

}
