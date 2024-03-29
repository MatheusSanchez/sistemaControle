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
 * Classe main que comeca a aplicacao.
 *@author Eduardo Baratela
 *@author Mateus Virginio
 *@author Matheus Sanchez
 *@author Pedro Brando 
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
	 * Metodo que limpa o que est� aparecendo na janela, deixando apenas seu fundo
	 * @param c : Container que ser� limpado
	 */
	public static void novaTela(Container c) {
		c.removeAll();
		c.revalidate();
		c.repaint();
	}
	
	/**
	 *  M�todo main que come�ar� o programa
	 */
	public static void main(String[] args) {
			Conexao.getInstance("pc");
		
		
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	
	}

}
