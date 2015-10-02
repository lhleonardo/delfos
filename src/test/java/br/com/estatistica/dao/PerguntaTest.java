package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.util.ConnectionFactory;

public class PerguntaTest {
	private static PerguntaDAO dao;

	public static void mostraTodosOsRegistros(Connection connection) throws SQLException {
		dao = new PerguntaDAO(connection);

		List<Pergunta> all = dao.getAll();

		if (!all.isEmpty()) {
			for (Pergunta pergunta : all) {
				System.out.println(pergunta);
			}
		} else {
			System.out.println("Lista vazia.");
		}
	}

	public static void inserePergunta(Connection connection) throws SQLException {
		dao = new PerguntaDAO(connection);

		Pergunta pergunta = new Pergunta(3, "Chocolate", "teste", "teste");

		Integer chave = dao.save(pergunta);

		if (chave != null) {
			System.out.println("Registro foi salvo!\nchave: " + chave);
		} else {
			System.out.println("Registro não foi salvo corretamente :/");
		}

	}

	public static void main(String[] args) {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			inserePergunta(connection);
			mostraTodosOsRegistros(connection);
			apagaPerguntaComId(7, connection);
			mostraTodosOsRegistros(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void apagaPerguntaComId(int id, Connection connection) throws SQLException {
		dao = new PerguntaDAO(connection);

		Pergunta p = new Pergunta();
		p.setId(id);

		boolean delete = dao.delete(p);

		System.out.println("Status de delete: " + delete);
	}

}

