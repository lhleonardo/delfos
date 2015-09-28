package br.com.estatistica.modelos.table;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Pesquisa;
import br.com.estatistica.modelos.Questionario;

public class TableModelQuestionario extends AbstractTableModel {
private static final long serialVersionUID = 1L;
	
	private List<Questionario> linhas;
	private String[] colunas = new String[] { "Nome","Descrição","Tema" };
	
	private static final int NOME = 0;
	private static final int DESCRICAO = 1;
	private static final int TEMA = 2;
	
	public TableModelQuestionario() {
		this.linhas = new ArrayList<Questionario>();
	}
	
	public TableModelQuestionario(List<Questionario> listaDePesquisas) {
		this.linhas = new ArrayList<Questionario>(listaDePesquisas);
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.linhas.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case NOME:
				return String.class;
			case DESCRICAO:
				return String.class;
			case TEMA:
				return String.class;
			default:
				throw new IndexOutOfBoundsException("Indice Invalido para o Array");
		}
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Questionario questionario = this.linhas.get(rowIndex);
		
		switch (columnIndex) {
			case NOME:
				return questionario.getNome();
			case DESCRICAO:
				return questionario.getDescricao();
			case TEMA:
				return questionario.getTema().getNome();
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Questionario questionario = this.linhas.get(rowIndex);
		
		switch (columnIndex) {
			case NOME:
				questionario.setNome((String) aValue);
				break;
			case DESCRICAO:
				questionario.setDescricao((String) aValue);
				break;
			case TEMA:
				questionario.getTema().setNome((String) aValue);
				break;
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
		this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	// Retorna o sócio referente a linha especificada
	public Questionario getPesquisa(int indiceLinha) {
		return this.linhas.get(indiceLinha);
	}
	
	// Adiciona o sócio especificado ao modelo
	public void addPesquisa(Questionario questionario) {
		// Adiciona o registro.
		this.linhas.add(questionario);
		
		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = this.getRowCount() - 1;
		
		// Notifica a mudança.
		this.fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	// Remove o sócio da linha especificada.
	public void removePesquisa(int indiceLinha) {
		// Remove o registro.
		this.linhas.remove(indiceLinha);
		
		// Notifica a mudança.
		this.fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	// Adiciona uma lista de sócios no final da lista.
	public void addListaDePesquisas(List<Questionario> questionarios) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = this.getRowCount();
		
		// Adiciona os registros.
		this.linhas.addAll(questionarios);
		
		// Notifica a mudança.
		this.fireTableRowsInserted(indice, indice + questionarios.size());
	}
	
	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de sócios.
		this.linhas.clear();
		
		// Notifica a mudança.
		this.fireTableDataChanged();
	}

}
