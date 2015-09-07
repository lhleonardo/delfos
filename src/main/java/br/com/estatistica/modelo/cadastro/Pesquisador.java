package br.com.estatistica.modelo.cadastro;

import java.util.Date;
import java.util.List;

public class Pesquisador extends Pessoa {

	public Pesquisador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(Integer id, String nome, Cpf cpf, String rg, Date dataNascimento, String descricao) {
		super(id, nome, cpf, rg, dataNascimento, descricao);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(Integer id, String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco,
	        List<Formacao> formacoes, List<AreaEstudo> areasEstudo, String descricao) {
		super(id, nome, tipoDocumento, rg, dataNascimento, endereco, formacoes, areasEstudo, descricao);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco, List<Formacao> formacoes,
	        List<AreaEstudo> areasEstudo, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, endereco, formacoes, areasEstudo, descricao);
		// TODO Auto-generated constructor stub
	}

	public Pesquisador(String nome, Documento tipoDocumento, String rg, Date dataNascimento, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, descricao);
		// TODO Auto-generated constructor stub
	}

}
