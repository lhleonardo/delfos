package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Pergunta;
import br.com.estatistica.modelos.Questionario;
import br.com.estatistica.modelos.Tipo_Pergunta;
import br.com.estatistica.modelos.Tipo_campo;
import br.com.estatistica.util.ConnectionFactory;

public class PerguntTest2 {
	
	public static void main(String[] args){
		
		Connection con = new ConnectionFactory().getConnection();
		Tipo_Pergunta tp1= new Tipo_Pergunta(1, "oi", "des");
		Tipo_campo tc1 = new Tipo_campo(1,"ola", "oi");
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


