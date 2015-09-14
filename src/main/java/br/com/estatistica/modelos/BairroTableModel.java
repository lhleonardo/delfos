package br.com.estatistica.modelos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BairroTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Bairro> linhas;
	private String[] colunas = { "Nome", "Descricao" };

	private static final int NOME = 0;
	private static final int DESCRICAO = 1;

	public BairroTableModel() {
		linhas = new ArrayList<Bairro>();
	}

	public BairroTableModel(List<Bairro> linhas) {
		this.linhas = new ArrayList<Bairro>(linhas);
	}

	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case NOME:
			return String.class;
		case DESCRICAO:
			return String.class;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
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
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Bairro bairro = linhas.get(linha);

		switch (coluna) {
		case NOME:
			return bairro.getNome();
		case DESCRICAO:
			return bairro.getDescricao();
		default:
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("Coluna inexistente.");
		}
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Bairro bairro = linhas.get(rowIndex);

		switch (columnIndex) {
		case NOME:
			bairro.setNome((String) aValue);
			break;
		case DESCRICAO:
			bairro.setDescricao((String) aValue);
			break;
		default:
			// Não deve ocorrer, pois só existem 2 colunas
			throw new IndexOutOfBoundsException("Coluna inexistente.");
		}

		fireTableCellUpdated(rowIndex, columnIndex);

	}

	public Bairro getBairro(int rowIndex) {
		return linhas.get(rowIndex);
	}

	public void addBairro(Bairro bairro) {
		linhas.add(bairro);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	public void removeBairro(int rowIndex) {
		linhas.remove(rowIndex);

		fireTableRowsDeleted(rowIndex, rowIndex);
	}

	public void addAll(List<Bairro> all) {
		int index = getRowCount();

		linhas.addAll(all);

		fireTableRowsInserted(index, index + all.size());
	}

	public void clear() {
		linhas.clear();

		fireTableDataChanged();
	}

}
