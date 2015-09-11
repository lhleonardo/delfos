package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Pesquisa;

public class PesquisaDAO extends GenericDAO<Pesquisa> {

	public PesquisaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void insert(Pesquisa model) throws SQLException {
		
		
	}

	@Override
	protected void update(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		
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
	public Pesquisa get(String value) throws SQLException {
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

}