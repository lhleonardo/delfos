package br.com.estatistica.bean;

import br.com.estatistica.modelos.Logradouro;

public class LogradouroFormatter implements Formatter {
	
	@Override
	public Object format(Object obj) {
		Logradouro tipo = (Logradouro) obj;
		
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
