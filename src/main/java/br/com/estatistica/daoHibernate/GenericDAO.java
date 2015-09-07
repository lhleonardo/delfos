package br.com.estatistica.daoHibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings("unchecked")
public class GenericDAO<PrimaryKey, Target> {
	private EntityManager entityManager;

	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Target getById(PrimaryKey pk) {
		return (Target) entityManager.find(getTypeClass(), pk);
	}

	public void save(Target entity) {
		entityManager.persist(entity);
	}

	public void update(Target entity) {
		entityManager.merge(entity);
	}

	public void delete(Target entity) {
		entityManager.remove(entity);
	}

	public List<Target> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}

	public void setEntityManager(EntityManager manager) {
		this.entityManager = manager;
	}
}
