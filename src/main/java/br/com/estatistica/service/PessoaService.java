package br.com.estatistica.service;

import br.com.estatistica.dao.SimpleEntityManager;
import br.com.estatistica.modelos.Pessoa;

public class PessoaService extends Service<Pessoa> {

	public PessoaService(SimpleEntityManager manager) {
		super(manager);
	}

	@Override
	protected boolean isNullId(Pessoa object) {
		return object.getId() == null;
	}

}
