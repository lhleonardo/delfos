package br.com.estatistica;

import br.com.estatistica.visao.FrmMenuPrincipal;

public class Estatistica {
	public static void main(String[] args) {
		FrmMenuPrincipal menu = new FrmMenuPrincipal();
		menu.definePerfilAcesso(UserAutenticate user);
		menu.show();

	}
}
