package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.extractors.TipoPerguntaExtractor;
import br.com.estatistica.modelos.TipoPergunta;

public class Tipo_PerguntaDAO extends GenericDAO<TipoPergunta> {
	
	private static final TipoPerguntaExtractor EXTRACTOR = new TipoPerguntaExtractor();
	

	private static final String SQL_SELECT = "SELECT * FROM Tipo_Pergunta";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Tipo_Pergunta(nome, descricao) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE Tipo_Pergunta SET nome = ?, descricao = ?";
	private static final String SQL_DELETE = "DELETE FROM Tipo_Pergunta WHERE id_tipo_pergunta = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";
	
	public Tipo_PerguntaDAO(Connection connection) {
		super(connection);

	}

	@Override
	protected Integer insert(TipoPergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT , PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			pst.setString (1, model.getNome());
			pst.setString(2, model.getDescricao());
			
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	

	@Override
	protected Integer update(TipoPergunta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, model.getId());
			pst.setString (2, model.getNome());
			pst.setString(3,  model.getDescricao());
			
			
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}

	}
	
	
	@Override
	public boolean delete(TipoPergunta model) throws SQLException {
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
	public List<TipoPergunta> getAll() throws SQLException {
		List<TipoPergunta> tipoperguntas = new ArrayList<TipoPergunta>();
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();
			
			tipoperguntas.addAll(new TipoPerguntaExtractor().extractAll(resultSet, super.getConnection()));
			
		}
		
		return tipoperguntas;
	}
	
	@Override
	public List<TipoPergunta> get(TipoPergunta model) throws SQLException {
		List<TipoPergunta> tipos = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2,model.getNome());
			pst.setString(2, model.getDescricao());

			ResultSet resultSet = pst.executeQuery();
			
			tipos = new ArrayList<>( EXTRACTOR.extractAll(resultSet, super.getConnection()));
			
		}
		
		return tipos;
	}
	
	@Override
	public TipoPergunta get(Integer idModel) throws SQLException {
		TipoPergunta tipopergunta = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();
			
			tipopergunta = new TipoPerguntaExtractor().extract(rs, super.getConnection());
			
		}
		
		return tipopergunta;
	}
	
	@Override
	public List<TipoPergunta> get(String value) throws SQLException {
		List<TipoPergunta> perguntas = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, value);
			perguntas.addAll(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return perguntas;
	}
	
	
	@Override
	public boolean isExist(TipoPergunta model) throws SQLException {

		return this.get(model) != null;
	}
	
	@Override
	public boolean isExist(Integer idModel) throws SQLException {

		return this.get(idModel) != null;
	}
	
}
