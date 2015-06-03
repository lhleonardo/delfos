package br.com.estatistica.modelo_hibernate;

import java.util.Date;

import br.com.estatistica.modelo.Documento;

/**
 * Classe responsável por ser um modelador de informações dos Especialistas que serão
 * cadastrados no sistema.
 * 
 * @see PessoaHib
 * @version 1.0
 * @author Leonardo Braz - lhleonardo@hotmail.com
 * @since 3.0
 */

public class EspecialistaHib extends PessoaHib {

	public EspecialistaHib(String nome, Documento tipoDocumento, String rg, Date dataNascimento, String descricao) {
		super(nome, tipoDocumento, rg, dataNascimento, descricao);
	}

}
