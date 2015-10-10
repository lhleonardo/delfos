package br.com.estatistica.modelos.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Estado;

/**
 * @author lhleonardo
 *
 */
public class TableModelEstado extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Estado> linhas;
	private String[] colunas = { "Cód.", "Nome", "UF", "Cod. IBGE" };

	private static final int CODIGO = 0;
	private static final int NOME = 1;
	private static final int UF = 2;
	private static final int COD_IBGE = 3;

	public TableModelEstado() {
		this.linhas = new ArrayList<Estado>();
	}

	public TableModelEstado(List<Estado> estados) {
		this.linhas = new ArrayList<Estado>(estados);
	}

	@Override
	public int getRowCount() {
		return this.linhas.size();
	}

	@Override
	public int getColumnCount() {
		return this.colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		return this.colunas[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case CODIGO:
				return int.class;
			case NOME:
				return String.class;
			case UF:
				return String.class;
			case COD_IBGE:
				return String.class;
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Estado estado = this.linhas.get(rowIndex);

		switch (columnIndex) {
			case CODIGO:
				return estado.getId();
			case NOME:
				return estado.getNome();
			case UF:
				return estado.getUf();
			case COD_IBGE:
				return estado.getCodIbge();
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}

	}

	public void add(Estado estado) {
		this.linhas.add(estado);

		int ultimoIndice = this.getRowCount() - 1;

		this.fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void remove(int rowIndex) {
		this.linhas.remove(rowIndex);

		this.fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void addAll(Collection<Estado> c) {
		int rowCount = this.getRowCount();
		this.linhas.addAll(c);
		this.fireTableRowsInserted(rowCount, rowCount + c.size());
	}

	public void clear() {
		this.linhas.clear();

		this.fireTableDataChanged();
	}

	public Estado get(int rowIndex) {
		return this.linhas.get(rowIndex);
	}
}
