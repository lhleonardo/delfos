package br.com.estatistica.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estatistica.modelo.cadastro.Estado;

public class TestHibernate {

	public static void main(String[] args) {
		Estado estado = new Estado("Rondônia", "RO");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("delfos");
	    EntityManager manager = factory.createEntityManager();
	    
		manager.persist(estado);
		
		manager.close();
    }

}
