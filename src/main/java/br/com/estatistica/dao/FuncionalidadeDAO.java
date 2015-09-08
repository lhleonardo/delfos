package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.extractors.FuncionalidadeExtractor;
import br.com.estatistica.modelos.Funcionalidade;

public class FuncionalidadeDAO extends GenericDAO<Funcionalidade> {

	private static final String SQL_INSERT = "INSERT INTO Funcionalidade(nome, descricao) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE Funcionalidade SET nome = ?, descricao = ? WHERE id_funcionalidade = ?;";
	private static final String SQL_DELETE = "DELETE FROM Funcionalidade WHERE id_funcionalidade = ?";
	private static final String SQL_SELECT = "SELECT * FROM Funcionalidade";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_funcionalidade = ?";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT + " WHERE nome LIKE ? AND descricao LIKE ?";

	public FuncionalidadeDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected void insert(Funcionalidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();
		}
	}

	@Override
	protected void update(Funcionalidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getId());
			pst.executeUpdate();
		}
	}

	@Override
	public void delete(Funcionalidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
		}
	}

	@Override
	public List<Funcionalidade> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionalidade get(Funcionalidade model) throws SQLException {
		Funcionalidade funcionalidade = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			ResultSet resultSet = pst.executeQuery();

			funcionalidade = new FuncionalidadeExtractor().extract(resultSet, null);
		}

		return funcionalidade;
	}

	@Override
	public Funcionalidade get(Integer idModel) throws SQLException {
		Funcionalidade funcionalidade = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet resultSet = pst.executeQuery();

			funcionalidade = new FuncionalidadeExtractor().extract(resultSet, null);

		}
		return funcionalidade;
	}

	@Override
	public Funcionalidade get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Funcionalidade model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
