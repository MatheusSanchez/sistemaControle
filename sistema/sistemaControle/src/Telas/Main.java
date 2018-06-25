package Telas;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

import conexao.Conexao;

public class Main {
	
	public static void novaJanela(JFrame jan) {
		jan.setVisible(true);
		jan.setSize(768, 480);
	}
	
	public static void novaTela(Container c) {
		c.removeAll();
		c.revalidate();
		c.repaint();
	}
	
	public static void main(String[] args) {
		Conexao.getInstance();
		
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	
	}

}
