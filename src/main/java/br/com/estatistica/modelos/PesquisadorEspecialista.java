package br.com.estatistica.modelos;

import java.util.Date;
import java.util.List;

/**
 * @author Leonardo Braz
 *
 */
public class PesquisadorEspecialista extends Pessoa {

	public PesquisadorEspecialista() {
		super();
	}

	public PesquisadorEspecialista(Integer id, String nome, Cpf cpf, String rg, Date dataNascimento, String descricao) {
		super(id, nome, cpf, rg, dataNascimento, descricao);
	}

	public PesquisadorEspecialista(Integer id, String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco,
			List<Formacao> formacoes, List<AreaEstudo> areasEstudo, String descricao) {
		super(id, nome, tipoDocumento, rg, dataNascimento, endereco, formacoes, areasEstudo, descricao);
	}

	public PesquisadorEspecialista(String nome, Documento tipoDocumento, String rg, Date dataNascimento, Endereco endereco,
			List<Formacao> formacoes, List<AreaEstudo> areasEstudo, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, endereco, formacoes, areasEstudo, descricao);
	}

	public PesquisadorEspecialista(String nome, Documento tipoDocumento, String rg, Date dataNascimento, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, descricao);
	}

}
