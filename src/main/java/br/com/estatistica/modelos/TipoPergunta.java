package br.com.estatistica.modelos;

public class TipoPergunta implements Identificator{

	private Integer id;
	private String nome;
	private String descricao;

	public TipoPergunta(String nome) {
		this.nome = nome;
	}

	public TipoPergunta(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoPergunta(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoPergunta() {

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

	public void validate() {
		if (this.getId() == null || this.nome == null || this.descricao == null) {
			throw new NullPointerException("ID,Nome ou Descrição não podem ser  nulos");
		}		
		
		
		
	}

}
