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
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Pergunta(id_pergunta, descricao,observacao,questionario,tipopergunta, tipocampo) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Pergunta SET descricao = ?, observacao = ?, questionario = ?, tipopergunta = ?, tipocampo = ? WHERE id_pergunta =?";
	private static final String SQL_DELETE = "DELETE FROM Pergunta WHERE id_usuario = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";


	public PerguntaDAO(Connection connection) {
		super(connection);
	}

	
	@Override
	protected Integer insert(Pergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, model.getId());
			pst.setString(2,model.getNome());
			pst.setString(2, model.getObservacao());
			pst.setString(3, model.getDescricao());

			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	
	@Override
	protected Integer update(Pergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE , PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(Pergunta model) throws SQLException {
		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());
				
				pst.executeUpdate();
				
			}if (this.get(model.getId()) == null) {
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
	public List<Pergunta> getAll() throws SQLException {
		List<Pergunta> perguntas = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			perguntas = new ArrayList<>(EXTRACTOR.extractAll(resultSet, null));
		}

		return perguntas;
	}

	@Override
	public Pergunta get(Pergunta model) throws SQLException {
		Pergunta pergunta = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getObservacao());
			ResultSet resultSet = pst.executeQuery();

			pergunta = new PerguntaExtractor().extract(resultSet, super.getConnection());

		}

		return pergunta;
	}

	@Override
	public Pergunta get(Integer idModel) throws SQLException {
		Pergunta pergunta = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();

			pergunta = new PerguntaExtractor().extract(rs, super.getConnection());

		}

		return pergunta;
	}

	@Override
	public List<Pergunta> get(String value) throws SQLException {

		List<Pergunta> perguntas = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
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
