package br.com.estatistica.modelos.table;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Pesquisa;





public class TableModelPesquisa extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private List<Pesquisa> linhas;
	private String[] colunas = new String[] { "Nome", "Data" };
	
	private static final int NOME = 0;
	private static final int DATA = 1;
	
	public TableModelPesquisa() {
		this.linhas = new ArrayList<Pesquisa>();
	}
	
	public TableModelPesquisa(List<Pesquisa> listaDePesquisas) {
		this.linhas = new ArrayList<Pesquisa>(listaDePesquisas);
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
			case DATA:
				return Date.class;
			default:
				throw new IndexOutOfBoundsException("Indice Invalido para o Array");
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pesquisa pesquisa = this.linhas.get(rowIndex);
		
		switch (columnIndex) {
			case NOME:
				return pesquisa.getNome();
			case DATA:
				return pesquisa.getData();
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pesquisa pesquisa = this.linhas.get(rowIndex);
		
		switch (columnIndex) {
			case NOME:
				pesquisa.setNome((String) aValue);
				break;
			case DATA:
				pesquisa.setData((Date) aValue);
				break;
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
		this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	// Retorna o sócio referente a linha especificada
	public Pesquisa getSocio(int indiceLinha) {
		return this.linhas.get(indiceLinha);
	}
	
	// Adiciona o sócio especificado ao modelo
	public void addPesquisa(Pesquisa pesquisa) {
		// Adiciona o registro.
		this.linhas.add(pesquisa);
		
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
	public void addListaDePesquisas(List<Pesquisa> pesquisas) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = this.getRowCount();
		
		// Adiciona os registros.
		this.linhas.addAll(pesquisas);
		
		// Notifica a mudança.
		this.fireTableRowsInserted(indice, indice + pesquisas.size());
	}
	
	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de sócios.
		this.linhas.clear();
		
		// Notifica a mudança.
		this.fireTableDataChanged();
	}
	
}
