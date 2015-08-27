package br.com.estatistica.modelo.calculo;

import javax.swing.table.AbstractTableModel;

public class QuestionarioTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1832655764925814644L;

	// Questionário que conterá as perguntas
	private Questionario questionario;
	// colunas da tabela
	private String[] colunas = { "Pergunta", "Resposta", "Valor_Alto", "Valor_Médio", "Valor_baixo" };

	/**
	 * Método responsável por retornar o nome da coluna
	 * 
	 * @param index
	 *            indice da coluna
	 */
	@Override
	public String getColumnName(int index) {
		return colunas[index];
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return questionario.getSizePerguntas();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0:
				
			default:
				return null;
		}
	}

}
