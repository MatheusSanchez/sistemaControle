package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

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
	
	/*Retorna as informações do produto, consultando pelo nome*/
	
	static public String[]  getInfos(String nomeProduto){
		
		String[] result = new String[3];
		Connection c = Conexao.getInstance();	
		String sql = "SELECT NOME, DESCRICAO, LUCRO_ESPERADO FROM PRODUTO WHERE NOME LIKE (?) ";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, nomeProduto);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
				for(int i = 0; i < 3 ; i++){
					result[i] = (rs.getString(i+1));
				}			
			}else{
				result = null;
			}
			
			
			
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Get Infos suce");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Get Infos deu ruim");
		}
		
		return result;
		
	}
	
	
	/*Update de produto pelo nome, o array de string deve estar no mesmo formato do cadastro*/
	static public void update(String [] form, String nomeAntigo){
		Connection c = Conexao.getInstance();
		
		String sql = "UPDATE PRODUTO SET NOME = (?), DESCRICAO = (?), LUCRO_ESPERADO = (?) WHERE NOME LIKE (?)";
		
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

			JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Produto");
		}
		
	}
	
	/*deleta o produto do nome digitado*/
	
	static public void delete(String nome){
		Connection c = Conexao.getInstance();
		
		String sql = "DELETE FROM PRODUTO WHERE NOME LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			pstm.setString(1, nome);
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar Produto");
		}
		
	}
	
	static public Vector getNames(){
		Connection c = Conexao.getInstance();
		
		Vector result = new Vector();

		String sql = "SELECT NOME FROM PRODUTO";
		
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
	
}

	
