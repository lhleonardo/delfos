package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.Mensagem;

public class PesquisaDAO extends GenericDAO<Pesquisa> {

	private static final String SQL_SELECT = "SELECT * FROM Pesquisa";
	private static final String SQL_SELECT_WHERE = SQL_SELECT + " WHERE id_especialista = ? AND data = ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_pesquisa = ?";
	private static final String SQL_SELECT_BY_DATA = SQL_SELECT + " WHERE data = ?";
	private static final String SQL_SELECT_BY_DESCRICAO = SQL_SELECT + " WHERE descricao = ?";
	private static final String SQL_INSERT = "INSERT INTO Pesquisa(data,descricao,limite_de_especialistas) VALUES(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE Pesquisa SET descricao = ?, limite_de_especialistas = ? WHERE id_pesquisa =?";
	private static final String SQL_DELETE = "DELETE FROM Pesquisa WHERE id_pesquisa = ?";
	
	public PesquisaDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Integer insert(Pesquisa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT)) {

			java.sql.Date dataSQL = new java.sql.Date(new java.util.Date().getTime());// Cria
																					  // Objeto
																					  // Data
																					  // do
																					  // Java.sql
																					  // e
																					  // utiliza
																					  // o
																					  // método
																					  // getTime
																					  // do
																					  // Objeto
																					  // Java.util

			pst.setDate(1, dataSQL);
			pst.setString(2, model.getDescricao());
			pst.setInt(3, model.getLimiteDeEspecialistas());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}

	}
	
	@Override
	protected Integer update(Pesquisa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getDescricao());
			pst.setInt(2, model.getLimiteDeEspecialistas());
			pst.setInt(3, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	@Override
	public boolean delete(Pesquisa model) throws SQLException {
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
	public List<Pesquisa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pesquisa get(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pesquisa get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isExist(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Pesquisa> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}