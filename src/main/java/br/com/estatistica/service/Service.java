package br.com.estatistica.service;

import br.com.estatistica.dao.GenericDAO;
import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.Validador;

public class Service<T extends Validador> {

	@SuppressWarnings("rawtypes")
	protected GenericDAO dao;
	protected SimpleEntityManager manager;

	public Service() {
	}

	@SuppressWarnings("unchecked")
	public void save(T object) {
		try {
			manager.beginTransaction();
			object.validate();
			dao.save(object);
			manager.commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			manager.rollBack();
		}
	}

}