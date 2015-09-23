package br.com.estatistica.modelos;

public class Tipo_campo implements Identificator{

	private Integer id;
	private String nome;
	private String descricao;

	public Tipo_campo(String nome) {
		this.nome = nome;
	}

	public Tipo_campo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Tipo_campo(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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
	public Integer getId() {
		
		return id;
	}

	@Override
	public void validate() {
		if (this.getId() == null || this.descricao == null) {
			throw new NullPointerException("ID ou Descrição não podem ser  nulos");
		}		
		
		
	}
	

}
