package br.com.estatistica.http;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;

import br.com.estatistica.util.ManipuladorDePropriedades;

public class ManipuladorDeLinks {

	private Desktop desktop;

	public ManipuladorDeLinks() {
		desktop = java.awt.Desktop.getDesktop();
	}

	public void abre(String URL) throws IOException, URISyntaxException {
		desktop.browse(new java.net.URI(URL));
	}

	public static void main(String[] args) {
		ManipuladorDeLinks gerenciador = new ManipuladorDeLinks();
		try {
			String local = new ManipuladorDePropriedades("delfos.properties").getProperty("web.url-wordpress");
			gerenciador.abre(local);
		} catch (IOException | URISyntaxException e) {
			System.out.println("Algo de errado aconteceu...\nDetalhes: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
