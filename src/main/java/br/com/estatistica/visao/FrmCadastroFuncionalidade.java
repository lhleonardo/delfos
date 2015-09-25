package br.com.estatistica.visao;

import java.awt.EventQueue;
import java.sql.Connection;

public class FrmCadastroFuncionalidade extends GenericFormCadastro {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				FrmCadastroFuncionalidade frame = new FrmCadastroFuncionalidade(null);
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public FrmCadastroFuncionalidade(Connection connection) {
		super("Cadastro de Funcionalidade", connection);

	}

}
