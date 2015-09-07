package br.com.estatistica.service;

import br.com.estatistica.dao.PerfilAcessoDAO;
import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelos.PerfilAcesso;

public class PerfilAcessoService extends Service<PerfilAcesso> {

	public PerfilAcessoService(SimpleEntityManager manager) {
		super(manager);
		dao = new PerfilAcessoDAO(manager.getEntityManager());
	}

	@Override
	protected boolean isNullId(PerfilAcesso object) {
		return object.getId() == null;
	}

}
