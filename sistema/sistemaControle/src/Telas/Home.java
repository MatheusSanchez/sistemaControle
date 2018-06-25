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

public class Home {

	JFrame frame;
	private static Container container;
	int tipo;
	private JTextField textNomeProduto;
	private JTextField textFieldDescricaoProduto;
	private JTextField textFieldLucroProduto;
	
	
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
		JPanel cadastroProduto = new JPanel();
		cadastroProduto.setVisible(false);
		cadastroProduto.setBounds(200, 121, 690, 289);
		frame.getContentPane().add(cadastroProduto);
		cadastroProduto.setLayout(null);
		
		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(179, 44, 86, 20);
		cadastroProduto.add(textNomeProduto);
		textNomeProduto.setColumns(10);
		
		textFieldDescricaoProduto = new JTextField();
		textFieldDescricaoProduto.setColumns(10);
		textFieldDescricaoProduto.setBounds(179, 79, 86, 20);
		cadastroProduto.add(textFieldDescricaoProduto);
		
		textFieldLucroProduto = new JTextField();
		textFieldLucroProduto.setColumns(10);
		textFieldLucroProduto.setBounds(179, 122, 86, 20);
		cadastroProduto.add(textFieldLucroProduto);
		
		JButton btnCadastrar = new JButton("cadastrar !");
		btnCadastrar.addActionListener(new ActionListener() {
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
		btnCadastrar.setBounds(335, 43, 89, 23);
		cadastroProduto.add(btnCadastrar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(69, 47, 46, 14);
		cadastroProduto.add(lblNome);
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setBounds(69, 82, 46, 14);
		cadastroProduto.add(lblDescricao);
		
		JLabel lblLucroEsperado = new JLabel("Lucro Esperado");
		lblLucroEsperado.setBounds(69, 125, 74, 14);
		cadastroProduto.add(lblLucroEsperado);
		
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setVisible(false);
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tipo == 1) {
					cadastroProduto.setVisible(true);
				}
			}
		});
		btnCadastro.setBounds(25, 193, 89, 23);
		frame.getContentPane().add(btnCadastro);
		
		JButton btnConsulta = new JButton("Consulta");
		btnConsulta.setVisible(false);
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsulta.setBounds(25, 227, 89, 23);
		frame.getContentPane().add(btnConsulta);
		
		JButton btnRemocao = new JButton("Remo\u00E7\u00E3o");
		btnRemocao.setVisible(false);
		btnRemocao.setBounds(25, 266, 89, 23);
		frame.getContentPane().add(btnRemocao);
		
		JButton btnAlteracao = new JButton("Alteracao");
		btnAlteracao.setVisible(false);
		btnAlteracao.setBounds(25, 307, 89, 23);
		frame.getContentPane().add(btnAlteracao);
		
		
		//Botão de produto
		JButton btnProduto = new JButton("Produto");
		btnProduto.setForeground(Color.BLACK);
		btnProduto.setBounds(55, 55, 159, 55);
		frame.getContentPane().add(btnProduto);
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 1;
				btnCadastro.setVisible(true);
				btnConsulta.setVisible(true);
				btnRemocao.setVisible(true);
				btnAlteracao.setVisible(true);
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
				btnCadastro.setVisible(true);
				btnConsulta.setVisible(true);
				btnRemocao.setVisible(true);
				btnAlteracao.setVisible(true);
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
				btnCadastro.setVisible(true);
				btnConsulta.setVisible(true);
				btnRemocao.setVisible(true);
				btnAlteracao.setVisible(true);
			}
		});
		
		
		//Botão de usuarios
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setForeground(Color.BLACK);
		btnUsuarios.setBounds(760, 55, 159, 55);
		frame.getContentPane().add(btnUsuarios);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo = 4;
				btnCadastro.setVisible(true);
				btnConsulta.setVisible(true);
				btnRemocao.setVisible(true);
				btnAlteracao.setVisible(true);
			}
		});
	
		
	}
}
