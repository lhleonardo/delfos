package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.extractors.PerfilAcessoExtractor;
import br.com.estatistica.modelos.PerfilAcesso;

public class PerfilAcessoDAO extends GenericDAO<PerfilAcesso> {

	private static final String SQL_SELECT = "SELECT * FROM Perfil_acesso";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT + " WHERE nome LIKE ? AND descricao LIKE ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM Perfil_acesso WHERE id_perfil_acesso = ?";
	private static final String SQL_INSERT = "INSERT INTO Perfil_acesso(nome,descricao) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Usuario SET nome = ?, descricao = ? WHERE id_perfil_acesso =?";
	private static final String SQL_DELETE = "DELETE FROM Perfil_acesso WHERE id_perfil_acesso = ?";

	public PerfilAcessoDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected void insert(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();

			ResultSet keys = pst.getGeneratedKeys();
			if (keys.next()) {

				model.setId(keys.getInt("id_perfil_acesso"));

				try (PermissoesAcessoDAO daoPermissao = new PermissoesAcessoDAO(super.getConnection())) {
					daoPermissao.save(model);
				}
			}
		}
	}

	@Override
	protected void update(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getId());
			pst.executeUpdate();

			try (PermissoesAcessoDAO daoPermissao = new PermissoesAcessoDAO(super.getConnection())) {
				daoPermissao.save(model);
			}
		}

	}

	@Override
	public void delete(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
		}
	}

	@Override
	public PerfilAcesso get(PerfilAcesso model) throws SQLException {
		PerfilAcesso perfil = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setString(1, '%' + model.getNome() + '%');
			pst.setString(2, model.getDescricao());
			ResultSet resultSet = pst.executeQuery();

			perfil = new PerfilAcessoExtractor().extract(resultSet, null);

		}
		return perfil;
	}

	@Override
	public PerfilAcesso get(Integer idModel) throws SQLException {
		PerfilAcesso perfil = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet resultSet = pst.executeQuery();

			perfil = new PerfilAcessoExtractor().extract(resultSet, null);
		}

		return perfil;
	}

	@Override
	public List<PerfilAcesso> getAll() throws SQLException {

		List<PerfilAcesso> perfis = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();
			perfis.addAll(new PerfilAcessoExtractor().extractAll(resultSet, getConnection()));
		}

		return perfis;
	}

	@Override
	public boolean isExist(PerfilAcesso model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public PerfilAcesso get(String value) throws SQLException {
		PerfilAcesso perfil = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, value);
			ResultSet resultSet = pst.executeQuery();

			perfil = new PerfilAcessoExtractor().extract(resultSet, super.getConnection());
		}

		return perfil;
	}

}
