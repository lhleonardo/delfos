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

public class TipoCampoDAO extends GenericDAO<TipoCampo> {

	private static final String SQL_SELECT = "SELECT * FROM TipoCampo";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO TipoCampo(id_TipoCampo, descricao,nome) VALUES(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE TipoCampo SET descricao = ?, nome = ?, WHERE id_tipopergunta =?";
	private static final String SQL_DELETE = "DELETE FROM TipoCampoWHERE id_usuario = ?";

	public TipoCampoDAO(Connection connection) {
		super(connection);

	}

	@Override
	protected Integer insert(TipoCampo model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getDescricao());

			pst.executeUpdate();
			return null;
		}
	}

	@Override
	protected Integer update(TipoCampo model) throws SQLException {

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.executeUpdate();
		}
		return null;
	}

	@Override
	public boolean delete(TipoCampo model) throws SQLException {
		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());
				int linhasAfetadas = pst.executeUpdate();
				if (linhasAfetadas > 0) {
					JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
				}
			}
		}
		return false;

	}

	@Override
	public List<TipoCampo> getAll() throws SQLException {
		List<TipoCampo> tiposcampos = new ArrayList<TipoCampo>();
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			tiposcampos.addAll(new TipoCampoExtractor().extractAll(resultSet, super.getConnection()));

		}

		return tiposcampos;
	}

	@Override
	public TipoCampo get(TipoCampo model) throws SQLException {
		TipoCampo tipocampo = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getDescricao());

			ResultSet resultSet = pst.executeQuery();

			tipocampo = new TipoCampoExtractor().extract(resultSet, super.getConnection());

		}

		return tipocampo;
	}

	@Override
	public TipoCampo get(Integer idModel) throws SQLException {
		TipoCampo tipocampo = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			tipocampo = new TipoCampoExtractor().extract(rs, super.getConnection());

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