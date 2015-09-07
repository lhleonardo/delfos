package br.com.estatistica.service;

import br.com.estatistica.dao.EstadoDAO;
import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelos.Estado;

public class EstadoService extends Service<Estado> {

	public EstadoService(SimpleEntityManager manager) {
		super(manager);
		dao = new EstadoDAO(manager.getEntityManager());
	}

	@Override
	protected boolean isNullId(Estado object) {
		return object.getId() == null;
	}

}
