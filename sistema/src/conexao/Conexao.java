package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Conexao {
	private static Connection conn;

	private Conexao() {
	}

	public synchronized static Connection getInstance() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl", "B9763050", "tantufas");
				//conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":orcl", user, password);
				System.out.println("conectou");
			} catch (Exception e) {
				e.printStackTrace();
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
