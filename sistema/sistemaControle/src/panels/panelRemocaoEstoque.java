package panels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import back.Estoque;

public class panelRemocaoEstoque {
	
	public panelRemocaoEstoque(JFrame frame,JPanel remocaoEstoque){
		//-----Panel de remocao de estoque-----
		//remocaoEstoque = new JPanel();
		remocaoEstoque.setVisible(false);
		remocaoEstoque.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(remocaoEstoque);
		remocaoEstoque.setLayout(null);
		
		JLabel lblRemooEstoque = new JLabel("REMO\u00C7\u00C3O - ESTOQUE");
		lblRemooEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRemooEstoque.setBounds(220, 11, 215, 14);
		remocaoEstoque.add(lblRemooEstoque);
		
		JComboBox comboBoxEstoque = new JComboBox(Estoque.getNpedidos());
		comboBoxEstoque.setBounds(188, 97, 301, 20);
		remocaoEstoque.add(comboBoxEstoque);
		
		JLabel lblSelecioneOCdigo = new JLabel("Selecione o numero do Pedido para Remover: ");
		lblSelecioneOCdigo.setBounds(188, 77, 301, 14);
		remocaoEstoque.add(lblSelecioneOCdigo);
		
		JButton btnNRemoverEstoque = new JButton("Remover");
		btnNRemoverEstoque.setBounds(288, 135, 89, 39);
		remocaoEstoque.add(btnNRemoverEstoque);
		
		remocaoEstoque.setVisible(true);
	}

}
