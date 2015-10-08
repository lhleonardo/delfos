package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;




import br.com.estatistica.modelos.TipoPergunta;

import br.com.estatistica.util.ConnectionFactory;

public class Tipo_PerguntaTest {

public static void main(String[] args){
		
		Connection con = new ConnectionFactory().getConnection();
		
		Tipo_PerguntaDAO tpDAO = new Tipo_PerguntaDAO(con);
		TipoPergunta tp1 = new TipoPergunta ("Ola", "Ola" );
		
		try {
			tpDAO.save(tp1);
		} catch (SQLException e) {
						e.printStackTrace();
		}
		
	}

		
	}


