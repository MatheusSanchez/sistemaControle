package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Estoque {
	
	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO REPOSICAO (COD_PRODUTO,P_COMPRA,P_VENDA,QNTD_REPOSICAO,DATA_REPOSICAO,QNTD_DISPONIVEL) VALUES (?,?,?,0)";
		
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
