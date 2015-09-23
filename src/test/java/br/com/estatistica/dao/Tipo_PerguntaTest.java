package br.com.estatistica.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.estatistica.modelos.TipoPergunta;
import br.com.estatistica.modelos.ModeloConexao;
import br.com.estatistica.util.ConnectionFactory;

public class Tipo_PerguntaTest {

public static void main(String[] args) {
	rodaTeste();
}

protected static void rodaTeste() {
	ModeloConexao modelo = new ModeloConexao();

	Connection connection = new ConnectionFactory(modelo).getConnection();

	try (Tipo_PerguntaDAO tpDao = new Tipo_PerguntaDAO(connection)) {

		// insereTipo_Pergunta(tpDao, 2);

		// excluiTipo_Pergunta(tpDao);

		buscaTodosOsTiposdePergunta(tpDao);

	} catch (SQLException | RuntimeException e) {

		JOptionPane.showMessageDialog(null, "Algo de errado aconteceu.\nDetalhes: " + e.getMessage());
	}
}

private static void buscaTodosOsTiposdePergunta(Tipo_PerguntaDAO tpDao) throws SQLException {

	for (TipoPergunta tipopergunta : tpDao.getAll()) {
		System.out.println(tipopergunta);
	}

}

protected static void insereTipoPergunta(Tipo_PerguntaDAO tpDao, int iteracoes) throws SQLException {

	for (int i = 0; i < iteracoes; i++) {

		TipoPergunta tipopergunta = new TipoPergunta();
		tipopergunta.setNome(JOptionPane.showInputDialog("Informe o nome para o tipo de pergunta: "));
		tipopergunta.setDescricao(JOptionPane.showInputDialog("Informe a descrição para ao tipo de pergunta: "));
		
		JOptionPane.showMessageDialog(null, "Prévia de Registro: \n" + tipopergunta);

		tpDao.save(tipopergunta);
	}

}

protected static void excluiTipoPergunta(Tipo_PerguntaDAO tpDao) throws SQLException {
	Integer id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do registro que será excluído:"));

	System.out.println(id);

	TipoPergunta tipopergunta = tpDao.get(id);

	System.out.println("Tipo de Pergunta: " + tipopergunta.getId() + '\n' + tipopergunta.getNome() + '\n' + tipopergunta.getDescricao());

	System.out.println("Excluíndo determinada tipo de pergunta do banco...");

	tpDao.delete(tipopergunta);

	boolean exist = !tpDao.isExist(tipopergunta);

	System.out.println("Resultado da exclusão: " + exist);
}
}

