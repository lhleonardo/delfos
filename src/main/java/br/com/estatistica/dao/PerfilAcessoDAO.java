package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.PerfilAcessoExtractor;
import br.com.estatistica.modelos.PerfilAcesso;
import br.com.estatistica.util.Mensagem;

public class PerfilAcessoDAO extends GenericDAO<PerfilAcesso> {

	private static final PerfilAcessoExtractor EXTRACTOR = new PerfilAcessoExtractor();
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
	protected Integer insert(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();

			model.setId(super.getGeneratedKeys(pst.getGeneratedKeys()));

			try (PermissoesAcessoDAO daoPermissao = new PermissoesAcessoDAO(super.getConnection())) {
				daoPermissao.save(model);
			}

			return model.getId();
		}

	}

	@Override
	protected Integer update(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getId());
			pst.executeUpdate();

			try (PermissoesAcessoDAO daoPermissao = new PermissoesAcessoDAO(super.getConnection())) {
				daoPermissao.save(model);
			}
			return null;
		}

	}

	@Override
	public boolean delete(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			if (this.get(model.getId()) == null) {
				Mensagem.informa(null, "Excluído com sucesso");
				return true;
			} else {
				return false;
			}
		}
		
	}
	
	@Override
	public PerfilAcesso get(PerfilAcesso model) throws SQLException {
		PerfilAcesso perfil = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setString(1, '%' + model.getNome() + '%');
			pst.setString(2, model.getDescricao());
			ResultSet resultSet = pst.executeQuery();

			perfil = EXTRACTOR.extract(resultSet, null);

		}
		return perfil;
	}

	@Override
	public PerfilAcesso get(Integer idModel) throws SQLException {
		PerfilAcesso perfil = null;

		System.out.println("PerfilAcessoDAO.get()");

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet resultSet = pst.executeQuery();

			System.out.println("PerfilAcessoDAO.get(vai entrar no extrator de perfil)");
			perfil = EXTRACTOR.extract(resultSet, super.getConnection());
		}

		return perfil;
	}

	@Override
	public List<PerfilAcesso> getAll() throws SQLException {

		List<PerfilAcesso> perfis = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();
			perfis.addAll(EXTRACTOR.extractAll(resultSet, this.getConnection()));
		}

		return perfis;
	}

	@Override
	public boolean isExist(PerfilAcesso model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public List<PerfilAcesso> get(String value) throws SQLException {
		List<PerfilAcesso> perfis = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, value);
			ResultSet resultSet = pst.executeQuery();

			perfis.addAll(EXTRACTOR.extractAll(resultSet, super.getConnection()));
		}

		return perfis;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}

}
