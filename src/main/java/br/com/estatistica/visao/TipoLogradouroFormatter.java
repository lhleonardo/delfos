package br.com.estatistica.visao;

import br.com.estatistica.bean.Formatter;
import br.com.estatistica.modelos.TipoLogradouro;

public class TipoLogradouroFormatter implements Formatter {

	@Override
	public Object format(Object obj) {
		TipoLogradouro tipo = (TipoLogradouro) obj;

		return (tipo == null) ? null : tipo.getSigla();
	}

	@Override
	public Object parse(Object s) {
		return null;
	}

	@Override
	public String getName() {
		return "logradouro";
	}

}
