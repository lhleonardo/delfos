package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Funcionalidade;

public class FuncionalidadeDAO extends GenericDAO<Funcionalidade> {

	private static final String SQL_INSERT = "INSERT INTO Funcionalidade(nome, descricao) VALUES (?,?);";
	private static final String SQL_UPDATE = "UPDATE Funcionalidade SET nome = ?, descricao = ? WHERE id_funcionalidade = ?;";

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
		// TODO Auto-generated method stub

	}

	@Override
	public List<Funcionalidade> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionalidade get(Funcionalidade model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcionalidade get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
