package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.TipoLogradouroExtractor;
import br.com.estatistica.modelos.TipoLogradouro;

public class TipoLogradouroDAO extends GenericDAO<TipoLogradouro> {

	private static final TipoLogradouroExtractor EXTRACTOR = new TipoLogradouroExtractor();
	
	private static final String SQL_SELECT = "SELECT * FROM Tipo_logradouro";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_tipo_logradouro = ?";

	public TipoLogradouroDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(TipoLogradouro model) throws SQLException {
		// TODO implementar
		return null;
	}

	@Override
	protected Integer update(TipoLogradouro model) throws SQLException {
		// TODO implementar

		return null;
	}

	@Override
	public boolean delete(TipoLogradouro model) throws SQLException {
		// TODO implementar

		return false;
	}

	@Override
	public List<TipoLogradouro> getAll() throws SQLException {
		List<TipoLogradouro> tipos = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			tipos = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return tipos;
	}

	@Override
	public TipoLogradouro get(TipoLogradouro model) throws SQLException {
		// TODO implementar

		return null;
	}

	@Override
	public TipoLogradouro get(Integer idModel) throws SQLException {

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			return EXTRACTOR.extract(pst.executeQuery(), null);
		}

	}

	@Override
	public List<TipoLogradouro> get(String value) throws SQLException {
		// TODO implementar
		return null;
	}

	@Override
	public boolean isExist(TipoLogradouro model) throws SQLException {
		// TODO implementar
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO implementar
		return false;
	}

}
