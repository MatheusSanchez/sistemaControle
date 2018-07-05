package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import conexao.Conexao;

/**
 *Classe com os métodos referentes ao Produto
 *@author Eduardo Baratela
 *@author Mateus Virginio
 *@author Matheus Sanchez
 *@author Pedro Brando 
 */
public class Produto {
	
	/**cadastro simples de produto 
	 * 
	 *  posições do array
	 *  
	 *  form[0] nome
	 *  form[1] descricao
	 *  form[2] lucro esperado
	 *  
	 * 	qntd_estoque sempre cadastrado com 0	
	 * 
	 * */
	
	/**
	 * Método estático que realiza o cadastro do produto
	 * @param form - array, sendo as posiçoes referentes a um atributo de produto.
	 */
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
			JOptionPane.showMessageDialog(null, "Erro ao inserir Produto " + e);
		}
		
	}	
	
	/**
	 * Método estático que pega as informações , com base no nome do produto. 
	 * @param nomeProduto - Nome do Produto.
	 * @return Retorna as informações do produto.
	 */
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

			/*JOptionPane.showMessageDialog(null, "Get Infos suce");*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no get Infos do Produto " + e);
		}
		
		return result;
		
	}
	
	/**
	 * Método estático responsável por pegar os nomes, com base no código do produto.
	 * @param cod - código do produto.
	 * @return Retorna o Nome.
	 */
	static public String getNames(String cod){
		Connection c = Conexao.getInstance();
		
		String result = "";

		String sql = "SELECT NOME FROM PRODUTO WHERE COD_PRODUTO LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, cod);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()){
				result = rs.getString(1);
			}
		
			pstm.close();

			/*JOptionPane.showMessageDialog(null, "Suceful get name");*/
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro no Get Name do Produt " + e);
		}
		
		return result;
			
	}
	
	/**
	 * Método estático responsável por pegar o códgi do produto, com base no nome do produto.
	 * @param name - nome do produto.
	 * @return Retorna o código do produto. 
	 */
	static public String getCod(String name){
		Connection c = Conexao.getInstance();
		
		String result = "";

		String sql = "SELECT COD_PRODUTO FROM PRODUTO WHERE NOME LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();

			if (rs.next()){
				result = rs.getString(1);
			}
		
			pstm.close();

			/*JOptionPane.showMessageDialog(null, "Suceful get code");*/
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro no Get Cod do Produto " + e);
		}
		
		return result;
			
	}
	
	
	/**
	 * Método estático responsável por atualizar a tabela produto pelo nome. 
	 * @param form - array, sendo as posiçoes referentes a um atributo de produto.
	 * @param nomeAntigo -Nome antigo do produto.
	 */	
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

			JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso ");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Produto " + e);
		}
		
	}
	
	/**
	 * Método estático responsável por excluir, com base no nome do produto. 
	 * @param nome - nome do produto.
	 */
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
			JOptionPane.showMessageDialog(null, "Erro ao deletar Produto " + e);
		}
		
	}
	
	/**
	 *Método estático responsável por pegar os nomes. 
	 * @return Retorna os nomes
	 */
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

			/*JOptionPane.showMessageDialog(null, "Consulta Realizada com sucesso");*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar consulta" + e);
		}
		
		return result;
			
	}
	
	
	
}

	
