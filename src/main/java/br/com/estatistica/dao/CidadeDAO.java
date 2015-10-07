package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.CidadeExtractor;
import br.com.estatistica.modelos.Cidade;

public class CidadeDAO extends GenericDAO<Cidade> {
	private static final CidadeExtractor EXTRACTOR = new CidadeExtractor();
	private static final String SQL_DELETE = "DELETE FROM Cidade WHERE id_cidade = ?";
	private static final String SQL_INSERT = "INSERT INTO Cidade(nome,descricao,cod_ibge,id_estado) VALUES (?,?,?,?);";
	private static final String SQL_SELECT = "SELECT * FROM Cidade";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT + " WHERE nome LIKE ? OR cod_ibge = ? OR descricao LIKE ? OR id_estado = ?;";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_cidade = ?;";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";
	private static final String SQL_UPDATE = "UPDATE Cidade SET nome = ?, descricao = ?, cod_ibge = ?, id_estado = ? WHERE id_cidade = ?;";
	
	public CidadeDAO(Connection connection) {
		super(connection);
	}
	
	@Override
	public boolean delete(Cidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			return super.confereExclusao(model.getId());
		}
	}
	
	@Override
	public Cidade get(Cidade model) throws SQLException {
		Cidade cidade = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setString(1, "%" + model.getNome() + "%");
			pst.setString(2, model.getCodIbge());
			pst.setString(3, "%" + model.getDescricao() + "%");
			pst.setInt(4, model.getEstado().getId());
			
			cidade = EXTRACTOR.extract(pst.executeQuery(), null);
		}
		
		return cidade;
	}
	
	@Override
	public Cidade get(Integer idModel) throws SQLException {
		Cidade cidade = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			
			cidade = EXTRACTOR.extract(pst.executeQuery(), this.getConnection());
		}
		
		return cidade;
	}
	
	@Override
	public List<Cidade> get(String value) throws SQLException {
		List<Cidade> cidades = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%" + value + "%");
			
			cidades = new ArrayList<Cidade>(EXTRACTOR.extractAll(pst.executeQuery(), this.getConnection()));
		}
		
		return cidades;
	}
	
	@Override
	public List<Cidade> getAll() throws SQLException {
		List<Cidade> cidades = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			cidades = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), super.getConnection()));
		}
		
		return cidades;
	}
	
	@Override
	protected Integer insert(Cidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getCodIbge());
			pst.setInt(4, model.getEstado().getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	public boolean isExist(Cidade model) throws SQLException {
		return this.get(model) != null;
	}
	
	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}
	
	@Override
	protected Integer update(Cidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getCodIbge());
			pst.setInt(4, model.getEstado().getId());
			pst.setInt(5, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
}
