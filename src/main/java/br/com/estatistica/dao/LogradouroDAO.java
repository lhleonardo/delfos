package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.LogradouroExtractor;
import br.com.estatistica.modelos.Logradouro;

/**
 * @author Leonardo Braz
 *
 */
public class LogradouroDAO extends GenericDAO<Logradouro> {

	private static final LogradouroExtractor EXTRACTOR = new LogradouroExtractor();
	private static final String SQL_INSERT = "INSERT INTO Tipo_logradouro VALUES (null, ?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Tipo_logradouro SET nome = ?, descricao = ?, sigla = ? WHERE id_tipo_logradouro = ?";
	private static final String SQL_DELETE = "DELETE FROM Tipo_logradouro WHERE id_tipo_logradouro = ?";
	private static final String SQL_SELECT = "SELECT * FROM Tipo_logradouro";
	private static final String SQL_SELECT_MULTIPLE_PARAMETERS = "SELECT * FROM TipoLogradouro WHERE nome LIKE ? OR sigla LIKE ? OR id_tipo_logradouro = ?";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM Tipo_logradouro WHERE id_tipo_logradouro = ?";
	private static final String SQL_SELECT_BY_NOME = "SELECT * FROM Tipo_logradouro WHERE nome LIKE ?";

	public LogradouroDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(Logradouro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getSigla());
			pst.executeQuery();

			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(Logradouro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getSigla());
			pst.setInt(4, model.getId());
			pst.executeQuery();

			return model.getId();
		}
	}

	@Override
	public boolean delete(Logradouro model) throws SQLException {
		if (this.get(model.getId()) != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());
				pst.executeUpdate();
			}
			return this.get(model.getId()) == null;
		} else {
			throw new NullPointerException("O registro não existe no banco de dados.");
		}
	}

	@Override
	public List<Logradouro> getAll() throws SQLException {
		List<Logradouro> logradouros = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {

			logradouros = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return logradouros;
	}

	@Override
	public List<Logradouro> get(Logradouro model) throws SQLException {
		List<Logradouro> logradouros = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_MULTIPLE_PARAMETERS)) {
			pst.setString(1, "%" + model.getNome() + "%");
			pst.setString(2, "%" + model.getSigla() + "%");
			pst.setInt(3, model.getId());

			logradouros = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return logradouros;
	}

	@Override
	public Logradouro get(Integer idModel) throws SQLException {

		Logradouro logradouro = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);

			logradouro = EXTRACTOR.extract(pst.executeQuery(), null);
		}

		return logradouro;
	}

	@Override
	public List<Logradouro> get(String value) throws SQLException {
		List<Logradouro> logradouros = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%" + value + "%");

			logradouros = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return logradouros;
	}

	@Override
	public boolean isExist(Logradouro model) throws SQLException {

		return this.get(model) != null;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}

}
