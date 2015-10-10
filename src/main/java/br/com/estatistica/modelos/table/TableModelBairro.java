package br.com.estatistica.modelos.table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Bairro;

/**
 * @author Leonardo Braz
 *
 */
public class TableModelBairro extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Bairro> rows;
	private String[] columns = { "Cód.", "Nome" };

	private static final int CODIGO = 0;
	private static final int NOME = 1;

	public TableModelBairro(List<Bairro> data) {
		this.rows = new ArrayList<Bairro>(data);
	}

	public TableModelBairro() {
		this.rows = new ArrayList<>();
	}

	@Override
	public int getColumnCount() {
		return this.columns.length;
	}

	@Override
	public int getRowCount() {
		return this.rows.size();
	}

	@Override
	public String getColumnName(int column) {
		return this.columns[column];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case CODIGO:
				return Integer.class;
			case NOME:
				return String.class;
			default:
				throw new IndexOutOfBoundsException("Indíce inexistente no array.");
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Bairro bairro = this.rows.get(rowIndex);

		switch (columnIndex) {
			case CODIGO:
				return bairro.getId();
			case NOME:
				return bairro.getNome();
			default:
				throw new IndexOutOfBoundsException("Indíce inexistente no array.");
		}

	}

	public void add(Bairro bairro) {
		this.rows.add(bairro);

		int ultimoIndice = this.getRowCount() - 1;

		this.fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void remove(int rowIndex) {
		this.rows.remove(rowIndex);

		this.fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void addAll(Collection<Bairro> c) {
		int rowCount = this.getRowCount();
		this.rows.addAll(c);
		this.fireTableRowsInserted(rowCount, rowCount + c.size());
	}

	public void clear() {
		this.rows.clear();

		this.fireTableDataChanged();
	}

	public Bairro get(int rowIndex) {
		return this.rows.get(rowIndex);
	}

}
