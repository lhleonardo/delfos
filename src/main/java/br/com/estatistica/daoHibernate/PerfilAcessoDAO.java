package br.com.estatistica.daoHibernate;

import javax.persistence.EntityManager;

import br.com.estatistica.modelo.cadastro.PerfilAcesso;

public class PerfilAcessoDAO extends GenericDAO<Integer, PerfilAcesso> {

	public PerfilAcessoDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
