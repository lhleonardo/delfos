package br.com.estatistica.tableModel;

import br.com.estatistica.bean.Formatter;
import br.com.estatistica.el.annotation.Resolvable;
import br.com.estatistica.modelos.Identificator;

public class Pessoa implements Identificator {
	@Resolvable(colName = "Nome")
	private String nome;
	@Resolvable(colName = "Idade", formatter = IntFormatter.class)
	private int idade;
	private Pessoa parent;
	
	public Pessoa(String nome, int idade, Pessoa parent) {
		this.nome = nome;
		this.idade = idade;
		this.parent = parent;
	}
	
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public static class IntFormatter implements Formatter {
		
		@Override
		public String format(Object obj) {
			return Integer.toString((Integer) obj);
		}
		
		@Override
		public String getName() {
			return "int";
		}
		
		@Override
		public Object parse(Object s) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}
	
}
