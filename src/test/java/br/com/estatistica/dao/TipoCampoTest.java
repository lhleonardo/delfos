package br.com.estatistica.dao;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.estatistica.modelos.Tipo_campo;
import br.com.estatistica.util.ConnectionFactory;

public class TipoCampoTest {
	

	
		public static void main(String[] args){
			
			Connection con = new ConnectionFactory().getConnection(); 
			Tipo_campoDAO pd1 = new Tipo_campoDAO(con);
			Tipo_campo tc1 = new Tipo_campo("oi", "ola");
			try {
				pd1.save(tc1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


}
