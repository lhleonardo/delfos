package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.Funcionalidade;
import br.com.estatistica.modelos.ModeloConexao;
import br.com.estatistica.util.ConnectionFactory;

public class FuncionalidadeTest {

	public static void main(String[] args) {
		rodaTeste();
	}

	protected static void rodaTeste() {
		ModeloConexao modelo = new ModeloConexao();

		Connection connection = new ConnectionFactory(modelo).getConnection();

		try (FuncionalidadeDAO fDao = new FuncionalidadeDAO(connection)) {

			// insereFuncionalidade(fDao, 2);

			// excluiFuncionalidade(fDao);

			buscaTodasAsFuncionalidades(fDao);

		} catch (SQLException | RuntimeException e) {

			JOptionPane.showMessageDialog(null, "Algo de errado aconteceu.\nDetalhes: " + e.getMessage());
		}
	}

	private static void buscaTodasAsFuncionalidades(FuncionalidadeDAO fDao) throws SQLException {

		for (Funcionalidade funcionalidade : fDao.getAll()) {
			System.out.println(funcionalidade);
		}

	}

	protected static void insereFuncionalidade(FuncionalidadeDAO fDao, int iteracoes) throws SQLException {

		for (int i = 0; i < iteracoes; i++) {

			Funcionalidade func = new Funcionalidade();
			func.setNome(JOptionPane.showInputDialog("Informe o nome para a funcionalidade: "));
			func.setDescricao(JOptionPane.showInputDialog("Informe a descrição para a funcionalidade: "));
			func.setChave(JOptionPane.showInputDialog("Informe a chave de identificação para a funcionalidade: "));

			JOptionPane.showMessageDialog(null, "Prévia de Registro: \n" + func);

			fDao.save(func);
		}

	}

	protected static void excluiFuncionalidade(FuncionalidadeDAO fDao) throws SQLException {
		Integer id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do registro que será excluído:"));

		System.out.println(id);

		Funcionalidade func = fDao.get(id);

		System.out.println("Funcionalidade: " + func.getId() + '\n' + func.getNome() + '\n' + func.getDescricao());

		System.out.println("Excluíndo determinada funcionalidade do banco...");

		fDao.delete(func);

		boolean exist = !fDao.isExist(func);

		System.out.println("Resultado da exclusão: " + exist);
	}
}
