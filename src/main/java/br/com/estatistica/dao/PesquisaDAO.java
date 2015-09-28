package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.PesquisaExtractor;
import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.Mensagem;

public class PesquisaDAO extends GenericDAO<Pesquisa> {
	
	private static final String SQL_SELECT = "SELECT * FROM Pesquisa";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE id_especialista = ? AND data = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_pesquisa = ?";
	private static final String SQL_SELECT_BY_DATA = SQL_SELECT + " WHERE data = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO Pesquisa(data,nome,descricao,limite_de_especialistas) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Pesquisa SET nome = ?,descricao = ?, limite_de_especialistas = ? WHERE id_pesquisa =?";
	private static final String SQL_DELETE = "DELETE FROM Pesquisa WHERE id_pesquisa = ?";

	public PesquisaDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	protected Integer insert(Pesquisa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			java.sql.Date dataSQL = new java.sql.Date(new java.util.Date().getTime());
			pst.setDate(1, dataSQL);
			pst.setString(2, model.getNome());
			pst.setString(3, model.getDescricao());
			pst.setInt(4, model.getLimiteDeEspecialistas());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
		
	}

	@Override
	protected Integer update(Pesquisa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getLimiteDeEspecialistas());
			pst.setInt(4, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(Pesquisa model) throws SQLException {
		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());

				pst.executeUpdate();
			}
			if (this.get(model.getId()) == null) {
				Mensagem.informa(null, "Excluído com sucesso.");
				return true;
			} else {
				Mensagem.aviso(null, "O registro não foi excluído corretamente, tente novamente mais tarde.");
				return false;
			}
		} else {
			throw new IllegalArgumentException("Informe um usuário antes de prosseguir.");
		}
		
	}

	@Override
	public List<Pesquisa> getAll() throws SQLException {
		List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			pesquisas.addAll(new PesquisaExtractor().extractAll(resultSet, super.getConnection()));

		}

		return pesquisas;
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
	public boolean isExist(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pesquisa> get(String nome) throws SQLException {
		List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%"+nome+"%");
			ResultSet resultSet = pst.executeQuery();

			pesquisas.addAll(new PesquisaExtractor().extractAll(resultSet, super.getConnection()));
	}
		return pesquisas;

}
}