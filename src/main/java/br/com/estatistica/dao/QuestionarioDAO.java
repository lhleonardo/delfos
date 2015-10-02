package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.estatistica.extractors.QuestionarioExtractor;
import br.com.estatistica.modelos.Questionario;
import br.com.estatistica.util.Mensagem;

public class QuestionarioDAO extends GenericDAO<Questionario> {
	
	private static final String SQL_SELECT = "SELECT * FROM Questionario";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_questionario = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO Questionario(nome,descricao,id_pesquisa,id_tema_questionario) VALUES (?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM Pesquisa WHERE id_questionario = ?";
	private static final String SQL_UPDATE = "UPDATE Questionario SET nome = ?,descricao = ?, id_tema_questionario = ?, id_pesquisa = ? WHERE id_pesquisa =?";
	
	public QuestionarioDAO(Connection connection) {
		super(connection);
	}
	
	
	
	protected Integer insert(Questionario model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getPesquisa().getId());
			pst.setInt(4, model.getTema().getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(Questionario model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getTema().getId());
		    pst.setInt(4, model.getPesquisa().getId());
			pst.setInt(3, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(Questionario model) throws SQLException {
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
	public List<Questionario> getAll() throws SQLException {
		List<Questionario> questionarios = new ArrayList<Questionario>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			questionarios.addAll(new QuestionarioExtractor().extractAll(resultSet, super.getConnection()));

		}

		return questionarios;
	}

	@Override
	public Questionario get(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questionario get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questionario> get(String nome) throws SQLException {
		List<Questionario> pesquisas = new ArrayList<Questionario>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%"+nome+"%");
			ResultSet resultSet = pst.executeQuery();

			pesquisas.addAll(new QuestionarioExtractor().extractAll(resultSet, super.getConnection()));
	}
		return pesquisas;

}
	

	@Override
	public boolean isExist(Questionario model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

}
