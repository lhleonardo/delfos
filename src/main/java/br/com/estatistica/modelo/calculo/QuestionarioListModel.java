package br.com.estatistica.modelo.calculo;

import java.util.EventListener;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

public class QuestionarioListModel extends AbstractListModel<Questionario> {

	List<Questionario> dados;

	@Override
	public ListDataListener[] getListDataListeners() {
		return super.getListDataListeners();
	}

	@Override
	public Questionario getElementAt(int index) {
		return this.dados.get(index);
	}

	@Override
	public int getSize() {
		return dados.size();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		super.addListDataListener(l);
	}

	@Override
	protected void fireContentsChanged(Object source, int index0, int index1) {
		// TODO Auto-generated method stub
		super.fireContentsChanged(source, index0, index1);
	}

	@Override
	protected void fireIntervalAdded(Object source, int index0, int index1) {
		// TODO Auto-generated method stub
		super.fireIntervalAdded(source, index0, index1);
	}

	@Override
	protected void fireIntervalRemoved(Object source, int index0, int index1) {
		// TODO Auto-generated method stub
		super.fireIntervalRemoved(source, index0, index1);
	}

	@Override
	public <T extends EventListener> T[] getListeners(Class<T> listenerType) {
		// TODO Auto-generated method stub
		return super.getListeners(listenerType);
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		super.removeListDataListener(l);
	}

}
