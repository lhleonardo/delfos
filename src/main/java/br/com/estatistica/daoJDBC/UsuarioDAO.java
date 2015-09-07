package br.com.estatistica.daoJDBC;

import java.sql.Connection;
import java.util.List;

import br.com.estatistica.modelo.cadastro.Usuario;

public class UsuarioDAO extends GenericDAOJDBC<Usuario> {

	public UsuarioDAO(Connection connection) {
		super(connection);
	}

	// @Override
	// public void save(Usuario model) {
	// if (model.getId() == null) {
	// this.insert(Usuario model);
	// } else {
	// this.update(Usuario model);
	// }
	// }

	@Override
	public void delete(Usuario model) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario get(Usuario model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Usuario model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Usuario model) {
		// TODO Auto-generated method stub

	}

}
