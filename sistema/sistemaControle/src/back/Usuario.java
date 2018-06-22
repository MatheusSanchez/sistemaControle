package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import conexao.Conexao;

public class Usuario {
	
	/*cadastro simples de usuario 
	 * 
	 *  posições do array
	 *  
	 *  [0] cpf // 111.111.111-11 // unico
	 *  [1] rg	// 11.111.111-1
	 *  [2] nome (max 30 caracteres)
	 *  [3] email (max 45 caracteres)
	 *  [4] senha	(max 20 caracteres)
	 * 
	 * */
	

	static public void cadastro(String [] form){
		
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO USUARIO (CPF,RG,NOME,EMAIL,SENHA) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			System.out.println("Preparando Comando Sql");

			for (int i = 0; i < 5; i++) {
				pstm.setString(i + 1, form[i]);
			}
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "USUARIO inserido com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir USUARIO");
		}
		
	}
	
	/*cadastro simples de usuario ja com tipo incluso, insere na tabela de tipos tambem 
	 * 
	 *  posições do array são as mesmas do cadastro de usuario
	 *   
	 * */
	
	static public void cadastro(String [] form, String Tipo){

		try {
			
			Usuario.cadastro(form);			
			TipoUsuario.cadastro(form[0], Tipo);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir USUARIO");
		}
		
	}
	

/**
 	Login Retorna true ou false
	  
	 posições do array
	   
	 [0] Email
	 [1] Senha
	
 * @param form
 * @return
 */
	static public boolean login(String user, String pass){

		try {	
			if(Usuario.getSenha(user).equals(pass)) {
		
				JOptionPane.showMessageDialog(null, "Logou com sucesso");
				return true;
			}else {
				JOptionPane.showMessageDialog(null, "Sem Login");
				return false;
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Banco Função Login");
			return false;
		}
		
	}
	
	/**
	 * Retorna a senha do usuario "user"
	 * 
	 * 
	 * 
	 * 
	 * @param user
	 * @return
	 */
	
	static public String getSenha(String user){
		Connection c = Conexao.getInstance();
		String s = "";
		
		String sql = "SELECT SENHA FROM USUARIO WHERE EMAIL LIKE ? OR CPF LIKE ?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			System.out.println("Preparando Comando Sql");
		
			pstm.setString(1, user);
			pstm.setString(2, user);
		
			System.out.println("Executanto a query " + sql);
			//pstm.execute();
			ResultSet rs = pstm.executeQuery();
			
			
			while (rs.next()){
				s = rs.getString(1);
			}
			
			System.out.println("Fim query ");
			pstm.close();
			
			if(s!= null) {
				JOptionPane.showMessageDialog(null, "Achei o Usuario " + user + " Sua senha " + s);
			}else {
				JOptionPane.showMessageDialog(null, "NÃO Achei o Usuario " + user);
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar no banco");
		}
		
		return s;
		
	}
	
	

}
