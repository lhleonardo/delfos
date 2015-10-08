package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.modelos.Questionario;
import br.com.estatistica.modelos.TipoPergunta;
import br.com.estatistica.modelos.TipoCampo;
import br.com.estatistica.util.ConnectionFactory;

public class PerguntTest2 {
	
	public static void main(String[] args){
		
		Connection con = new ConnectionFactory().getConnection();
		TipoPergunta tp1= new TipoPergunta(1, "oi", "des");
		TipoCampo tc1 = new TipoCampo(1,"ola", "oi");
		Questionario q = new Questionario(1);
		PerguntaDAO perguntaDAO = new PerguntaDAO(con);
		Pergunta p1 = new Pergunta ("Nome", "Ola", "Ola", q, tp1, tc1 );
		
		try {
			perguntaDAO.save(p1);
		} catch (SQLException e) {
						e.printStackTrace();
		}
		
	}

		
	}


