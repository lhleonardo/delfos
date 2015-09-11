package br.com.estatistica.modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Pesquisa implements Identificator {

	private Integer id;
	private String descricao;
	private Date data;
	private List<Pesquisador> responsaveis;
	private List<Especialista> participantes;
	private int LIMITE_DE_ESPECIALISTAS = 0;

	public Pesquisa(int id, String descricao, Date data, List<Pesquisador> responsaveis, List<Especialista> participantes,
	        int limiteDeEspecialistas) {
		this.id = id;
		this.descricao = descricao;
		this.data = data;
		this.responsaveis = responsaveis;
		this.participantes = participantes;
		this.LIMITE_DE_ESPECIALISTAS = limiteDeEspecialistas;
	}

	public Pesquisa(int id, String descricao, List<Pesquisador> responsaveis, List<Especialista> participantes, int limiteDeEspecialistas) {
		this.id = id;
		this.descricao = descricao;
		this.data = Calendar.getInstance().getTime();
		this.responsaveis = responsaveis;
		this.participantes = participantes;
		this.LIMITE_DE_ESPECIALISTAS = limiteDeEspecialistas;
	}

	public Pesquisa(String descricao, Date data, List<Pesquisador> responsaveis, List<Especialista> participantes) {
		this.descricao = descricao;
		this.data = data;
		this.responsaveis = responsaveis;
		this.participantes = participantes;
	}

	public Pesquisa(String descricao, List<Pesquisador> responsaveis, List<Especialista> participantes) {
		this.descricao = descricao;
		this.data = Calendar.getInstance().getTime();
		this.responsaveis = responsaveis;
		this.participantes = participantes;
	}

	public Pesquisa() {
		this.participantes = new ArrayList<Especialista>();
		this.responsaveis = new ArrayList<Pesquisador>();
		this.data = Calendar.getInstance().getTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Pesquisador> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Pesquisador> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public List<Especialista> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Especialista> participantes) {
		this.participantes = participantes;
	}

	public int getLimiteDeEspecialistas() {
		return this.LIMITE_DE_ESPECIALISTAS;
	}

	public void setLimiteDeEspecialistas(int limite) {
		this.LIMITE_DE_ESPECIALISTAS = limite;
	}


	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
