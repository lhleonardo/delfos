package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Tipo_Pergunta;
import br.com.estatistica.util.ConnectionFactory;

public class Tipo_PerguntaTest {

	public static void main (String[] args){
		Connection con = new ConnectionFactory().getConnection();
		try(Tipo_PerguntaDAO tipoperguntaDAO = new Tipo_PerguntaDAO(con)){
			Tipo_Pergunta tipopergunta = new Tipo_Pergunta ("KC oooooooooooo", "kckc teste teste");
			tipoperguntaDAO.insert(tipopergunta);
			}		
		
		catch(SQLException exception){
			
		}
	
}
}
