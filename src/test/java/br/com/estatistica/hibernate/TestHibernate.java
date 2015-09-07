package br.com.estatistica.hibernate;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.estatistica.daoHibernate.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.PerfilAcesso;
import br.com.estatistica.service.PerfilAcessoService;

public class TestHibernate {

	public static void main(String[] args) {
		Map<String, String> properties = getProperties();
		semService(properties);

	}

	private static Map<String, String> getProperties() {
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", "root");
		properties.put("javax.persistence.jdbc.password", "delfos#123");
		return properties;
	}

	private static void comService(Map<String, String> properties) {
		SimpleEntityManager manager = new SimpleEntityManager("delfos", properties);
		PerfilAcessoService service = new PerfilAcessoService(manager);

		PerfilAcesso perfil = new PerfilAcesso("Administrador", "Perfil para administradores do Sistema");

		service.save(perfil);
	}

	private static void semService(Map<String, String> properties) {
		PerfilAcesso acesso = new PerfilAcesso("Administradores", "Perfil para os administradores do sistema");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("delfos", properties);
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.persist(acesso);

		manager.getTransaction().commit();

		manager.close();
	}

}
