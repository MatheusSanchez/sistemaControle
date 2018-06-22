package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class TipoUsuario {
	
	/*cadastro simples de TipoUsuario 
	 * 
	 *  posições do array
	 *  
	 *  [0] CPF_USUARIO 111.111.111-11 
	 *  [1] TIPO ("O","F","A")
	 *  
	 *  
	 *  // tipo tem que ser 'A'(adm) ou 'O'(outros) ou 'F'(funcionarios)
	 * 
	 * */
	
	static public void cadastro(String Cpf, String Tipo){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO TIPO_USUARIO (CPF_USUARIO,TIPO) VALUES (?,?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			Tipo = Tipo.toUpperCase();
			
			pstm.setString(1, Cpf);
			pstm.setString(2, Tipo);
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "TIPO do usuario "+Cpf+" inserido com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir USUARIO TIPO do usuario "+Cpf);
		}
		
	}

}
