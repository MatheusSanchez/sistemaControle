package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.Produto;

public class panelCadastroProduto {
	
	public JTextField textNomeProduto_C;
	public JTextField textFieldDescricaoProduto_C;
	public JTextField textFieldLucroProduto_C;
	
	public panelCadastroProduto(JFrame frame,JPanel cadastroProduto){
			//-----Panel de cadastro de produto-----
			//cadastroProduto = new JPanel();
			cadastroProduto.setVisible(false);
			cadastroProduto.setBounds(282, 129, 638, 284);
			frame.getContentPane().add(cadastroProduto);
			cadastroProduto.setLayout(null);
			
			textNomeProduto_C = new JTextField();
			textNomeProduto_C.setToolTipText("Ex: HD Samsung 1TB");
			textNomeProduto_C.setBounds(207, 69, 192, 20);
			cadastroProduto.add(textNomeProduto_C);
			textNomeProduto_C.setColumns(10);
			
			textFieldDescricaoProduto_C = new JTextField();
			textFieldDescricaoProduto_C.setToolTipText("Ex: HD externo Samsung 1TB, 2 anos de garantia");
			textFieldDescricaoProduto_C.setColumns(10);
			textFieldDescricaoProduto_C.setBounds(207, 114, 192, 20);
			cadastroProduto.add(textFieldDescricaoProduto_C);
			
			textFieldLucroProduto_C = new JTextField();
			textFieldLucroProduto_C.setToolTipText("Ex: 120,00");
			textFieldLucroProduto_C.setColumns(10);
			textFieldLucroProduto_C.setBounds(207, 158, 192, 20);
			cadastroProduto.add(textFieldLucroProduto_C);
			
			//Botão responsável pelo cadastro de um produto
			JButton btnCadastrarProduto = new JButton("Cadastrar");
			btnCadastrarProduto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String [] form_P = new String[3];				
						form_P[0] = textNomeProduto_C.getText();
						form_P[1] = textFieldDescricaoProduto_C.getText();
						form_P[2] = textFieldLucroProduto_C.getText();
						System.out.println(form_P[0] + form_P[1] +form_P[2]);
						Produto.cadastro(form_P);			
				}
			});
			btnCadastrarProduto.setBounds(246, 198, 118, 45);
			cadastroProduto.add(btnCadastrarProduto);
			
			JLabel lblNomeProd_I = new JLabel("Nome :");
			lblNomeProd_I.setBounds(286, 56, 78, 14);
			cadastroProduto.add(lblNomeProd_I);
			
			JLabel lblDescricao_I = new JLabel("Descri\u00E7\u00E3o : ");
			lblDescricao_I.setBounds(277, 100, 93, 14);
			cadastroProduto.add(lblDescricao_I);
			
			JLabel lblLucroEsperado_I = new JLabel("Lucro esperado (R$):");
			lblLucroEsperado_I.setBounds(252, 145, 147, 14);
			cadastroProduto.add(lblLucroEsperado_I);
			
			JLabel lblTitulo_CadastroProduto = new JLabel("CADASTRO - PRODUTO");
			lblTitulo_CadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTitulo_CadastroProduto.setBounds(205, 0, 257, 45);
			cadastroProduto.add(lblTitulo_CadastroProduto);
			cadastroProduto.setVisible(true);
			
	}

}
