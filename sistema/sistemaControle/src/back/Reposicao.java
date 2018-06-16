package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Reposicao {
	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO REPOSICAO (COD_PRODUTO,P_COMPRA,P_VENDA,QNTD_REPOSICAO,DATA_REPOSICAO,QNTD_DISPONIVEL) "
				+ "VALUES (?,?,?,?,TO_DATE(?, 'DD/MM/YYYY'),?)";
		
		/*INSERT INTO REPOSICAO(COD_PRODUTO,P_COMPRA,P_VENDA,QNTD_REPOSICAO,DATA_REPOSICAO,QNTD_DISPONIVEL)
		VALUES (1,240,250,45,TO_DATE('16/06/2017', 'DD/MM/YYYY'),45);*/
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			
			System.out.println("preparando");
					
			for (int i = 0; i < 5; i++) {
				pstm.setString(i + 1, form[i]);
			}
			pstm.setString(6, form[3]); // quantidade disponivel == qntd reposicao
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Reposicao inserido com sucesso");
			
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Erro ao inserir Reposicao");
		}
		
	}	
}
