package br.com.estatistica.extractors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por representar um tipo de extração a partir de uma consulta
 * pré-realizada com o banco de dados.
 * 
 * @author Leonardo Braz
 *
 * @param <T>
 *            Modelo de dados que sofrerá extração para objeto.
 */
public abstract class Extractable<T> {

	/**
	 * Método responsável por extrair um determinado registro do modelo relacional e
	 * criar um objeto com suas informações a partir de seu modelo.
	 * 
	 * @param rs
	 *            ResultSet com os devidos resultados de uma consulta.
	 * @param con
	 *            Conexão válida com o banco de dados.
	 * @return Modelo de Dados já serializado.
	 * @throws SQLException
	 *             caso ocorra algo na extração.
	 */
	public T extract(ResultSet rs, Connection con) throws SQLException {
		if (rs.next()) {
			if (con != null) {
				return this.extractModel(rs, con);
			} else {
				return this.extractModel(rs, null);
			}
		}
		return null;
	}

	/**
	 * Método responsável por realizar totalmente a extração do banco de dados para um
	 * objeto válido. <br>
	 * <br>
	 * Esse método é fundamental para o funcionamento dos métodos públicos de extração.
	 * 
	 * @param rs
	 *            ResultSet com os devidos resultados de uma consulta.
	 * @param con
	 *            Conexão válida com o banco de dados.
	 * @return Modelo de Dados já serializado.
	 * @throws SQLException
	 *             caso ocorra algo na extração.
	 */
	protected abstract T extractModel(ResultSet rs, Connection con) throws SQLException;

	/**
	 * Método responsável por extrair os registros do modelo relacional e criar uma lista
	 * de objetos com suas informações.
	 * 
	 * @param rs
	 *            ResultSet com os devidos resultados de uma consulta.
	 * @param con
	 *            Conexão válida com o banco de dados.
	 * @return Lista de objetos já serializados a partir de seu modelo de dados.
	 * @throws SQLException
	 *             caso ocorra algo na extração.
	 */
	public List<T> extractAll(ResultSet rs, Connection con) throws SQLException {
		List<T> all = new ArrayList<T>();

		while (rs.next()) {
			if (con != null) {
				all.add(extractModel(rs, con));
			} else {
				all.add(extractModel(rs, null));
			}
		}

		return all;
	}
}
