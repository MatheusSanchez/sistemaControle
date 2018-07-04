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
	JLabel lblNovoCdigoDe;
	JLabel lblNomeProduto_A;
	JLabel lblNovoPreoDe;
	JTextField textFieldPrecoCompra_A ;
	JLabel lblNovoPreoVenda;
	JTextField textFieldPrecoVenda_A ;
	JLabel lblNovaQuantidadeDe;
	JTextField textFieldQtdReposicao_A;
	JLabel lblNovaDataDe;
	JTextField textFieldDataReposicao_A;
	JButton btnAlterarEstoque;

	
	
	
	
	public void exibeBotoes() {
		
		lblNovoCdigoDe.setVisible(true);
		lblNomeProduto_A.setVisible(true);
		lblNovoPreoDe.setVisible(true);
		textFieldPrecoCompra_A.setVisible(true);
		lblNovoPreoVenda.setVisible(true);
		textFieldPrecoVenda_A.setVisible(true);
		lblNovaQuantidadeDe.setVisible(true);
		textFieldQtdReposicao_A.setVisible(true);
		lblNovaDataDe.setVisible(true);
		textFieldDataReposicao_A.setVisible(true);
		btnAlterarEstoque.setVisible(true);
		
	}
	
public void someBotoes() {
		
		lblNovoCdigoDe.setVisible(false);
		lblNomeProduto_A.setVisible(false);
		lblNovoPreoDe.setVisible(false);
		textFieldPrecoCompra_A.setVisible(false);
		lblNovoPreoVenda.setVisible(false);
		textFieldPrecoVenda_A.setVisible(false);
		lblNovaQuantidadeDe.setVisible(false);
		textFieldQtdReposicao_A.setVisible(false);
		lblNovaDataDe.setVisible(false);
		textFieldDataReposicao_A.setVisible(false);
		btnAlterarEstoque.setVisible(false);
		
	}
	
	
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
		
		comboBoxAlteracaoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				someBotoes();
			}
		});
		
		JLabel lblItemDeEstoque = new JLabel("Numero do Pedido ser modificado:");
		lblItemDeEstoque.setBounds(32, 116, 203, 14);
		alteracaoEstoque.add(lblItemDeEstoque);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(85, 166, 89, 23);
		alteracaoEstoque.add(btnConsultar);
		
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
				exibeBotoes();
			}
		});
		
		
		
		lblNovoCdigoDe = new JLabel("Nome do produto:");
		lblNovoCdigoDe.setBounds(245, 62, 164, 14);
		alteracaoEstoque.add(lblNovoCdigoDe);
		lblNovoCdigoDe.setVisible(false);
		
		lblNomeProduto_A = new JLabel("");
		lblNomeProduto_A.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeProduto_A.setBounds(245, 82, 164, 17);
		alteracaoEstoque.add(lblNomeProduto_A);
		lblNovoCdigoDe.setVisible(false);
		lblNomeProduto_A.setVisible(false);
		
		lblNovoPreoDe = new JLabel("Novo pre\u00E7o de compra:");
		lblNovoPreoDe.setBounds(245, 128, 164, 14);
		alteracaoEstoque.add(lblNovoPreoDe);
		
		textFieldPrecoCompra_A = new JTextField();
		textFieldPrecoCompra_A.setColumns(10);
		textFieldPrecoCompra_A.setBounds(245, 143, 164, 20);
		alteracaoEstoque.add(textFieldPrecoCompra_A);
		lblNovoPreoDe.setVisible(false);
		textFieldPrecoCompra_A.setVisible(false);
		
		
		lblNovoPreoVenda = new JLabel("Novo pre\u00E7o venda:");
		lblNovoPreoVenda.setBounds(245, 186, 164, 14);
		alteracaoEstoque.add(lblNovoPreoVenda);
		
		
		textFieldPrecoVenda_A = new JTextField();
		textFieldPrecoVenda_A.setColumns(10);
		textFieldPrecoVenda_A.setBounds(245, 202, 164, 20);
		alteracaoEstoque.add(textFieldPrecoVenda_A);
		
		lblNovoPreoVenda.setVisible(false);
		textFieldPrecoVenda_A.setVisible(false);
		
		
		
		lblNovaQuantidadeDe = new JLabel("Nova quantidade de reposi\u00E7\u00E3o:");
		lblNovaQuantidadeDe.setBounds(449, 62, 179, 14);
		alteracaoEstoque.add(lblNovaQuantidadeDe);
	
		
		textFieldQtdReposicao_A = new JTextField();
		textFieldQtdReposicao_A.setColumns(10);
		textFieldQtdReposicao_A.setBounds(449, 79, 164, 20);
		alteracaoEstoque.add(textFieldQtdReposicao_A);
		
		lblNovaQuantidadeDe.setVisible(false);
		textFieldQtdReposicao_A.setVisible(false);
		
	
		
		
		lblNovaDataDe = new JLabel("Nova data de reposi\u00E7\u00E3o:");
		lblNovaDataDe.setBounds(449, 128, 179, 14);
		alteracaoEstoque.add(lblNovaDataDe);
		
		textFieldDataReposicao_A = new JTextField();
		textFieldDataReposicao_A.setColumns(10);
		textFieldDataReposicao_A.setBounds(449, 143, 164, 20);
		alteracaoEstoque.add(textFieldDataReposicao_A);
		
		lblNovaDataDe.setVisible(false);
		textFieldDataReposicao_A.setVisible(false);
		
	
		
		
		
		btnAlterarEstoque = new JButton("Alterar");
		btnAlterarEstoque.setBounds(475, 190, 89, 42);
		alteracaoEstoque.add(btnAlterarEstoque);
		
		btnAlterarEstoque.setVisible(false);
		
		
		
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
