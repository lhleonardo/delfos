package br.com.estatistica.modelos;

import java.io.IOException;

import br.com.estatistica.util.ManipuladorDePropriedades;
import br.com.estatistica.util.Mensagem;

/**
 * Classe modelo para as configurações de conexão com o banco de dados, contendo <b>Host,
 * Caminho para o banco de dados, Driver, Usuário e Senha</b> para conexão.
 *
 * @author Leonardo Braz
 * @since 1.6
 * @version 0.1
 *
 */
public class ModeloConexao {
	
	public ManipuladorDePropriedades manipulador;
	
	public ModeloConexao() {
		this.manipulador = new ManipuladorDePropriedades("src/main/resources/delfos.properties");
		
		try {
			this.setCaminhoDatabase(this.manipulador.getProp().getProperty("database.nomeDatabase"));
			this.setDriver(this.manipulador.getProp().getProperty("database.driver"));
			this.setHost(this.manipulador.getProp().getProperty("database.host"));
			this.setUsuario(this.manipulador.getProp().getProperty("database.usuario"));
			this.setSenha(this.manipulador.getProp().getProperty("database.senha"));
		} catch (IOException e) {
			Mensagem.erro(null, e);
		}
	}
	
	/**
	 * Atributo responsável por indicar a localização do servidor onde se encontram o
	 * banco de dados, podendo ser em uma rede local ou externa.
	 *
	 */
	private String host;
	
	/**
	 * Nome do schema do banco de dados.
	 */
	private String nomeDatabase;
	
	/**
	 * Caminho do driver de gerenciamento de determinado banco. <br>
	 * Geralmente é encontrado em uma biblioteca .jar
	 */
	private String driver;
	
	/**
	 * Usuário para a conexão do banco de dados.
	 */
	private String usuario;
	
	/**
	 * Senha para autenticação do usuário no banco de dados.
	 */
	private String senha;
	
	public String getHost() {
		return this.host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getNomeDatabase() {
		return this.nomeDatabase;
	}
	
	public void setCaminhoDatabase(String caminhoDatabase) {
		this.nomeDatabase = caminhoDatabase;
	}
	
	public String getDriver() {
		return this.driver;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
	 * Método responsável por retornar a URL para conexão já formatada, contendo o seu
	 * tipo de conector(JDBC), o host onde se encontra o servidor e o endereço para a
	 * conexão.
	 *
	 * @author Leonardo Braz
	 * @return String
	 * @since 1.4
	 */
	public String getURL() {
		return "jdbc:" + this.getJdbc() + "://" + this.getHost().trim() + '/' + this.getNomeDatabase().trim();
	}
	
	/**
	 * Método responsável por descobrir o tipo de banco a partir da classe de conexão
	 * utilizada pelo driver, sendo MySQL, Firebird, Oracle, etc.
	 *
	 * @since 1.4
	 * @author Leonardo Braz
	 * @return String
	 */
	public String getJdbc() {
		String driver = this.getDriver();
		driver = driver.replace(".", ";");
		String[] valores = driver.split(";");
		
		return this.getJdbcPelaClasseDoDriver(valores);
		
	}
	
	/**
	 * Método responsável por retornar o Jdbc pela classe utilizada pelo Driver, onde é
	 * utilizado pelo método getJdbc.
	 *
	 * @param valores
	 *            que serão informados pelo método getJdbc
	 * @return String
	 * @author Leonardo Braz
	 *
	 */
	private String getJdbcPelaClasseDoDriver(String[] valores) {
		String resultado = null;
		for (String string : valores) {
			string = string.trim();
			if ((string.equals("mysql")) || (string.equals("firebirdsql"))) {
				resultado = string;
			}
		}
		return resultado;
	}
	
}
