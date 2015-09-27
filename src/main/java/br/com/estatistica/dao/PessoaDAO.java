package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelos.Especialista;
import br.com.estatistica.modelos.Pesquisador;
import br.com.estatistica.modelos.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa> {

	private static final String SQL_INSERT = "INSERT INTO Pessoa(nome, descricao, cpf, rg, e-mail, is_pesquisador,is_especialista) VALUES(?,?,?,?,?,?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE Pessoa SET nome = ?, descricao = ?, cpf = ?, rg = ?, e-mail = ?, is_pesquisador = ?, is_especialista = ? WHERE id_pessoa = ?";
	private static final String SQL_DELETE = "DELETE FROM Pessoa WHERE id_pessoa = ?";
	private static final String SQL_SELECT = "";

	public PessoaDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(Pessoa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getTipoDocumento().getValor());
			pst.setString(4, model.getRg());
			pst.setString(5, model.getEmail());
			pst.setBoolean(6, model instanceof Pesquisador);
			pst.setBoolean(7, model instanceof Especialista);
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(Pessoa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getTipoDocumento().getValor());
			pst.setString(4, model.getRg());
			pst.setString(5, model.getEmail());
			pst.setBoolean(6, model instanceof Pesquisador);
			pst.setBoolean(7, model instanceof Especialista);
			pst.setInt(8, model.getId());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	public boolean delete(Pessoa model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();

			return super.confereExclusao(model.getId());

		}
	}

	@Override
	public List<Pessoa> getAll() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {

		}

		return null;
	}

	@Override
	public Pessoa get(Pessoa model) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa get(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Pessoa model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Pessoa> get(String value) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
