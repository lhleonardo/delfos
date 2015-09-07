package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.extractors.UsuarioExtractor;
import br.com.estatistica.modelos.PerfilAcesso;
import br.com.estatistica.modelos.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final String SQL_SELECT = "SELECT * FROM Usuario";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_SELECT_BY_LOGIN = SQL_SELECT + " WHERE login = ?";
	private static final String SQL_SELECT_BY_LOGIN_AND_SENHA = SQL_SELECT_BY_LOGIN + " AND senha = ?";
	private static final String SQL_INSERT = "INSERT INTO Usuario(login,senha,descricao,id_perfil_usuario) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Usuario SET login = ?, senha = ?, descricao = ?, id_perfil_usuario = ? WHERE id_usuario =?";
	private static final String SQL_DELETE = "DELETE FROM Usuario WHERE id_usuario = ?";

	public UsuarioDAO(Connection connection) {
		super(connection);
	}

	@Override
	public void delete(Usuario model) throws SQLException {
		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());
				int linhasAfetadas = pst.executeUpdate();
				if (linhasAfetadas > 0) {
					JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
				}
			}
		}
	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			usuarios.addAll(new UsuarioExtractor().extractAll(resultSet, super.getConnection()));

		}

		return usuarios;
	}

	@Override
	public Usuario get(Usuario model) throws SQLException {
		Usuario usuario = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setString(1, model.getLogin());
			pst.setString(2, model.getSenha());
			ResultSet resultSet = pst.executeQuery();

			usuario = new UsuarioExtractor().extract(resultSet, super.getConnection());

		}

		return usuario;
	}

	public boolean autentica(String login, String senha) throws SQLException {

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_LOGIN_AND_SENHA)) {
			pst.setString(1, login);
			pst.setString(2, senha);
			ResultSet resultSet = pst.executeQuery();

			return resultSet.next();

		}

	}

	public boolean isExist(String login) throws SQLException {
		return this.get(login) != null;
	}

	public Usuario get(String login) throws SQLException {
		Usuario usuario = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_LOGIN)) {
			pst.setString(1, login);
			ResultSet rs = pst.executeQuery();

			usuario = new UsuarioExtractor().extract(rs, super.getConnection());

		}

		return usuario;
	}

	@Override
	public boolean isExist(Usuario model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public void save(Usuario model) throws SQLException {
		model.validate();
		if (model.getId() == null) {
			this.insert(model);
		} else {
			this.update(model);
		}

		JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
	}

	protected void update(Usuario model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getLogin());
			pst.setString(2, model.getSenha());
			pst.setString(3, model.getDescricao());
			pst.setInt(4, validaPerfilTransient(model));
			pst.setInt(5, model.getId());
			pst.executeUpdate();
		}

	}

	protected void insert(Usuario model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT)) {
			pst.setString(1, model.getLogin());
			pst.setString(2, model.getSenha());
			pst.setString(3, model.getDescricao());
			pst.setInt(4, validaPerfilTransient(model));
			pst.executeUpdate();
		}
	}

	private Integer validaPerfilTransient(Usuario model) throws SQLException {
		if (model.getPerfilAcesso().getId() == null) {
			try (PerfilAcessoDAO daoPerfil = new PerfilAcessoDAO(super.getConnection())) {
				daoPerfil.save(model.getPerfilAcesso());
				PerfilAcesso acesso = daoPerfil.get(model.getPerfilAcesso());
				return acesso.getId();
			}
		} else {
			return model.getPerfilAcesso().getId();
		}
	}

	@Override
	public Usuario get(Integer idModel) throws SQLException {
		Usuario usuario = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			usuario = new UsuarioExtractor().extract(rs, super.getConnection());

		}

		return usuario;
	}
}
