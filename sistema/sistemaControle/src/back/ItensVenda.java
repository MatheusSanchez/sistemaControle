package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class ItensVenda {
	
	/*cadastro simples de produto 
	 * 
	 *  posições do array
	 *  
	 *  [0] COD_PRODUTO
	 *  [1] QNTD_PRODUTO
	 *  [2] PRECO_REPOSICAO
	 *  [3] PRECO_VENDA
	 *  [4] LUCRO
	 *  	
	 * 
	 * */
	
	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO ITENS_VENDA (COD_VENDA,COD_PRODUTO,QNTD_PRODUTO,PRECO_REPOSICAO,PRECO_VENDA,LUCRO) VALUES ((SELECT MAX(COD_VENDA) FROM VENDA),?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 5; i++) {
				pstm.setString(i + 1, form[i]);
			}
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			/*JOptionPane.showMessageDialog(null, "iTENS Venda Inserida com sucesso");*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro  " + e);
		}
		
	}	


}
