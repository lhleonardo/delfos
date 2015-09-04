package br.com.estatistica.modelo.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe responsável por representar uma cidade para um determinado endereço.
 * 
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
@Entity
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade", nullable = true)
	private int id;
	private String nome;
	private String descricao;

	@OneToOne
	@Column(name = "id_estado")
	private Estado estado;

	public Cidade(int id, String nome, String descricao, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}

	public Cidade(String nome, String descricao, Estado estado) {
		this.nome = nome;
		this.descricao = descricao;
		this.estado = estado;
	}

	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
