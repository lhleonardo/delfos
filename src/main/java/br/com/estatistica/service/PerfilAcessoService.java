package br.com.estatistica.service;

import br.com.estatistica.dao.PerfilAcessoDAO;
import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.PerfilAcesso;

public class PerfilAcessoService extends Service<PerfilAcesso> {

	public PerfilAcessoService(SimpleEntityManager manager) {
		this.manager = manager;
		dao = new PerfilAcessoDAO(manager.getEntityManager());
	}


}
