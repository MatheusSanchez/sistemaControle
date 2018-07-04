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
	JButton btnAlterarProduto;
	JLabel lblNome_P;
	JLabel lblDescricao;
	JLabel lblLucroEsperado;
	
	JLabel lblNovoNome;
	
	public void someBotoes() {
		lblNovoNome.setVisible(false);
		btnAlterarProduto.setVisible(false);
		lblNovoNome.setVisible(false);
		textNomeProduto_A.setVisible(false);
		lblDescricao.setVisible(false);
		textFieldDescricaoProduto_A.setVisible(false);
		lblLucroEsperado.setVisible(false);
		textFieldLucroProduto_A.setVisible(false);
		
	}
	
	public void exibeBotoes() {
		lblNovoNome.setVisible(true);
		btnAlterarProduto.setVisible(true);
		lblNovoNome.setVisible(true);
		textNomeProduto_A.setVisible(true);
		lblDescricao.setVisible(true);
		textFieldDescricaoProduto_A.setVisible(true);
		lblLucroEsperado.setVisible(true);
		textFieldLucroProduto_A.setVisible(true);
	}

	
	public panelAlteracaoProduto(JFrame frame,JPanel alteracaoProduto){
		//-----Panel de alteracao de produto-----
				//alteracaoProduto = new JPanel();
				alteracaoProduto.setVisible(false);
				alteracaoProduto.setForeground(new Color(0, 128, 128));
				alteracaoProduto.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(alteracaoProduto);
				alteracaoProduto.setLayout(null);
				
				
				
				JLabel lblTitulo_AlteracaoProduto = new JLabel("ALTERA\u00C7\u00C3O - PRODUTO");
				lblTitulo_AlteracaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblTitulo_AlteracaoProduto.setBounds(198, 11, 257, 45);
				alteracaoProduto.add(lblTitulo_AlteracaoProduto);
				
				lblNome_P = new JLabel("Selecione o Produto para alterar !");
				lblNome_P.setBounds(201, 83, 190, 14);
				alteracaoProduto.add(lblNome_P);
				
				JComboBox comboBoxProduto = new JComboBox(Produto.getNames()); // faz o comboBox com o nome dos produtos que vem do banco		
				comboBoxProduto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
							 someBotoes();	
					}
				});
				
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
							 exibeBotoes();
						 }
					}
				});
				btnConsultaBox.setBounds(464, 99, 89, 23);
				alteracaoProduto.add(btnConsultaBox);
				
				
				lblNovoNome = new JLabel("Novo nome :");
				lblNovoNome.setBounds(263, 132, 91, 13);
				lblNovoNome.setVisible(false);
				alteracaoProduto.add(lblNovoNome);
				
				
				textNomeProduto_A = new JTextField();
				textNomeProduto_A.setToolTipText("Ex: HD Samsung 1TB");
				textNomeProduto_A.setBounds(198, 145, 192, 20);
				textNomeProduto_A.setVisible(false);
				alteracaoProduto.add(textNomeProduto_A);
				textNomeProduto_A.setColumns(10);
				
				lblDescricao = new JLabel("Nova descri\u00E7\u00E3o : ");
				lblDescricao.setVisible(false);
				lblDescricao.setBounds(260, 176, 127, 14);
				alteracaoProduto.add(lblDescricao);
				
				textFieldDescricaoProduto_A = new JTextField();
				textFieldDescricaoProduto_A.setToolTipText("Ex: HD externo Samsung, 1TB, 2 anos de garantia");
				textFieldDescricaoProduto_A.setColumns(10);
				textFieldDescricaoProduto_A.setBounds(198, 191, 192, 20);
				textFieldDescricaoProduto_A.setVisible(false);
				alteracaoProduto.add(textFieldDescricaoProduto_A);
				
				
				 lblLucroEsperado = new JLabel("Novo lucro esperado (R$):");
				lblLucroEsperado.setBounds(233, 222, 152, 14);
				lblLucroEsperado.setVisible(false);
				alteracaoProduto.add(lblLucroEsperado);
				
				textFieldLucroProduto_A = new JTextField();
				textFieldLucroProduto_A.setToolTipText("Ex: 100,00");
				textFieldLucroProduto_A.setColumns(10);
				textFieldLucroProduto_A.setBounds(198, 237, 192, 20);
				textFieldLucroProduto_A.setVisible(false);
				alteracaoProduto.add(textFieldLucroProduto_A);
				
				
				//Botão responsável pela alteracao de um produto
				btnAlterarProduto = new JButton("Alterar");
				btnAlterarProduto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String [] form_P = new String[3];
						
							form_P[0] = textNomeProduto_A.getText();
							form_P[1] = textFieldDescricaoProduto_A.getText();
							form_P[2] = textFieldLucroProduto_A.getText();
						
							Produto.update(form_P,(String)comboBoxProduto.getSelectedItem());
						
					}
				});
				btnAlterarProduto.setVisible(false);
				btnAlterarProduto.setBounds(453, 166, 118, 45);
				alteracaoProduto.add(btnAlterarProduto);	
				alteracaoProduto.setVisible(true);
	}

}
