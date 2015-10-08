package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Pesquisa;

public class PesquisadorParticipaPesquisaDAO extends GenericDAO<Pesquisa> {

	private static final String SQL_INSERT = "INSERT INTO Pesquisador_responsavel_pesquisa(id_pesquisa, id_pesquisador) VALUES(?,?)";
	
	public PesquisadorParticipaPesquisaDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Integer insert(Pesquisa model) throws SQLException {
		try (PreparedStatement pst2 = super.getConnection().prepareStatement(SQL_INSERT)) {
			for (int i = 0; i < model.getResponsaveis().size(); i++) {
				pst2.setInt(1, model.getId());
				pst2.setInt(2, model.getResponsaveis().get(i).getId());
				pst2.executeUpdate();
			}
		}
		return null;
	}
	
	@Override
	protected Integer update(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean delete(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public List<Pesquisa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Pesquisa> get(Pesquisa model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Pesquisa get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Pesquisa> get(String value) throws SQLException {
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
	
}
