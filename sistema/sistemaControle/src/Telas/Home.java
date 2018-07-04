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
import panels.panelCadastroEstoque;
import panels.panelCadastroProduto;
import panels.panelCadastroVenda;
import panels.panelConsultaEstoque;
import panels.panelConsultaProduto;
import panels.panelConsultaVenda;
import panels.panelRemocaoEstoque;
import panels.panelRemocaoProduto;

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
	
	
	private JTextField textFieldNomeUsuario;
	private JTextField textFieldRGUsuario;
	private JTextField textFieldCPFUsuario;
	private JTextField textFieldEmailUsuario;
	private JTextField textFieldSenhaUsuario;
	private JTextField textFieldConfirmacaoUsuario;
	private JTextField textFieldProduto;
	private JTextField textFieldConfirmacaoProduto;
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
	private JComboBox boxTipoFuncionario;
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
					System.out.println("entrou no cadastro estoque");
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
					TelaConsulta t = new TelaConsulta(consultaProduto,"Produto","","SELECT*FROM PRODUTO",col);
					consultaProduto.setVisible(true);
					
					consultaProduto.setViewportView(t.table);							
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
					remocaoProduto.removeAll();
					remocaoProduto.revalidate();
					remocaoProduto.repaint();
					new panelRemocaoProduto(frame,remocaoProduto);
				}
				else if(tipo == 2) {
					remocaoVenda.setVisible(true);
				}
				else if(tipo == 3) {
					remocaoEstoque.removeAll();
					remocaoEstoque.revalidate();
					remocaoEstoque.repaint();
					new panelRemocaoEstoque(frame,remocaoEstoque);
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
