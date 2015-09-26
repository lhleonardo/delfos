package br.com.estatistica.modelos.table;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Pesquisa;

public class TableModelPesquisa extends AbstractTableModel {
	private List<Pesquisa> linhas;
	private String[] colunas = new String[] {"Nome", "Data"};
	
	private static final int NOME = 0;
	private static final int DATA = 1;
	
	public TableModelPesquisa(){
		linhas = new ArrayList<Pesquisa>();
	}
	
	public TableModelPesquisa(List<Pesquisa> listaDePesquisas){
		linhas = new ArrayList<Pesquisa>(listaDePesquisas);
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return linhas.size();
	}
	
	@Override
	public String getColumnName(int columnIndex){
		return colunas[columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case NOME:
			return String.class;
		case DATA:
			return Date.class;
		default:
			throw new IndexOutOfBoundsException("Indice Invalido para o Array");
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex){
		Pesquisa pesquisa = linhas.get(rowIndex);

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
	public void setValueAt(Object aValue, int rowIndex, int columnIndex){
		Pesquisa pesquisa = linhas.get(rowIndex);

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
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	// Retorna o sócio referente a linha especificada
	public Pesquisa getSocio(int indiceLinha) {
	    return linhas.get(indiceLinha);
	}
	 
	// Adiciona o sócio especificado ao modelo
	public void addPesquisa(Pesquisa pesquisa) {
	    // Adiciona o registro.
	    linhas.add(pesquisa);
	 
	    // Pega a quantidade de registros e subtrai 1 para
	    // achar o último índice. A subtração é necessária
	    // porque os índices começam em zero.
	    int ultimoIndice = getRowCount() - 1;
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	 
	// Remove o sócio da linha especificada.
	public void removePesquisa(int indiceLinha) {
	    // Remove o registro.
	    linhas.remove(indiceLinha);
	 
	    // Notifica a mudança.
	    fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	 
	// Adiciona uma lista de sócios no final da lista.
	public void addListaDePesquisas(List<Pesquisa> pesquisas) {
	    // Pega o tamanho antigo da tabela, que servirá
	    // como índice para o primeiro dos novos registros
	    int indice = getRowCount();
	 
	    // Adiciona os registros.
	    linhas.addAll(pesquisas);
	 
	    // Notifica a mudança.
	    fireTableRowsInserted(indice, indice + pesquisas.size());
	}
	 
	// Remove todos os registros.
	public void limpar() {
	    // Remove todos os elementos da lista de sócios.
	    linhas.clear();
	 
	    // Notifica a mudança.
	    fireTableDataChanged();
	}
	
	
	

}
