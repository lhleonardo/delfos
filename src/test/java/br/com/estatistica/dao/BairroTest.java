package br.com.estatistica.dao;

import java.sql.SQLException;

import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.util.ConnectionFactory;

public class BairroTest {

	public static void main(String[] args) {
		try (BairroDAO bDao = new BairroDAO(new ConnectionFactory().getConnection())) {
			Bairro bairro = new Bairro();
			bairro.setNome("Cafézinho");
			bairro.setDescricao("Bairro de teste");
			System.out.println(bDao.save(bairro));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
