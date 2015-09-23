package br.com.estatistica.modelos;

/**
 * Classe responsável por representar um estado de determinada cidade.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */
public class Estado implements Identificator {

	private Integer id;
	private String nome;
	private String descricao;
	private String uf;
	private String codIbge;

	public Estado(int id, String nome, String uf, String descricao, String codIbge) {
		this.id = id;
		this.nome = nome;
		this.codIbge = codIbge;
		this.setUf(uf);
		this.descricao = descricao;
	}

	public Estado(String nome, String uf, String descricao, String codIbge) {
		this.nome = nome;
		this.codIbge = codIbge;
		this.setUf(uf);
		this.descricao = descricao;
	}

	public Estado(String nome, String uf) {
		this.setUf(uf);
		this.setNome(nome);
	}

	public Estado() {
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

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		if (uf.length() <= 3) {
			this.uf = uf;
		} else {
			throw new IndexOutOfBoundsException("Valor inválido para a representação de UF.");
		}
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodIbge() {
		return this.codIbge;
	}

	public void setCodIbge(String codIbge) {
		this.codIbge = codIbge;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void validate() {

	}

}
