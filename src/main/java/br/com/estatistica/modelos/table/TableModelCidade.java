package br.com.estatistica.modelos.table;

import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Cidade;
import br.com.estatistica.modelos.Estado;

/**
 * @author Leonardo Braz
 *
 */
public class TableModelCidade extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Cidade> linhas;
	private String[] colunas = { "Nome", "UF" };

	private static final int COLUNA_NOME = 0;
	private static final int COLUNA_UF = 1;

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.linhas.size();
	}

	@Override
	public String getColumnName(int arg0) {
		return this.colunas[arg0];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case COLUNA_NOME:
				return String.class;
			case COLUNA_UF:
				return Estado.class;
			default:
				throw new IllegalArgumentException("Índice inválido para o array.");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cidade cidade = this.linhas.get(rowIndex);

		switch (columnIndex) {
			case COLUNA_NOME:
				return cidade.getNome();
			case COLUNA_UF:
				return cidade.getEstado().getUf();
			default:
				throw new IllegalArgumentException("Índice inválido para o array.");
		}
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	public void add(Cidade bairro) {
		this.linhas.add(bairro);
		
		int ultimoIndice = this.getRowCount() - 1;
		
		this.fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	public void remove(int rowIndex) {
		this.linhas.remove(rowIndex);
		
		this.fireTableRowsDeleted(rowIndex, rowIndex);
	}
	
	public void addAll(Collection<Cidade> c) {
		int rowCount = this.getRowCount();
		this.linhas.addAll(c);
		this.fireTableRowsInserted(rowCount, rowCount + c.size());
	}
	
	public void clear() {
		this.linhas.clear();
		
		this.fireTableDataChanged();
	}
	
	public Cidade get(int rowIndex) {
		return this.linhas.get(rowIndex);
	}
	
}
