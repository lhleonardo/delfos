package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.extractors.TipoCampoExtractor;
import br.com.estatistica.modelos.Tipo_campo;

public class Tipo_campoDAO extends GenericDAO<Tipo_campo> {

	private static final String SQL_SELECT = "SELECT * FROM Tipo_campo";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Tipo_campo(descricao,nome) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE TipoCampo SET descricao = ?, nome = ?, WHERE id_Tipo_campo =?";
	private static final String SQL_DELETE = "DELETE FROM Tipo_campo WHERE id_tipo_campo = ?";

	public Tipo_campoDAO(Connection connection) {
		super(connection);

	}

	@Override
	protected Integer insert(Tipo_campo model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT , PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());

			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(Tipo_campo model) throws SQLException {

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.executeUpdate();
		
		return super.getGeneratedKeys(pst.getGeneratedKeys());
	}
	}

	@Override
	public boolean delete(Tipo_campo model) throws SQLException {
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
	public List<Tipo_campo> getAll() throws SQLException {
		List<Tipo_campo> tiposcampos = new ArrayList<Tipo_campo>();
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			tiposcampos.addAll(new TipoCampoExtractor().extractAll(resultSet, super.getConnection()));

		}

		return tiposcampos;
	}

	@Override
	public Tipo_campo get(Tipo_campo model) throws SQLException {
		Tipo_campo tipocampo = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getNome());
			pst.setString(2, model.getDescricao());

			ResultSet resultSet = pst.executeQuery();

			tipocampo = new TipoCampoExtractor().extract(resultSet, super.getConnection());

		}

		return tipocampo;
	}

	@Override
	public Tipo_campo get(Integer idModel) throws SQLException {
		Tipo_campo tipocampo = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			tipocampo = new TipoCampoExtractor().extract(rs, super.getConnection());

		}

		return tipocampo;

	}

	@Override
	public List<Tipo_campo> get(String value) throws SQLException {
		return null;
	}

	@Override
	public boolean isExist(Tipo_campo model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}

}