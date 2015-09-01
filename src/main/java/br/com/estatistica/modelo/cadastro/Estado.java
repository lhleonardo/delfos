package br.com.estatistica.modelo.cadastro;

/**
 * Classe responsável por representar um estado de determinada cidade.
 * 
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Estado {

	private int id;
	private String nome;
	private String uf;
	private String descricao;

	public Estado(int id, String nome, String uf, String descricao) {
		this.id = id;
		this.nome = nome;
		this.setUf(uf);
		this.descricao = descricao;
	}

	public Estado(String nome, String uf, String descricao) {
		this.nome = nome;
		this.setUf(uf);
		this.descricao = descricao;
	}

	public Estado(String nome, String uf) {
		this.setUf(uf);
		this.setNome(nome);
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		if (uf.length() <= 3) {
			this.uf = uf;
		} else {
			throw new IndexOutOfBoundsException("Valor inválido para a representação de UF.");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
