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

import back.Produto;

public class panelCadastroVenda {
	
	public JTextField textFieldCPF_V;
	public JTextField textData_V;
	public JTextField textCodigoProduto;
	public JTextField textPrecoOriginal;
	public JTextField textDescontoDado;
	public JTextField textPrecoVenda;
	public JTextField textLucro;
	public JTextField textCodigoVenda;
	public JLabel lblPrecoDeVenda;
	public JLabel lblCodigoDeVenda;
	public JLabel lblLucro;
	public JComboBox comboBoxQtdVenda;
	public JComboBox comboBoxNomeProduto;
	private JLabel lblNroPedido;
	private JComboBox comboBoxNroPedido;
	
	public panelCadastroVenda(JFrame frame,JPanel cadastroVenda){
		//-----Panel de cadastro de venda-----
		//cadastroVenda = new JPanel();
		cadastroVenda.setVisible(false);
		cadastroVenda.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(cadastroVenda);
		cadastroVenda.setLayout(null);
		
		JLabel lblCadastroVenda = new JLabel("CADASTRO - VENDA");
		lblCadastroVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCadastroVenda.setBounds(235, 11, 283, 14);
		cadastroVenda.add(lblCadastroVenda);
		
		textData_V = new JTextField();
		textData_V.setBounds(378, 199, 207, 19);
		cadastroVenda.add(textData_V);
		textData_V.setColumns(10);
		
		textPrecoOriginal = new JTextField();
		textPrecoOriginal.setBounds(49, 109, 207, 19);
		cadastroVenda.add(textPrecoOriginal);
		textPrecoOriginal.setColumns(10);
		
		textDescontoDado = new JTextField();
		textDescontoDado.setBounds(49, 153, 207, 19);
		cadastroVenda.add(textDescontoDado);
		textDescontoDado.setColumns(10);
		
		textPrecoVenda = new JTextField();
		textPrecoVenda.setBounds(378, 110, 207, 19);
		cadastroVenda.add(textPrecoVenda);
		textPrecoVenda.setColumns(10);
		
		textLucro = new JTextField();
		textLucro.setBounds(378, 153, 207, 19);
		cadastroVenda.add(textLucro);
		textLucro.setColumns(10);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(378, 186, 163, 13);
		cadastroVenda.add(lblData);
		
		JLabel lblPrecoOriginal = new JLabel("Pre\u00E7o original:");
		lblPrecoOriginal.setBounds(49, 96, 207, 13);
		cadastroVenda.add(lblPrecoOriginal);
		
		JLabel lblDescontoDado = new JLabel("Desconto dado:");
		lblDescontoDado.setBounds(49, 138, 207, 13);
		cadastroVenda.add(lblDescontoDado);
		
		lblPrecoDeVenda = new JLabel("Pre\u00E7o de venda:");
		lblPrecoDeVenda.setBounds(378, 96, 189, 13);
		cadastroVenda.add(lblPrecoDeVenda);
		
		lblLucro = new JLabel("Lucro:");
		lblLucro.setBounds(378, 139, 207, 13);
		cadastroVenda.add(lblLucro);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(75, 192, 142, 43);
		cadastroVenda.add(btnNewButton);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(49, 52, 196, 13);
		cadastroVenda.add(lblProduto);
		
		comboBoxNomeProduto = new JComboBox(Produto.getNames());
		
		comboBoxNomeProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				 System.out.println("Codigo " + Produto.getCod((String)comboBoxNomeProduto.getSelectedItem()));
			}
		});
		comboBoxNomeProduto.setBounds(49, 68, 207, 20);
		cadastroVenda.add(comboBoxNomeProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade a ser vendida:");
		lblQuantidade.setBounds(474, 52, 154, 13);
		cadastroVenda.add(lblQuantidade);
		
		comboBoxQtdVenda = new JComboBox();
		comboBoxQtdVenda.setBounds(501, 68, 84, 20);
		cadastroVenda.add(comboBoxQtdVenda);
		
		lblNroPedido = new JLabel("N\u00BA Pedido");
		lblNroPedido.setBounds(378, 52, 86, 13);
		cadastroVenda.add(lblNroPedido);
		
		comboBoxNroPedido = new JComboBox();
		comboBoxNroPedido.setBounds(378, 68, 71, 20);
		cadastroVenda.add(comboBoxNroPedido);
		
		cadastroVenda.setVisible(true);
	}
}
