package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.extractors.TipoCampoExtractor;
import br.com.estatistica.modelos.TipoCampo;

public class Tipo_campoDAO extends GenericDAO<TipoCampo> {

	/**
	 * 
	 */
	private static final TipoCampoExtractor EXTRACTOR = new TipoCampoExtractor();
	private static final String SQL_SELECT = "SELECT * FROM Tipo_campo";
	private static final String SQL_SELECT_WHERE = SQL_SELECT
			+ " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT
			+ " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Tipo_campo(descricao,nome) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE TipoCampo SET descricao = ?, nome = ?, WHERE id_Tipo_campo =?";
	private static final String SQL_DELETE = "DELETE FROM Tipo_campo WHERE id_tipo_campo = ?";

	public Tipo_campoDAO(Connection connection) {
		super(connection);

	}

	@Override
	protected Integer insert(TipoCampo model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());

			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(TipoCampo model) throws SQLException {

		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.executeUpdate();

			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(TipoCampo model) throws SQLException {
		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection()
					.prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());
				int linhasAfetadas = pst.executeUpdate();
				if (linhasAfetadas > 0) {
					JOptionPane
							.showMessageDialog(null, "Excluído com sucesso.");
				}
			}
		}
		return false;

	}

	@Override
	public List<TipoCampo> getAll() throws SQLException {
		List<TipoCampo> tiposcampos = new ArrayList<TipoCampo>();
		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			tiposcampos.addAll(EXTRACTOR.extractAll(resultSet,
					super.getConnection()));

		}

		return tiposcampos;
	}

	@Override
	public List<TipoCampo> get(TipoCampo model) throws SQLException {
		List<TipoCampo> tipocampo = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getNome());
			pst.setString(2, model.getDescricao());

			ResultSet resultSet = pst.executeQuery();

			tipocampo = new ArrayList<>(EXTRACTOR.extractAll(resultSet,
					super.getConnection()));

		}

		return tipocampo;
	}

	@Override
	public TipoCampo get(Integer idModel) throws SQLException {
		TipoCampo tipocampo = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			tipocampo = EXTRACTOR.extract(rs, super.getConnection());

		}

		return tipocampo;

	}

	@Override
	public List<TipoCampo> get(String value) throws SQLException {
		return null;
	}

	@Override
	public boolean isExist(TipoCampo model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}

}