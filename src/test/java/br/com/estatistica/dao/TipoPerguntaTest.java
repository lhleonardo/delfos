package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.TipoPergunta;
import br.com.estatistica.util.ConnectionFactory;

public class TipoPerguntaTest {
	
	public static void main(String[] args){
		
		Connection con = new ConnectionFactory().getConnection(); 
		Tipo_PerguntaDAO tp1 = new Tipo_PerguntaDAO(con);
		TipoPergunta tc1 = new TipoPergunta("oi", "ola");
		try {
			tp1.save(tc1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
