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

	/**
	 *
	 */
	private static final PessoaExtractor EXTRACTOR = new PessoaExtractor();
	private static final String SQL_INSERT = "INSERT INTO Pessoa(nome, descricao, cpf, rg, email, is_pesquisador,is_especialista,id_endereco) VALUES(?,?,?,?,?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE Pessoa SET nome = ?, descricao = ?, cpf = ?, rg = ?, email = ?, is_pesquisador = ?, is_especialista = ?, id_endereco = ? WHERE id_pessoa = ?";
	private static final String SQL_DELETE = "DELETE FROM Pessoa WHERE id_pessoa = ?";
	private static final String SQL_SELECT = "SELECT * FROM Pessoa";
	private static final String SQL_SELECT_BY_ID = SQL_SELECT + " WHERE id_pessoa = ?";
	private static final String SQL_SELECT_BY_NOME = SQL_SELECT + "WHERE nome LIKE ?";
	private EnderecoDAO eDao;

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
			pst.setInt(8, this.salvaEndereco(model));
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}

	/**
	 * @return
	 * @throws SQLException
	 */
	private Integer salvaEndereco(Pessoa model) throws SQLException {

		this.eDao = new EnderecoDAO(this.getConnection());

		return this.eDao.save(model.getEndereco());
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
			pst.setInt(8, this.atualizaEndereco(model));
			// TODO pst.setInt(9, atualizaInformacoesDeUsuario());
			pst.setInt(9, model.getId());
			pst.executeUpdate();
			return model.getId();
		}
	}

	/**
	 * @param model
	 * @return
	 * @throws SQLException
	 */
	private int atualizaEndereco(Pessoa model) throws SQLException {
		this.eDao = new EnderecoDAO(this.getConnection());

		return this.eDao.save(model.getEndereco());
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
		List<Pessoa> pessoas = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			pessoas = new ArrayList<Pessoa>(EXTRACTOR.extractAll(pst.executeQuery(), super.getConnection()));
		}

		return pessoas;
	}

	@Deprecated
	@Override
	public Pessoa get(Pessoa model) throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Override
	public Pessoa get(Integer idModel) throws SQLException {

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT_BY_ID)) {
			pst.setInt(1, idModel);
			return EXTRACTOR.extract(pst.executeQuery(), this.getConnection());
		}
	}

	@Deprecated
	@Override
	public boolean isExist(Pessoa model) throws SQLException {
		throw new UnsupportedOperationException("Operação não suportada.");
	}

	@Override
	public boolean isExist(Integer idModel) throws SQLException {
		return this.get(idModel) != null;
	}

	@Override
	public List<Pessoa> get(String value) throws SQLException {
		List<Pessoa> pessoas = null;

		try (PreparedStatement pst = this.getConnection().prepareStatement(SQL_SELECT_BY_NOME)) {
			pst.setString(1, "%" + value + "%");
			pessoas = new ArrayList<>(EXTRACTOR.extractAll(pst.executeQuery(), this.getConnection()));
		}

		return pessoas;
	}
}
