package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.estatistica.modelos.Identificator;
import br.com.estatistica.util.Mensagem;

/**
 * Classe responsável por ser a gerenciadora de todos os DAO's do sistema,
 * estabelecendo um contrato e padrões entre eles.
 *
 * @author Leonardo Braz
 * @since 1.6
 *
 * @param <T>
 *            Classe do tipo identificadora, sendo representada pelo modelo de
 *            dados para determinadas operações. <br>
 *            As classes que forem filhas desta deverão informar seu determinado
 *            modelo, afim de que seja genericamente configurado suas operações.
 */
public abstract class GenericDAO<T extends Identificator> implements AutoCloseable {
	
	boolean mostraConfirmacao = true;
	
	private Connection connection;
	
	/**
	 * Construtor responsável por inicializar a instância de um DAO para
	 * determinado CRUD.
	 *
	 * @param connection
	 *            conexão válida com o banco de dados
	 */
	public GenericDAO(Connection connection) {
		this.connection = connection;
	}
	
	/**
	 * Método responsável por <b>salvar</b> determinado registro no banco de
	 * dados.<br>
	 * O método tem o objetivo de simplificar as operações de inserção e
	 * atualização de dados no banco. <br>
	 * <br>
	 * Caso o modelo de dados passado como parâmetro possuir o <i><b>valor
	 * nulo</b></i> em seu identificador, o método realizará a <i><b>operação de
	 * inserção</b></i> de registro no banco de dados. <br>
	 * <br>
	 * Caso contrário, a <i><b>operação de atualização</b></i> do registro no
	 * banco de dados será executada.
	 *
	 * @param model
	 *            modelo com as informações que serão salvas. Caso possua
	 *            identificador nulo, será realizado a operação presente no
	 *            método insert. Caso contrário, será atualizado o valor do
	 *            registro no banco de dados.
	 * @throws SQLException
	 *             caso ocorra algum erro em instruções ao banco de dados.
	 */
	public Integer save(T model) throws SQLException {
		model.validate();
		Integer chavesGeradas = null;
		if (model.getId() == null) {
			chavesGeradas = this.insert(model);
		} else {
			chavesGeradas = this.update(model);
		}
		
		if (this.mostraConfirmacao) {
			Mensagem.informa(null, "Salvo com sucesso.");
		}
		
		return chavesGeradas;
	}
	
	/**
	 * Método auxiliar responsável por realizar a inserção de um determinado
	 * registro informado como parâmetro. <br>
	 * <br>
	 * Para o uso desse método, o valor do <b>identificador</b> deverá vim como
	 * vazio, afim de adicionar um novo registro no banco de dados <br>
	 * <br>
	 * Esses métodos deverão ser sobrescrevidos pelas classes filhas e
	 * <i>configurado com as determinadas regras de negócio</i> para cada tipo
	 * de modelo de dados.
	 *
	 * @param model
	 *            Modelo de dados com as informações que serão inseridas no
	 *            banco.
	 * @throws SQLException
	 *             caso ocorra algum erro em instruções ao banco de dados.
	 *
	 */
	protected abstract Integer insert(T model) throws SQLException;
	
	/**
	 * Método auxiliar responsável por realizar a atualização de determinado
	 * registro existente no banco de dados. <br>
	 * <br>
	 * Para o uso desse método, o valor do <b>identificador</b> não pode ser
	 * nulo, pois a exclusão será feita a partir do mesmo. <br>
	 * <br>
	 * Esses métodos deverão ser sobrescrevidos pelas classes filhas e
	 * <i>configurado com as determinadas regras de negócio</i> para cada tipo
	 * de modelo de dados.
	 *
	 * @param model
	 *            Modelo de dados com as informações que serão atualizadas no
	 *            banco de dados.
	 * @throws SQLException
	 */
	protected abstract Integer update(T model) throws SQLException;
	
	/**
	 * Método auxiliar responsável por realizar a <b>exclusão</b> de determinado
	 * registro existente no banco de dados. <br>
	 * <br>
	 * Para o uso desse método, o valor do <b>identificador</b> não pode ser
	 * nulo, pois a exclusão será feita a partir do mesmo. <br>
	 * <br>
	 * Esses métodos deverão ser sobrescrevidos pelas classes filhas e
	 * <i>configurado com as determinadas regras de negócio</i> para cada tipo
	 * de modelo de dados.
	 *
	 * @param model
	 *            Modelo de dados com as informações que serão atualizadas no
	 *            banco de dados.
	 * @throws SQLException
	 */
	public abstract boolean delete(T model) throws SQLException;
	
	/**
	 * Método responsável por retornar <b>todos</b> os registros no banco de
	 * dados para determinado tipo de <code>Identificator</code> informado na
	 * instância da classe, em ordem crescente de acordo com o seu
	 * <code>Identificator</code>.
	 *
	 * @return Lista com os registros encontrados no banco de dados. <br>
	 *         Caso não seja encontrado nenhum registro, retornará uma lista
	 *         vazia <b>(null).</b>
	 * @throws SQLException
	 */
	public abstract List<T> getAll() throws SQLException;
	
	/**
	 * Método responsável por retornar <b>um registro</b> no banco de dados para
	 * determinado tipo de <code>Identificator</code> informado na instância da
	 * classe, em ordem crescente de acordo com o seu <code>Identificator</code> .
	 *
	 * @param model
	 *            - Modelo de dados que deverá ser pesquisado no banco de dados.
	 * @return Registro encontrado no banco de acordo com o filtro informado por
	 *         parâmetro <br>
	 *         Caso não seja encontrado nenhum registro, retornará uma registro
	 *         vazio <b>(null).</b>
	 * @throws SQLException
	 */
	public abstract List<T> get(T model) throws SQLException;
	
	/**
	 * Método responsável por retornar <b>um registro</b> no banco de dados para
	 * determinado tipo de <code>Identificator</code> informado na instância da
	 * classe, em ordem crescente de acordo com o seu <code>Identificator</code> .
	 *
	 * @param idModel
	 *            Valor do identificador do registro que deverá ser pesquisado,
	 *            onde geralmente é a chave primária do registro.
	 * @return Registro encontrado no banco de acordo com o filtro informado por
	 *         parâmetro <br>
	 *         Caso não seja encontrado nenhum registro, retornará uma registro
	 *         vazio <b>(null).</b>
	 * @throws SQLException
	 */
	public abstract T get(Integer idModel) throws SQLException;
	
	/**
	 * Método responsável por retornar <b>um registro</b> no banco de dados para
	 * determinado tipo de <code>Identificator</code> informado na instância da
	 * classe, em ordem crescente de acordo com o seu <code>Identificator</code> .
	 *
	 * @param value
	 *            Valor para o filtro da pesquisa. Geralmente é aplicado ao
	 *            atributo <b>nome</b> de determinado modelo.
	 * @return Registro encontrado no banco de acordo com o filtro informado por
	 *         parâmetro <br>
	 *         Caso não seja encontrado nenhum registro, retornará uma registro
	 *         vazio <b>(null).</b>
	 * @throws SQLException
	 */
	public abstract List<T> get(String value) throws SQLException;
	
	/**
	 * Método responsável por verificar se determinado registro está presente no
	 * banco de dados.
	 *
	 * @param model
	 *            Modelo de Dados com as informações que serão validadas
	 * @return true ou false caso esteja presente ou não, respectivamente.
	 * @throws SQLException
	 *             caso ocorra algum erro de consulta no banco de dados.
	 */
	public abstract boolean isExist(T model) throws SQLException;
	
	/**
	 * Método responsável por verificar se determinado registro está presente no
	 * banco de dados.
	 *
	 * @param idModel
	 *            valor para o identificador do Modelo de Dados, geralmente
	 *            sendo a chave primária do registro no banco de dados.
	 * @return true ou false caso esteja presente ou não, respectivamente.
	 * @throws SQLException
	 *             caso ocorra algum erro de consulta no banco de dados.
	 */
	public abstract boolean isExist(Integer idModel) throws SQLException;
	
	/**
	 * Método responsável por realizar uma lista de instruções <b>DML(Data
	 * Manipulation Language)</b> no banco de dados. <br>
	 * <br>
	 * As instruções de <b>retorno <i>(select)</i></b> não são permitidas nesse
	 * método.
	 *
	 * @param operacoes
	 *            Lista de instruções que serão executadas.
	 * @throws SQLException
	 *             caso ocorra algum problema na execução das instruções DML.
	 */
	protected void executeBath(List<String> operacoes) throws SQLException {
		if (!operacoes.isEmpty()) {
			try (Statement stmt = this.getConnection().createStatement()) {
				for (String operacao : operacoes) {
					stmt.addBatch(operacao);
				}
				stmt.executeBatch();
				stmt.clearBatch();
			}
		} else {
			throw new IllegalArgumentException("Não é possível adicionar uma lista vazia para a sequência de instruções.");
		}
	}
	
	/**
	 * Método responsável por retornar a chave primária gerada pelo auto
	 * incremento do banco de dados.
	 *
	 * @param keys
	 *            ResultSet de chaves geradas
	 * @param nomeDoCampo
	 *            nome do campo
	 * @return chave primária gerada.
	 * @throws SQLException
	 */
	protected Integer getGeneratedKeys(ResultSet keys) throws SQLException {
		if (keys.next()) {
			return keys.getInt(1);
		}
		return null;
	}
	
	public boolean confereExclusao(Integer id) throws SQLException {
		if (this.isExist(id) == false) {
			if (this.mostraConfirmacao) {
				Mensagem.informa(null, "Excluído com sucesso.");
			}
			return true;
		} else {
			Mensagem.aviso(null, "O registro não foi excluído corretamente, tente novamente mais tarde.");
			return false;
		}
	}
	
	public boolean isMostraConfirmacao() {
		return this.mostraConfirmacao;
	}
	
	public void setMostraConfirmacao(boolean mostraConfirmacao) {
		this.mostraConfirmacao = mostraConfirmacao;
	}
	
	/**
	 * Método responsável por retornar a conexão com o banco de dados atual
	 *
	 * @return conexão ativa com o banco de dados.
	 */
	public Connection getConnection() {
		return this.connection;
	}
	
	/**
	 * Método responsável por fechar todas as conexões com o banco.
	 */
	@Override
	public void close() throws SQLException {
		if (!this.getConnection().isClosed()) {
			this.connection.close();
			System.out.println("Desconectado do banco.");
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		this.close();
		
		if (this.connection != null) {
			this.connection = null;
		}
		System.gc();
		super.finalize();
	}
	
}
