package br.com.estatistica.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class GerenciadorDeTelas {

	public static Point centralizarTela(JFrame frame) {
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dw = frame.getSize();
		return new Point((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);
	}

}
