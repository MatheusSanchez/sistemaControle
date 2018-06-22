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
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.ImageCapabilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;

public class TelaLogin {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(145,170,157));


		frame.setBounds(100, 100, 973, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblResultado = new JLabel("resultado");
		lblResultado.setBounds(753, 118, 95, 45);
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
		
		JLabel lblTodosOsDireitos = new JLabel("TODOS OS DIREITOS RESERVADOS.");
		lblTodosOsDireitos.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTodosOsDireitos.setBounds(23, 20, 513, 29);
		panel_1.add(lblTodosOsDireitos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("Button.border"));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(62, 96, 111));
		panel_2.setBounds(292, 154, 320, 175);
		frame.getContentPane().add(panel_2);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(75, 47, 46, 14);
		panel_2.add(lblLogin);
		
		userField = new JTextField();
		userField.setBounds(158, 44, 89, 20);
		panel_2.add(userField);
		userField.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(75, 89, 46, 14);
		panel_2.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 86, 89, 20);
		panel_2.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(207, 141, 89, 23);
		panel_2.add(btnLogin);
		btnLogin.setBackground(new Color(0, 0, 255));
		btnLogin.setForeground(new Color(0, 0, 0));
		
		JButton btnCrieUmConta = new JButton("Crie um Conta");
		btnCrieUmConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCrieUmConta.setForeground(Color.BLACK);
		btnCrieUmConta.setBackground(Color.BLUE);
		btnCrieUmConta.setBounds(788, 355, 159, 55);
		frame.getContentPane().add(btnCrieUmConta);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user,pass;
				user="";
				pass="";
				
				user = userField.getText();
				pass = passwordField.getText();
				
				if(user != "" && pass != "") {
					if(Usuario.login(user, pass)) {
						lblResultado.setText("Logouuuuuuu");
					}else {
						lblResultado.setText("EROUUU");
					}
				}
				
				
			}
		});
		

		
		
		
	
		
	}
}
