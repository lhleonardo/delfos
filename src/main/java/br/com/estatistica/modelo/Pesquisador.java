package br.com.estatistica.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe responsável por ser um modelador de informações dos <code>Pesquisadores</code>
 * que serão cadastrados no sistema.
 * 
 * @see Pessoa
 * @author Leonardo Braz
 * @since 5.0
 */

public class Pesquisador extends Pessoa {

	public Pesquisador(String nome, Documento tipoDocumento, String rg, Date dataNascimento, String descricao) {

		super(nome, tipoDocumento, rg, dataNascimento, descricao);
	}

}
