package br.com.estatistica.service;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.Estado;

public class EstadoService extends Service<Estado> {

	public EstadoService(SimpleEntityManager manager) {
		this.manager = manager;
		dao = new EstadoDAO(manager.getEntityManager());
	}

	public static void main(String[] args) {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("delfos");
		EstadoService service = new EstadoService(simpleEntityManager);

		Estado estado = new Estado("asdfasdfasdfasdfasdfasd", "asdf");

		service.save(estado);

		simpleEntityManager.close();
	}
}
