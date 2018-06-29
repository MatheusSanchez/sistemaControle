package Telas;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;

import back.Produto;
import conexao.Conexao;

/**
 * Classe main que comeca a aplicacao
 *
 */
public class Main {
	
	/**
	 * Metodo que cria uma nova janela(JFrame)
	 * @param jan : JFrame passado para aparecer na tela
	 */
	public static void novaJanela(JFrame jan) {
		jan.setVisible(true);
		jan.setSize(768, 480);
	}
	
	/**
	 * Metodo que limpa o que está aparecendo na janela, deixando apenas seu fundo
	 * @param c : Container que será limpado
	 */
	public static void novaTela(Container c) {
		c.removeAll();
		c.revalidate();
		c.repaint();
	}
	
	/**
	 * método main que comecara o programa
	 */
	public static void main(String[] args) {
		Conexao.getInstance("lab");
		
		
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	
	}

}
