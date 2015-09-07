package br.com.estatistica.dao;

import javax.persistence.EntityManager;

import br.com.estatistica.util.JPAUtil;

public class SimpleEntityManager {

	private EntityManager entityManager = new JPAUtil().getEntityManager();


	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	public void commit() {
		entityManager.getTransaction().commit();
	}

	public void remove(Object object) {
		this.beginTransaction();
		entityManager.remove(object);
		this.commit();
		this.close();
	}

	/**
	 * THIS METHOD NEEDS TO BE ALWAYS CALLED
	 */
	public void close() {
		if (entityManager.isOpen())
			entityManager.close();
	}

	public void rollBack() {
		entityManager.getTransaction().rollback();
		this.close();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
