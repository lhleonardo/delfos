package br.com.estatistica.bean;

import br.com.estatistica.modelos.Estado;

public class EstadoFormatter implements Formatter {

	@Override
	public Object format(Object obj) {
		Estado estado = (Estado) obj;

		if (estado == null) {
			return "";
		}

		return estado.getUf();
	}

	@Override
	public Object parse(Object s) {
		return null;
	}

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

}
