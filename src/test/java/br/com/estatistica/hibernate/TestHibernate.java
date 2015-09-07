package br.com.estatistica.hibernate;

import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelos.Estado;
import br.com.estatistica.service.EstadoService;

public class TestHibernate {

	public static void main(String[] args) {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager();
		EstadoService service = new EstadoService(simpleEntityManager);

		Estado estado = new Estado("Rondônia", "RO");

		service.save(estado);

	}

}
