package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.RespostaExtractor;
import br.com.estatistica.modelos.Resposta;
import br.com.estatistica.util.Mensagem;

public class RespostaDAO extends GenericDAO<Resposta> {
	
	private static final RespostaExtractor EXTRACTOR = new RespostaExtractor();
	
	private static final String SQL_SELECT = "SELECT * FROM Resposta";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE login = ? AND senha = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_usuario = ?";
	private static final String SQL_INSERT = "INSERT INTO Resposta(nome, descricao,observacao, id_pergunta, id_pessoa) VALUES(?, ?, ?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Resposta SET id_pergunta=?, id_pessoa=?, nome = ?, descricao = ?, observacao = ? WHERE id_resposta=?";
	private static final String SQL_DELETE = "DELETE FROM Resposta WHERE id_resposta = ?";
	private static final String SQL_SELECT_BY_DESCRICAO = SQL_SELECT + " WHERE descricao LIKE ?";
	
	public RespostaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Integer insert(Resposta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getObservacao());
			pst.setInt(4, model.getPergunta().getId());
			pst.setInt(5, model.getPessoa().getId());
			
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	protected Integer update(Resposta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			pst.setInt(1, model.getPergunta().getId());
			pst.setInt(2, model.getPessoa().getId());
			pst.setString(3, model.getNome());
			pst.setString(4, model.getDescricao());
			pst.setString(5, model.getObservacao());
			pst.setInt(6, model.getId());
			
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	public boolean delete(Resposta model) throws SQLException {
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
	public List<Resposta> getAll() throws SQLException {
		List<Resposta> respostas = new ArrayList<Resposta>();
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();
			
			respostas.addAll(new RespostaExtractor().extractAll(resultSet, super.getConnection()));
		}
		
		return respostas;
	}
	
	@Override
	public Resposta get(Resposta model) throws SQLException {
		Resposta resposta = null;
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_WHERE)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getObservacao());
			pst.setInt(3, model.getPergunta().getId());
			pst.setInt(4, model.getPessoa().getId());
			
			ResultSet resultSet = pst.executeQuery();
			
			resposta = new RespostaExtractor().extract(resultSet, super.getConnection());
			
		}
		
		return resposta;
	}
	
	@Override
	public Resposta get(Integer idModel) throws SQLException {
		Resposta resposta = null;
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			ResultSet rs = pst.executeQuery();
			
			resposta = new RespostaExtractor().extract(rs, super.getConnection());
			
		}
		
		return resposta;
	}
	
	@Override
	public List<Resposta> get(String descricao) throws SQLException {
		List<Resposta> respostas = new ArrayList<Resposta>();
		
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_DESCRICAO)) {
			pst.setString(1, "%" + descricao + "%");
			ResultSet resultSet = pst.executeQuery();
			respostas.addAll(EXTRACTOR.extractAll(resultSet, super.getConnection()));
		}
		
		return respostas;
	}
	
	@Override
	public boolean isExist(Resposta model) throws SQLException {
		return this.get(model) != null;
		
	}
	
	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}
}