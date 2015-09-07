package br.com.estatistica.dao;

import javax.persistence.EntityManager;

import br.com.estatistica.modelos.Estado;

public class EstadoDAO extends GenericDAO<Integer, Estado> {

	public EstadoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
