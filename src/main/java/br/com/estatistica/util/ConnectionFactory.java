package br.com.estatistica.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.estatistica.modelos.ModeloConexao;
import br.com.estatistica.modelos.Usuario;

/**
 * Classe responsável pelas operações de conexão do banco de dados, como conectar e
 * desconectar.
 * 
 * @author Leonardo Braz
 * @since 1.0
 * @version 1.0
 */
public class ConnectionFactory {

	private static Usuario usuarioConectado = null;

	/**
	 * Classe manipuladora do modelo de conexões, que será responsável por trazer as
	 * informações necessárias para abrir uma conexão com o banco.
	 */
	private ModeloConexao modelo;

	/**
	 * Interface responsável por gerenciar a conexão.
	 * 
	 * @see Connection
	 */
	private Connection con = null;

	/**
	 * Construtor para utilização da classe, recebendo objeto do tipo ModeloConexao
	 * 
	 * @param modelo
	 *            {@link ModeloConexao} com as informações pré-definidas
	 * @author Leonardo Braz
	 * @see ModeloConexao
	 */
	public ConnectionFactory(ModeloConexao modelo) {
		this.modelo = modelo;
	}

	public ConnectionFactory() {
		this.modelo = new ModeloConexao();
	}

	/**
	 * Responsável por realizar a conexão bruta com o banco de dados, retornando um
	 * Connection que já tenha a conexão pronta para uso
	 * 
	 * @return Connection Conexão pronta para ser manipulada.
	 * @author Leonardo Braz
	 */
	public Connection getConnection() {
		try {
			// salva na memória a classe de conexão do conector java
			Class.forName(modelo.getDriver());
			// realiza a conexão recebendo a URL, usuário e senha
			con = DriverManager.getConnection(modelo.getURL(), modelo.getUsuario(), modelo.getSenha());

			System.out.println("Conectado.");

		} catch (SQLException e) {
			// erro SQL
			Mensagem.informa("Não foi possível conectar-se ao banco de dados pelo devido motivo: \n" + e.getMessage());
		} catch (ClassNotFoundException e) {
			// não encontrou a classe do conector
			Mensagem.informa("Não foi possível conectar-se ao banco de dados pois a classe \n" + modelo.getDriver()
			        + " \nnão foi encontrada.");
		}
		return con;

	}

	/**
	 * Responsável por desconectar o banco de dados, recebendo uma conexão
	 * <b>Connection</b> que não esteja nula.
	 * 
	 * @return true para desconectado e false para falha.
	 * @param conexao
	 *            Connection que será fechada
	 * @author Leonardo Braz
	 */
	public boolean desconectar(Connection conexao) {
		boolean resultado = false;
		try {
			if (conexao != null) {
				conexao.close();
				resultado = true;
			}
		} catch (SQLException ex) {
			Mensagem.informa("Não foi possivel desconectar-se ao banco de dados pelo devido motivo: \n" + ex.getMessage());
			resultado = false;
		}
		return resultado;
	}

	public static Usuario getUsuarioConectado() {
		return usuarioConectado;
	}

	public static void setUsuarioConectado(Usuario usuarioConectado) {
		ConnectionFactory.usuarioConectado = usuarioConectado;
	}
}
