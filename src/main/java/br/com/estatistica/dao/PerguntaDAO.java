package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.PerguntaExtractor;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.util.Mensagem;

public class PerguntaDAO extends GenericDAO<Pergunta> {

	private static final PerguntaExtractor EXTRACTOR = new PerguntaExtractor();

	private static final String SQL_SELECT = "SELECT * FROM Pergunta";
	private static final String SQL_SELECT_WHERE = SQL_SELECT
			+ " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT
			+ " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Pergunta(nome, descricao,observacao,id_tipo_pergunta, id_tipo_campo,id_questionario) VALUES(?,?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Pergunta SET nome = ?,descricao = ?, observacao = ?, id_questionario = ?, id_tipo_pergunta = ?, id_tipo_campo = ? WHERE id_pergunta =?";
	private static final String SQL_DELETE = "DELETE FROM Pergunta WHERE id_pergunta = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT
			+ " WHERE nome LIKE ?";

	public PerguntaDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(Pergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getObservacao());
			pst.setInt(4, model.getTipoPergunta().getId());
			pst.setInt(5, model.getTipoCampo().getId());
			pst.setInt(6, model.getQuestionario().getId());

			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(Pergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getObservacao());
			pst.setInt(4, model.getTipoPergunta().getId());
			pst.setInt(5, model.getTipoCampo().getId());
			pst.setInt(6, model.getQuestionario().getId());
			pst.setInt(7, model.getId());

			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(Pergunta p1) throws SQLException {
		if (p1.getId() != null) {
			try (PreparedStatement pst = super.getConnection()
					.prepareStatement(SQL_DELETE)) {
				pst.setInt(1, p1.getId());

				pst.executeUpdate();

			}
			if (this.get(p1.getId()) == null) {
				Mensagem.informa(null, "Excluído com sucesso.");
				return true;
			} else {
				Mensagem.aviso(null,
						"O registro não foi excluído corretamente, tente novamente mais tarde.");
				return false;
			}
		} else {
			throw new IllegalArgumentException(
					"Informe um usuário antes de prosseguir.");
		}

	}

	@Override
	public List<Pergunta> getAll() throws SQLException {
		List<Pergunta> perguntas = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			perguntas = new ArrayList<>(EXTRACTOR.extractAll(resultSet, null));
		}

		return perguntas;
	}

	@Override
	public List<Pergunta> get(Pergunta model) throws SQLException {
		List<Pergunta> perguntas = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getNome());
			pst.setString(3, model.getDescricao());
			pst.setString(4, model.getObservacao());
			pst.setInt(5, model.getTipoPergunta().getId());
			pst.setInt(6, model.getTipoCampo().getId());
			pst.setInt(7, model.getQuestionario().getId());

			ResultSet resultSet = pst.executeQuery();

			perguntas = new ArrayList<>(EXTRACTOR.extractAll(resultSet,
					super.getConnection()));

		}

		return perguntas;
	}

	@Override
	public Pergunta get(Integer idModel) throws SQLException {
		Pergunta pergunta = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			pergunta = new PerguntaExtractor().extract(rs,
					super.getConnection());

		}

		return pergunta;
	}

	@Override
	public List<Pergunta> get(String value) throws SQLException {

		List<Pergunta> perguntas = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(
				SQL_SELECT_BY_NOME)) {
			pst.setString(1, value);
			perguntas.addAll(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return perguntas;
	}

	@Override
	public boolean isExist(Pergunta model) throws SQLException {
		return this.get(model) != null;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;

	}

}
