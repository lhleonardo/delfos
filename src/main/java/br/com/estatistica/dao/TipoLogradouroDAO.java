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
	private static final String SQL_INSERT = "INSERT INTO Tipo_logradouro(nome,descricao) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE Tipo_logradouro SET nome = ?, descricao = ? WHERE id_tipo_logradouro = ?;";
	private static final String SQL_DELETE = "DELETE FROM Tipo_logradouro WHERE id_tipo_logradouro = ?";
	private static final String SQL_SELECT = "SELECT * FROM Tipo_logradouro";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT + " WHERE nome LIKE ? OR descricao LIKE ?;";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_tipo_logradouro = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?;";

	public TipoLogradouroDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(TipoLogradouro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();

			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(TipoLogradouro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getId());
			pst.executeUpdate();

			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(TipoLogradouro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();

			return super.confereExclusao(model.getId());

		}
	}

	@Override
	public List<TipoLogradouro> getAll() throws SQLException {
		List<TipoLogradouro> logradouros = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			logradouros = new ArrayList<TipoLogradouro>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return logradouros;
	}

	@Override
	public TipoLogradouro get(TipoLogradouro model) throws SQLException {
		TipoLogradouro logradouro = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());

			logradouro = EXTRACTOR.extract(pst.executeQuery(), null);
		}

		return logradouro;
	}

	@Override
	public TipoLogradouro get(Integer idModel) throws SQLException {
		TipoLogradouro logradouro = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);

			logradouro = EXTRACTOR.extract(pst.executeQuery(), null);
		}
		return logradouro;
	}

	@Override
	public List<TipoLogradouro> get(String value) throws SQLException {
		List<TipoLogradouro> logradouros = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%" + value + "%");
			logradouros = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return logradouros;
	}

	@Override
	public boolean isExist(TipoLogradouro model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}

}
