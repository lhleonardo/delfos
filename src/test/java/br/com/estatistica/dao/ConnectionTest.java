package br.com.estatistica.dao;

import java.sql.Connection;

import br.com.estatistica.util.ConnectionFactory;

public class ConnectionTest {
	public static void main (String[]args){
		Connection conec = new ConnectionFactory().getConnection();
		PesquisaDAO pesquisa = new PesquisaDAO(conec);
		
	}

}
