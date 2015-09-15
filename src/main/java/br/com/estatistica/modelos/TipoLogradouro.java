package br.com.estatistica.modelos;

/**
 * Classe responsável por representar um tipo de logradouro para um determinado endereço.
 *
 * EX: Rua, Avenida, etc.
 *
 * @version 1.0
 * @author Leonardo Braz
 * @since 1.5
 */

public class TipoLogradouro implements Identificator {

	private Integer id;
	private String nome;
	private String descricao;

	public TipoLogradouro(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoLogradouro(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public TipoLogradouro(String nome) {
		this.nome = nome;
	}

	public TipoLogradouro() {
		// TODO Auto-generated constructor stub
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.descricao == null) ? 0 : this.descricao.hashCode());
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		TipoLogradouro other = (TipoLogradouro) obj;
		if (this.descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!this.descricao.equals(other.descricao)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		if (this.nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!this.nome.equals(other.nome)) {
			return false;
		}
		return true;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub

	}

}
