package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.extractors.Extractable;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.Cidade;
import br.com.estatistica.modelos.Endereco;
import br.com.estatistica.modelos.TipoLogradouro;

public class EnderecoExtractor extends Extractable<Endereco> {

	private BairroDAO dao;
	private TipoLogradouroDAO tlDao;
	private CidadeDAO cDao;

	@Override
	protected Endereco extractModel(ResultSet rs, Connection con) throws SQLException {
		Endereco endereco = new Endereco();

		endereco.setId(rs.getInt("id_endereco"));
		endereco.setCep(rs.getString("cep"));
		endereco.setDescricao(rs.getString("descricao"));
		endereco.setLogradouro(rs.getString("logradouro"));
		endereco.setNumero(rs.getString("numero"));

		endereco.setCidade(this.extractCidade(rs.getInt("id_cidade"), con));
		endereco.setBairro(this.extractBairro(rs.getInt("id_bairro"), con));
		endereco.setTipoLogradouro(this.extractLogradouro(rs.getInt("id_tipo_logradouro"), con));

		return endereco;
	}

	/**
	 * @param int1
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	private Cidade extractCidade(int int1, Connection con) throws SQLException {

		this.cDao = new CidadeDAO(con);
		
		return this.cDao.get(int1);
	}

	/**
	 * @param idTipoLogradouro
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	private TipoLogradouro extractLogradouro(int idTipoLogradouro, Connection con) throws SQLException {
		this.tlDao = new TipoLogradouroDAO(con);

		return this.tlDao.get(idTipoLogradouro);
	}

	private Bairro extractBairro(Integer idBairro, Connection con) throws SQLException {
		this.dao = new BairroDAO(con);
		return this.dao.get(idBairro);
	}

}
