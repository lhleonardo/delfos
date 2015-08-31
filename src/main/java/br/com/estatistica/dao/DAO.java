package br.com.estatistica.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * Interface responsável por realizar um contrato com as classes que realizarão operações
 * com o banco de dados.<br>
 * Essa interface deverá incluir as operações básicas que o banco pode fazer, tais como
 * salvar, cadastrar, excluir e etc.
 * 
 * @author lhleonardo
 *
 * @param <T>
 *            classe que será manipulada para realizar operações no banco de dados.
 */

public interface DAO<T> {

	/**
	 * Faz a inserção ou atualização na base de dados.
	 * 
	 * @param T
	 *            sendo a classe genérica que será recebida na declaração da interface.
	 * @throws SQLException
	 * @throws <code>RuntimeException</code> se algum problema ocorrer.
	 */
	void save(T modelo) throws SQLException, NullPointerException;

	/**
	 * Exclui o registro na base de dados
	 * 
	 * @param T
	 *            sendo a classe genérica que será recebida na declaração da interface.
	 * @throws <code>RuntimeException</code> se algum problema ocorrer.
	 */
	void remove(T modelo) throws SQLException, NullPointerException;

	/**
	 * Método que retorna todos os registros que estarão presentes na base de dados
	 * 
	 * @return Lista com os registros.
	 * @throws <code>RuntimeException</code> se algum problema ocorrer.
	 */
	List<T> getAll() throws SQLException;

	/**
	 * Método responsável por pesquisar os registros a partir de um nome.
	 * 
	 * @param nome
	 *            Filtro da pesquisa.
	 * @return Lista com filtro em nome.
	 * @throws <code>RuntimeException</code> se algum problema ocorrer.
	 */
	List<T> getByNome(String nome) throws SQLException, NullPointerException;

	/**
	 * Método responsável por pesquisar o registro pelo código.
	 * 
	 * @param id
	 *            filtro da pesquisa.
	 * @return T já com o filtro, caso não encontre nada retorna <code>null</code>.
	 * @throws <code>RuntimeException</code> se algum problema ocorrer.
	 */
	T findById(Integer id) throws SQLException, NullPointerException;

	/**
	 * Inicializa o componente de persistencia.
	 */
	void init();

}
