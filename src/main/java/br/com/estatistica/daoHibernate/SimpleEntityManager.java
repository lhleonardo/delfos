package br.com.estatistica.daoHibernate;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SimpleEntityManager {

	private EntityManager entityManager;
	private EntityManagerFactory factory;

	public SimpleEntityManager(EntityManagerFactory factory, Map<String, String> properties) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager(properties);
	}

	public SimpleEntityManager(String persistenceUnitName, Map<String, String> properties) {
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.entityManager = factory.createEntityManager();
	}

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
		if (factory.isOpen())
			factory.close();
	}

	public void rollBack() {
		entityManager.getTransaction().rollback();
		this.close();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
