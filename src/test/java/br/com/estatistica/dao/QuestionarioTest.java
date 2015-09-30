package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;


import br.com.estatistica.modelos.Questionario;
import br.com.estatistica.util.ConnectionFactory;

public class QuestionarioTest {
	Connection con = new ConnectionFactory().getConnection(); 
	QuestionarioDAO pd1 = new QuestionarioDAO(con);
	Questionario q1 = new Questionario("Nome Lixo", "ola");{
	try {
		pd1.save(q1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
