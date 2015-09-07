package br.com.estatistica.service;

import br.com.estatistica.daoHibernate.PerfilAcessoDAO;
import br.com.estatistica.daoHibernate.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.PerfilAcesso;

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
