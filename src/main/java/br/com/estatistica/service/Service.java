package br.com.estatistica.service;

import br.com.estatistica.dao.GenericDAO;
import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.Validador;

public abstract class Service<T extends Validador> {

	@SuppressWarnings("rawtypes")
	protected GenericDAO dao;
	protected SimpleEntityManager manager;

	public Service(SimpleEntityManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("unchecked")
	public void save(T object) {
		try {
			manager.beginTransaction();
			if (isNullId(object)) {
				dao.save(object);
			} else {
				dao.update(object);
			}
			manager.commit();
			manager.close();
		} catch (RuntimeException e) {
			e.printStackTrace();
			manager.rollBack();
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public void delete(T object) {
		try {
			manager.beginTransaction();

			if (isNullId(object)) {
				dao.delete(object);
			}

			manager.commit();
			manager.close();

		} catch (RuntimeException e) {
			e.printStackTrace();
			manager.rollBack();
			manager.close();
		}
	}

	@SuppressWarnings("unchecked")
	public T find(Integer id) {
		manager.beginTransaction();
		T search = (T) dao.getById(id);
		manager.close();
		return search;

	}

	protected abstract boolean isNullId(T object);

}