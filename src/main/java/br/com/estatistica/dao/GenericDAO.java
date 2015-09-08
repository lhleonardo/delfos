package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.Identificator;

/**
 * Classe responsável por ser a gerenciadora de todos os DAO's do sistema, estabelecendo
 * um contrato e padrões entre eles.
 * 
 * @author Leonardo Braz
 * @since 1.6
 *
 * @param <T>
 *            Classe do tipo identificadora.
 */
public abstract class GenericDAO<T extends Identificator> implements AutoCloseable {

	private Connection connection;

	/**
	 * Construtor responsável por inicializar a instância de um DAO para determinado
	 * CRUD.
	 * 
	 * @param connection
	 *            conexão válida com o banco de dados
	 */
	public GenericDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método responsável por salvar determinado registro no banco de dados.<br>
	 * O método tem o objetivo de simplificar as operações de inserção e atualização de
	 * dados no banco.
	 * 
	 * @param model
	 *            modelo com as informações que serão salvas. Caso possua identificador
	 *            nulo, será realizado a operação presente no método insert. Caso
	 *            contrário, será atualizado o valor do registro no banco de dados.
	 * @throws SQLException
	 */
	public void save(T model) throws SQLException {
		model.validate();
		if (model.getId() == null) {
			this.insert(model);
		} else {
			this.update(model);
		}

		JOptionPane.showMessageDialog(null, "Salvo com sucesso.");
	}

	protected abstract void insert(T model) throws SQLException;

	protected abstract void update(T model) throws SQLException;

	public abstract void delete(T model) throws SQLException;

	public abstract List<T> getAll() throws SQLException;

	public abstract T get(T model) throws SQLException;

	public abstract T get(Integer idModel) throws SQLException;

	public abstract T get(String value) throws SQLException;

	public abstract boolean isExist(T model) throws SQLException;

	public abstract boolean isExist(Integer idModel) throws SQLException;

	protected void executeBath(List<String> operacoes) throws SQLException {
		if (!operacoes.isEmpty()) {
			try (Statement stmt = this.getConnection().createStatement()) {
				for (String operacao : operacoes) {
					stmt.addBatch(operacao);
				}
				stmt.executeBatch();
				stmt.clearBatch();
			}
		} else {
			throw new IllegalArgumentException("Não é possível adicionar uma lista vazia para a sequência de instruções.");
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void close() throws SQLException {
		if (!this.getConnection().isClosed()) {
			this.connection.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		close();

		if (this.connection != null) {
			this.connection = null;
		}
		System.gc();
		super.finalize();
	}

}
