package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.Produto;

public class panelRemocaoProduto {
	
	private JTextField textFieldProduto;
	private JTextField textFieldConfirmacaoProduto;
	
	public panelRemocaoProduto(JFrame frame,JPanel remocaoProduto) {
		//-----Panel de remo��o de um produto-----
		//remocaoProduto = new JPanel();
		remocaoProduto.setVisible(false);
		remocaoProduto.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(remocaoProduto);
		remocaoProduto.setLayout(null);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(38, 102, 280, 28);
		remocaoProduto.add(textFieldProduto);
		textFieldProduto.setColumns(10);
		
		textFieldConfirmacaoProduto = new JTextField();
		textFieldConfirmacaoProduto.setBounds(38, 163, 280, 28);
		remocaoProduto.add(textFieldConfirmacaoProduto);
		textFieldConfirmacaoProduto.setColumns(10);
		
		//Bot�o que faz a a��o de remover um produto
		JButton btnRemover_P = new JButton("Remover");
		btnRemover_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] form_P = new String[2];
					form_P[0] = textFieldProduto.getText();
					form_P[1] = textFieldConfirmacaoProduto.getText();
					if(form_P[1].equals(form_P[0])){
						Produto.delete(form_P[1]);	
					}else{
						JOptionPane.showMessageDialog(null, "Campos Diferentes !");
					}				
			}
		});
		btnRemover_P.setBounds(428, 114, 115, 46);
		remocaoProduto.add(btnRemover_P);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto a ser removido :");
		lblNomeDoProduto.setBounds(38, 84, 280, 14);
		remocaoProduto.add(lblNomeDoProduto);
		
		JLabel lblNewLabel = new JLabel("Confirme o nome do produto a ser removido:");
		lblNewLabel.setBounds(38, 146, 280, 14);
		remocaoProduto.add(lblNewLabel);
		
		JLabel lblTitulo_Remo��oProduto = new JLabel("REMO��O - PRODUTO");
		lblTitulo_Remo��oProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_Remo��oProduto.setBounds(209, 10, 257, 45);
		remocaoProduto.add(lblTitulo_Remo��oProduto);
		remocaoProduto.setVisible(true);
	}

}
