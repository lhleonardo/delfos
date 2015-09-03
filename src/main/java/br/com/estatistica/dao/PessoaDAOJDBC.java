package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelo.cadastro.Pessoa;

public class PessoaDAOJDBC implements DAO<Pessoa> {

	private Connection con;

	public PessoaDAOJDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void save(Pessoa modelo) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Pessoa modelo) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Pessoa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> getByNome(String nome) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa getById(Integer id) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		if (this.con.isClosed()) {
			this.con.close();
			this.con = null;
			System.gc();
		}
	}
}
