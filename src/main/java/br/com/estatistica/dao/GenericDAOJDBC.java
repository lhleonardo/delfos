package br.com.estatistica.dao;

import java.sql.Connection;
import java.util.List;

import br.com.estatistica.modelos.Identificator;

public abstract class GenericDAOJDBC<T extends Identificator> {

	private Connection connection;

	public GenericDAOJDBC(Connection connection) {
		this.connection = connection;
	}

	public abstract void save(T model);

	public abstract void delete(T model);

	public abstract List<T> getAll();

	public abstract T get(T model);

	public abstract boolean isExist(T model);

	public Connection getConnection() {
		return connection;
	}

	@Override
	protected void finalize() throws Throwable {
		if (!this.getConnection().isClosed()) {
			this.connection.close();
		}

		if (this.connection != null) {
			this.connection = null;
		}
		System.gc();
		super.finalize();
	}

}
