package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Funcionalidade;

public class FuncionalidadeDAO extends GenericDAO<Funcionalidade> {

	public FuncionalidadeDAO(Connection connection) {
		super(connection);
    }

	@Override
	protected void insert(Funcionalidade model) throws SQLException {
	    // TODO Auto-generated method stub
	    
    }

	@Override
	protected void update(Funcionalidade model) throws SQLException {
	    // TODO Auto-generated method stub
	    
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
