package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.Produto;

public class panelAlteracaoProduto {
	
	public JTextField textFieldLucroProduto_A;
	public JTextField textNomeProduto_A;
	public JTextField textFieldDescricaoProduto_A;
	

	
	public panelAlteracaoProduto(JFrame frame,JPanel alteracaoProduto){
		//-----Panel de alteracao de produto-----
				//alteracaoProduto = new JPanel();
				alteracaoProduto.setVisible(false);
				alteracaoProduto.setForeground(new Color(0, 128, 128));
				alteracaoProduto.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(alteracaoProduto);
				alteracaoProduto.setLayout(null);
				
				textNomeProduto_A = new JTextField();
				textNomeProduto_A.setToolTipText("Ex: HD Samsung 1TB");
				textNomeProduto_A.setBounds(198, 145, 192, 20);
				alteracaoProduto.add(textNomeProduto_A);
				textNomeProduto_A.setColumns(10);
				
				textFieldDescricaoProduto_A = new JTextField();
				textFieldDescricaoProduto_A.setToolTipText("Ex: HD externo Samsung, 1TB, 2 anos de garantia");
				textFieldDescricaoProduto_A.setColumns(10);
				textFieldDescricaoProduto_A.setBounds(198, 191, 192, 20);
				alteracaoProduto.add(textFieldDescricaoProduto_A);
				
				textFieldLucroProduto_A = new JTextField();
				textFieldLucroProduto_A.setToolTipText("Ex: 100,00");
				textFieldLucroProduto_A.setColumns(10);
				textFieldLucroProduto_A.setBounds(198, 237, 192, 20);
				alteracaoProduto.add(textFieldLucroProduto_A);
				
				JLabel lblNome_P = new JLabel("Nome do produto a ser alterado :");
				lblNome_P.setBounds(201, 83, 190, 14);
				alteracaoProduto.add(lblNome_P);
				
				JLabel lblDescricao = new JLabel("Nova descri\u00E7\u00E3o : ");
				lblDescricao.setBounds(260, 176, 127, 14);
				alteracaoProduto.add(lblDescricao);
				
				JLabel lblLucroEsperado = new JLabel("Novo lucro esperado (R$):");
				lblLucroEsperado.setBounds(233, 222, 152, 14);
				alteracaoProduto.add(lblLucroEsperado);
				
				JLabel lblTitulo_AlteracaoProduto = new JLabel("ALTERA\u00C7\u00C3O - PRODUTO");
				lblTitulo_AlteracaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblTitulo_AlteracaoProduto.setBounds(198, 11, 257, 45);
				alteracaoProduto.add(lblTitulo_AlteracaoProduto);
				
				JLabel lblNovoNome = new JLabel("Novo nome :");
				lblNovoNome.setBounds(263, 132, 91, 13);
				alteracaoProduto.add(lblNovoNome);
				
				JComboBox comboBoxProduto = new JComboBox(Produto.getNames()); // faz o comboBox com o nome dos produtos que vem do banco		
				comboBoxProduto.setBounds(196, 100, 194, 21);
				alteracaoProduto.add(comboBoxProduto);
				
				JButton btnConsultaBox = new JButton("Consulta");
				btnConsultaBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 String nomeSelecionado = (String)comboBoxProduto.getSelectedItem(); // pega o item selecionado no comboBox
						 String [] result =  Produto.getInfos(nomeSelecionado);
						 if(result != null){
							 textNomeProduto_A.setText(result[0]);
							 textFieldDescricaoProduto_A.setText(result[1]);
							 textFieldLucroProduto_A.setText(result[2]);
						 }
					}
				});
				btnConsultaBox.setBounds(464, 99, 89, 23);
				alteracaoProduto.add(btnConsultaBox);
				
				//Botão responsável pela alteracao de um produto
				JButton btnAlterarProduto = new JButton("Alterar");
				btnAlterarProduto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String [] form_P = new String[3];
						
							form_P[0] = textNomeProduto_A.getText();
							form_P[1] = textFieldDescricaoProduto_A.getText();
							form_P[2] = textFieldLucroProduto_A.getText();
						
							Produto.update(form_P,(String)comboBoxProduto.getSelectedItem());
						
					}
				});
				btnAlterarProduto.setBounds(453, 166, 118, 45);
				alteracaoProduto.add(btnAlterarProduto);	
				alteracaoProduto.setVisible(true);
	}

}
