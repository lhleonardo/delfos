package br.com.estatistica.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.util.ConnectionFactory;

public class BairroTest {

	public static void main(String[] args) {
		try (BairroDAO bDao = new BairroDAO(new ConnectionFactory().getConnection())) {

			pesquisar(bDao);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void pesquisar(BairroDAO bDao) throws SQLException {
	    List<Bairro> bairros = bDao.getAll();

	    for (Bairro bairro : bairros) {
	    	System.out.println(bairro.getId() + "\n" + bairro.getNome() + "\n" + bairro.getDescricao());
	    }
    }

}
