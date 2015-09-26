package br.com.estatistica.modelos;

/**
 * Classe responsável por representar um bairro para um determinado endereço.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */

public class Bairro implements Identificator {
	
	private Integer id;
	private String nome;
	private String descricao;
	
	public Bairro(Integer id, String nome, String descricao) {
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
	
	public Bairro() {
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public void validate() {
		if (this.nome == null) {
			throw new IllegalArgumentException("O campo nome é de preenchimento obrigatório.");
		}
	}
	
	@Override
	public String toString() {
		return "Bairro (id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao + ")";
	}
	
}
