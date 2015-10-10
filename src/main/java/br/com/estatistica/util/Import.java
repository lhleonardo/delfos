/**
 * Classe Import.java
 *
 * @author Leonardo Braz
 */
package br.com.estatistica.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;

import br.com.estatistica.modelos.Estado;

/**
 * @author Leonardo Braz
 *
 */
public class Import {

	public void importEstado() {
		List<Estado> estados = new ArrayList<Estado>();
		try {
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showOpenDialog(null);
			
			if (result == JFileChooser.APPROVE_OPTION) {
				Scanner scanner = new Scanner(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
			}
		} catch (FileNotFoundException ex) {

		}
	}

}
