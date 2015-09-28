/**
 * Classe PessoaExtractor.java
 *
 * @author Leonardo Braz
 */
package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.extractors.Extractable;
import br.com.estatistica.modelos.Cnpj;
import br.com.estatistica.modelos.Cpf;
import br.com.estatistica.modelos.Endereco;
import br.com.estatistica.modelos.Pessoa;

/**
 * @author Leonardo Braz
 *
 */
public class PessoaExtractor extends Extractable<Pessoa> {
	
	private EnderecoDAO eDao;
	
	/*
	 * (non-Javadoc)
	 * @see br.com.estatistica.extractors.Extractable#extractModel(java.sql.ResultSet,
	 * java.sql.Connection)
	 */
	@Override
	protected Pessoa extractModel(ResultSet rs, Connection con) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(rs.getInt("id_pessoa"));
		pessoa.setNome(rs.getString("nome"));
		pessoa.setDescricao(rs.getString("descricao"));
		pessoa.setEmail(rs.getString("email"));
		pessoa.setDataNascimento(rs.getDate("data_nascimento"));
		
		pessoa.setTipoDocumento((rs.getString("cpf").length() <= 11) ? new Cpf(rs.getString("cpf")) : new Cnpj(rs.getString("cpf")));
		pessoa.setRg(rs.getString("rg"));
		
		this.eDao = new EnderecoDAO(con);
		Endereco endereco = this.eDao.get(rs.getInt("id_endereco"));
		pessoa.setEndereco(endereco);
		
		return pessoa;
	}
}
