package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.extractors.BairroExtractor;
import br.com.estatistica.modelos.Bairro;

public class BairroDAO extends GenericDAO<Bairro> {

	private static final BairroExtractor EXTRACTOR = new BairroExtractor();

	private static final String SQL_INSERT = "INSERT INTO Bairro(nome, descricao) VALUES (?,?)";
	private static final String SQL_UPDATE = "UPDATE Bairro SET nome = ?, descricao = ? WHERE id_bairro = ?";
	private static final String SQL_DELETE = "DELETE FROM Bairro WHERE id_bairro = ?";
	private static final String SQL_SELECT = "SELECT * FROM Bairro";
	private static final String SQL_SELECT_BY_ALL = SQL_SELECT + " WHERE id_bairro = ? OR nome LIKE ? OR descricao LIKE ?";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_bairro = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + " WHERE nome LIKE ?";

	public BairroDAO(Connection connection) {
		super(connection);
	}

	@Override
	protected Integer insert(Bairro model) throws SQLException {
		System.out.println("Tá dentro do metodo insert");
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setString(1, model.getNome());
			System.out.println("Tá setando a descrição");
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}

	}

	@Override
	protected Integer update(Bairro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pst.setInt(1, model.getId());
			pst.setString(1, model.getNome());
			pst.setString(2, model.getDescricao());
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}

	}

	@Override
	public boolean delete(Bairro model) throws SQLException {
		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_DELETE)) {
			pst.setInt(1, model.getId());
			pst.executeUpdate();
			return verificaSeORegistroFoiApagado(model.getId());

		}
	}

	@Override
	public List<Bairro> getAll() throws SQLException {
		List<Bairro> bairros = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			ResultSet resultSet = pst.executeQuery();

			bairros = new ArrayList<>(EXTRACTOR.extractAll(resultSet, null));
		}

		return bairros;
	}

	@Override
	public Bairro get(Bairro model) throws SQLException {
		Bairro bairro = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ALL)) {
			pst.setInt(1, model.getId());
			pst.setString(2, model.getNome());
			pst.setString(3, model.getDescricao());

			bairro = EXTRACTOR.extract(pst.executeQuery(), null);
		}

		return bairro;
	}

	@Override
	public Bairro get(Integer idModel) throws SQLException {
		Bairro bairro = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			bairro = EXTRACTOR.extract(pst.executeQuery(), null);
		}

		return bairro;
	}

	@Override
	public List<Bairro> get(String value) throws SQLException {
		List<Bairro> bairros = new ArrayList<>();

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, value);
			bairros.addAll(EXTRACTOR.extractAll(pst.executeQuery(), null));
		}

		return bairros;
	}

	@Override
	public boolean isExist(Bairro model) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
