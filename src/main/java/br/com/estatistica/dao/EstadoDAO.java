package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.EstadoExtractor;
import br.com.estatistica.modelos.Estado;

public class EstadoDAO extends GenericDAO<Estado> {
	
	private static final EstadoExtractor EXTRACTOR = new EstadoExtractor();
	private static final String SQL_INSERT = "INSERT INTO Estado(nome,uf,cod_ibge,descricao) VALUES (?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE Estado SET nome = ?, uf = ?, cod_ibge = ?, descricao = ? WHERE id_estado = ?;";
	private static final String SQL_DELETE = "DELETE FROM Estado WHERE id_estado = ?;";
	private static final String SQL_SELECT = "SELECT * FROM Estado";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT
			+ " WHERE id_estado = ? OR nome LIKE ? OR uf =  ? OR descricao LIKE ? OR cod_ibge = ?;";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_estado = ?;";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";
	
	public EstadoDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	protected Integer insert(Estado model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getUf());
			pst.setString(3, model.getCodIbge());
			pst.setString(4, model.getDescricao());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	protected Integer update(Estado model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getUf());
			pst.setString(3, model.getCodIbge());
			pst.setString(4, model.getDescricao());
			pst.setInt(5, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	public boolean delete(Estado model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			return super.confereExclusao(model.getId());
		}
	}
	
	@Override
	public List<Estado> getAll() throws SQLException {
		List<Estado> estados = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();
			
			estados = new ArrayList<>(EXTRACTOR.extractAll(resultSet, null));
		}
		
		return estados;
	}
	
	@Override
	public List<Estado> get(Estado model) throws SQLException {
		List<Estado> estados = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setInt(1, model.getId());
			pst.setString(2, "%" + model.getNome() + "%");
			pst.setString(3, "%" + model.getUf() + "%");
			pst.setString(4, "%" + model.getDescricao() + "%");
			pst.setString(5, "%" + model.getCodIbge() + "%");
			
			estados = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}
		
		return estados;
	}
	
	@Override
	public Estado get(Integer idModel) throws SQLException {
		Estado estado = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet resultSet = pst.executeQuery();
			
			estado = EXTRACTOR.extract(resultSet, null);
		}
		
		return estado;
	}
	
	@Override
	public List<Estado> get(String value) throws SQLException {
		List<Estado> estados = new ArrayList<>();
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%" + value + "%");
			ResultSet resultSet = pst.executeQuery();
			
			estados.addAll(EXTRACTOR.extractAll(resultSet, null));
		}
		
		return estados;
	}
	
	@Override
	public boolean isExist(Estado model) throws SQLException {
		return this.get(model) != null;
	}
	
	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}
	
}
