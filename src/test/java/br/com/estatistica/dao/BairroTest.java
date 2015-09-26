package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Bairro;
import br.com.estatistica.util.ConnectionFactory;

public class BairroTest {

	private static BairroDAO dao;

	public static void mostraTodosOsRegistros(Connection connection) throws SQLException {
		dao = new BairroDAO(connection);

		List<Bairro> all = dao.getAll();

		if (!all.isEmpty()) {
			for (Bairro bairro : all) {
				System.out.println(bairro);
			}
		} else {
			System.out.println("Lista vazia.");
		}
	}

	public static void insereBairro(Connection connection) throws SQLException {
		dao = new BairroDAO(connection);

		Bairro bairro = new Bairro("Primavera", "Bairro muito perigoso.");

		Integer chave = dao.save(bairro);

		if (chave != null) {
			System.out.println("Registro foi salvo!\nchave: " + chave);
		} else {
			System.out.println("Registro não foi salvo corretamente :/");
		}

	}

	public static void main(String[] args) {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			insereBairro(connection);
			mostraTodosOsRegistros(connection);
			apagaBairroComId(7, connection);
			mostraTodosOsRegistros(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void apagaBairroComId(int id, Connection connection) throws SQLException {
		dao = new BairroDAO(connection);

		Bairro b = new Bairro();
		b.setId(id);

		boolean delete = dao.delete(b);

		System.out.println("Status de delete: " + delete);
	}

}
