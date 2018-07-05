package Telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import back.Usuario;
import javax.swing.SwingConstants;

public class TelaCadastroInicial extends JFrame {
	
	JFrame frame;
	private static Container container;
	private JTextField textFieldNome;
	private JTextField textFieldRG;
	private JTextField textFieldCPF;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldConfirmacao;
	
	/**
	 * Create the frame.
	 */
	public TelaCadastroInicial() {
		initialize();
		this.frame.setResizable(false);
	}
	
	public void img(JPanel panel, Container c) {
		//Logo Icmc
		JLabel lblLogoIcmc = 	new JLabel("");
		lblLogoIcmc.setBounds(816, 10, 131, 49);
		ImageIcon instituicao= new ImageIcon("images/LogoIcmc.png");
		Image img1 = instituicao.getImage().getScaledInstance(lblLogoIcmc.getWidth(), lblLogoIcmc.getHeight(), Image.SCALE_DEFAULT);
		
		lblLogoIcmc.setIcon(new ImageIcon(img1));
		panel.add(lblLogoIcmc);
		
		//Logo Memp's
		JLabel lblLogoMemps = 	new JLabel("");
		lblLogoMemps.setBounds(0, 28, 281, 114);
		ImageIcon empresa = new ImageIcon("images/Memps.png");
		Image img2 = empresa.getImage().getScaledInstance(lblLogoMemps.getWidth(), lblLogoMemps.getHeight(), Image.SCALE_DEFAULT);
		
		lblLogoMemps.setIcon(new ImageIcon(img2));
		c.add(lblLogoMemps);
	}


	/**
	 * Metodo que inicializa a janela de login
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().setBackground(new Color(145,170,157));
		container = frame.getContentPane();

		frame.setBounds(100, 100, 973, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setForeground(Color.RED);
		lblResultado.setBounds(622, 178, 123, 45);
		frame.getContentPane().add(lblResultado);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 973, 30);
		panel.setBackground(new Color(25,52,65));
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(62,96,111));
		panel_1.setBounds(0, 421, 957, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		img(panel_1,container);
		
		JLabel lblTodosOsDireitos = new JLabel("TODOS OS DIREITOS RESERVADOS.");
		lblTodosOsDireitos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTodosOsDireitos.setBounds(23, 20, 513, 29);
		panel_1.add(lblTodosOsDireitos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Button.border"));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(62, 96, 111));
		panel_2.setBounds(285, 35, 374, 382);
		frame.getContentPane().add(panel_2);
		
		JLabel lblTitulo = new JLabel("CADASTRO");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(136, 10, 156, 26);
		panel_2.add(lblTitulo);		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(68, 69, 45, 13);
		panel_2.add(lblNome);
		
		JLabel lblRG = new JLabel("RG:");
		lblRG.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRG.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRG.setBounds(68, 121, 45, 13);
		panel_2.add(lblRG);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(68, 166, 45, 13);
		panel_2.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(68, 214, 45, 13);
		panel_2.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(68, 264, 45, 13);
		panel_2.add(lblSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme\r\n a senha:");
		lblConfirmeASenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConfirmeASenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmeASenha.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmeASenha.setBounds(0, 316, 113, 34);
		panel_2.add(lblConfirmeASenha);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(123, 65, 196, 19);
		panel_2.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(123, 117, 196, 19);
		panel_2.add(textFieldRG);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(123, 162, 196, 19);
		panel_2.add(textFieldCPF);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(123, 210, 196, 19);
		panel_2.add(textFieldEmail);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(123, 260, 193, 19);
		panel_2.add(passwordFieldSenha);
		
		passwordFieldConfirmacao = new JPasswordField();
		passwordFieldConfirmacao.setBackground(UIManager.getColor("Button.background"));
		passwordFieldConfirmacao.setBounds(123, 313, 196, 19);
		panel_2.add(passwordFieldConfirmacao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] form = new String[7];
				
				form[0] = textFieldCPF.getText();
				form[1] = textFieldRG.getText();
				form[2] = textFieldNome.getText();
				form[3] = textFieldEmail.getText();
				form[4] = passwordFieldSenha.getText();
				form[5] = passwordFieldConfirmacao.getText();
				//System.out.println(form[0] + " " + form[1] + " " + form[2] + " " + form[3] + " " + form[4] + " " + form[5]);
				if(form[4].equals(form[5])){
					Usuario.cadastro(form);
				}
			}
		});
		btnCadastrar.setBounds(267, 351, 97, 21);
		panel_2.add(btnCadastrar);
		
		JButton button = new JButton("<-- Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin window = new TelaLogin();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		button.setBackground(UIManager.getColor("Button.background"));
		button.setBorderPainted(false);
		button.setBounds(10, 15, 90, 21);
		panel_2.add(button);
	}
}	
