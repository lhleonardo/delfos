package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco> {

	private static final String SQL_INSERT = "INSERT INTO Endereco(logradouro, descricao, numero, cep, id_tipo_logradouro, id_bairro, id_cidade) VALUES (?,?,?,?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE Endereco SET logradouro = ?, descricao = ?, numero = ?, cep = ?, id_tipo_logradouro = ?, id_bairro = ?, id_cidade = ? WHERE id_endereco = ?;";
	private static final String SQL_DELETE = "DELETE FROM Endereco WHERE id_endereco = ?";
	private static final String SQL_SELECT = "SELECT * FROM Endereco";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_endereco = ?;";

	public EnderecoDAO(Connection connection) {
		super(connection);
		this.setMostraConfirmacao(false);
	}

	@Override
	protected Integer insert(Endereco model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getLogradouro());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getNumero());
			pst.setString(4, model.getCep());
			pst.setInt(5, model.getTipoLogradouro().getId());
			pst.setInt(6, model.getBairro().getId());
			pst.setInt(7, model.getCidade().getId());
			pst.executeUpdate();

			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	@Override
	protected Integer update(Endereco model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE)) {
			pst.setString(1, model.getLogradouro());
			pst.setString(2, model.getDescricao());
			pst.setString(3, model.getNumero());
			pst.setString(4, model.getCep());

			pst.setInt(5, model.getTipoLogradouro().getId());
			pst.setInt(6, model.getBairro().getId());
			pst.setInt(7, model.getCidade().getId());
			pst.setInt(8, model.getId());
			pst.executeUpdate();

			return model.getId();
		}
	}

	@Override
	public boolean delete(Endereco model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			return this.confereExclusao(model.getId());
		}
	}

	@Override
	@Deprecated
	public List<Endereco> getAll() throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Override
	@Deprecated
	public List<Endereco> get(Endereco model) throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Override
	public Endereco get(Integer idModel) throws SQLException {
		Endereco endereco = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);

			endereco = new EnderecoExtractor().extract(pst.executeQuery(), this.getConnection());
		}

		return endereco;
	}

	@Deprecated
	@Override
	public List<Endereco> get(String value) throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Deprecated
	@Override
	public boolean isExist(Endereco model) throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {

		return this.get(idModel) != null;
	}

}
