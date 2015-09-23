package br.com.estatistica.modelos;

public class TipoCampo implements Identificator{

	private Integer id;
	private String nome;
	private String descricao;

	public TipoCampo(String nome) {
		this.nome = nome;
	}

	public TipoCampo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoCampo(int id, String nome, String descricao) {
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
