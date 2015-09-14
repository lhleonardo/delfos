package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Cidade;

public class CidadeDAO extends GenericDAO<Cidade> {
	private static final String SQL_INSERT = "INSERT INTO Cidade(nome,descricao,cod_ibge,id_estado) VALUES (?,?,?,?);";

	public CidadeDAO(Connection connection) {
		super(connection);
	}

	@Override
	public boolean delete(Cidade model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cidade get(Cidade model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cidade get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Integer insert(Cidade model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getCodigoIbge());
			pst.setInt(4, model.getEstado().getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean isExist(Cidade model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Integer update(Cidade model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
