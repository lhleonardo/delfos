package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Resposta;
import br.com.estatistica.modelos.Pessoa;
import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.util.ConnectionFactory;

public class RespostaTest {
	
	
public static void main(String[] args){
		
		Connection con = new ConnectionFactory().getConnection();
		RespostaDAO respostaDAO = new RespostaDAO(con);
		Pergunta pergunta1= new Pergunta(1, "Ela", "É", "Feliz");
		Pessoa pessoa1 = new Pessoa(1);
		Resposta resposta1 = new Resposta("Oi", pergunta1, pessoa1, "Qual seu nome");
		
		try {
					respostaDAO.save(resposta1);
				} catch (SQLException e) {
								e.printStackTrace();
		
		
		}
		
	
}}

//}
