package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Produto {
	
	/*cadastro simples de produto 
	 * 
	 *  posições do array
	 *  
	 *  [0] nome
	 *  [1] descricao
	 *  [2] lucro esperado
	 *  
	 * 	qntd_estoque sempre cadastrado com 0	
	 * 
	 * */
	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO PRODUTO (NOME,DESCRICAO,LUCRO_ESPERADO,QNTD_ESTOQUE) VALUES (?,?,?,0)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 3; i++) {
				pstm.setString(i + 1, form[i]);
			}
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir Produto");
		}
		
	}	
	
}
