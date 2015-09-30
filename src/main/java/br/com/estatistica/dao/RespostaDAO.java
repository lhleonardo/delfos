package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Resposta;
public class RespostaDAO extends GenericDAO<Resposta> {
	
	private static final String SQL_SELECT = "SELECT * FROM Resposta";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_resposta = ?";
	private static final String SQL_INSERT = "INSERT INTO Resposta(id_resposta, descricao,observacao, ) VALUES(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Resposta SET descricao = ?, observacao = ?, pergunta = ?, pessoa =? WHERE id_pergunta =?";
	private static final String SQL_DELETE = "DELETE FROM Resposta WHERE id_resposta = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";

	
	public RespostaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Integer insert(Resposta model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer update(Resposta model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Resposta model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Resposta> getAll() throws SQLException {
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
	public List<Resposta> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Resposta model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}	
}