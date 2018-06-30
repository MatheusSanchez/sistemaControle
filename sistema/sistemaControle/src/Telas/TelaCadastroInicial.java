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
		lblLogoMemps.setBounds(0, 28, 281, 114);
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
		panel_2.setBounds(285, 35, 374, 382);
		frame.getContentPane().add(panel_2);
		
		JLabel lblTitulo = new JLabel("CADASTRO");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBounds(136, 10, 156, 26);
		panel_2.add(lblTitulo);		
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(62, 68, 45, 13);
		panel_2.add(lblNome);
		
		JLabel lblRG = new JLabel("RG :");
		lblRG.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRG.setBounds(62, 120, 45, 13);
		panel_2.add(lblRG);
		
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(62, 165, 45, 13);
		panel_2.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(62, 213, 45, 13);
		panel_2.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(62, 263, 45, 13);
		panel_2.add(lblSenha);
		
		JLabel lblConfirmeASenha = new JLabel("Confirme\r\n a senha :");
		lblConfirmeASenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmeASenha.setVerticalAlignment(SwingConstants.TOP);
		lblConfirmeASenha.setBounds(10, 316, 97, 34);
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
		button.setBackground(new Color(62, 96, 111));
		button.setBorderPainted(false);
		button.setBounds(10, 15, 85, 21);
		panel_2.add(button);
	}
}	
