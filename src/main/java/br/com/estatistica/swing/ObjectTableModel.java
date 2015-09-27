package br.com.estatistica.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.el.FieldResolver;
import br.com.estatistica.el.annotation.AnnotationResolver;
import br.com.estatistica.modelos.Identificator;

/**
 * A TableModel based on reflection.
 *
 * @author Marcos Vasconcelos
 */
public class ObjectTableModel<T extends Identificator> extends AbstractTableModel implements Iterable<T> {

	private static final long serialVersionUID = 1L;
	private List<T> data;
	private FieldResolver fields[];
	private boolean editDefault;
	private Boolean editableCol[];
	
	/**
	 * Creates an <code>ObjectTableModel</code> using the specified
	 * <code>AnnotationResolver</code> to resolve the columns.
	 *
	 * @param resolver
	 *            the annotation resolver
	 * @param cols
	 *            columns to be resolved
	 */
	public ObjectTableModel(AnnotationResolver resolver, String cols) {
		this.data = new ArrayList<T>();
		this.fields = resolver.resolve(cols).clone();
		this.editDefault = false;
		this.editableCol = new Boolean[this.fields.length];
	}
	
	/**
	 * Creates an <code>ObjectTableModel</code> using the a AnnotationResolver
	 * created with the clazz param to resolve columns.
	 *
	 * @param clazz
	 *            the clazz of type T
	 * @param cols
	 *            columns to be resolved
	 */
	public ObjectTableModel(Class<T> clazz, String cols) {
		this(new AnnotationResolver(clazz), cols);
	}
	
	/**
	 * Creates an <code>ObjectTableModel</code> using the specified fields.
	 *
	 * @param fields
	 */
	public ObjectTableModel(FieldResolver fields[]) {
		this.data = new ArrayList<T>();
		this.fields = fields.clone();
		this.editDefault = false;
	}
	
	/**
	 * Sets the default condition for cell editing.
	 *
	 * @param editable
	 *            <tt>true</tt> if the cells are editable by default
	 */
	public void setEditableDefault(boolean editable) {
		this.editDefault = editable;
	}
	
	/**
	 * Sets the condition for the specified column's cells editing
	 *
	 * @param col
	 *            the column index
	 * @param editable
	 *            <tt>true</tt> if the cells in specified column are editable by
	 *            default
	 */
	public void setColEditable(int col, boolean editable) {
		this.editableCol[col] = editable;
	}
	
	/**
	 * Returns <tt>true</tt> if the cell at specified row and column is
	 * editable.
	 *
	 * @return <tt>true</tt> if the cell at specified row and column is
	 *         editable.
	 */
	@Override
	public boolean isCellEditable(int i, int k) {
		if (this.editableCol == null || this.editableCol[k] == null) {
			return this.editDefault;
		}
		return this.editableCol[k];
	}
	
	@Override
	public int getColumnCount() {
		return this.fields.length;
	}
	
	@Override
	public int getRowCount() {
		return this.data.size();
	}
	
	/**
	 * Returns the value for the cell at specified row and column.
	 *
	 * @param arg0
	 *            the row whose value is to be queried
	 * @param arg1
	 *            the column whose value is to be queried
	 * @return the value of the specified cell
	 */
	@Override
	public Object getValueAt(int arg0, int arg1) {
		try {
			Object obj = this.data.get(arg0);
			Object obj2 = this.fields[arg1].getValue(obj);
			return obj2;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Sets the value in the cell at specified row and column to <code>value</code>.
	 *
	 * @param value
	 *            the new value
	 * @param arg0
	 *            the row whose value is to be changed
	 * @param arg1
	 *            the column whose value is to be changed
	 */
	@Override
	public void setValueAt(Object value, int arg0, int arg1) {
		try {
			Object obj = this.data.get(arg0);
			this.fields[arg1].setValue(obj, value);
			
			this.fireTableCellUpdated(arg0, arg1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the value object in the specified row index.
	 *
	 * @param arg0
	 *            the row index
	 * @return the value object in the specified row index
	 */
	public T getValue(int arg0) {
		return this.data.get(arg0);
	}
	
	/**
	 * Returns the name of the column at specified column index.
	 *
	 * @return the name of the column at specified column index
	 */
	@Override
	public String getColumnName(int col) {
		return this.fields[col].getName();
	}
	
	/**
	 * Appends a value object to the end of this table model.
	 *
	 * @param obj
	 *            the value to be added
	 */
	public void add(T obj) {
		this.data.add(obj);
		// fireTableDataChanged();
		int lastIndex = this.getRowCount() - 1;
		this.fireTableRowsInserted(lastIndex, lastIndex);
	}
	
	/**
	 * Removes all the values of this table model.
	 */
	public void clear() {
		this.data = new ArrayList<T>();
		this.fireTableDataChanged();
	}
	
	/**
	 * Sets this table model data list.
	 *
	 * @param data
	 *            the data list
	 */
	@SuppressWarnings("unchecked")
	public void setData(List<? extends Identificator> data) {
		this.data = (List<T>) data;
		this.fireTableDataChanged();
	}
	
	/**
	 * Removes the value at the specified row.
	 *
	 * @param row
	 *            the index of the value to be removed
	 */
	public void remove(int row) {
		this.data.remove(row);
		// fireTableDataChanged();
		this.fireTableRowsDeleted(row, row);
	}
	
	/**
	 * Returns this table model data list
	 *
	 * @return this table model data list
	 */
	public List<T> getData() {
		return new ArrayList<T>(this.data);
	}
	
	/**
	 * Removes all the values in the specified rows.
	 *
	 * @param idx
	 *            the rows to be removed
	 */
	public void remove(int idx[]) {
		for (int i = idx.length - 1; i >= 0; i--) {
			this.remove(idx[i]);
		}
	}
	
	/**
	 * Removes from this table model all the values contained in the specified
	 * list.
	 *
	 * @param objs
	 *            the list of values to be removed
	 */
	public void remove(List<T> objs) {
		for (T t : objs) {
			this.remove(this.indexOf(t));
		}
	}
	
	/**
	 * Removes the first occurrence of the specified value from this table
	 * model.
	 *
	 * @param obj
	 *            the value to be removed
	 */
	public void remove(T obj) {
		this.remove(this.indexOf(obj));
	}
	
	/**
	 * Appends all of the values in the specified collection to this table
	 * model.
	 *
	 * @param coll
	 *            collection of values to be added
	 */
	public void addAll(Collection<T> coll) {
		for (T t : coll) {
			this.add(t);
		}
	}
	
	/**
	 * Returns a list containing all the values in the specified rows.
	 *
	 * @param idx
	 *            the rows to be returned in the list
	 * @return the list of values
	 */
	public List<T> getList(int idx[]) {
		List<T> list = new ArrayList<T>();
		int size = idx.length;
		for (int j = 0; j < size; j++) {
			list.add(this.getValue(idx[j]));
		}
		
		return list;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified value in this
	 * table model, or -1 if this model does not contain the value.
	 *
	 * @param obj
	 *            the value to search for
	 * @return the index of the first occurrence of the specified value or -1 if
	 *         it's not found.
	 */
	public int indexOf(T obj) {
		return this.data.indexOf(obj);
	}
	
	/**
	 * Returns <tt>true</tt> if this table model contains no values
	 *
	 * @return <tt>true</tt> if this table model contains no values
	 */
	public boolean isEmpty() {
		return this.data.isEmpty();
	}
	
	/**
	 * Returns the field resolver associated to the specified column.
	 *
	 * @param colIndex
	 *            the column index
	 * @return the field resolver associated to the specified column
	 */
	public FieldResolver getColumnResolver(int colIndex) {
		return this.fields[colIndex];
	}
	
	/**
	 * Returns the column class for all the cell values in the column.
	 *
	 * @param col
	 *            the index of the column
	 * @return the column class
	 */
	@Override
	public Class<?> getColumnClass(int col) {
		return this.getColumnResolver(col).getFieldType();
	}
	
	@Override
	public Iterator<T> iterator() {
		return this.data.iterator();
	}

}