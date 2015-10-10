package br.com.estatistica.dialog;

import java.sql.SQLException;
import java.util.List;

import br.com.estatistica.modelos.Estado;
import br.com.estatistica.util.ConnectionFactory;
import br.com.estatistica.visao.FrmConsultaEstado;

/**
 * @author Leonardo Braz
 *
 */
public class TestConsultaEstado {
	
	public static void main(String[] args) {
		try {
			FrmConsultaEstado frame = new FrmConsultaEstado(null, new ConnectionFactory().getConnection());
			if (frame.execute()) {
				List<Estado> selecionadas = frame.getSelecionadas();
				selecionadas.forEach(System.out::println);
			}
		} catch (SQLException ex) {
			// TODO Implementar o tratamento de exceções
			ex.printStackTrace();
		}
	}

}
