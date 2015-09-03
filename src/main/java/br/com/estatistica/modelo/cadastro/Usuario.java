package br.com.estatistica.modelo.cadastro;


public class Usuario {

	private int id;
	private String login;
	private String descricao;

	private PerfilAcesso perfilAcesso;

	private Pessoa pessoa;

	public Usuario(int id, String login, String descricao, PerfilAcesso perfilAcesso, Pessoa pessoa) {
		this.id = id;
		this.login = login;
		this.descricao = descricao;
		this.perfilAcesso = perfilAcesso;
		this.pessoa = pessoa;
	}

	public Usuario(String login, PerfilAcesso perfilAcesso, Pessoa pessoa) {
		this.login = login;
		this.perfilAcesso = perfilAcesso;
		this.pessoa = pessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PerfilAcesso getPerfilAcesso() {
		return perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
