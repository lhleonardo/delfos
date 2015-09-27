package br.com.estatistica.visao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import br.com.estatistica.bean.DefaultFormatter;
import br.com.estatistica.bean.Formatter;

public class ObjectComboBoxModel<T> implements ComboBoxModel {
	private List<T> data;
	private T selectedItem;
	private Formatter formatter;
	private Map<Object, T> map = new HashMap<Object, T>();

	public ObjectComboBoxModel() {
		this.data = new ArrayList<T>();
		this.formatter = new DefaultFormatter();
	}

	public void setFormatter(Formatter formatter) {
		if (formatter == null) {
			System.out.println("Formatter can't be null. A default one will be set.");
			formatter = new DefaultFormatter();
		}

		this.formatter = formatter;
		this.map.clear();
		for (T t : this.data) {
			this.map.put(formatter.format(t), t);
		}
	}

	public void add(T obj) {
		this.data.add(obj);
		this.map.put(this.formatter.format(obj), obj);
	}

	public void clear() {
		this.data.clear();
		this.map.clear();
	}

	public void setData(List<T> list) {
		this.data = list;
		this.map.clear();
		for (T t : this.data) {
			this.map.put(this.formatter.format(t), t);
		}
	}

	public T getSelectedObject() {
		return this.selectedItem;
	}

	@Override
	public Object getSelectedItem() {
		return this.formatter.format(this.selectedItem);
	}

	@Override
	public void setSelectedItem(Object arg0) {
		this.selectedItem = this.map.get(arg0);
		
	}

	public void setSelectedObject(T obj) {
		this.selectedItem = obj;
	}

	@Override
	public Object getElementAt(int arg0) {
		return this.formatter.format(this.data.get(arg0));
	}

	@Override
	public int getSize() {
		return this.data.size();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
	}
}