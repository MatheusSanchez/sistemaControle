package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import conexao.Conexao;

public class Usuario {

		/**
	 *Classe com os m�todos referentes ao Usu�rio
	 *@author Eduardo Baratela
	 *@author Mateus Virginio
	 *@author Matheus Sanchez
	 *@author Pedro Brando 
	 */
	static public void cadastro(String [] form){
		
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO USUARIO (CPF,RG,NOME,EMAIL,SENHA) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			for (int i = 0; i < 5; i++) {
				pstm.setString(i + 1, form[i]);
			}
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso !");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir Usuario " + e);
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
	
	/**
	 * M�todo est�tico respons�vel por pegar o Tipo de Usu�rio, com base no CPF
	 * @param CPF - String do CPF
	 * @return Retorna o tipo de Usu�rio,
	 */
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
			JOptionPane.showMessageDialog(null, "Erro no Get Tipo User " + e);
		}
		
		return result;
		
		
	}

	/**
	 * M�todo est�tico respons�vel por pegar as informa�oes do usu�rio, com base no nome de usu�rio.
	 * @param nomeUsuario - Nome do usu�rio.
	 * @return Retorna as informa��es do usu�rio.
	 */
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
			JOptionPane.showMessageDialog(null, "Erro no get Infos User "  + e );
		}
		
		return result;
		
	}
	
	/**
	 * M�todo est�tico respons�vel por pegar os nomes
	 * @return Retorna os nomes, que est�o na tabela de usu�rio
	 */
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

			/*JOptionPane.showMessageDialog(null, "Consulta Realizada com sucesso");*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no get names do Usuario " + e);
		}
		
		return result;
			
	}
	
	/**
	 * M�todo est�tico que realiza o cadastro de usuario, com base no tipo de usu�rio, al�m de inserir na tabela de tipos. 
	 * @param form - array, sendo as posi�oes referentes a um atributo de usu�rios.
	 * @param Tipo - Tipo de usu�rio.
	 */
	static public void cadastro(String [] form, String Tipo){

		try {
			
			Usuario.cadastro(form);			
			TipoUsuario.cadastro(form[0], Tipo);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir USUARIO");
		}
		
	}
	

	/**
	 * M�todo est�tico respons�vel pelo login
	 * @param user - Campo do login, pode ser CPF ou Email.
	 * @param pass - Campo do login, destinado a senha.
	 * @return Retorna true (se o login estiver correto) ou false (se o login estiver incorreto).
	 */
	static public boolean login(String user, String pass){

		try {	
			if(Usuario.getSenha(user).equals(pass)) {
				
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Erro no Banco Fun��o Login");
			return false;
		}
		
	}
	
	/**
	 * M�todo est�tico respons�vel por pegar a senha, com base no campo USER do login.
	 * @param user - Campo do login, pode ser CPF ou Email.
	 * @return Retorna a senha do usuario.
	 */
	static public String getSenha(String user){
		Connection c = Conexao.getInstance();
		String s = null;
		
		String sql = "SELECT SENHA FROM USUARIO WHERE EMAIL LIKE ? OR CPF LIKE ?";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			pstm.setString(1, user);
			pstm.setString(2, user);

			ResultSet rs = pstm.executeQuery();
			
			
			while (rs.next()){
				s = rs.getString(1);
			}
			
			pstm.close();
			
			if(s!= null) {
				System.out.println("Achei o Usuario " + user + " Sua senha " + s);
			}else {
				JOptionPane.showMessageDialog(null, "Usu�rio Inexistente !");
			}

			
		} catch (Exception e) {
			/*JOptionPane.showMessageDialog(null, "Erro ao usuario no Banco");*/
		}
		
		return s;
		
	}
	
	/**
	 * M�todo est�tico respons�vel por atualizar os Usu�rios.
	 * @param form - array, sendo as posi�oes referentes a um atributo de usu�rios.
	 * @param nomeAntigo - Nome antigo de usu�rio.
	 */
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
			JOptionPane.showMessageDialog(null, "Erro ao alterar Usuario " + e);
		}
		
	}
	
	/**
	 * M�todo est�tico respons�vel por excluir um usu�rio, com base no nome do usu�rio.
	 * @param nome - Nome do usu�rio.
	 */
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
			JOptionPane.showMessageDialog(null, "Erro ao deletar Usuario " + e);
		}
		
	}
	

}
