package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.extractors.PerguntaExtractor;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.util.Mensagem;

public class PerguntaDAO extends GenericDAO<Pergunta> {
	private static final String SQL_SELECT = "SELECT * FROM Pergunta";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Pergunta(id_pergunta, descricao,observacao,questionario,tipopergunta, tipocampo) VALUES(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Pergunta SET descricao = ?, observacao = ?, questionario = ?, tipopergunta = ?, tipocampo = ? WHERE id_pergunta =?";
	private static final String SQL_DELETE = "DELETE FROM Pergunta WHERE id_usuario = ?";

	// TODO: Arrumar implementação de acordo com a padronização de DAO's

	public PerguntaDAO(Connection connection) {
		super(connection);

	}

	@Override
	protected Integer insert(Pergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getObservacao());
			pst.setString(3, model.getDescricao());

			pst.executeUpdate();
			return null;
		}
	}
	
	
	@Override
	protected Integer update(Pergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.executeUpdate();
			return null;
		}
	}

	@Override
	public boolean delete(Pergunta model) throws SQLException {
		if (model.getId() != null) {
			try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
				pst.setInt(1, model.getId());
				int linhasAfetadas = pst.executeUpdate();
				if (linhasAfetadas > 0) {
					JOptionPane.showMessageDialog(null, "Excluído com sucesso.");
				}
			}
		}
		return false;
	}

	@Override
	public List<Pergunta> getAll() throws SQLException {
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			perguntas.addAll(new PerguntaExtractor().extractAll(resultSet, super.getConnection()));

		}

		return perguntas;
	}

	@Override
	public Pergunta get(Pergunta model) throws SQLException {
		Pergunta pergunta = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
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

		return null;
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
