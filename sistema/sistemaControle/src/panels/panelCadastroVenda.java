package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import back.Estoque;
import back.Produto;
import back.Venda;

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
	public JLabel lblFormaDePagamento;
	public JComboBox<Integer> comboBoxQtdVenda;
	public JComboBox comboBoxNomeProduto;
	public JComboBox comboBoxFormaPagamento;
	private JLabel lblNroPedido;
	private JComboBox comboBoxNroPedido;
	private int max = 0;
	private String numPed;
	private float precoCompra_Uni;
	private float precoCompra_Total;
	private float precoVenda_Uni;
	private float precoVenda_Total;
	private int qtd;
	private float lucro;
	private float desconto = 0;
	private String[] form = new String[5];
	DecimalFormat df = new DecimalFormat("0.00");
	
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
		
		textDescontoDado = new JTextField("0.00");
		textDescontoDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qtd = (int)comboBoxQtdVenda.getSelectedItem();
				
				desconto = Float.parseFloat(textDescontoDado.getText());
				lucro = precoVenda_Total - precoCompra_Total - desconto;
				textLucro.setText(Float.toString(lucro));
			}
		});
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
		
		JLabel lblPrecoOriginal = new JLabel("Pre\u00E7o de compra:");
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
				String [] form1 = new String[7];
				form1[0] = "111.111.111-11";
				form1[1] = textData_V.getText();
				form1[2] = df.format(desconto);
				form1[3] = df.format(precoCompra_Total);
				form1[4] = df.format(precoVenda_Total);
				form1[5] = df.format(lucro);
				form1[6] = (String)comboBoxFormaPagamento.getSelectedItem();
				System.out.println("form1 = " + form1[0] + " " + form1[1] + " " + form1[2] + " " + form1[3] + " " + form1[4] + " " + form1[5] + " " + form1[6]);
				
				String [] form2 = new String[5];
				form2[0] = Produto.getCod((String)comboBoxNomeProduto.getSelectedItem());
				form2[1] = Integer.toString(qtd);
				form2[2] = df.format(precoCompra_Uni);
				form2[3] = df.format(precoVenda_Uni);
				float lucro_uni = precoVenda_Uni - precoCompra_Uni;
				form2[4] = df.format(lucro_uni);
				System.out.println("form2 = " + form2[0] + " " + form2[1] + " " + form2[2] + " " + form2[3] + " " + form2[4]);

				Venda.cadastro(form1, form2, numPed);
			}
		});
		btnNewButton.setBounds(75, 192, 142, 43);
		cadastroVenda.add(btnNewButton);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(49, 52, 196, 13);
		cadastroVenda.add(lblProduto);
		
		comboBoxQtdVenda = new JComboBox();
		comboBoxQtdVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qtd = (int)comboBoxQtdVenda.getSelectedItem();
				
				precoCompra_Total = precoCompra_Uni * qtd;
				precoVenda_Total = precoVenda_Uni * qtd;
				desconto = Float.parseFloat(textDescontoDado.getText());
				lucro = precoVenda_Total - precoCompra_Total - desconto;
				textPrecoOriginal.setText(Float.toString(precoCompra_Total));
				textPrecoVenda.setText(Float.toString(precoVenda_Total));
				textLucro.setText(Float.toString(lucro));
			}
		});
		comboBoxQtdVenda.setBounds(501, 68, 84, 20);
		cadastroVenda.add(comboBoxQtdVenda);
		
		comboBoxNroPedido = new JComboBox();
		comboBoxNroPedido.setBounds(378, 68, 71, 20);
		cadastroVenda.add(comboBoxNroPedido);
		
		comboBoxNomeProduto = new JComboBox(Produto.getNames());
		
		comboBoxNomeProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				 System.out.println("Codigo " + Produto.getCod((String)comboBoxNomeProduto.getSelectedItem()));
				 cadastroVenda.remove(comboBoxNroPedido);
				 comboBoxNroPedido = new JComboBox(Estoque.getNpedidos(Produto.getCod((String)comboBoxNomeProduto.getSelectedItem())));
				 comboBoxNroPedido.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {
							numPed = (String)comboBoxNroPedido.getSelectedItem();
							max = Integer.parseInt(Estoque.getMax(numPed));
							for(int i = 1; i <= max; i++) {
								comboBoxQtdVenda.addItem(i);
							}
							form = Estoque.getInfos(numPed);
							System.out.println(form[0] + " " + form[1] + " " + form[2] + " " + form[3] + " " + form[4]);
							
							precoCompra_Uni = Float.parseFloat(form[1]);
							precoVenda_Uni = Float.parseFloat(form[2]);
							textData_V.setText(form[4]);
						}
				});
				comboBoxNroPedido.setBounds(378, 68, 71, 20);
				cadastroVenda.add(comboBoxNroPedido);
			}
		});
		comboBoxNomeProduto.setBounds(49, 68, 207, 20);
		cadastroVenda.add(comboBoxNomeProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade a ser vendida:");
		lblQuantidade.setBounds(474, 52, 154, 13);
		cadastroVenda.add(lblQuantidade);
		
		lblNroPedido = new JLabel("N\u00BA Pedido");
		lblNroPedido.setBounds(378, 52, 86, 13);
		cadastroVenda.add(lblNroPedido);
		
		comboBoxFormaPagamento = new JComboBox();
		comboBoxFormaPagamento.setModel(new DefaultComboBoxModel(new String[] {"D", "C"}));
		comboBoxFormaPagamento.setBounds(378, 245, 207, 21);
		cadastroVenda.add(comboBoxFormaPagamento);
		
		lblFormaDePagamento = new JLabel("Forma de pagamento:");
		lblFormaDePagamento.setBounds(378, 230, 207, 13);
		cadastroVenda.add(lblFormaDePagamento);
		
		cadastroVenda.setVisible(true);
	}
}
