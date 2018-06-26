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
	
	
	public Home(Container c, JFrame j) {
		
		initialize(c,j);
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(62,96,111));
		panel_1.setBounds(0, 421, 957, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTodosOsDireitos = new JLabel("TODOS OS DIREITOS RESERVADOS.");
		lblTodosOsDireitos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTodosOsDireitos.setBounds(23, 20, 513, 29);
		panel_1.add(lblTodosOsDireitos);
		
		//Panel de produto
		/*JPanel cadastroProduto = new JPanel();
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
		
		JButton btnCadastrarProduto = new JButton("Cadastrar");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] form = new String[3];
				if(tipo == 1){
					form[0] = textNomeProduto.getText();
					form[1] = textFieldDescricaoProduto.getText();
					form[2] = textFieldLucroProduto.getText();
					System.out.println(form[0] + form[1] +form[2]);
					Produto.cadastro(form);
				}
				
				
			}
		});
		btnCadastrarProduto.setBounds(504, 139, 89, 23);
		cadastroProduto.add(btnCadastrarProduto);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(69, 47, 89, 14);
		cadastroProduto.add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o : ");
		lblDescricao.setBounds(69, 95, 89, 14);
		cadastroProduto.add(lblDescricao);
		
		JLabel lblLucroEsperado = new JLabel("Lucro esperado :");
		lblLucroEsperado.setBounds(69, 143, 89, 14);
		cadastroProduto.add(lblLucroEsperado);*/
		
		//Panel de cadastro de usuario
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
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(72, 36, 46, 14);
		cadastroUsuario.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("RG :");
		lblNewLabel.setBounds(72, 67, 46, 14);
		cadastroUsuario.add(lblNewLabel);
		
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
		
		//Botão de Cadastro
		JButton btnCadastro_P = new JButton("Cadastro");
		btnCadastro_P.setVisible(false);
		btnCadastro_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo == 1) {
					//cadastroProduto.setVisible(true);
				}
				else if(tipo == 4) {
					cadastroUsuario.setVisible(true);
				}
			}
		});
		btnCadastro_P.setBounds(99, 149, 89, 23);
		frame.getContentPane().add(btnCadastro_P);
		
		JButton btnConsulta_P = new JButton("Consulta");
		btnConsulta_P.setVisible(false);
		btnConsulta_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsulta_P.setBounds(99, 213, 89, 23);
		frame.getContentPane().add(btnConsulta_P);
		
		JButton btnRemocao_P = new JButton("Remo\u00E7\u00E3o");
		btnRemocao_P.setVisible(false);
		btnRemocao_P.setBounds(99, 282, 89, 23);
		frame.getContentPane().add(btnRemocao_P);
		
		JButton btnAlteracao_P = new JButton("Altera\u00E7\u00E3o");
		btnAlteracao_P.setVisible(false);
		btnAlteracao_P.setBounds(99, 353, 89, 23);
		frame.getContentPane().add(btnAlteracao_P);
		
		
		//Botão de produto
		JButton btnProduto = new JButton("Produto");
		btnProduto.setForeground(Color.BLACK);
		btnProduto.setBounds(55, 55, 159, 55);
		frame.getContentPane().add(btnProduto);
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 1;
				btnCadastro_P.setVisible(true);
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
		/*btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 2;
				btnCadastro_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
			}
		});*/
		
		
		//Botão de estoque
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setForeground(Color.BLACK);
		btnEstoque.setBounds(529, 55, 159, 55);
		frame.getContentPane().add(btnEstoque);
		/*btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 3;
				btnCadastro_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
			}
		});*/
				
	
		//Botão de usuarios
		JButton btnUsuarios = new JButton("Usu\u00E1rios");
		btnUsuarios.setForeground(Color.BLACK);
		btnUsuarios.setBounds(760, 55, 159, 55);
		frame.getContentPane().add(btnUsuarios);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 4;
				btnCadastro_P.setVisible(true);
				btnConsulta_P.setVisible(true);
				btnRemocao_P.setVisible(true);
				btnAlteracao_P.setVisible(true);
			}
		});
	}
}
