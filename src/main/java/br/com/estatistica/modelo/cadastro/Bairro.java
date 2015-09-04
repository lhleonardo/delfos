package br.com.estatistica.modelo.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe responsável por representar um bairro para um determinado endereço.
 * 
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */

@Entity
// cria persistencia de entidade para a tabela bairro
public class Bairro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bairro")
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
