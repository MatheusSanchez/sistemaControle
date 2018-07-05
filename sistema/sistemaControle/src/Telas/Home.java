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
import panels.panelAlteracaoEstoque;
import panels.panelAlteracaoProduto;
import panels.panelAlteracaoUsuario;
import panels.panelCadastroEstoque;
import panels.panelCadastroProduto;
import panels.panelCadastroUsuario;
import panels.panelCadastroVenda;
import panels.panelConsultaEstoque;
import panels.panelConsultaProduto;
import panels.panelConsultaUsuario;
import panels.panelConsultaVenda;
import panels.panelRemocaoEstoque;
import panels.panelRemocaoProduto;
import panels.panelRemocaoUsuario;

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
	
	private JTable table;
	private JPanel cadastroProduto = new JPanel();
	private JScrollPane consultaProduto = new JScrollPane();
	private JPanel alteracaoProduto = new JPanel();
	private JPanel remocaoProduto = new JPanel();
	private JPanel cadastroVenda = new JPanel();
	private JScrollPane consultaVenda = new JScrollPane();
	private JPanel remocaoVenda = new JPanel();
	private JPanel alteracaoVenda = new JPanel();
	private JPanel cadastroEstoque = new JPanel();
	private JScrollPane consultaEstoque = new JScrollPane();
	private JPanel remocaoEstoque = new JPanel();
	private JPanel alteracaoEstoque = new JPanel();
	private JPanel cadastroUsuario = new JPanel();
	private JPanel remocaoUsuario = new JPanel();
	private JPanel consultaUsuario = new JPanel();
	private JPanel alteracaoUsuario = new JPanel();
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
			},
			new String[] {
				"COD_PRODUTO", "NOME", "DESCRICAO", "LUCRO ESPERADO", "Quantidade DISPONIVEL"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(51);
		table.getColumnModel().getColumn(2).setPreferredWidth(77);
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		consultaProduto.setViewportView(table);
		
		
		//De Venda			
		
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
						
				//De Estoque
				
				
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
				
				
		
		
		//De Usuário
		
				
				
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

		 
				
				
				
		
				
				
		//BOTOES LATERAIS
		
		//Botão de Inserção
		btnInserir_P = new JButton("Inserir");
		btnInserir_P.setVisible(false);
		btnInserir_P.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetaTudo();
				btnInserir_P.setBackground(SystemColor.activeCaption);
				if(tipo == 1) {
					cadastroProduto.removeAll();
					cadastroProduto.revalidate();
					cadastroProduto.repaint();
					new panelCadastroProduto(frame,cadastroProduto);	
				}
				else if(tipo == 2) {
					cadastroVenda.removeAll();
					cadastroVenda.revalidate();
					cadastroVenda.repaint();
					new panelCadastroVenda(frame,cadastroVenda);
				}
				else if(tipo == 3) {
					cadastroEstoque.removeAll();
					cadastroEstoque.revalidate();
					cadastroEstoque.repaint();
					new panelCadastroEstoque(frame,cadastroEstoque);
				}
				else if(tipo == 4) {
					cadastroUsuario.removeAll();
					cadastroUsuario.revalidate();
					cadastroUsuario.repaint();
					new panelCadastroUsuario(frame,cadastroUsuario);
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
					/*consultaProduto.removeAll();
					consultaProduto.revalidate();
					consultaProduto.repaint();
					new panelConsultaProduto(frame,consultaProduto);*/
					
					
					
					String[] col = new String[5];
					col[0] = "COD_PRODUTO";
					col[1] = "NOME";
					col[2] = "DESCRICAO";
					col[3] = "LUCRO_ESPERADO";
					col[4] = "QNTD_ESTOQUE";
					String sql = "SELECT*FROM PRODUTO";
					TelaConsulta t = new TelaConsulta(consultaProduto,"PRODUTO","MAOE","SELECT*FROM PRODUTO",col);
					consultaProduto.setVisible(true);
					
					consultaProduto.setViewportView(t.table);
					
					consultaProduto.setVisible(true);
				}
				else if(tipo == 2) {
					/*consultaVenda.removeAll();
					consultaVenda.revalidate();
					consultaVenda.repaint();
					new panelConsultaVenda(frame,consultaVenda);*/
					
					consultaVenda.setVisible(true);
				}
				else if(tipo == 3) {		
					/*consultaEstoque.removeAll();
					consultaEstoque.revalidate();
					consultaEstoque.repaint();
					new panelConsultaEstoque(frame,consultaEstoque);*/
					

					String[] col = new String[7];
					col[0] = "N_PEDIDO";
					col[1] = "COD_PRODUTO";
					col[2] = "P_COMPRA";
					col[3] = "P_VENDA";
					col[4] = "QNTD_REPOSICAO";
					col[5] = "DATA_REPOSICAO";
					col[6] = "QNTD_DISPONIVEL";
					String sql = "SELECT*FROM REPOSICAO";
					TelaConsulta t = new TelaConsulta(consultaEstoque,"REPOSICAO","MAOE","SELECT*FROM REPOSICAO",col);
					consultaEstoque.setVisible(true);
					
					consultaEstoque.setViewportView(t.table);
					
					consultaEstoque.setVisible(true);
				}
				else if(tipo == 4) {
					consultaUsuario.removeAll();
					consultaUsuario.revalidate();
					consultaUsuario.repaint();
					new panelConsultaUsuario(frame,consultaUsuario);
					
					//consultaUsuario.setVisible(true);
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
					remocaoProduto.removeAll();
					remocaoProduto.revalidate();
					remocaoProduto.repaint();
					new panelRemocaoProduto(frame,remocaoProduto);
				}
				else if(tipo == 3) {
					remocaoEstoque.removeAll();
					remocaoEstoque.revalidate();
					remocaoEstoque.repaint();
					new panelRemocaoEstoque(frame,remocaoEstoque);
				}
				else if(tipo == 4) {
					remocaoUsuario.removeAll();
					remocaoUsuario.revalidate();
					remocaoUsuario.repaint();
					new panelRemocaoUsuario(frame,remocaoUsuario);
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
				else if(tipo == 3) {
					alteracaoEstoque.removeAll();
					alteracaoEstoque.revalidate();
					alteracaoEstoque.repaint();
					new panelAlteracaoEstoque(frame,alteracaoEstoque);
				}
				else if(tipo == 4) {
					alteracaoUsuario.removeAll();
					alteracaoUsuario.revalidate();
					alteracaoUsuario.repaint();
					new panelAlteracaoUsuario(frame,alteracaoUsuario);
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
