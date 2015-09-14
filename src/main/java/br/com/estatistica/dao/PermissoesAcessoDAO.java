package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.estatistica.extractors.PermissoesAcessoExtractor;
import br.com.estatistica.modelos.Funcionalidade;
import br.com.estatistica.modelos.PerfilAcesso;
import br.com.estatistica.util.Mensagem;

public class PermissoesAcessoDAO extends GenericDAO<PerfilAcesso> {

	private static final String SQL_SELECT = "SELECT * FROM Funcionalidade_has_Perfil_acesso WHERE id_perfil_acesso = ? AND id_funcionalidade = ?";
	private static final String SQL_DELETE = "DELETE FROM Funcionalidade_has_Perfil_acesso WHERE id_perfil_acesso = ?";
	private static final String SQL_SELECT_BY_PERFIL = "SELECT * FROM Funcionalidade_has_Perfil_acesso WHERE id_perfil_acesso = ?";
	private List<String> operacoes = new ArrayList<>();

	public PermissoesAcessoDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Integer save(PerfilAcesso model) throws SQLException {
		if (!model.getPermissoes().isEmpty()) {

			for (Funcionalidade funcionalidade : model.getPermissoes().keySet()) {

				if (!isExist(model, funcionalidade)) {
					operacoes.add("INSERT INTO Funcionalidade_has_Perfil_acesso(id_perfil_acesso,id_funcionalidade,acesso) values ("
					        + model.getId() + "," + funcionalidade.getId() + "," + model.possuiPermissao(funcionalidade) + ");");
				} else {
					operacoes.add("UPDATE Funcionalidade_has_Perfil_acesso SET id_funcionalidade = " + model.getId() + ", acesso = "
					        + model.possuiPermissao(funcionalidade) + " WHERE id_perfil_acesso = " + model.getId() + ";");
				}

			}

			super.executeBath(operacoes);

			Mensagem.informa(null, "Salvo com sucesso.");

		} else {
			throw new IllegalArgumentException("Devem ser informadas as permissões para esse perfil.");
		}
		return null;
	}

	private boolean isExist(PerfilAcesso model, Funcionalidade funcionalidade) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			pst.setInt(1, model.getId());
			pst.setInt(2, funcionalidade.getId());
			ResultSet resultSet = pst.executeQuery();

			return resultSet.next();
		}
	}

	@Override
	public boolean delete(PerfilAcesso model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			int executeUpdate = pst.executeUpdate();

			if (executeUpdate > 0) {
				Mensagem.informa(null, "Excluído com sucesso.");
				return true;
			} else {
				return false;
			}
		}

	}

	public Map<Funcionalidade, Boolean> getAll(PerfilAcesso model) throws SQLException {
		Map<Funcionalidade, Boolean> permissoes = new HashMap<Funcionalidade, Boolean>();

		System.out.println("PermissoesAcessoDAO.getAll()");

		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_PERFIL)) {
				System.out.println("PermissoesAcessoDAO.getAll(passo 1)");
				pst.setInt(1, model.getId());
				System.out.println("PermissoesAcessoDAO.getAll(passo 2)");
				ResultSet resultSet = pst.executeQuery();

				System.out.println("PermissoesAcessoDAO.getAll(vai extrair as permissões)");
				permissoes = new PermissoesAcessoExtractor().extract(resultSet, getConnection());
			}
		} else
			throw new NullPointerException(
			        "O perfil de acesso informado para realizar a associação com as permissões é inválido ou inexistente.");

		return permissoes;
	}

	@Deprecated
	protected Integer insert(PerfilAcesso model) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	protected Integer update(PerfilAcesso model) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	public List<PerfilAcesso> getAll() throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	public PerfilAcesso get(PerfilAcesso model) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	public PerfilAcesso get(Integer idModel) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	public List<PerfilAcesso> get(String value) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	public boolean isExist(PerfilAcesso model) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

	@Deprecated
	public boolean isExist(Integer idModel) throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível.");
	}

}
