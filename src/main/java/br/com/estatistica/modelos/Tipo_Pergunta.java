package br.com.estatistica.modelos;

public class Tipo_Pergunta implements Identificator{

	private Integer id;
	private String nome;
	private String descricao;

	public Tipo_Pergunta(String nome) {
		this.nome = nome;
	}

	public Tipo_Pergunta(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public Tipo_Pergunta(int id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Tipo_Pergunta() {

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
		if ( this.nome == null || this.descricao == null) {
			throw new NullPointerException("Nome ou Descrição não podem ser  nulos");
		}		
		
		
		
	}

}
