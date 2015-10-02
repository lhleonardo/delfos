package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Tipo_Pergunta;
import br.com.estatistica.util.ConnectionFactory;

public class TipoPerguntaTest {
	
	public static void main(String[] args){
		
		Connection con = new ConnectionFactory().getConnection(); 
		Tipo_PerguntaDAO tp1 = new Tipo_PerguntaDAO(con);
		Tipo_Pergunta tc1 = new Tipo_Pergunta("oi", "ola");
		try {
			tp1.save(tc1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
