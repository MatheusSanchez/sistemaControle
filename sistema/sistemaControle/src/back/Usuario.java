package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import conexao.Conexao;

public class Usuario {
	
	/*cadastro simples de usuario 
	 * 
	 *  posições do array
	 *  
	 *  [0] cpf
	 *  [1] rg
	 *  [2] nome
	 *  [3] email
	 *  [4] senha	
	 * 
	 * */
	

	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO USUARIO (CPF,RG,NOME,EMAIL,SENHA) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			
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
	

}
