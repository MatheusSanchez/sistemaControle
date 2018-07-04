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
import back.Produto;

public class panelCadastroEstoque {
	
	public JLabel lblCadastroEstoque;
	public JTextField textFieldPrecoCompra;
	public JTextField textFieldqtdReposicao;
	public JTextField textFieldData;
	public JTextField textFieldPrecoVenda;
	public JLabel lblCodProdE;
	public JLabel lblPrecoCompraE;
	public JLabel lblPrecoVendaE;
	public JLabel lblQtdRepoE;
	public JLabel lblDataRepoE;
	public JComboBox comboBoxCodigoProduto;	
	
	public panelCadastroEstoque(JFrame frame,JPanel cadastroEstoque){
		//-----Panel de cadastro de estoque-----
		//cadastroEstoque = new JPanel();
		cadastroEstoque.setVisible(false);
		cadastroEstoque.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(cadastroEstoque);
		cadastroEstoque.setLayout(null);
		
		lblCadastroEstoque = new JLabel("CADASTRO - ESTOQUE");
		lblCadastroEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCadastroEstoque.setBounds(218, 11, 254, 14);
		cadastroEstoque.add(lblCadastroEstoque);
		
		textFieldPrecoCompra = new JTextField();
		textFieldPrecoCompra.setBounds(97, 131, 188, 20);
		cadastroEstoque.add(textFieldPrecoCompra);
		textFieldPrecoCompra.setColumns(10);
		
		textFieldqtdReposicao = new JTextField();
		textFieldqtdReposicao.setBounds(334, 76, 188, 20);
		cadastroEstoque.add(textFieldqtdReposicao);
		textFieldqtdReposicao.setColumns(10);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(334, 131, 188, 20);
		cadastroEstoque.add(textFieldData);
		textFieldData.setColumns(10);
		
		textFieldPrecoVenda = new JTextField();
		textFieldPrecoVenda.setBounds(97, 189, 188, 20);
		cadastroEstoque.add(textFieldPrecoVenda);
		textFieldPrecoVenda.setColumns(10);
		
		lblCodProdE = new JLabel("Produto:");
		lblCodProdE.setBounds(107, 61, 178, 14);
		cadastroEstoque.add(lblCodProdE);
		
		lblPrecoCompraE = new JLabel("Digite o pre\u00E7o de compra:");
		lblPrecoCompraE.setBounds(107, 119, 166, 14);
		cadastroEstoque.add(lblPrecoCompraE);
		
		lblPrecoVendaE = new JLabel("Digite o pre\u00E7o de venda:");
		lblPrecoVendaE.setBounds(107, 176, 166, 14);
		cadastroEstoque.add(lblPrecoVendaE);
		
		lblQtdRepoE = new JLabel("Digite a quantidade de reposi\u00E7\u00E3o:");
		lblQtdRepoE.setBounds(334, 61, 220, 14);
		cadastroEstoque.add(lblQtdRepoE);
		
		lblDataRepoE = new JLabel("Digite a data de reposi\u00E7\u00E3o:");
		lblDataRepoE.setBounds(334, 119, 178, 14);
		cadastroEstoque.add(lblDataRepoE);
		
		JButton btnAdicionarAoEstoque = new JButton("Inserir");
		btnAdicionarAoEstoque.setBounds(364, 180, 108, 37);
		cadastroEstoque.add(btnAdicionarAoEstoque);
		
		comboBoxCodigoProduto = new JComboBox(Produto.getNames());
		comboBoxCodigoProduto.setBounds(97, 75, 188, 21);
		cadastroEstoque.add(comboBoxCodigoProduto);
		
		btnAdicionarAoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] form = new String[5];
				String nomeProduto = (String)comboBoxCodigoProduto.getSelectedItem();
				System.out.println("nomeProduto = " + nomeProduto);
				
				form[0] = Produto.getCod(nomeProduto);
				form[1] = textFieldPrecoCompra.getText();
				form[2] = textFieldPrecoVenda.getText();
				form[3] = textFieldqtdReposicao.getText();		
				form[4] = textFieldData.getText();
				
				System.out.println(form[0] + " " + form[1] + " " + form[2] + " " + form[3] + " " + form[4]);
				Estoque.cadastro(form);	
			}
		});
		
		cadastroEstoque.setVisible(true);
	}

}
