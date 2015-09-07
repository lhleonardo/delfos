package br.com.estatistica.service;

import br.com.estatistica.daoHibernate.SimpleEntityManager;
import br.com.estatistica.modelo.cadastro.Pessoa;

public class PessoaService extends Service<Pessoa> {

	public PessoaService(SimpleEntityManager manager) {
		super(manager);
	}

	@Override
	protected boolean isNullId(Pessoa object) {
		return object.getId() == null;
	}

}
