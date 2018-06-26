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
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Classe da janela pos login, onde existe a tela inicial com todas as funcionalidades
 *
 */
public class Home {

	JFrame frame;
	private static Container container;
	int tipo;
	private JTextField textNomeProduto;
	private JTextField textFieldDescricaoProduto;
	private JTextField textFieldLucroProduto;
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
	
	
	public Home(Container c, JFrame j) {
		
		initialize(c,j);
		this.frame.setVisible(true);
	}

	/**
	 * inicializa o conteúdo do Frame e do Container
	 * @param c Container da janela
	 * @param j Frame da aplicação
	 */
	private void initialize(Container c,JFrame j) {
		frame = j;
		frame.getContentPane().setBackground(new Color(145,170,157));
		container = c;

		frame.setBounds(100, 100, 973, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 973, 30);
		panel.setBackground(new Color(25,52,65));
		frame.getContentPane().add(panel);
		
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
		//-----Panel de cadastro de produto-----
		JPanel cadastroProduto = new JPanel();
		cadastroProduto.setVisible(false);
		cadastroProduto.setBounds(282, 121, 637, 289);
		frame.getContentPane().add(cadastroProduto);
		cadastroProduto.setLayout(null);
		
		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(179, 44, 192, 20);
		cadastroProduto.add(textNomeProduto);
		textNomeProduto.setColumns(10);
		
		textFieldDescricaoProduto = new JTextField();
		textFieldDescricaoProduto.setColumns(10);
		textFieldDescricaoProduto.setBounds(179, 92, 192, 20);
		cadastroProduto.add(textFieldDescricaoProduto);
		
		textFieldLucroProduto = new JTextField();
		textFieldLucroProduto.setColumns(10);
		textFieldLucroProduto.setBounds(179, 140, 192, 20);
		cadastroProduto.add(textFieldLucroProduto);
		
		//Botão responsável pelo cadastro de um produto
		JButton btnCadastrarProduto = new JButton("Cadastrar");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] form_P = new String[3];
				if(tipo == 1){
					form_P[0] = textNomeProduto.getText();
					form_P[1] = textFieldDescricaoProduto.getText();
					form_P[2] = textFieldLucroProduto.getText();
					System.out.println(form_P[0] + form_P[1] +form_P[2]);
					Produto.cadastro(form_P);
				}
				
				
			}
		});
		btnCadastrarProduto.setBounds(425, 115, 118, 45);
		cadastroProduto.add(btnCadastrarProduto);
		
		JLabel lblNome_P = new JLabel("Nome :");
		lblNome_P.setBounds(69, 47, 89, 14);
		cadastroProduto.add(lblNome_P);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o : ");
		lblDescricao.setBounds(69, 95, 89, 14);
		cadastroProduto.add(lblDescricao);
		
		JLabel lblLucroEsperado = new JLabel("Lucro esperado :");
		lblLucroEsperado.setBounds(69, 143, 100, 14);
		cadastroProduto.add(lblLucroEsperado);
		
		//-----Panel de remoção de um produto-----
		JPanel remocaoProduto = new JPanel();
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
		
		//Botão que faz a ação de remover um produto
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
		
		//Panel de Consulta de Produto
		JScrollPane consultaProduto = new JScrollPane();
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
		
		
		//De Usuário
		//-----Panel de cadastro de usuario-----
		JPanel cadastroUsuario = new JPanel();
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
		
		//Botão responsavel pelo cadastro de usuario
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
		
		
		//BOTOES LATERAIS
		
		//Botão de Inserção
		JButton btnInserir_P = new JButton("Inserir");
		btnInserir_P.setVisible(false);
		btnInserir_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo == 1) {
					cadastroProduto.setVisible(true);
				}
				else if(tipo == 4) {
					cadastroUsuario.setVisible(true);
				}
			}
		});
		btnInserir_P.setBounds(99, 149, 89, 23);
		frame.getContentPane().add(btnInserir_P);
		
		
		//Botão de Consulta
		JButton btnConsulta_P = new JButton("Consulta");
		btnConsulta_P.setVisible(false);
		btnConsulta_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipo == 1) {
					System.out.println("Consultando produtos cadastrados");
					consultaProduto.setVisible(true);
				}
			}
		});
		btnConsulta_P.setBounds(99, 213, 89, 23);
		frame.getContentPane().add(btnConsulta_P);
		
		//Botão de Remoção
		JButton btnRemocao_P = new JButton("Remo\u00E7\u00E3o");
		btnRemocao_P.setVisible(false);
		btnRemocao_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo == 1) {
					remocaoProduto.setVisible(true);
				}
				else if(tipo == 4) {
					cadastroUsuario.setVisible(true);
				}
			}
		});
		btnRemocao_P.setBounds(99, 282, 89, 23);
		frame.getContentPane().add(btnRemocao_P);
		
		//Botão de Alteracao
		JButton btnAlteracao_P = new JButton("Altera\u00E7\u00E3o");
		btnAlteracao_P.setVisible(false);
		btnAlteracao_P.setBounds(99, 353, 89, 23);
		frame.getContentPane().add(btnAlteracao_P);
		
		
		//BOTOES DE CIMA
		
		//Botão de produto
		JButton btnProduto = new JButton("Produto");
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
			}
		});
		
		
		//Botão de vendas
		JButton btnVendas = new JButton("Vendas");
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
			}
		});
		
		
		//Botão de estoque
		JButton btnEstoque = new JButton("Estoque");
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
			}
		});
				
	
		//Botão de usuarios
		JButton btnUsuarios = new JButton("Usu\u00E1rios");
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
			}
		});
	}
}
