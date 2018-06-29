package conexao;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Conexao {
	private static Connection conn;
	

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
					/*Scanner s = new Scanner(System.in);	// trocar para pedir user e senha
					System.out.print("Host: ");
					String host = s.nextLine(); 
					System.out.print("Port: ");
					String port = s.nextLine();
					System.out.print("User: ");
					String user = s.nextLine();
					System.out.print("Password: ");
					String password = s.nextLine();*/
					conn = DriverManager.getConnection("jdbc:oracle:thin:@" + "192.168.183.15" + ":" + "1521" + ":orcl", "m9081453", "matxd96114974!!!");
					System.out.println("Conexao estabelecida");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao banco 123");
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
					System.out.println("Conexao estabelecida");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nao foi possivel conectar ao banco");
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
