package br.com.estatistica.modelos;

public class Funcionalidade implements Identificator {

	private Integer id;
	private String nome;
	private String descricao;
	private String chave;

	public Funcionalidade(Integer id, String nome, String descricao, String chave) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.setChave(chave);
	}

	public Funcionalidade(String nome, String descricao, String chave) {
		this.nome = nome;
		this.descricao = descricao;
		this.setChave(chave);
	}

	public <T> Funcionalidade(String nome, String descricao, Class<T> chave) {
		this.nome = nome;
		this.descricao = descricao;
		this.setChave(chave);
	}

	public String getChave() {
		return chave;
	}

	public <T> void setChave(Class<T> classType) {
		this.chave = classType.getSimpleName();
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Funcionalidade() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		if (this.getNome() == null) {
			throw new NullPointerException("O campo Nome é de preenchimento obrigatório.");
		}
	}

	@Override
	public String toString() {
		return "Funcionalidade (id=" + id + ", nome=" + nome + ", descricao=" + descricao + ")";
	}

}
