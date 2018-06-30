package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

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
	
	/*RETORNA AS INFOS DO USUARIO 
	 * 
	  	[0] cpf // 111.111.111-11 // unico
	 *  [1] rg	// 11.111.111-1
	 *  [2] nome (max 30 caracteres)
	 *  [3] email (max 45 caracteres)
	 *  [4] senha	(max 20 caracteres)
	 * */
	
	static public String  getTipo(String CPF){
		
		Connection c = Conexao.getInstance();	
		String sql = "SELECT TIPO FROM TIPO_USUARIO WHERE CPF_USUARIO LIKE (?) ";
		String result = null;
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, CPF);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
				
					result= (rs.getString(1));
						
			}else{
				result = null;
			}
			
			
			
			System.out.println("Fim a query ");
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Get Tipo deu ruim Users");
		}
		
		return result;
		
		
	}
	
static public String[]  getInfos(String nomeUsuario){
		
		String[] result = new String[5];
		Connection c = Conexao.getInstance();	
		String sql = "SELECT CPF,RG,NOME,EMAIL,SENHA FROM USUARIO WHERE NOME LIKE (?) ";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, nomeUsuario);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
				for(int i = 0; i < 5 ; i++){
					result[i] = (rs.getString(i+1));
				}			
			}else{
				result = null;
			}
			
			
			
			System.out.println("Fim a query ");
			pstm.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Get Infos deu ruim Users");
		}
		
		return result;
		
	}
	
	static public Vector getNames(){
		Connection c = Conexao.getInstance();
		
		Vector result = new Vector();

		String sql = "SELECT NOME FROM USUARIO";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			ResultSet rs = pstm.executeQuery();
			
			

			while (rs.next()){
				result.add(rs.getString(1));
			}
	
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Consulta Realizada com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta");
		}
		
		return result;
			
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
	
	static public void update(String [] form, String nomeAntigo){
		Connection c = Conexao.getInstance();
		
		String sql = "UPDATE USUARIO SET NOME = (?), EMAIL = (?), SENHA = (?) WHERE NOME LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 3; i++) {
				pstm.setString(i + 1, form[i]);
			}
			pstm.setString(4, nomeAntigo);
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Usuario Alterado com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Usuario");
		}
		
	}
	
	static public void delete(String nome){
		Connection c = Conexao.getInstance();
		
		String sql = "DELETE FROM USUARIO WHERE NOME LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			pstm.setString(1, nome);
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar Usuario");
		}
		
	}
	

}
