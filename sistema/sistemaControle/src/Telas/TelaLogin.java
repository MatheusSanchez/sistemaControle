package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import back.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.ImageCapabilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

/**
 * Classe que possui a tela de Login
 *
 */
public class TelaLogin {

	JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private static Container container;

	
	/**
	 * Construtor da classe que inicializa a tela
	 */
	public TelaLogin() {
		
		initialize();
	}
	
	public void img(JPanel panel, Container c) {
		//Logo Icmc
		JLabel lblLogoIcmc = 	new JLabel("");
		lblLogoIcmc.setBounds(816, 10, 131, 49);
		ImageIcon instituicao= new ImageIcon("C:\\Users\\eduar\\Documents\\USP\\sistemaControle\\sistema\\sistemaControle\\images\\LogoIcmc.png");
		Image img1 = instituicao.getImage().getScaledInstance(lblLogoIcmc.getWidth(), lblLogoIcmc.getHeight(), Image.SCALE_DEFAULT);
		
		lblLogoIcmc.setIcon(new ImageIcon(img1));
		panel.add(lblLogoIcmc);
		
		//Logo Memp's
		JLabel lblLogoMemps = 	new JLabel("");
		lblLogoMemps.setBounds(285, 31, 333, 114);
		ImageIcon empresa = new ImageIcon("C:\\Users\\eduar\\Documents\\USP\\sistemaControle\\sistema\\sistemaControle\\images\\Memps.png");
		Image img2 = empresa.getImage().getScaledInstance(lblLogoMemps.getWidth(), lblLogoMemps.getHeight(), Image.SCALE_DEFAULT);
		
		lblLogoMemps.setIcon(new ImageIcon(img2));
		c.add(lblLogoMemps);
	}

	/**
	 * Metodo que inicializa a janela de login
	 */
	private void initialize() {
		frame = new JFrame();
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
		panel_2.setBounds(290, 144, 322, 198);
		frame.getContentPane().add(panel_2);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(46, 47, 46, 14);
		panel_2.add(lblLogin);
		
		userField = new JTextField();
		userField.setBounds(116, 44, 164, 20);
		panel_2.add(userField);
		userField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(46, 89, 46, 14);
		panel_2.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 86, 164, 20);
		panel_2.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(191, 140, 89, 23);
		panel_2.add(btnLogin);
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(new Color(0, 0, 0));
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user,pass;
				user="";
				pass="";
				
				user = userField.getText();
				pass = passwordField.getText();
				
				if(user != "" && pass != "") {
					if(Usuario.login(user, pass)) {
						Main.novaTela(container);
						Home h = new Home(container,frame);
						
					}else {
						lblResultado.setText("Login Incorreto !!!");
					}
				}
				
				
			}
		});
		
		JButton btnCrieUmConta = new JButton("Crie uma conta");
		btnCrieUmConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroInicial window = new TelaCadastroInicial();
				window.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCrieUmConta.setForeground(Color.BLACK);
		btnCrieUmConta.setBackground(Color.WHITE);
		btnCrieUmConta.setBounds(788, 355, 159, 55);
		frame.getContentPane().add(btnCrieUmConta);
		
		
		
	}
}
