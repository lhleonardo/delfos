package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.FuncionalidadeExtractor;
import br.com.estatistica.modelos.Funcionalidade;

public class FuncionalidadeDAO extends GenericDAO<Funcionalidade> {
	
	private FuncionalidadeExtractor extractor = new FuncionalidadeExtractor();
	
	private static final String SQL_INSERT = "INSERT INTO Funcionalidade(nome, descricao, chave) VALUES (?,?,?);";
	private static final String SQL_UPDATE = "UPDATE Funcionalidade SET nome = ?, descricao = ?, chave = ? WHERE id_funcionalidade = ?;";
	private static final String SQL_DELETE = "DELETE FROM Funcionalidade WHERE id_funcionalidade = ?";
	private static final String SQL_SELECT = "SELECT * FROM Funcionalidade";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_funcionalidade = ?";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT + " WHERE nome LIKE ? AND descricao LIKE ? AND chave = ?;";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?;";
	private static final String SQL_SELECT_BY_CHAVE = SQL_SELECT + " WHERE chave LIKE ?;";
	
	public FuncionalidadeDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	protected Integer insert(Funcionalidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getChave());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	protected Integer update(Funcionalidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getChave());
			pst.setInt(4, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	public boolean delete(Funcionalidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			return this.get(model.getId()) == null;
		}
	}
	
	@Override
	public List<Funcionalidade> getAll() throws SQLException {
		List<Funcionalidade> funcionalidades = new ArrayList<Funcionalidade>();
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();
			
			funcionalidades.addAll(this.extractor.extractAll(resultSet, null));
			
		}
		
		return funcionalidades;
	}
	
	@Override
	public List<Funcionalidade> get(Funcionalidade model) throws SQLException {
		List<Funcionalidade> funcionalidades = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getChave());
			ResultSet resultSet = pst.executeQuery();
			
			funcionalidades = new ArrayList<>( this.extractor.extractAll(resultSet, null));
		}
		
		return funcionalidades;
	}
	
	@Override
	public Funcionalidade get(Integer idModel) throws SQLException {
		Funcionalidade funcionalidade = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet resultSet = pst.executeQuery();
			
			funcionalidade = this.extractor.extract(resultSet, null);
			
		}
		return funcionalidade;
	}
	
	@Override
	public List<Funcionalidade> get(String value) throws SQLException {
		List<Funcionalidade> func = new ArrayList<>();
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%" + value + "%");
			ResultSet resultSet = pst.executeQuery();
			
			func.addAll(this.extractor.extractAll(resultSet, null));
		}
		
		return func;
	}
	
	public Funcionalidade getByChave(String chave) throws SQLException {
		Funcionalidade func = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_CHAVE)) {
			pst.setString(1, "%" + chave + "%");
			ResultSet resultSet = pst.executeQuery();
			
			func = this.extractor.extract(resultSet, null);
		}
		
		return func;
	}
	
	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}
	
	@Override
	public boolean isExist(Funcionalidade model) throws SQLException {
		
		return this.get(model) != null;
	}
	
}
