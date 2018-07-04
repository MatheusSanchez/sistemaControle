package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.Estoque;

public class panelAlteracaoEstoque {
	
	
	public panelAlteracaoEstoque(JFrame frame,JPanel alteracaoEstoque){
		//-----Panel de alteracao de estoque-----
		//alteracaoEstoque = new JPanel();
		alteracaoEstoque.setVisible(false);
		alteracaoEstoque.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(alteracaoEstoque);
		alteracaoEstoque.setLayout(null);
		
		JLabel lblAlteraoEstoque = new JLabel("ALTERA\u00C7\u00C3O - ESTOQUE");
		lblAlteraoEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAlteraoEstoque.setBounds(214, 11, 255, 14);
		alteracaoEstoque.add(lblAlteraoEstoque);
		
		JComboBox comboBoxAlteracaoEstoque = new JComboBox(Estoque.getNpedidos());
		comboBoxAlteracaoEstoque.setBounds(32, 136, 191, 20);
		alteracaoEstoque.add(comboBoxAlteracaoEstoque);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(85, 166, 89, 23);
		alteracaoEstoque.add(btnConsultar);
		
		JTextField textFieldPrecoCompra_A = new JTextField();
		textFieldPrecoCompra_A.setColumns(10);
		textFieldPrecoCompra_A.setBounds(245, 143, 164, 20);
		alteracaoEstoque.add(textFieldPrecoCompra_A);
		
		JTextField textFieldPrecoVenda_A = new JTextField();
		textFieldPrecoVenda_A.setColumns(10);
		textFieldPrecoVenda_A.setBounds(245, 202, 164, 20);
		alteracaoEstoque.add(textFieldPrecoVenda_A);
		
		JTextField textFieldQtdReposicao_A = new JTextField();
		textFieldQtdReposicao_A.setColumns(10);
		textFieldQtdReposicao_A.setBounds(449, 79, 164, 20);
		alteracaoEstoque.add(textFieldQtdReposicao_A);
		
		JTextField textFieldDataReposicao_A = new JTextField();
		textFieldDataReposicao_A.setColumns(10);
		textFieldDataReposicao_A.setBounds(449, 143, 164, 20);
		alteracaoEstoque.add(textFieldDataReposicao_A);
		
		JButton btnAlterarEstoque = new JButton("Alterar");
		btnAlterarEstoque.setBounds(475, 190, 89, 42);
		alteracaoEstoque.add(btnAlterarEstoque);
		
		JLabel lblNovoCdigoDe = new JLabel("Nome do produto:");
		lblNovoCdigoDe.setBounds(245, 62, 164, 14);
		alteracaoEstoque.add(lblNovoCdigoDe);
		
		JLabel lblNovoPreoDe = new JLabel("Novo pre\u00E7o de compra:");
		lblNovoPreoDe.setBounds(245, 128, 164, 14);
		alteracaoEstoque.add(lblNovoPreoDe);
		
		JLabel lblNovoPreoVenda = new JLabel("Novo pre\u00E7o venda:");
		lblNovoPreoVenda.setBounds(245, 186, 164, 14);
		alteracaoEstoque.add(lblNovoPreoVenda);
		
		JLabel lblNovaQuantidadeDe = new JLabel("Nova quantidade de reposi\u00E7\u00E3o:");
		lblNovaQuantidadeDe.setBounds(449, 62, 179, 14);
		alteracaoEstoque.add(lblNovaQuantidadeDe);
		
		JLabel lblNovaDataDe = new JLabel("Nova data de reposi\u00E7\u00E3o:");
		lblNovaDataDe.setBounds(449, 128, 179, 14);
		alteracaoEstoque.add(lblNovaDataDe);
		
		JLabel lblItemDeEstoque = new JLabel("Item de estoque a ser modificado:");
		lblItemDeEstoque.setBounds(32, 116, 203, 14);
		alteracaoEstoque.add(lblItemDeEstoque);
		
		JLabel lblNomeProduto_A = new JLabel("");
		lblNomeProduto_A.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeProduto_A.setBounds(245, 82, 164, 17);
		alteracaoEstoque.add(lblNomeProduto_A);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numPedido = (String)comboBoxAlteracaoEstoque.getSelectedItem();
				String[] form = Estoque.getInfos(numPedido);
				System.out.println("numPedido = " + numPedido);
				
				lblNomeProduto_A.setText(form[0]);
				textFieldPrecoCompra_A.setText(form[1]);
				textFieldPrecoVenda_A.setText(form[2]);
				textFieldQtdReposicao_A.setText(form[3]);	
				textFieldDataReposicao_A.setText(form[4]);
				
				System.out.println(form[0] + " " + form[1] + " " + form[2] + " " + form[3] + " " + form[4]);
			}
		});
		
		btnAlterarEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] troca = new String[4];
				String numPed = (String)comboBoxAlteracaoEstoque.getSelectedItem();
				
				troca[0] = textFieldPrecoCompra_A.getText();
				troca[1] = textFieldPrecoVenda_A.getText();
				troca[2] = textFieldQtdReposicao_A.getText();
				troca[3] = textFieldDataReposicao_A.getText();
				
				System.out.println(troca[0] + " " + troca[1] + " " + troca[2] + " " + troca[3] + " " + numPed);
				
				Estoque.update(troca, numPed);
			}
		});
		
		alteracaoEstoque.setVisible(true);
	}

}
