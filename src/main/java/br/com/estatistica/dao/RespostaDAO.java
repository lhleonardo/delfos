package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Identificator;

public class RespostaDAO extends GenericDAO {

	public RespostaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Integer insert(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer update(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identificator get(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identificator get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
