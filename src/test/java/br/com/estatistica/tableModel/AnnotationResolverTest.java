package br.com.estatistica.tableModel;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.estatistica.el.annotation.AnnotationResolver;
import br.com.estatistica.visao.ObjectTableModel;

public class AnnotationResolverTest {
	public void show() {
		// Here we create the resolver for annotated classes.
		AnnotationResolver resolver = new AnnotationResolver(Pessoa.class);
		// We use the resolver as parameter to the ObjectTableModel
		// and the String represent the cols.
		ObjectTableModel<Pessoa> tableModel = new ObjectTableModel<Pessoa>(resolver, "nome,idade, parent.nome");
		tableModel.setEditableDefault(true);
		// Here we use the list to be the data of the table.
		tableModel.setData(this.getData());
		
		JTable table = new JTable(tableModel);
		JFrame frame = new JFrame("ObjectTableModel");
		JScrollPane pane = new JScrollPane();
		pane.setViewportView(table);
		pane.setPreferredSize(new Dimension(400, 200));
		frame.add(pane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// Just for create a default List to show.
	private List<Pessoa> getData() {
		List<Pessoa> list = new ArrayList<Pessoa>();
		list.add(new Pessoa("Marky", 17, new Pessoa("Marcos", 40)));
		list.add(new Pessoa("Jhonny", 21));
		list.add(new Pessoa("Douglas", 50, new Pessoa("Adams", 20)));
		return list;
	}
	
	public static void main(String[] args) {
		new AnnotationResolverTest().show();
	}
}