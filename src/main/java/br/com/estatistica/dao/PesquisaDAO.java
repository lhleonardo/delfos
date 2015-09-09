package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Identificator;

public class PesquisaDAO extends GenericDAO {

	public PesquisaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void insert(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void update(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Identificator model) throws SQLException {
		// TODO Auto-generated method stub
		
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
	public Identificator get(String value) throws SQLException {
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
