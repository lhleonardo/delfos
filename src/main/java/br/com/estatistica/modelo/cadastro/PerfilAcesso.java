package br.com.estatistica.modelo.cadastro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PerfilAcesso implements Validador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil_acesso")
	private Integer id;
	private String nome;
	private String descricao;

	public PerfilAcesso(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public PerfilAcesso(String nome) {
		this.nome = nome;
	}

	public PerfilAcesso(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getId() {
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

	@Override
	public void validate() {
		if (this.getNome() == null || this.getDescricao() == null) {
			throw new IllegalArgumentException("Nome e descrição não podem ser nulos.");
		}
	}

}
