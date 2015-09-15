package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estatistica.extractors.Extractable;
import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.modelos.Endereco;

public class EnderecoExtractor extends Extractable<Endereco> {

	@Override
	protected Endereco extractModel(ResultSet rs, Connection con) throws SQLException {
		Endereco endereco = new Endereco();
		endereco.setId(rs.getInt("id_endereco"));
		endereco.setCep(rs.getString("cep"));
		endereco.setDescricao(rs.getString("descricao"));
		endereco.setLogradouro(rs.getString("logradouro"));
		endereco.setNumero(rs.getString("numero"));

		endereco.setBairro(this.extractBairro(rs.getInt("id_bairro"), con));

		// endereco.setTipoLogradouro(tipoLogradouro);
		return null;
	}

	private Bairro extractBairro(Integer idBairro, Connection con) throws SQLException {
		if (idBairro > 0) {
			try (BairroDAO dao = new BairroDAO(con)) {
				return dao.get(idBairro);
			}
		} else {
			return null;
		}
	}

}
