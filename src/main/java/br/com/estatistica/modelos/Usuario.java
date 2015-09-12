package br.com.estatistica.modelos;

public class Usuario implements Identificator, Validador {

	private Integer id;
	private String login;
	private String senha;
	private String descricao;

	private PerfilAcesso perfilAcesso;

	public Usuario(int id, String login, String senha, String descricao, PerfilAcesso perfilAcesso) {
		this.id = id;
		this.login = login;
		this.descricao = descricao;
		this.perfilAcesso = perfilAcesso;
	}

	public Usuario(String login, String senha, PerfilAcesso perfilAcesso) {
		this.login = login;
		this.perfilAcesso = perfilAcesso;
	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	@Override
	public void validate() {
		if (this.login == null || this.descricao == null || this.perfilAcesso == null) {
			throw new NullPointerException("Login, descrição ou perfil de acesso não podem ser nulo.");
		}
	}

	@Override
	public String toString() {
		return "Código: " + this.getId() + "\nLogin: " + this.getLogin() + "\nPerfil de Acesso: " + this.getPerfilAcesso().getNome();
	}

}
