package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Questionario;

public class QuestionarioDAO extends GenericDAO<Questionario> {
	public QuestionarioDAO(Connection connection) {
		super(connection);
	}
	
	
	
	@Override
	protected Integer insert(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer update(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Questionario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questionario get(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questionario get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questionario> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
