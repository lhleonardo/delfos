package br.com.estatistica.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.util.ConnectionFactory;

public class BairroTest {

	public static void main(String[] args) {
		try (BairroDAO bDao = new BairroDAO(new ConnectionFactory().getConnection())) {
			Integer pk = inserir(bDao);

			System.out.println("Chave gerada: " + String.valueOf(pk));

			Bairro retornaApenasUm = retornaApenasUm(bDao, pk);

			System.out.println("Registro encontrado pela chave " + pk + ":" + retornaApenasUm);

			retornaTodos(bDao);

			delete(bDao, retornaApenasUm);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void delete(BairroDAO bDao, Bairro retornaApenasUm) throws SQLException {
		bDao.delete(retornaApenasUm);
	}

	private static Bairro retornaApenasUm(BairroDAO bDao, Integer pk) throws SQLException {
		return bDao.get(pk);
	}

	private static Integer inserir(BairroDAO bDao) throws SQLException {
		Bairro bairro = new Bairro("Nova Brasília", "Teste de Bairro");
		return bDao.save(bairro);
	}

	private static void retornaTodos(BairroDAO bDao) throws SQLException {
		List<Bairro> bairros = new ArrayList<Bairro>();
		bairros.addAll(bDao.getAll());

		for (Bairro bairro : bairros) {
			System.out.println(bairro);
		}
	}

}
