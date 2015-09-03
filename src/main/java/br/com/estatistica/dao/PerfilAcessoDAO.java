package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelo.cadastro.PerfilAcesso;

public class PerfilAcessoDAO implements DAO<PerfilAcesso> {

	private Connection con;

	public PerfilAcessoDAO(Connection con) {
		this.con = con;
	}

	public PerfilAcessoDAO() {
		this.con = null;
	}

	@Override
	public void save(PerfilAcesso modelo) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(PerfilAcesso modelo) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PerfilAcesso> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PerfilAcesso> getByNome(String nome) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PerfilAcesso getById(Integer id) throws SQLException, NullPointerException {
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
		if (!this.con.isClosed()) {
			this.con.close();
			this.con = null;
			System.gc();
		}
	}

}
