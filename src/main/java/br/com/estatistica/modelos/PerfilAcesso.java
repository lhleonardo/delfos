package br.com.estatistica.modelos;

import java.util.HashMap;
import java.util.Map;

public class PerfilAcesso implements Validador, Identificator {

	private Integer id;
	private String nome;
	private String descricao;

	private Map<Funcionalidade, Boolean> permissoes = new HashMap<Funcionalidade, Boolean>();

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

	public PerfilAcesso() {
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

	public void adicionaPermissao(Funcionalidade funcionalidade, Boolean acesso) {
		funcionalidade.validate();
		this.permissoes.put(funcionalidade, acesso);
	}

	public void setPermissoes(Map<Funcionalidade, Boolean> permissoes) {
		this.permissoes = permissoes;
	}

	public Map<Funcionalidade, Boolean> getPermissoes() {
		return permissoes;
	}

	public boolean possuiPermissao(Funcionalidade funcionalidade) {
		return permissoes.get(funcionalidade);
	}

	@Override
	public void validate() {
		if (this.getNome() == null || this.getDescricao() == null) {
			throw new IllegalArgumentException("Nome e descrição não podem ser nulos.");
		}
	}

	@Override
	public String toString() {

		StringBuffer permissoes = new StringBuffer();

		for (Funcionalidade f : this.getPermissoes().keySet()) {
			System.out.println(f + "\nAcesso: " + this.getPermissoes().get(f) + "\n");
		}

		return "PerfilAcesso (id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", permissões: " + permissoes + ")";
	}

}
