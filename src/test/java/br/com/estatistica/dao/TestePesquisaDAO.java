package br.com.estatistica.dao;

import java.sql.Connection;



import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.util.ConnectionFactory;

public class TestePesquisaDAO {
	public static void main(String[]args){
		Connection con = new ConnectionFactory().getConnection();
		try (PesquisaDAO pesquisaDAO = new PesquisaDAO(con)){
			
			Pesquisa p1 = new Pesquisa("Pesquisa teste", null, null);
			pesquisaDAO.insert(p1);
		}catch(Exception e){
			
		}
	}

}
