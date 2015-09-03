package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelo.cadastro.Usuario;

public class UsuarioDAO implements DAO<Usuario> {

	private static final String SQL_INSERT = "insert into usuario(login, descricao, id_pessoa, id_perfil_acesso) values (?,?,?,?)";
	private Connection con;

	@Override
	public void save(Usuario modelo) throws SQLException, NullPointerException {
		if (modelo.getId() == 0) {
			this.insert(modelo);
		} else {
			this.update(modelo);
		}
	}

	private void update(Usuario modelo) {

	}

	private void insert(Usuario modelo) throws SQLException {
		try (PreparedStatement pst = con.prepareStatement(SQL_INSERT)) {
			pst.setString(1, modelo.getLogin());
			pst.setString(2, modelo.getDescricao());
			pst.setInt(3, modelo.getPessoa().getId());
			pst.setInt(4, modelo.getPerfilAcesso().getId());
			pst.executeUpdate();
		}

	}

	@Override
	public void remove(Usuario modelo) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getByNome(String nome) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Integer id) throws SQLException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (!this.con.isClosed()) {
			this.con.close();
			this.con = null;
		}
		System.gc();
	}

}
