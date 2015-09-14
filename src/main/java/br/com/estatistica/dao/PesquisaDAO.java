package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Pesquisa;

public class PesquisaDAO extends GenericDAO<Pesquisa> {
	
	private static final String SQL_SELECT = "SELECT * FROM Pesquisa";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_SELECT_BY_LOGIN = SQL_SELECT + " WHERE login = ?";
	private static final String SQL_SELECT_BY_LOGIN_AND_SENHA = SQL_SELECT_BY_LOGIN + " AND senha = ?";
	private static final String SQL_INSERT = "INSERT INTO Usuario(login,senha,descricao,id_perfil_usuario) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Usuario SET login = ?, senha = ?, descricao = ?, id_perfil_usuario = ? WHERE id_usuario =?";
	private static final String SQL_DELETE = "DELETE FROM Usuario WHERE id_usuario = ?";

	public PesquisaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Integer insert(Pesquisa model) throws SQLException {
		return null;
		
	}

	@Override
	protected Integer update(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pesquisa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pesquisa get(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pesquisa get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isExist(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pesquisa> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}