package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.TemaQuestionarioExtractor;
import br.com.estatistica.modelos.TemaQuestionario;
import br.com.estatistica.modelos.Usuario;
import br.com.estatistica.util.Mensagem;

public class TemaQuestionarioDAO extends GenericDAO<TemaQuestionario> {
	
	private static final String SQL_SELECT = "SELECT * FROM Tema_questionario";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_tema_questionario = ?";
	private static final String SQL_SELECT_BY_DATA = SQL_SELECT + " WHERE data = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + "  WHERE nome LIKE ?";
	private static final String SQL_INSERT = "INSERT INTO Tema_Questionario(nome,descricao) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE Pesquisa SET nome = ?,descricao = ? WHERE id_tema_questionario =?";
	private static final String SQL_DELETE = "DELETE FROM Pesquisa WHERE id_tema_questionario = ?";
	

	public TemaQuestionarioDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(TemaQuestionario model) throws SQLException {
try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
	
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();
			
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(TemaQuestionario model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(TemaQuestionario model) throws SQLException {
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
	public List<TemaQuestionario> getAll() throws SQLException {
		List<TemaQuestionario> temas = new ArrayList<TemaQuestionario>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			temas.addAll(new TemaQuestionarioExtractor().extractAll(resultSet, super.getConnection()));

		}

		return temas;
	}

	@Override
	public TemaQuestionario get(TemaQuestionario model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemaQuestionario get(Integer idModel) throws SQLException {
		TemaQuestionario tema = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			tema = EXTRACTOR.extract(rs, super.getConnection());

		}

		return usuario;
	}

	@Override
	public List<TemaQuestionario> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(TemaQuestionario model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
