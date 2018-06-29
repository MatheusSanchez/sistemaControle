package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import back.Produto;
import back.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import java.awt.Font;
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
	private JTextField textNomeProduto_A;
	private JTextField textFieldDescricaoProduto_A;
	private JTextField textFieldLucroProduto_A;
	private JTextField textNomeProduto_C;
	private JTextField textFieldDescricaoProduto_C;
	private JTextField textFieldLucroProduto_C;
	private JTextField textFieldNomeUsuario;
	private JTextField textFieldRGUsuario;
	private JTextField textFieldCPFUsuario;
	private JTextField textFieldEmailUsuario;
	private JTextField textFieldSenhaUsuario;
	private JTextField textFieldConfirmacaoUsuario;
	private JTextField textFieldTipoUsuario;
	private JTextField textFieldProduto;
	private JTextField textFieldConfirmacaoProduto;
	private JTable table;
	private JPanel cadastroProduto;
	private JScrollPane consultaProduto;
	private JPanel alteracaoProduto;
	private JPanel remocaoProduto;
	private JPanel cadastroVenda;
	private JPanel consultaVenda;
	private JPanel remocaoVenda;
	private JPanel alteracaoVenda;
	private JPanel cadastroEstoque;
	private JPanel consultaEstoque;
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
	
	public Home(Container c, JFrame j) {
		
		initialize(c,j);
		this.frame.setVisible(true);
	}
	
	/**
	 * Fun��o que seta todas os panels de informacao como false, para que quando novos panels forem clicados n�o fiquem sobrepostos
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
		btnInserir_P.setBackground(new Color(240, 240, 240));
		btnConsulta_P.setBackground(new Color(240, 240, 240));
		btnRemocao_P.setBackground(new Color(240, 240, 240));
		btnAlteracao_P.setBackground(new Color(240, 240, 240));
	}
	
	private void resetaBotoesCima() {
		btnProduto.setBackground(new Color(240, 240, 240));
		btnVendas.setBackground(new Color(240, 240, 240));
		btnEstoque.setBackground(new Color(240, 240, 240));
		btnUsuarios.setBackground(new Color(240, 240, 240));
	}

	/**
	 * inicializa o conte�do do Frame e do Container
	 * @param c Container da janela
	 * @param j Frame da aplica��o
	 */
	private void initialize(Container c,JFrame j) {
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
				Main.novaTela(frame.getContentPane());
				TelaLogin window = new TelaLogin();
				window.frame.setVisible(true);
			}
		});
		btnLogout.setBounds(836, 5, 85, 21);
		panel.add(btnLogout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(62,96,111));
		panel_1.setBounds(0, 421, 957, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTodosOsDireitos = new JLabel("TODOS OS DIREITOS RESERVADOS.");
		lblTodosOsDireitos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTodosOsDireitos.setBounds(23, 20, 513, 29);
		panel_1.add(lblTodosOsDireitos);
		
		
		//PAINEIS
		
		//De Produtos:
		//-----Panel de alteracao de produto-----
		alteracaoProduto = new JPanel();
		alteracaoProduto.setVisible(false);
		alteracaoProduto.setBounds(282, 121, 637, 255);
		frame.getContentPane().add(alteracaoProduto);
		alteracaoProduto.setLayout(null);
		
		textNomeProduto_A = new JTextField();
		textNomeProduto_A.setBounds(179, 109, 192, 20);
		alteracaoProduto.add(textNomeProduto_A);
		textNomeProduto_A.setColumns(10);
		
		textFieldDescricaoProduto_A = new JTextField();
		textFieldDescricaoProduto_A.setColumns(10);
		textFieldDescricaoProduto_A.setBounds(179, 152, 192, 20);
		alteracaoProduto.add(textFieldDescricaoProduto_A);
		
		textFieldLucroProduto_A = new JTextField();
		textFieldLucroProduto_A.setColumns(10);
		textFieldLucroProduto_A.setBounds(179, 194, 192, 20);
		alteracaoProduto.add(textFieldLucroProduto_A);
		
		//Bot�o respons�vel pela alteracao de um produto
		JButton btnAlterarProduto = new JButton("Alterar");
		btnAlterarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] form_P = new String[3];
				if(tipo == 1){
					form_P[0] = textNomeProduto_A.getText();
					form_P[1] = textFieldDescricaoProduto_A.getText();
					form_P[2] = textFieldLucroProduto_A.getText();
					System.out.println(form_P[0] + form_P[1] +form_P[2]);
					Produto.cadastro(form_P);
				}
			}
		});
		btnAlterarProduto.setBounds(438, 152, 118, 45);
		alteracaoProduto.add(btnAlterarProduto);
		
		JLabel lblNome_P = new JLabel("Nome do produto a ser alterado :");
		lblNome_P.setBounds(10, 68, 159, 14);
		alteracaoProduto.add(lblNome_P);
		
		JLabel lblDescricao = new JLabel("Nova descri\u00E7\u00E3o : ");
		lblDescricao.setBounds(78, 154, 79, 14);
		alteracaoProduto.add(lblDescricao);
		
		JLabel lblLucroEsperado = new JLabel("Novo lucro esperado :");
		lblLucroEsperado.setBounds(57, 196, 112, 14);
		alteracaoProduto.add(lblLucroEsperado);
		
		JLabel lblTitulo_AlteracaoProduto = new JLabel("ALTERA\u00C7\u00C3O - PRODUTO");
		lblTitulo_AlteracaoProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_AlteracaoProduto.setBounds(209, 10, 257, 45);
		alteracaoProduto.add(lblTitulo_AlteracaoProduto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
		comboBox.setBounds(177, 65, 194, 21);
		alteracaoProduto.add(comboBox);
		
		JLabel lblNovoNome = new JLabel("Novo nome :");
		lblNovoNome.setBounds(96, 112, 61, 13);
		alteracaoProduto.add(lblNovoNome);
		
		
		//-----Panel de cadastro de produto-----
		cadastroProduto = new JPanel();
		cadastroProduto.setVisible(false);
		cadastroProduto.setBounds(282, 121, 637, 255);
		frame.getContentPane().add(cadastroProduto);
		cadastroProduto.setLayout(null);
		
		textNomeProduto_C = new JTextField();
		textNomeProduto_C.setBounds(179, 76, 192, 20);
		cadastroProduto.add(textNomeProduto_C);
		textNomeProduto_C.setColumns(10);
		
		textFieldDescricaoProduto_C = new JTextField();
		textFieldDescricaoProduto_C.setColumns(10);
		textFieldDescricaoProduto_C.setBounds(179, 128, 192, 20);
		cadastroProduto.add(textFieldDescricaoProduto_C);
		
		textFieldLucroProduto_C = new JTextField();
		textFieldLucroProduto_C.setColumns(10);
		textFieldLucroProduto_C.setBounds(179, 177, 192, 20);
		cadastroProduto.add(textFieldLucroProduto_C);
		
		//Bot�o respons�vel pelo cadastro de um produto
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
		btnCadastrarProduto.setBounds(438, 152, 118, 45);
		cadastroProduto.add(btnCadastrarProduto);
		
		JLabel lblNomeProd_I = new JLabel("Nome :");
		lblNomeProd_I.setBounds(80, 78, 89, 14);
		cadastroProduto.add(lblNomeProd_I);
		
		JLabel lblDescricao_I = new JLabel("Descri\u00E7\u00E3o : ");
		lblDescricao_I.setBounds(80, 130, 89, 14);
		cadastroProduto.add(lblDescricao_I);
		
		JLabel lblLucroEsperado_I = new JLabel("Lucro esperado :");
		lblLucroEsperado_I.setBounds(69, 179, 100, 14);
		cadastroProduto.add(lblLucroEsperado_I);
		
		JLabel lblTitulo_CadastroProduto = new JLabel("CADASTRO - PRODUTO");
		lblTitulo_CadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_CadastroProduto.setBounds(209, 10, 257, 45);
		cadastroProduto.add(lblTitulo_CadastroProduto);
		
		//-----Panel de remo��o de um produto-----
		remocaoProduto = new JPanel();
		remocaoProduto.setVisible(false);
		remocaoProduto.setBounds(282, 149, 636, 227);
		frame.getContentPane().add(remocaoProduto);
		remocaoProduto.setLayout(null);
		
		textFieldProduto = new JTextField();
		textFieldProduto.setBounds(38, 49, 280, 28);
		remocaoProduto.add(textFieldProduto);
		textFieldProduto.setColumns(10);
		
		textFieldConfirmacaoProduto = new JTextField();
		textFieldConfirmacaoProduto.setBounds(38, 102, 280, 28);
		remocaoProduto.add(textFieldConfirmacaoProduto);
		textFieldConfirmacaoProduto.setColumns(10);
		
		//Bot�o que faz a a��o de remover um produto
		JButton btnRemover_P = new JButton("Remover");
		btnRemover_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] form_P = new String[2];
				if(tipo == 1){
					form_P[0] = textFieldProduto.getText();
					form_P[1] = textFieldConfirmacaoProduto.getText();
					if(form_P[0].equals(form_P[1])) System.out.println(form_P[0] + " " +  form_P[1]);
				}
				
				
			}
		});
		btnRemover_P.setBounds(417, 84, 115, 46);
		remocaoProduto.add(btnRemover_P);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto a ser removido :");
		lblNomeDoProduto.setBounds(38, 34, 280, 14);
		remocaoProduto.add(lblNomeDoProduto);
		
		JLabel lblNewLabel = new JLabel("Confirme o nome do produto a ser removido:");
		lblNewLabel.setBounds(38, 88, 280, 14);
		remocaoProduto.add(lblNewLabel);
		
		JLabel lblTitulo_Remo��oProduto = new JLabel("REMO��O - PRODUTO");
		lblTitulo_CadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_CadastroProduto.setBounds(209, 10, 257, 45);
		cadastroProduto.add(lblTitulo_CadastroProduto);
		
		//Panel de Consulta de Produto
		consultaProduto = new JScrollPane();
		consultaProduto.setVisible(false);
		consultaProduto.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(consultaProduto);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Descri\u00E7\u00E3o", "Quantidade", "Lucro"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.getColumnModel().getColumn(2).setPreferredWidth(136);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		consultaProduto.setViewportView(table);
		
		JLabel lblTitulo_ConsulaProduto = new JLabel("CONSULTA - PRODUTO");
		lblTitulo_CadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_CadastroProduto.setBounds(209, 10, 257, 45);
		cadastroProduto.add(lblTitulo_CadastroProduto);
		
		
		//De Venda
		//-----Panel de cadastro de venda-----
		cadastroVenda = new JPanel();
		cadastroVenda.setVisible(false);
		cadastroVenda.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(cadastroVenda);
		cadastroVenda.setLayout(null);
		
		JLabel lblCadastroVenda = new JLabel("CADASTRO - VENDA");
		lblCadastroVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCadastroVenda.setBounds(232, 11, 283, 14);
		cadastroVenda.add(lblCadastroVenda);
		
		//-----Panel de consulta de venda-----
		consultaVenda = new JPanel();
		consultaVenda.setVisible(false);
		consultaVenda.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(consultaVenda);
		consultaVenda.setLayout(null);
		
		JLabel lblConsultaVenda = new JLabel("CONSULTA - VENDAS");
		lblConsultaVenda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConsultaVenda.setBounds(253, 11, 171, 14);
		consultaVenda.add(lblConsultaVenda);
		
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
		cadastroEstoque.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(cadastroEstoque);
		cadastroEstoque.setLayout(null);
		
		JLabel lblCadastroEstoque = new JLabel("CADASTRO - ESTOQUE");
		lblCadastroEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCadastroEstoque.setBounds(218, 11, 254, 14);
		cadastroEstoque.add(lblCadastroEstoque);
		
		//-----Panel de consulta de estoque-----	
		consultaEstoque = new JPanel();
		consultaEstoque.setVisible(false);
		consultaEstoque.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(consultaEstoque);
		consultaEstoque.setLayout(null);
		
		JLabel lblConsultaEstoque = new JLabel("CONSULTA - ESTOQUE");
		lblConsultaEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConsultaEstoque.setBounds(193, 11, 230, 14);
		consultaEstoque.add(lblConsultaEstoque);
		 
		//-----Panel de remocao de estoque-----
		remocaoEstoque = new JPanel();
		remocaoEstoque.setVisible(false);
		remocaoEstoque.setBounds(282, 143, 637, 233);
		frame.getContentPane().add(remocaoEstoque);
		remocaoEstoque.setLayout(null);
		
		JLabel lblRemooEstoque = new JLabel("REMO\u00C7\u00C3O - ESTOQUE");
		lblRemooEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRemooEstoque.setBounds(213, 11, 215, 14);
		remocaoEstoque.add(lblRemooEstoque);
		
		//-----Panel de alteracao de estoque-----
		alteracaoEstoque = new JPanel();
		alteracaoEstoque.setVisible(false);
		alteracaoEstoque.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(alteracaoEstoque);
		alteracaoEstoque.setLayout(null);
		
		JLabel lblAlteraoEstoque = new JLabel("ALTERA\u00C7\u00C3O - ESTOQUE");
		lblAlteraoEstoque.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAlteraoEstoque.setBounds(214, 11, 255, 14);
		alteracaoEstoque.add(lblAlteraoEstoque);
		
		
		//De Usu�rio
		//-----Panel de cadastro de usuario-----
		cadastroUsuario = new JPanel();
		cadastroUsuario.setVisible(false);
		cadastroUsuario.setBounds(282, 121, 637, 289);
		frame.getContentPane().add(cadastroUsuario);
		cadastroUsuario.setLayout(null);
		
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setBounds(204, 33, 288, 20);
		cadastroUsuario.add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);
		
		textFieldRGUsuario = new JTextField();
		textFieldRGUsuario.setBounds(204, 64, 288, 20);
		cadastroUsuario.add(textFieldRGUsuario);
		textFieldRGUsuario.setColumns(10);
		
		textFieldCPFUsuario = new JTextField();
		textFieldCPFUsuario.setBounds(204, 95, 288, 20);
		cadastroUsuario.add(textFieldCPFUsuario);
		textFieldCPFUsuario.setColumns(10);
		
		textFieldEmailUsuario = new JTextField();
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
		
		textFieldTipoUsuario = new JTextField();
		textFieldTipoUsuario.setBounds(204, 229, 288, 20);
		cadastroUsuario.add(textFieldTipoUsuario);
		textFieldTipoUsuario.setColumns(10);
		
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
		lblTitulo_CadastroProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_CadastroProduto.setBounds(209, 10, 257, 45);
		cadastroProduto.add(lblTitulo_CadastroProduto);
		
		//Bot�o responsavel pelo cadastro de usuario
		JButton btnCadastrarUsuario = new JButton("Cadastrar");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String [] form_U = new String[7];
				if(tipo == 4){
					form_U[0] = textFieldCPFUsuario.getText();
					form_U[1] = textFieldRGUsuario.getText();
					form_U[2] = textFieldNomeUsuario.getText();
					form_U[3] = textFieldEmailUsuario.getText();
					form_U[4] = textFieldSenhaUsuario.getText();
					form_U[5] = textFieldConfirmacaoUsuario.getText();
					form_U[6] = textFieldTipoUsuario.getText();
					System.out.println(form_U[0] + " " + form_U[1] + " " + form_U[2] + " " + form_U[3] + " " + form_U[4] + " " + form_U[5] + " " + form_U[6]);
					if(form_U[4].equals(form_U[5])){
						Usuario.cadastro(form_U, form_U[6]);
					}
				}
				
				
			}
		});
		btnCadastrarUsuario.setBounds(505, 228, 89, 23);
		cadastroUsuario.add(btnCadastrarUsuario);
		
		//-----Panel de consulta de usuario-----	
		consultaUsuario = new JPanel();
		consultaUsuario.setVisible(false);
		consultaUsuario.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(consultaUsuario);
		consultaUsuario.setLayout(null);
		
		JLabel lblConsultaUsuarios = new JLabel("CONSULTA - USUARIOS");
		lblConsultaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConsultaUsuarios.setBounds(232, 11, 233, 14);
		consultaUsuario.add(lblConsultaUsuarios);
		 
		//-----Panel de remocao de usuario-----
		remocaoUsuario = new JPanel();
		remocaoUsuario.setVisible(false);
		remocaoUsuario.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(remocaoUsuario);
		remocaoUsuario.setLayout(null);
		
		JLabel lblRemooUsuarios = new JLabel("REMO\u00C7\u00C3O - USUARIOS");
		lblRemooUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRemooUsuarios.setBounds(208, 11, 264, 14);
		remocaoUsuario.add(lblRemooUsuarios);
		
		//-----Panel de alteracao de usuario-----
		alteracaoUsuario = new JPanel();
		alteracaoUsuario.setVisible(false);
		alteracaoUsuario.setBounds(282, 149, 637, 227);
		frame.getContentPane().add(alteracaoUsuario);
		alteracaoUsuario.setLayout(null);
		
		JLabel lblAlteraoUsuarios = new JLabel("ALTERA\u00C7\u00C3O - USUARIOS");
		lblAlteraoUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAlteraoUsuarios.setBounds(220, 11, 289, 14);
		alteracaoUsuario.add(lblAlteraoUsuarios);
		
		
		//BOTOES LATERAIS
		
		//Bot�o de Inser��o
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
		btnInserir_P.setBounds(99, 149, 89, 23);
		frame.getContentPane().add(btnInserir_P);
		
		//Bot�o de Consulta
		btnConsulta_P = new JButton("Consulta");
		btnConsulta_P.setVisible(false);
		btnConsulta_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetaTudo();
				btnConsulta_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {
					System.out.println("Consultando produtos cadastrados");
					consultaProduto.setVisible(true);
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
		btnConsulta_P.setBounds(99, 213, 89, 23);
		frame.getContentPane().add(btnConsulta_P);
		
		//Bot�o de Remo��o
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
		btnRemocao_P.setBounds(99, 282, 89, 23);
		frame.getContentPane().add(btnRemocao_P);
		
		//Bot�o de Alteracao
		btnAlteracao_P = new JButton("Altera\u00E7\u00E3o");
		btnAlteracao_P.setVisible(false);
		btnAlteracao_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetaTudo();
				btnAlteracao_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {
					alteracaoProduto.setVisible(true);
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
		btnAlteracao_P.setBounds(99, 353, 89, 23);
		frame.getContentPane().add(btnAlteracao_P);
		
		
		//BOTOES DE CIMA
		
		//Bot�o de produto
		btnProduto = new JButton("Produto");
		btnProduto.setForeground(Color.BLACK);
		btnProduto.setBounds(55, 55, 159, 55);
		frame.getContentPane().add(btnProduto);
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 1;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				resetaTudo();
				resetaBotoesCima();
				btnProduto.setBackground(SystemColor.activeCaption);
			}
		});
		
		
		//Bot�o de vendas
		btnVendas = new JButton("Vendas");
		btnVendas.setForeground(Color.BLACK);
		btnVendas.setBounds(282, 55, 159, 55);
		frame.getContentPane().add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 2;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				resetaTudo();
				resetaBotoesCima();
				btnVendas.setBackground(SystemColor.activeCaption);
			}
		});
		
		
		//Bot�o de estoque
		btnEstoque = new JButton("Estoque");
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
				resetaTudo();
				resetaBotoesCima();
				btnEstoque.setBackground(SystemColor.activeCaption);
			}
		});
				
	
		//Bot�o de usuarios
		btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.setForeground(Color.BLACK);
		btnUsuarios.setBounds(760, 55, 159, 55);
		frame.getContentPane().add(btnUsuarios);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 4;
				btnInserir_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
				resetaTudo();
				resetaBotoesCima();
				btnUsuarios.setBackground(SystemColor.activeCaption);
			}
		});
	}
}
