package br.com.estatistica.modelo.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe responsável por representar uma determinada formação que determinada pessoa
 * pode possuir.
 * 
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
@Entity
public class Formacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formacao")
	private int id;
	private String nome;
	private String especializacao;

	public Formacao(int id, String nome, String especializacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.especializacao = especializacao;
	}

	public Formacao(String nome, String especializacao) {
		super();
		this.nome = nome;
		this.especializacao = especializacao;
	}

	public Formacao(String nome) {
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

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

}
