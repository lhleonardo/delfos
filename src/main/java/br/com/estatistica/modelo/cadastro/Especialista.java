package br.com.estatistica.modelo.cadastro;

import java.util.Date;
import java.util.List;

public class Especialista extends Pessoa {

	public Especialista(String nome, Documento tipoDocumento, String rg, Date dataNascimento, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, descricao);
	}

	public Especialista(Integer id, String nome, Cpf cpf, String rg, Date dataNascimento, String descricao) {
		super(id, nome, cpf, rg, dataNascimento, descricao);
	}

	public Especialista(Integer id, String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco,
	        List<Formacao> formacoes, List<AreaEstudo> areasEstudo, String descricao) {
		super(id, nome, tipoDocumento, rg, dataNascimento, endereco, formacoes, areasEstudo, descricao);
	}

	public Especialista(String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco, List<Formacao> formacoes,
	        List<AreaEstudo> areasEstudo, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, endereco, formacoes, areasEstudo, descricao);
	}

	public Especialista() {
	}

}
