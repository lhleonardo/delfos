package br.com.estatistica.modelo.cadastro;

/**
 * Classe responsável por representar um bairro para um determinado endereço.
 * 
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Bairro {

	private int id;
	private String nome;
	private String descricao;

	public Bairro(int id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Bairro(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Bairro(String nome) {
		super();
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
