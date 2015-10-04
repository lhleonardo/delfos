package br.com.estatistica.modelos.table;

import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.modelos.Resposta;

public class TableModelResposta {
	private static final long serialVersionUID = 1L;

	private List<Resposta> linhas;
	private String[] colunas = new String[] { "Nome", "Descrição", "Data" };

	private static final int NOME = 0;
	private static final int DESCRICAO = 1;
	private static final int OBSERVACAO = 2;

	public TableModelResposta() {
		this.linhas = new ArrayList<Resposta>();
	}

	public TableModelResposta(List<Resposta> listaDeResposta) {
		this.linhas = new ArrayList<Resposta>(listaDeResposta);
	}

	public int getColumnCount() {
		return this.colunas.length;
	}

	public int getRowCount() {
		return this.linhas.size();
	}

	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case NOME:
				return String.class;
			case DESCRICAO:
				return String.class;
			case OBSERVACAO:
				return String.class;
			default:
				throw new IndexOutOfBoundsException("Indice Invalido para o Array");
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Resposta resposta = this.linhas.get(rowIndex);

		switch (columnIndex) {
			case NOME:
				return resposta.getNome();
			case DESCRICAO:
				return resposta.getDescricao();
			case OBSERVACAO:
				return resposta.getObservacao();
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Resposta resposta = this.linhas.get(rowIndex);

		switch (columnIndex) {
			case NOME:
				resposta.setNome((String) aValue);
				break;
			case DESCRICAO:
				resposta.setNome((String) aValue);
				break;
			case OBSERVACAO:
				resposta.setObservacao((String) aValue);
				break;
			default:
				throw new IndexOutOfBoundsException("Indice da coluna nao existe");
		}
		this.fireTableCellUpdated(rowIndex, columnIndex);
	}

	private void fireTableCellUpdated(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	// Retorna o sócio referente a linha especificada
	public Resposta getResposta(int indiceLinha) {
		return this.linhas.get(indiceLinha);
	}

	// Adiciona o sócio especificado ao modelo
	public void addResposta(Resposta resposta) {
		// Adiciona o registro.
		this.linhas.add(resposta);

		// Pega a quantidade de registros e subtrai 1 para
		// achar o último índice. A subtração é necessária
		// porque os índices começam em zero.
		int ultimoIndice = this.getRowCount() - 1;

		// Notifica a mudança.
		this.fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

	private void fireTableRowsInserted(int ultimoIndice, int ultimoIndice2) {
		// TODO Auto-generated method stub

	}

	// Remove o sócio da linha especificada.
	public void removeResposta(int indiceLinha) {
		// Remove o registro.
		this.linhas.remove(indiceLinha);

		// Notifica a mudança.
		this.fireTableRowsDeleted(indiceLinha, indiceLinha);
	}

	private void fireTableRowsDeleted(int indiceLinha, int indiceLinha2) {
		// TODO Auto-generated method stub

	}

	// Adiciona uma lista de sócios no final da lista.
	public void addListaDeRespostas(List<Resposta> respostas) {
		// Pega o tamanho antigo da tabela, que servirá
		// como índice para o primeiro dos novos registros
		int indice = this.getRowCount();

		// Adiciona os registros.
		this.linhas.addAll(respostas);

		// Notifica a mudança.
		this.fireTableRowsInserted(indice, indice + respostas.size());
	}

	// Remove todos os registros.
	public void limpar() {
		// Remove todos os elementos da lista de sócios.
		this.linhas.clear();

		// Notifica a mudança.
		this.fireTableDataChanged();
	}

	private void fireTableDataChanged() {
		// TODO Auto-generated method stub

	}
}
