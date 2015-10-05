package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.ConnectionFactory;

public class SavePesquisaTest {
	private static PesquisaDAO pd1;

	public static void main(String[] args){
		Connection con = new ConnectionFactory().getConnection(); 
		pd1 = new PesquisaDAO(con);
		Pesquisa p1 = new Pesquisa("Nome Lixo", "ola", 10);
		try {
			pd1.save(p1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
