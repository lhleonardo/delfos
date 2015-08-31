package br.com.estatistica.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.estatistica.modelo.cadastro.Cpf;
import br.com.estatistica.modelo.cadastro.Pesquisador;

/**
 * Classe responsável por fazer a extração dos dados presentes no banco e tranformá-los
 * em objetos
 * 
 * @author lhleonardo - Leonardo Braz
 * @since 1.4
 */
public class PesquisadorExtractor {

	/**
	 * Método que extrai as informações de um pesquisador no Banco de Dados e transforma
	 * em um objeto manipulável
	 * 
	 * @param rs
	 *            resultado de pesquisa de query
	 * @return Pesquisador pré moldado com as informações do banco de dados.
	 * @throws SQLException
	 *             para erro de consulta
	 */
	public Pesquisador extract(ResultSet rs) throws SQLException {
		int id = rs.getInt("idPesquisador");
		String nome = rs.getString("nome");
		Cpf cpf = new Cpf(rs.getString("cpf"));
		String rg = rs.getString("rg");
		Date dataNascimento = rs.getDate("dataNascimento");
		String descricao = rs.getString("descricao");

		return new Pesquisador(id, nome, cpf, rg, dataNascimento, descricao);
	}

	/**
	 * Método que realiza as mesmas operações do <code>extract</code>, entretanto é
	 * utilizado para mais de uma extração de informações ao banco de dados
	 * 
	 * @param rs
	 * @return Lista de pesquisadores
	 * @throws SQLException
	 */
	public List<Pesquisador> extractAll(ResultSet rs) throws SQLException {
		List<Pesquisador> resultado = new ArrayList<Pesquisador>();

		while (rs.next()) {
			resultado.add(this.extract(rs));
		}

		return resultado;
	}
}
