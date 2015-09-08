package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.Funcionalidade;
import br.com.estatistica.modelos.ModeloConexao;
import br.com.estatistica.util.ConnectionFactory;

public class FuncionalidadeTest {

	public static void main(String[] args) {

		// Funcionalidade func = new Funcionalidade("Cadastro de Usuario",
		// "Cadastrar usuários que estarão logados no sistema");

		ModeloConexao modelo = new ModeloConexao();

		Connection connection = new ConnectionFactory(modelo).getConnection();

		try (FuncionalidadeDAO fDao = new FuncionalidadeDAO(connection)) {

			// fDao.save(func);

			Scanner scanner = new Scanner(System.in);

			System.out.println("Informe o ID da funcionalidade:");

			Integer id = scanner.nextInt();

			System.out.println(id);

			 Funcionalidade func = fDao.get(id);

			System.out.println("Funcionalidade: " + func.getId() + '\n' + func.getNome() + '\n' +
			 func.getDescricao());

			// JOptionPane.showMessageDialog(null, func);

		} catch (SQLException | RuntimeException e) {

			JOptionPane.showMessageDialog(null, "Algo de errado aconteceu.\nDetalhes: " + e.getMessage());
		}

	}
}
