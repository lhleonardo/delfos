package br.com.estatistica.modelos;

/**
 * @author Leonardo Braz
 *
 */
public class Logradouro implements Identificator {

	private Integer id;
	private String nome;
	private String descricao;
	private String sigla;

	public Logradouro(Integer id, String nome, String descricao, String sigla) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public Logradouro(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public Logradouro(String nome, String descricao, String sigla) {
		this.nome = nome;
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	public Logradouro() {
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public void validate() {
		if (this.nome.isEmpty()) {
			throw new IllegalArgumentException("O nome é de preenchimento obrigatório.");
		}

	}
}
