package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Especialista;
import br.com.estatistica.modelos.Pesquisador;
import br.com.estatistica.modelos.Pessoa;
import br.com.estatistica.modelos.Usuario;

public class PessoaDAO extends GenericDAO<Pessoa> {
	
	private static final String SQL_INSERT = "INSERT INTO Pessoa(nome, descricao, cpf, rg, e-mail, is_pesquisador,is_especialista,id_endereco,id_usuario) VALUES(?,?,?,?,?,?,?,?,?);";
	private static final String SQL_UPDATE = "UPDATE Pessoa SET nome = ?, descricao = ?, cpf = ?, rg = ?, e-mail = ?, is_pesquisador = ?, is_especialista = ?, id_endereco = ?, id_usuario = ? WHERE id_pessoa = ?";
	private static final String SQL_DELETE = "DELETE FROM Pessoa WHERE id_pessoa = ?";
	private static final String SQL_SELECT = "";
	private EnderecoDAO eDao;
	private UsuarioDAO uDao;
	
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
			pst.setInt(9, this.salvaUsuario(model));
			pst.executeUpdate();
			return super.getGeneratedKeys(pst.getGeneratedKeys());
		}
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	private Integer salvaUsuario(Pessoa model) throws SQLException {
		Usuario user = model.getUsuario();
		if (user != null) {
			user.validate();
			this.uDao = new UsuarioDAO(this.getConnection());
			
			return this.uDao.save(user);
		} else {
			return null;
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
			// TODO pst.setInt(8, atualizaInformacoesDeEndereco());
			// TODO pst.setInt(9, atualizaInformacoesDeUsuario());
			pst.setInt(10, model.getId());
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
		List<Pessoa> pessoas = null;

		try (PreparedStatement pst = super.getConnection().prepareStatement(SQL_SELECT)) {
			// TODO pessoas = new ArrayList<>(new
			// PessoaExtractor().extractAll(pst.executeQuery(), super.getConnection()));
		}

		return pessoas;
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
