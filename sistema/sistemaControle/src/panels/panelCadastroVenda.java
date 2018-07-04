package panels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	public JLabel lblNewLabel_1;
	public JLabel lblCodigoDeVenda;
	
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
		
		textFieldCPF_V = new JTextField();
		textFieldCPF_V.setBounds(49, 66, 207, 19);
		cadastroVenda.add(textFieldCPF_V);
		textFieldCPF_V.setColumns(10);
		
		textData_V = new JTextField();
		textData_V.setBounds(49, 109, 207, 19);
		cadastroVenda.add(textData_V);
		textData_V.setColumns(10);
		
		textCodigoProduto = new JTextField();
		textCodigoProduto.setBounds(49, 149, 207, 19);
		cadastroVenda.add(textCodigoProduto);
		textCodigoProduto.setColumns(10);
		
		textPrecoOriginal = new JTextField();
		textPrecoOriginal.setBounds(49, 189, 207, 19);
		cadastroVenda.add(textPrecoOriginal);
		textPrecoOriginal.setColumns(10);
		
		textDescontoDado = new JTextField();
		textDescontoDado.setBounds(49, 230, 207, 19);
		cadastroVenda.add(textDescontoDado);
		textDescontoDado.setColumns(10);
		
		textPrecoVenda = new JTextField();
		textPrecoVenda.setBounds(376, 66, 207, 19);
		cadastroVenda.add(textPrecoVenda);
		textPrecoVenda.setColumns(10);
		
		textLucro = new JTextField();
		textLucro.setBounds(376, 109, 207, 19);
		cadastroVenda.add(textLucro);
		textLucro.setColumns(10);
		
		textCodigoVenda = new JTextField();
		textCodigoVenda.setBounds(376, 149, 207, 19);
		cadastroVenda.add(textCodigoVenda);
		textCodigoVenda.setColumns(10);
		
		JLabel lblCPF_V = new JLabel("CPF:");
		lblCPF_V.setBounds(49, 52, 45, 13);
		cadastroVenda.add(lblCPF_V);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(49, 96, 45, 13);
		cadastroVenda.add(lblData);
		
		JLabel lblCodigoDoProduto = new JLabel("C\u00F3digo do produto:");
		lblCodigoDoProduto.setBounds(49, 138, 154, 13);
		cadastroVenda.add(lblCodigoDoProduto);
		
		JLabel lblPrecoOriginal = new JLabel("Pre\u00E7o original:");
		lblPrecoOriginal.setBounds(49, 176, 84, 13);
		cadastroVenda.add(lblPrecoOriginal);
		
		JLabel lblDescontoDado = new JLabel("Desconto dado:");
		lblDescontoDado.setBounds(49, 218, 84, 13);
		cadastroVenda.add(lblDescontoDado);
		
		lblPrecoDeVenda = new JLabel("Pre\u00E7o de venda:");
		lblPrecoDeVenda.setBounds(376, 52, 142, 13);
		cadastroVenda.add(lblPrecoDeVenda);
		
		lblNewLabel_1 = new JLabel("Lucro:");
		lblNewLabel_1.setBounds(376, 95, 45, 13);
		cadastroVenda.add(lblNewLabel_1);
		
		lblCodigoDeVenda = new JLabel("C\u00F3digo de venda:");
		lblCodigoDeVenda.setBounds(376, 138, 142, 13);
		cadastroVenda.add(lblCodigoDeVenda);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(406, 188, 142, 43);
		cadastroVenda.add(btnNewButton);
		
		cadastroVenda.setVisible(true);
	}
}
