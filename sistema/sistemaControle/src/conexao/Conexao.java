package conexao;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Conexao {
	private static Connection conn;
	
	private static String host;
	private static String port;
	private static String user;
	private static String password;
	

	private Conexao() {
	}
	
	public synchronized static Connection getInstance() {
		if (conn == null) {
			System.out.println("Conexão com o banco não estabelecida !");
		}
		return conn;
	}
	public synchronized static Connection getInstance(String conexao) {
		if (conn == null) {
			
			if(conexao.equals("lab")){
				try {
					//recebendo dados de conexao do ususario
					/*if (host == null) {
						host = JOptionPane.showInputDialog(null, "Host: ");
						if (host == null) {
							System.exit(0);
						}
						port = JOptionPane.showInputDialog(null, "Port: ");
						if (port == null) {
							System.exit(0);
						}
						user = JOptionPane.showInputDialog(null, "User: ");
						if (user == null) {
							System.exit(0);
						}
						password = JOptionPane.showInputDialog(null, "Password: ");
						if (password == null) {
							System.exit(0);
						}
					}
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":orcl", user, password); //conecta com o banco
					conn.setAutoCommit(false);
					System.out.println("Conexao estabelecida");*/
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@" + "192.168.183.15" + ":" + "1521" + ":orcl", "m9081453", "matxd96114974!!!");
					System.out.println("Conexao com banco estabelecida !");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de dados, contate o administrador !");
				}
			}else{
				try {
					/*Scanner s = new Scanner(System.in);	// trocar para pedir user e senha
					System.out.print("Host: ");
					String host = s.nextLine(); 
					System.out.print("Port: ");
					String port = s.nextLine();
					System.out.print("User: ");
					String user = s.nextLine();
					System.out.print("Password: ");
					String password = s.nextLine();*/
					conn = DriverManager.getConnection("jdbc:oracle:thin:@" + "grad.icmc.usp.br" + ":" + "15215" + ":orcl", "m9081453", "matxd96114974!!!");
					System.out.println("Conexao com banco estabelecida !");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de dados, contate o administrador !");
				}
			}
			
			
		
		
		}
		return conn;
	}

	public synchronized static void fecharConnexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
