package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


import br.com.estatistica.modelos.Tipo_Pergunta;
import br.com.estatistica.util.ConnectionFactory;

public class Tipo_PerguntaTest {

			private static Tipo_PerguntaDAO dao;
		
		public static void mostraTodosOsRegistros(Connection connection) throws SQLException {
			dao = new Tipo_PerguntaDAO(connection);

			List<Tipo_Pergunta> all = dao.getAll();

			if (!all.isEmpty()) {
				for (Tipo_Pergunta tpergunta : all) {
					System.out.println(tpergunta);
				}
			} else {
				System.out.println("Lista vazia.");
			}
		}

		public static void insereTipoPergunta(Connection connection) throws SQLException {
			dao = new Tipo_PerguntaDAO(connection);

			Tipo_Pergunta tpergunta = new Tipo_Pergunta(2, "Chocolate", "teste");

			Integer chave = dao.save(tpergunta);

			if (chave != null) {
				System.out.println("Registro foi salvo!\nchave: " + chave);
			} else {
				System.out.println("Registro não foi salvo corretamente :/");
			}

		}

		public static void main(String[] args) {
			try {
				Connection connection = new ConnectionFactory().getConnection();
				insereTipoPergunta(connection);
				mostraTodosOsRegistros(connection);
				apagaTipoPerguntaComId(7, connection);
				mostraTodosOsRegistros(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		private static void apagaTipoPerguntaComId(int id, Connection connection) throws SQLException {
		    dao = new Tipo_PerguntaDAO(connection);

			Tipo_Pergunta p = new Tipo_Pergunta();
			p.setId(id);

			boolean delete = dao.delete(p);

			System.out.println("Status de delete: " + delete);
		}

	}

