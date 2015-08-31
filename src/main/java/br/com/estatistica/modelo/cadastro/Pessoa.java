package br.com.estatistica.modelo.cadastro;

import java.util.Date;

/**
 * Classe responsável por modelar as pessoas que serão salvas e manipuladas em funções do
 * software. <br>
 * Algumas classes que estendem de Pessoa: {@code Especialista}, {@code Pessoa}, etc...
 * 
 * @author lhleonardo
 * @version 1.0
 * @since 1.0
 *
 */

public class Pessoa {

	private Integer id;
	private String nome;
	private Documento tipoDocumento;
	private String rg;
	private Date dataNascimento;

	/**
	 * 
	 * Método de inicialização da classe Pessoa
	 * 
	 * @param id
	 *            atributo identificador da pessoa
	 * @param nome
	 *            Nome Completo da Pessoa
	 * @param tipoDocumento
	 *            Tipo de Documento cadastrado na CNP(Cadastro Nacional de Pessoa)
	 * @param rg
	 *            número do RG
	 * @param dataNascimento
	 *            data de nascimento
	 * @param descricao
	 *            descrição da pessoa
	 */
	public Pessoa(String nome, Documento tipoDocumento, String rg, Date dataNascimento, String descricao) {
		super();
		this.nome = nome;
		this.tipoDocumento = tipoDocumento;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.descricao = descricao;
	}

	public Pessoa(Integer id, String nome, Cpf cpf, String rg, Date dataNascimento, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoDocumento = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.descricao = descricao;
	}

	private String descricao;

	/**
	 * Método responsável por retornar a informação:[id] da classe Pessoa.java
	 * 
	 * @return id atributo identificador
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Método responsável por definir um valor para o campo id, sendo informado pelo
	 * parametro id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Método responsável por retornar a informação:[nome] da classe Pessoa.java
	 * 
	 * @return the nome do objeto
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método responsável por definir um valor para o campo nome, sendo informado pelo
	 * parametro nome
	 * 
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método responsável por retornar a informação:[dataNascimento] da classe
	 * Pessoa.java
	 * 
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * Método responsável por definir um valor para o campo dataNascimento, sendo
	 * informado pelo parametro dataNascimento
	 * 
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Método responsável por retornar a informação:[descricao] da classe Pessoa.java
	 * 
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Método responsável por definir um valor para o campo descricao, sendo informado
	 * pelo parametro descricao
	 * 
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Método responsável por retornar a informação:[tipoDocumento] da classe Pessoa.java
	 * 
	 * @return the tipoDocumento
	 */
	public Documento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Método responsável por definir um valor para o campo tipoDocumento, sendo
	 * informado pelo parametro tipoDocumento
	 * 
	 * @param tipoDocumento
	 *            the tipoDocumento to set
	 */
	public void setTipoDocumento(Documento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Método responsável por retornar a informação:[rg] da classe Pessoa.java
	 * 
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * Método responsável por definir um valor para o campo rg, sendo informado pelo
	 * parametro rg
	 * 
	 * @param rg
	 *            the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

}
