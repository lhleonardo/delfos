package br.com.estatistica.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
public class Pessoa implements Identificator {

	private Integer id;
	private String nome;

	private Documento tipoDocumento;
	private String rg;
	private Date dataNascimento;
	private String descricao;
	private String email;

	private Endereco endereco;

	private Usuario usuario;

	private List<Formacao> formacoes;
	private List<AreaEstudo> areasEstudo;

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

	public Pessoa(Integer id, String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco,
			List<Formacao> formacoes, List<AreaEstudo> areasEstudo, String descricao) {
		this.id = id;
		this.nome = nome;
		this.tipoDocumento = tipoDocumento;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.formacoes = formacoes;
		this.areasEstudo = areasEstudo;
		this.descricao = descricao;
	}

	public Pessoa(String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco, List<Formacao> formacoes,
			List<AreaEstudo> areasEstudo, String descricao) {
		this.nome = nome;
		this.tipoDocumento = tipoDocumento;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.formacoes = formacoes;
		this.areasEstudo = areasEstudo;
		this.descricao = descricao;
	}

	public Pessoa() {
		this.formacoes = new ArrayList<Formacao>();
		this.areasEstudo = new ArrayList<AreaEstudo>();
	}

	/**
	 * Método responsável por retornar a informação:[id] da classe Pessoa.java
	 *
	 * @return id atributo identificador
	 */
	@Override
	public Integer getId() {
		return this.id;
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
		return this.nome;
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
		return this.dataNascimento;
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
		return this.descricao;
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
		return this.tipoDocumento;
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
		return this.rg;
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

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Formacao> getFormacoes() {
		return this.formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public List<AreaEstudo> getAreasEstudo() {
		return this.areasEstudo;
	}

	public void setAreasEstudo(List<AreaEstudo> areasEstudo) {
		this.areasEstudo = areasEstudo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void validate() {
		if (this.getNome() == null || this.getTipoDocumento().getValor() == null) {
			throw new NullPointerException("Informações obrigatórias estáo nulas.");
		}
		this.getEndereco().validate();
	}

}
