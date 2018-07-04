package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import back.Estoque;
import back.Produto;
import back.Usuario;
import Telas.TelaConsulta;
import panels.panelAlteracaoProduto;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.ImageCapabilities;
import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * Classe da janela pos login, onde existe a tela inicial com todas as funcionalidades
 *
 */
public class Home {

	JFrame frame;
	private static Container container;
	int tipo;
	
	
	private JTextField textNomeProduto_C;
	private JTextField textFieldDescricaoProduto_C;
	private JTextField textFieldLucroProduto_C;
	private JTextField textFieldNomeUsuario;
	private JTextField textFieldRGUsuario;
	private JTextField textFieldCPFUsuario;
	private JTextField textFieldEmailUsuario;
	private JTextField textFieldSenhaUsuario;
	private JTextField textFieldConfirmacaoUsuario;
	private JTextField textFieldProduto;
	private JTextField textFieldConfirmacaoProduto;
	private JTable table;
	private JPanel cadastroProduto;
	private JScrollPane consultaProduto;
	private JPanel alteracaoProduto = new JPanel();
	private JPanel remocaoProduto;
	private JPanel cadastroVenda;
	private JScrollPane consultaVenda;
	private JPanel remocaoVenda;
	private JPanel alteracaoVenda;
	private JPanel cadastroEstoque;
	private JScrollPane consultaEstoque;
	private JPanel remocaoEstoque;
	private JPanel alteracaoEstoque;
	private JPanel cadastroUsuario;
	private JPanel remocaoUsuario;
	private JPanel consultaUsuario;
	private JPanel alteracaoUsuario;
	private JButton btnInserir_P;
	private JButton btnConsulta_P;
	private JButton btnRemocao_P;
	private JButton btnAlteracao_P;
	private JButton btnProduto;
	private JButton btnVendas;
	private JButton btnEstoque;	
	private JButton btnUsuarios;
	private JComboBox boxTipoFuncionario;
	private JTextField textFieldCPF_V;
	private JTextField textData_V;
	private JTextField textCodigoProduto;
	private JTextField textPrecoOriginal;
	private JTextField textDescontoDado;
	private JTextField textPrecoVenda;
	private JTextField textLucro;
	private JTextField textCodigoVenda;
	private JLabel lblPrecoDeVenda;
	private JLabel lblNewLabel_1;
	private JLabel lblCodigoDeVenda;
	private JTextField textNomeUsuario_A;
	private JTextField textEmailUsuario_A;
	private JTextField textSenhaUsuario_A;
	private JTextField textConfirmacao_A;
	
	public Home(Container c, JFrame j) {
		
		initialize(c,j);
		this.frame.setVisible(true);
	}
	
	public void img(JPanel panel) {
		JLabel lblLogoIcmc = new JLabel("");
		lblLogoIcmc.setBounds(816, 10, 131, 49);
		ImageIcon plano= new ImageIcon("images/LogoIcmc.png");
		Image img = plano.getImage().getScaledInstance(lblLogoIcmc.getWidth(), lblLogoIcmc.getHeight(), Image.SCALE_DEFAULT);
		
		lblLogoIcmc.setIcon(new ImageIcon(img));
		panel.add(lblLogoIcmc);
		
		//adicionando o logo

		JLabel lblLogoMemps = 	new JLabel("");
		lblLogoMemps.setBounds(560, 0, 274, 79);
		ImageIcon empresa = new ImageIcon("images/Memps2.png");
		Image img2 = empresa.getImage().getScaledInstance(lblLogoMemps.getWidth(), lblLogoMemps.getHeight(), Image.SCALE_DEFAULT);
		
		lblLogoMemps.setIcon(new ImageIcon(img2));
		panel.add(lblLogoMemps);
	}
	
	/**
	 * Função que seta todas os panels de informacao como false, para que quando novos panels forem clicados não fiquem sobrepostos
	 */
	private void resetaTudo() {
		cadastroProduto.setVisible(false);
		remocaoProduto.setVisible(false);
		alteracaoProduto.setVisible(false);
		consultaProduto.setVisible(false);
		cadastroUsuario.setVisible(false);
		remocaoUsuario.setVisible(false);
		consultaUsuario.setVisible(false);
		alteracaoUsuario.setVisible(false);
		cadastroVenda.setVisible(false);
		consultaVenda.setVisible(false);
		remocaoVenda.setVisible(false);
		alteracaoVenda.setVisible(false);
		cadastroEstoque.setVisible(false);
		remocaoEstoque.setVisible(false);
		consultaEstoque.setVisible(false);
		alteracaoEstoque.setVisible(false);
		btnInserir_P.setBackground(new Color(218, 232, 252));
		btnConsulta_P.setBackground(new Color(218, 232, 252));
		btnRemocao_P.setBackground(new Color(218, 232, 252));
		btnAlteracao_P.setBackground(new Color(218, 232, 252));
	}
	
	private void resetaBotoesCima() {
		btnProduto.setBackground(SystemColor.menu);
		btnVendas.setBackground(SystemColor.menu);
		btnEstoque.setBackground(SystemColor.menu);
		btnUsuarios.setBackground(SystemColor.menu);
	}

	/**
	 * inicializa o conteúdo do Frame e do Container
	 * @param c Container da janela
	 * @param j Frame da aplicação
	 */
	private void initialize(Container c,JFrame j) {
		j.setVisible(false);
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(145,170,157));
		container = c;

		frame.setBounds(100, 100, 973, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 973, 30);
		panel.setBackground(new Color(25,52,65));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				TelaLogin window = new TelaLogin();
				window.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(827, 5, 94, 21);
		panel.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(62,96,111));
		panel_1.setBounds(0, 421, 957, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		img(panel_1);
		
		JLabel lblTodosOsDireitos = new JLabel("TODOS OS DIREITOS RESERVADOS.");
		lblTodosOsDireitos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTodosOsDireitos.setBounds(23, 20, 513, 29);
		panel_1.add(lblTodosOsDireitos);
		
		
		
		//PAINEIS
		
		//De Produtos:
		
	

		
		//-----Panel de cadastro de produto-----
		cadastroProduto = new JPanel();
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
				if(tipo == 1){
					form_P[0] = textNomeProduto_C.getText();
					form_P[1] = textFieldDescricaoProduto_C.getText();
					form_P[2] = textFieldLucroProduto_C.getText();
					System.out.println(form_P[0] + form_P[1] +form_P[2]);
					Produto.cadastro(form_P);
				}
				
				
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
		
		//-----Panel de remoção de um produto-----
		remocaoProduto = new JPanel();
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
		
		//Botão que faz a ação de remover um produto
		JButton btnRemover_P = new JButton("Remover");
		btnRemover_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] form_P = new String[2];
				if(tipo == 1){
					form_P[0] = textFieldProduto.getText();
					form_P[1] = textFieldConfirmacaoProduto.getText();
					if(form_P[1].equals(form_P[0])){
						Produto.delete(form_P[1]);	
					}else{
						JOptionPane.showMessageDialog(null, "Campos Diferentes !");
					}
					
					//if(form_P[0].equals(form_P[1])) System.out.println(form_P[0] + " " +  form_P[1]);
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
		
		JLabel lblTitulo_RemoçãoProduto = new JLabel("REMOÇÃO - PRODUTO");
		lblTitulo_RemoçãoProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_RemoçãoProduto.setBounds(209, 10, 257, 45);
		remocaoProduto.add(lblTitulo_RemoçãoProduto);
		
		//Panel de Consulta de Produto
		consultaProduto = new JScrollPane();
		consultaProduto.setVisible(false);
		consultaProduto.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(consultaProduto);
			
		
		JLabel lblTitulo_ConsultaProduto = new JLabel("CONSULTA - PRODUTO");
		lblTitulo_ConsultaProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_ConsultaProduto.setBounds(209, 10, 257, 45);
		consultaProduto.add(lblTitulo_ConsultaProduto);
		
		
		//De Venda
		//-----Panel de cadastro de venda-----
				cadastroVenda = new JPanel();
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
				
				//-----Panel de consulta de venda-----
				consultaVenda = new JScrollPane();
				consultaVenda.setVisible(false);
				consultaVenda.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(consultaVenda);
				
				JTable tableVenda = new JTable();
				tableVenda.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
					},
					new String[] {
						"Data", "CPF", "C\u00F3digo Venda", "C\u00F3digo Prod.", "Pre\u00E7o", "Pre\u00E7o Venda", "Lucro"
					}
				));
				consultaVenda.setViewportView(tableVenda);
				
				//-----Panel de remocao de venda-----
				remocaoVenda = new JPanel();
				remocaoVenda.setVisible(false);
				remocaoVenda.setBounds(282, 149, 637, 227);
				frame.getContentPane().add(remocaoVenda);
				remocaoVenda.setLayout(null);
				
				JLabel lblRemocaoVendas = new JLabel("REMO\u00C7\u00C3O - VENDAS");
				lblRemocaoVendas.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRemocaoVendas.setBounds(228, 11, 219, 14);
				remocaoVenda.add(lblRemocaoVendas);
				
				//-----Panel de alteracao de venda-----
				alteracaoVenda = new JPanel();
				alteracaoVenda.setVisible(false);
				alteracaoVenda.setBounds(282, 149, 637, 227);
				frame.getContentPane().add(alteracaoVenda);
				alteracaoVenda.setLayout(null);
				
				JLabel lblAlteraoVenda = new JLabel("ALTERA\u00C7\u00C3O - VENDA");
				lblAlteraoVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblAlteraoVenda.setBounds(249, 11, 213, 14);
				alteracaoVenda.add(lblAlteraoVenda);
		
		
				//De Estoque
				//-----Panel de cadastro de estoque-----
				cadastroEstoque = new JPanel();
				cadastroEstoque.setVisible(false);
				cadastroEstoque.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(cadastroEstoque);
				cadastroEstoque.setLayout(null);
				
				JLabel lblCadastroEstoque = new JLabel("CADASTRO - ESTOQUE");
				lblCadastroEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblCadastroEstoque.setBounds(218, 11, 254, 14);
				cadastroEstoque.add(lblCadastroEstoque);
				
				JTextField textFieldPrecoCompra = new JTextField();
				textFieldPrecoCompra.setBounds(97, 131, 188, 20);
				cadastroEstoque.add(textFieldPrecoCompra);
				textFieldPrecoCompra.setColumns(10);
				
				JTextField textFieldqtdReposicao = new JTextField();
				textFieldqtdReposicao.setBounds(334, 76, 188, 20);
				cadastroEstoque.add(textFieldqtdReposicao);
				textFieldqtdReposicao.setColumns(10);
				
				JTextField textFieldData = new JTextField();
				textFieldData.setBounds(334, 131, 188, 20);
				cadastroEstoque.add(textFieldData);
				textFieldData.setColumns(10);
				
				JTextField textFieldPrecoVenda = new JTextField();
				textFieldPrecoVenda.setBounds(97, 189, 188, 20);
				cadastroEstoque.add(textFieldPrecoVenda);
				textFieldPrecoVenda.setColumns(10);
				
				JLabel lblCodProdE = new JLabel("Produto:");
				lblCodProdE.setBounds(107, 61, 178, 14);
				cadastroEstoque.add(lblCodProdE);
				
				JLabel lblPrecoCompraE = new JLabel("Digite o pre\u00E7o de compra:");
				lblPrecoCompraE.setBounds(107, 119, 166, 14);
				cadastroEstoque.add(lblPrecoCompraE);
				
				JLabel lblPrecoVendaE = new JLabel("Digite o pre\u00E7o de venda:");
				lblPrecoVendaE.setBounds(107, 176, 166, 14);
				cadastroEstoque.add(lblPrecoVendaE);
				
				JLabel lblQtdRepoE = new JLabel("Digite a quantidade de reposi\u00E7\u00E3o:");
				lblQtdRepoE.setBounds(334, 61, 220, 14);
				cadastroEstoque.add(lblQtdRepoE);
				
				JLabel lblDataRepoE = new JLabel("Digite a data de reposi\u00E7\u00E3o:");
				lblDataRepoE.setBounds(334, 119, 178, 14);
				cadastroEstoque.add(lblDataRepoE);
				
				JButton btnAdicionarAoEstoque = new JButton("Inserir");
				btnAdicionarAoEstoque.setBounds(364, 180, 108, 37);
				cadastroEstoque.add(btnAdicionarAoEstoque);
				
				JComboBox comboBoxCodigoProduto = new JComboBox(Produto.getNames());
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
				
				//-----Panel de consulta de estoque-----	
				consultaEstoque = new JScrollPane();
				consultaEstoque.setVisible(false);
				consultaEstoque.setBounds(282, 149, 637, 227);
				frame.getContentPane().add(consultaEstoque);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
					},
					new String[] {
						"Nro Pedido", "C\u00F3digo", "Pre\u00E7o Compra", "Pre\u00E7o Venda", "Quantidade Repo", "Data Reposi\u00E7\u00E3o", "Quantidade Dispo"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(62);
				table.getColumnModel().getColumn(1).setPreferredWidth(51);
				table.getColumnModel().getColumn(2).setPreferredWidth(77);
				table.getColumnModel().getColumn(3).setPreferredWidth(77);
				table.getColumnModel().getColumn(4).setPreferredWidth(95);
				table.getColumnModel().getColumn(5).setPreferredWidth(86);
				table.getColumnModel().getColumn(6).setPreferredWidth(98);
				consultaEstoque.setViewportView(table);
				
				//JLabel lblTitulo_ConsultaEstqoue = new JLabel("CONSULTA - ESTOQUE");
				consultaEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
				consultaEstoque.setBounds(282, 129, 638, 281);
				//consultaEstoque.add(consultaEstoque);
				 
				//-----Panel de remocao de estoque-----
				remocaoEstoque = new JPanel();
				remocaoEstoque.setVisible(false);
				remocaoEstoque.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(remocaoEstoque);
				remocaoEstoque.setLayout(null);
				
				JLabel lblRemooEstoque = new JLabel("REMO\u00C7\u00C3O - ESTOQUE");
				lblRemooEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRemooEstoque.setBounds(220, 11, 215, 14);
				remocaoEstoque.add(lblRemooEstoque);
				
				JComboBox comboBoxEstoque = new JComboBox(Estoque.getNpedidos());
				comboBoxEstoque.setBounds(188, 97, 301, 20);
				remocaoEstoque.add(comboBoxEstoque);
				
				JLabel lblSelecioneOCdigo = new JLabel("Selecione o c\u00F3digo do produto que deseja remover:");
				lblSelecioneOCdigo.setBounds(188, 77, 301, 14);
				remocaoEstoque.add(lblSelecioneOCdigo);
				
				JButton btnNRemoverEstoque = new JButton("Remover");
				btnNRemoverEstoque.setBounds(288, 135, 89, 39);
				remocaoEstoque.add(btnNRemoverEstoque);
				
				//-----Panel de alteracao de estoque-----
				alteracaoEstoque = new JPanel();
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
		
		
		//De Usuário
		//-----Panel de cadastro de usuario-----
			cadastroUsuario = new JPanel();
			cadastroUsuario.setVisible(false);
			cadastroUsuario.setBounds(282, 129, 638, 281);
			frame.getContentPane().add(cadastroUsuario);
			cadastroUsuario.setLayout(null);
				
			textFieldNomeUsuario = new JTextField();
			textFieldNomeUsuario.setToolTipText("Ex: Matheus Sanchez");
			textFieldNomeUsuario.setBounds(204, 33, 288, 20);
			cadastroUsuario.add(textFieldNomeUsuario);
			textFieldNomeUsuario.setColumns(10);
				
			textFieldRGUsuario = new JTextField();
			textFieldRGUsuario.setToolTipText("12.345.678");
			textFieldRGUsuario.setBounds(204, 64, 288, 20);
			cadastroUsuario.add(textFieldRGUsuario);
			textFieldRGUsuario.setColumns(10);
				
			textFieldCPFUsuario = new JTextField();
			textFieldCPFUsuario.setToolTipText("123.456.789-10");
			textFieldCPFUsuario.setBounds(204, 95, 288, 20);
			cadastroUsuario.add(textFieldCPFUsuario);
			textFieldCPFUsuario.setColumns(10);
				
			textFieldEmailUsuario = new JTextField();
			textFieldEmailUsuario.setToolTipText("matheussanchez.gmail.com");
			textFieldEmailUsuario.setBounds(204, 126, 288, 20);
			cadastroUsuario.add(textFieldEmailUsuario);
			textFieldEmailUsuario.setColumns(10);
				
			textFieldSenhaUsuario = new JTextField();
			textFieldSenhaUsuario.setBounds(204, 157, 288, 20);
			cadastroUsuario.add(textFieldSenhaUsuario);
			textFieldSenhaUsuario.setColumns(10);
				
			textFieldConfirmacaoUsuario = new JTextField();
			textFieldConfirmacaoUsuario.setBounds(204, 194, 288, 20);
			cadastroUsuario.add(textFieldConfirmacaoUsuario);
			textFieldConfirmacaoUsuario.setColumns(10);
				
			JLabel lblNome_U = new JLabel("Nome :");
			lblNome_U.setBounds(72, 36, 46, 14);
			cadastroUsuario.add(lblNome_U);
				
			JLabel lblRG = new JLabel("RG :");
			lblRG.setBounds(72, 67, 46, 14);
			cadastroUsuario.add(lblRG);
				
			JLabel lblCpf = new JLabel("CPF :");
			lblCpf.setBounds(72, 98, 46, 14);
			cadastroUsuario.add(lblCpf);
				
			JLabel lblEmail = new JLabel("Email :");
			lblEmail.setBounds(72, 129, 46, 14);
			cadastroUsuario.add(lblEmail);
				
			JLabel lblSenha = new JLabel("Senha :");
			lblSenha.setBounds(72, 160, 46, 14);
			cadastroUsuario.add(lblSenha);
				
			JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
			lblConfirmeASenha.setBounds(72, 197, 122, 14);
			cadastroUsuario.add(lblConfirmeASenha);
				
			JLabel lblTipoDeFuncionrio = new JLabel("Tipo de funcion\u00E1rio:");
			lblTipoDeFuncionrio.setBounds(72, 232, 122, 14);
			cadastroUsuario.add(lblTipoDeFuncionrio);
				
			JLabel lblTitulo_CadastroUsuario = new JLabel("CADASTRO - USUARIO");
			lblTitulo_CadastroUsuario.setVerticalAlignment(SwingConstants.TOP);
			lblTitulo_CadastroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblTitulo_CadastroUsuario.setBounds(209, 0, 257, 45);
			cadastroUsuario.add(lblTitulo_CadastroUsuario);
				
			boxTipoFuncionario = new JComboBox();
			boxTipoFuncionario.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Funcionario", "Outro"}));
			boxTipoFuncionario.setToolTipText("");
			boxTipoFuncionario.setBounds(204, 229, 288, 20);
			cadastroUsuario.add(boxTipoFuncionario);
				
			//Botão responsavel pelo cadastro de usuario
			JButton btnCadastrarUsuario = new JButton("Cadastrar");
			btnCadastrarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					String [] form_U = new String[7];
					String aux = new String();
					if(tipo == 4){
						form_U[0] = textFieldCPFUsuario.getText();
						form_U[1] = textFieldRGUsuario.getText();
						form_U[2] = textFieldNomeUsuario.getText();
						form_U[3] = textFieldEmailUsuario.getText();
						form_U[4] = textFieldSenhaUsuario.getText();
						form_U[5] = textFieldConfirmacaoUsuario.getText();
						form_U[6] = boxTipoFuncionario.getToolTipText();
						if(form_U[6].equals("Administrador")) {
							aux = "A";
						}
						if(form_U[6].equals("Funcionario")) {
							aux = "F";
						}
						if(form_U[6].equals("Outro")) {
							aux = "O";
						}
						System.out.println(form_U[0] + " " + form_U[1] + " " + form_U[2] + " " + form_U[3] + " " + form_U[4] + " " + form_U[5] + " " + form_U[6] + " " + aux);
						if(form_U[4].equals(form_U[5])){
							Usuario.cadastro(form_U, form_U[6]);
						}
					}
						
						
				}
			});
			btnCadastrarUsuario.setBounds(518, 114, 95, 45);
			cadastroUsuario.add(btnCadastrarUsuario);
				
				
			//-----Panel de consulta de usuario-----	
				consultaUsuario = new JPanel();
				consultaUsuario.setVisible(false);
				consultaUsuario.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(consultaUsuario);
				consultaUsuario.setLayout(null);
				
				JLabel lblConsultaUsuarios = new JLabel("CONSULTA - USUARIOS");
				lblConsultaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblConsultaUsuarios.setBounds(232, 11, 233, 14);
				consultaUsuario.add(lblConsultaUsuarios);
				
				JComboBox cBUsuarios = new JComboBox(Usuario.getNames());
				cBUsuarios.setBounds(39, 123, 248, 20);
				consultaUsuario.add(cBUsuarios);
				
				JLabel lblNome_C = new JLabel("Nome:");
				lblNome_C.setBounds(356, 72, 46, 14);
				consultaUsuario.add(lblNome_C);
				
				JLabel lblRg_C = new JLabel("RG:");
				lblRg_C.setBounds(356, 104, 46, 14);
				consultaUsuario.add(lblRg_C);
				
				JLabel lblCpf_C = new JLabel("CPF:");
				lblCpf_C.setBounds(356, 139, 46, 14);
				consultaUsuario.add(lblCpf_C);
				
				JLabel lblEmail_C = new JLabel("Email:");
				lblEmail_C.setBounds(356, 176, 46, 14);
				consultaUsuario.add(lblEmail_C);
				
				JLabel lblDadoAquiNo = new JLabel("Nome do usu\u00E1rio");
				lblDadoAquiNo.setVerticalAlignment(SwingConstants.TOP);
				lblDadoAquiNo.setBounds(426, 72, 156, 14);
				consultaUsuario.add(lblDadoAquiNo);
				
				JLabel lblRgDoUsurio = new JLabel("RG do usu\u00E1rio");
				lblRgDoUsurio.setVerticalAlignment(SwingConstants.TOP);
				lblRgDoUsurio.setBounds(426, 104, 156, 14);
				consultaUsuario.add(lblRgDoUsurio);
				
				JLabel lblCpfDoUsurio = new JLabel("CPF do usu\u00E1rio");
				lblCpfDoUsurio.setVerticalAlignment(SwingConstants.TOP);
				lblCpfDoUsurio.setBounds(426, 139, 156, 14);
				consultaUsuario.add(lblCpfDoUsurio);
				
				JLabel lblEmailDoUsurio = new JLabel("Email do usu\u00E1rio");
				lblEmailDoUsurio.setVerticalAlignment(SwingConstants.TOP);
				lblEmailDoUsurio.setBounds(426, 176, 156, 14);
				consultaUsuario.add(lblEmailDoUsurio);
				
				JLabel lblSelecioneOUsurio = new JLabel("Selecione o usu\u00E1rio que deseja consultar:");
				lblSelecioneOUsurio.setBounds(40, 104, 248, 14);
				consultaUsuario.add(lblSelecioneOUsurio);
				
				JLabel lblTipo = new JLabel("Tipo:");
				lblTipo.setBounds(356, 209, 46, 14);
				consultaUsuario.add(lblTipo);
				
				JLabel lblTipoDoUsurio = new JLabel("Tipo do usu\u00E1rio");
				lblTipoDoUsurio.setVerticalAlignment(SwingConstants.TOP);
				lblTipoDoUsurio.setBounds(426, 209, 156, 14);
				consultaUsuario.add(lblTipoDoUsurio);
				
				JButton btnVisualizar = new JButton("Visualizar");
				btnVisualizar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nomeSelecionado = (String)cBUsuarios.getSelectedItem(); // pega o item selecionado no comboBox
						 String [] result =  Usuario.getInfos(nomeSelecionado);
						 if(result != null){
							 lblCpfDoUsurio.setText(result[0]);
							 lblRgDoUsurio.setText(result[1]);
							 lblDadoAquiNo.setText(result[2]);
							 lblEmailDoUsurio.setText(result[3]);
							 result[4] = Usuario.getTipo(result[0]);
							 if(result[4] != null){
								 lblTipoDoUsurio.setText(result[4]);
							 }
							 else lblTipoDoUsurio.setText("Tipo não cadastrado");
						 }
					}
				});
				btnVisualizar.setBounds(100, 154, 133, 36);
				consultaUsuario.add(btnVisualizar);

		 
				//-----Panel de remocao de usuario-----
				remocaoUsuario = new JPanel();
				remocaoUsuario.setVisible(false);
				remocaoUsuario.setBounds(281, 129, 638, 281);
				frame.getContentPane().add(remocaoUsuario);
				remocaoUsuario.setLayout(null);
				
				JLabel lblRemooUsuarios = new JLabel("REMO\u00C7\u00C3O - USUARIOS");
				lblRemooUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRemooUsuarios.setBounds(208, 11, 264, 14);
				remocaoUsuario.add(lblRemooUsuarios);
				
				JComboBox comboBoxRemocao_U = new JComboBox(Usuario.getNames());
				comboBoxRemocao_U.setBounds(185, 116, 264, 20);
				remocaoUsuario.add(comboBoxRemocao_U);
				
				JLabel lblEscolhaOUsurio = new JLabel("Escolha o usu\u00E1rio que deseja remover :");
				lblEscolhaOUsurio.setBounds(205, 95, 257, 14);
				remocaoUsuario.add(lblEscolhaOUsurio);
				
				JButton btnRemover = new JButton("Remover");
				btnRemover.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir ?") == JOptionPane.YES_OPTION) {
							Usuario.delete((String)comboBoxRemocao_U.getSelectedItem());
						}
							
					}
				});
				btnRemover.setBounds(250, 147, 119, 30);
				remocaoUsuario.add(btnRemover);
				
				JLabel lblRemocaoUsuarios = new JLabel("REMO\u00C7\u00C3O - USUARIOS");
				lblRemocaoUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblRemocaoUsuarios.setBounds(208, 11, 264, 14);
				remocaoUsuario.add(lblRemocaoUsuarios);
				
				
				//-----Panel de alteracao de usuario-----
				alteracaoUsuario = new JPanel();
				alteracaoUsuario.setVisible(false);
				alteracaoUsuario.setBounds(282, 129, 638, 281);
				frame.getContentPane().add(alteracaoUsuario);
				alteracaoUsuario.setLayout(null);
				
				JLabel lblAlteraoUsuarios = new JLabel("ALTERA\u00C7\u00C3O - USUARIOS");
				lblAlteraoUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblAlteraoUsuarios.setBounds(220, 11, 289, 14);
				alteracaoUsuario.add(lblAlteraoUsuarios);
				
				JComboBox comboBoxUsuario_A = new JComboBox(Usuario.getNames());
				comboBoxUsuario_A.setBounds(23, 133, 209, 19);
				alteracaoUsuario.add(comboBoxUsuario_A);
				
				JButton btnAlterarUsuario = new JButton("Alterar");
				btnAlterarUsuario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String [] form = new String[4];
						
						form[0] = textNomeUsuario_A.getText();
						form[1] = textEmailUsuario_A.getText();
						form[2] = textSenhaUsuario_A.getText();
						form[3] = textConfirmacao_A.getText();
						
						if(form[2].equals(form[3])){
							Usuario.update(form,(String)comboBoxUsuario_A.getSelectedItem());	
						}else{
							JOptionPane.showMessageDialog(null, "As senhas estão diferetes !");
						}
					
						
					}
				});
				btnAlterarUsuario.setBounds(519, 125, 85, 46);
				alteracaoUsuario.add(btnAlterarUsuario);
				
				textNomeUsuario_A = new JTextField();
				textNomeUsuario_A.setBounds(269, 66, 209, 19);
				alteracaoUsuario.add(textNomeUsuario_A);
				textNomeUsuario_A.setColumns(10);
				
				textEmailUsuario_A = new JTextField();
				textEmailUsuario_A.setBounds(269, 112, 209, 19);
				alteracaoUsuario.add(textEmailUsuario_A);
				textEmailUsuario_A.setColumns(10);
				
				textSenhaUsuario_A = new JTextField();
				textSenhaUsuario_A.setBounds(269, 152, 209, 19);
				alteracaoUsuario.add(textSenhaUsuario_A);
				textSenhaUsuario_A.setColumns(10);
				
				textConfirmacao_A = new JTextField();
				textConfirmacao_A.setBounds(269, 196, 209, 19);
				alteracaoUsuario.add(textConfirmacao_A);
				textConfirmacao_A.setColumns(10);
				
				JComboBox comboBoxTipoUsuario_A = new JComboBox();
				comboBoxTipoUsuario_A.setBounds(269, 234, 209, 19);
				alteracaoUsuario.add(comboBoxTipoUsuario_A);
				
				JLabel lblNome_A = new JLabel("Nome:");
				lblNome_A.setBounds(269, 54, 209, 13);
				alteracaoUsuario.add(lblNome_A);
				
				JLabel lblEmail_A = new JLabel("Email:");
				lblEmail_A.setBounds(269, 95, 209, 13);
				alteracaoUsuario.add(lblEmail_A);
				
				JLabel lblSenha_A = new JLabel("Senha:");
				lblSenha_A.setBounds(269, 141, 45, 13);
				alteracaoUsuario.add(lblSenha_A);
				
				JLabel lblConfirmeASenha_A = new JLabel("Confirme a Senha:");
				lblConfirmeASenha_A.setBounds(269, 181, 209, 13);
				alteracaoUsuario.add(lblConfirmeASenha_A);
				
				JLabel lblTipo_A = new JLabel("Tipo:");
				lblTipo_A.setBounds(269, 219, 45, 13);
				alteracaoUsuario.add(lblTipo_A);
				
				JButton btnConsultaAlteracao_U = new JButton("Consulta");
				btnConsultaAlteracao_U.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nomeSelecionado = (String)comboBoxUsuario_A.getSelectedItem();
						String []result = Usuario.getInfos(nomeSelecionado);
						textNomeUsuario_A.setText(result[2]);
						textEmailUsuario_A.setText(result[3]);
						textSenhaUsuario_A.setText(result[4]);
						
					}
				});
				btnConsultaAlteracao_U.setBounds(82, 163, 89, 23);
				alteracaoUsuario.add(btnConsultaAlteracao_U);
				
				JLabel lblNewLabelA = new JLabel("Selecione o usu\u00E1rio que deseja alterar:");
				lblNewLabelA.setBounds(35, 112, 209, 14);
				alteracaoUsuario.add(lblNewLabelA);
		
				
				
		//BOTOES LATERAIS
		
		//Botão de Inserção
		btnInserir_P = new JButton("Inserir");
		btnInserir_P.setVisible(false);
		btnInserir_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetaTudo();
				btnInserir_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {
					cadastroProduto.setVisible(true);
				}
				else if(tipo == 2) {
					cadastroVenda.setVisible(true);
				}
				else if(tipo == 3) {
					cadastroEstoque.setVisible(true);
				}
				else if(tipo == 4) {
					cadastroUsuario.setVisible(true);
				}
			}
		});
		btnInserir_P.setBackground(new Color(218, 232, 252));
		btnInserir_P.setBounds(86, 143, 117, 46);
		frame.getContentPane().add(btnInserir_P);
		
		//Botão de Consulta
		btnConsulta_P = new JButton("Consulta");
		btnConsulta_P.setVisible(false);
		btnConsulta_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetaTudo();
				btnConsulta_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {
			
					String[] col = new String[5];
					col[0] = "COD_PRODUTO";
					col[1] = "NOME";
					col[2] = "DESCRICAO";
					col[3] = "LUCRO_ESPERADO";
					col[4] = "QNTD_ESTOQUE";
					String sql = "SELECT*FROM PRODUTO";
					TelaConsulta t = new TelaConsulta(consultaProduto,"Produto","","SELECT*FROM PRODUTO",col);
					consultaProduto.setVisible(true);
					

					
					
					consultaProduto.setViewportView(t.table);
					
					
					
				}
				else if(tipo == 2) {
					consultaVenda.setVisible(true);
				}
				else if(tipo == 3) {
					consultaEstoque.setVisible(true);
				}
				else if(tipo == 4) {
					consultaUsuario.setVisible(true);
				}
			}
		});
		btnConsulta_P.setBackground(new Color(218, 232, 252));
		btnConsulta_P.setBounds(86, 211, 117, 46);
		frame.getContentPane().add(btnConsulta_P);
		
		//Botão de Remoção
		btnRemocao_P = new JButton("Remo\u00E7\u00E3o");
		btnRemocao_P.setVisible(false);
		btnRemocao_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetaTudo();
				btnRemocao_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {
					remocaoProduto.setVisible(true);
				}
				else if(tipo == 2) {
					remocaoVenda.setVisible(true);
				}
				else if(tipo == 3) {
					remocaoEstoque.setVisible(true);
				}
				else if(tipo == 4) {
					remocaoUsuario.setVisible(true);
				}
			}
		});
		btnRemocao_P.setBackground(new Color(218, 232, 252));
		btnRemocao_P.setBounds(86, 275, 117, 46);
		frame.getContentPane().add(btnRemocao_P);
		
		//Botão de Alteracao
		btnAlteracao_P = new JButton("Altera\u00E7\u00E3o");
		btnAlteracao_P.setVisible(false);
		btnAlteracao_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetaTudo();
				btnAlteracao_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {	
					alteracaoProduto.removeAll();
					alteracaoProduto.revalidate();
					alteracaoProduto.repaint();
					new panelAlteracaoProduto(frame,alteracaoProduto);	
				
					
				}
				else if(tipo == 2) {
					alteracaoVenda.setVisible(true);
				}
				else if(tipo == 3) {
					alteracaoEstoque.setVisible(true);
				}
				else if(tipo == 4) {
					alteracaoUsuario.setVisible(true);
				}
			}
		});
		btnAlteracao_P.setBackground(new Color(218, 232, 252));
		btnAlteracao_P.setBounds(86, 346, 117, 46);
		frame.getContentPane().add(btnAlteracao_P);
		
		
		//BOTOES DE CIMA
		
		//Botão de produto
		btnProduto = new JButton("Produto");
		btnProduto.setBackground(SystemColor.menu);
		btnProduto.setForeground(Color.BLACK);
		btnProduto.setBounds(64, 55, 159, 55);
		frame.getContentPane().add(btnProduto);
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 1;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				btnRemocao_P.setEnabled(true);
				btnAlteracao_P.setEnabled(true);
				resetaTudo();
				resetaBotoesCima();
				btnProduto.setBackground(SystemColor.activeCaption);
			}
		});
		
		
		//Botão de vendas
		btnVendas = new JButton("Vendas");
		btnVendas.setBackground(SystemColor.menu);
		btnVendas.setForeground(Color.BLACK);
		btnVendas.setBounds(297, 55, 159, 55);
		frame.getContentPane().add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 2;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				btnRemocao_P.setEnabled(false);
				btnAlteracao_P.setEnabled(false);
				resetaTudo();
				resetaBotoesCima();
				btnVendas.setBackground(SystemColor.activeCaption);
			}
		});
		
		
		//Botão de estoque
		btnEstoque = new JButton("Estoque");
		btnEstoque.setBackground(SystemColor.menu);
		btnEstoque.setForeground(Color.BLACK);
		btnEstoque.setBounds(529, 55, 159, 55);
		frame.getContentPane().add(btnEstoque);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 3;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				btnRemocao_P.setEnabled(true);
				btnAlteracao_P.setEnabled(true);
				resetaTudo();
				resetaBotoesCima();
				btnEstoque.setBackground(SystemColor.activeCaption);
			}
		});
				
	
		//Botão de usuarios
		btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.setBackground(SystemColor.menu);
		btnUsuarios.setForeground(Color.BLACK);
		btnUsuarios.setBounds(760, 55, 160, 55);
		frame.getContentPane().add(btnUsuarios);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 4;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				btnRemocao_P.setEnabled(true);
				btnAlteracao_P.setEnabled(true);
				resetaTudo();
				resetaBotoesCima();
				btnUsuarios.setBackground(SystemColor.activeCaption);
			}
		});
	}
}
