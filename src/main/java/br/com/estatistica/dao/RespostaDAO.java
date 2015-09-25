package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

//Teste

import br.com.estatistica.modelos.Resposta;
import br.com.estatistica.util.Mensagem;

public class RespostaDAO extends GenericDAO {
	private static final String SQL_SELECT = "SELECT * FROM Resposta";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE id_especialista = ? AND data = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_pesquisa = ?";
	private static final String SQL_SELECT_BY_DESCRICAO = SQL_SELECT + " WHERE descricao = ?";
	private static final String SQL_INSERT = "INSERT INTO Resposta(descricao, observacao) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE Resposta SET descricao = ?, observacao = ? WHERE id_pesquisa =?";
	private static final String SQL_DELETE = "DELETE FROM Resposta WHERE id_pesquisa = ?";
	
	public RespostaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	protected Integer insert (Resposta model) throws SQLException {
		
		try(PreparedStatement pst = super.getConnection().PreparedStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)){
			
			java.sql.Date dataSQL = new java.sql.Date(new java.util.Date().getTime());
			
			
			pst.setString(1, model.getDescricao());
			pst.setString(2, model.getObservacao());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}

	}

	@Override
	protected Integer update(Resposta model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getDescricao());
			pst.setString(2, model.getObservacao());
			pst.setInt(3, model.getId());
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
				Mensagem.informa(null, "Resposta excluída com sucesso.");
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
	public List getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resposta get(Resposta model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resposta get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Observacao model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
