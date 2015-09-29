package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;


import br.com.estatistica.modelos.Tipo_Pergunta;
import br.com.estatistica.util.ConnectionFactory;

public class Tipo_PerguntaTest {

	public static void main (String[] args){
		
		Connection con = new ConnectionFactory().getConnection(); 
		Tipo_PerguntaDAO tipop1 = new Tipo_PerguntaDAO(con);
		Tipo_Pergunta tpergunta = new Tipo_Pergunta("ola", "teste");
		try {
			tipop1.insert(tpergunta);
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}

}
