package br.com.estatistica.modelos.table;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.estatistica.modelos.Pergunta;


public class TableModelPergunta extends AbstractTableModel{
private static final long serialVersionUID = 1L;
	
	private List<Pergunta> linhas;
	private String[] colunas = new String[] { "Pergunta","Descrição","Observação","Tipo de Pergunta" };
	
	private static final int PERGUNTA = 0;
	private static final int DESCRICAO = 1;
	private static final int OBSERVACAO = 2;
	private static final int TIPODEPERGUNTA = 3;
	
	
	public TableModelPergunta() {
		this.linhas = new ArrayList<Pergunta>();
	}
	
	public TableModelPergunta(List<Pergunta> listaDePergunta) {
		this.linhas = new ArrayList<Pergunta>(listaDePergunta);
	}
	@Override
	public int getColumnCount() {
		return this.colunas.length;
		
	}

	@Override
	public int getRowCount() {
		return this.linhas.size();
		
	}
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case PERGUNTA:
				return String.class;
			case DESCRICAO:
				return String.class;
			case OBSERVACAO:
				return String.class;
			case TIPODEPERGUNTA:
				return String.class;
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
		Pergunta pergunta = this.linhas.get(rowIndex);
		
		switch (columnIndex) {
			case PERGUNTA:
				return pergunta.getNome();
			case DESCRICAO:
				return pergunta.getDescricao();
			case OBSERVACAO:
				return pergunta.getObservacao();
			case TIPODEPERGUNTA:
				return pergunta.getTipoPergunta();
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pergunta pergunta = this.linhas.get(rowIndex);
		
		switch (columnIndex) {
			case PERGUNTA:
				pergunta.setNome((String) aValue);
				break;
			case DESCRICAO:
				pergunta.setDescricao((String) aValue);
				break;
			case OBSERVACAO:
				pergunta.setObservacao((String) aValue);
				break;
			case TIPODEPERGUNTA:
				pergunta.setTipoPergunta ((String)aValue);
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
		this.fireTableCellUpdated(rowIndex, columnIndex);
	}
	
	// Retorna o sócio referente a linha especificada
	public Pergunta getPergunta(int indiceLinha) {
		return this.linhas.get(indiceLinha);
	}
	
	// Adiciona o sócio especificado ao modelo
	
	public void addPergunta(Pergunta pergunta) {
		
		// Adiciona o registro.
		
		this.linhas.add(pergunta);
		
		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = this.getRowCount() - 1;
		
		// Notifica a mudança.
		this.fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}
	
	// Remove o sócio da linha especificada.
	public void removePergunta(int indiceLinha) {
		// Remove o registro.
		this.linhas.remove(indiceLinha);
		
		// Notifica a mudança.
		this.fireTableRowsDeleted(indiceLinha, indiceLinha);
	}
	
	// Adiciona uma lista de sócios no final da lista.
	public void addListaDePergunta(List<Pergunta> perguntas) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = this.getRowCount();
		
		// Adiciona os registros.
		this.linhas.addAll(perguntas);
		
		// Notifica a mudança.
		this.fireTableRowsInserted(indice, indice + perguntas.size());
	}
	
	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de sócios.
		this.linhas.clear();
		
		// Notifica a mudança.
		this.fireTableDataChanged();
	}
 	

}
