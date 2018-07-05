package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Venda {
	
	/*cadastro simples de produto 
	 * 
	 *  posi��es do array
	 *  
	 *  [0] cpf_vendedor
	 *  [1] data_venda
	 *  [2] Desconto
	 *  [3] Custo_total
	 *  [4] Preco_venda
	 *  [5] Lucro_t
	 *  [6] t_pagamento	
	 *  
	 * 	qntd_estoque sempre cadastrado com 0	
	 * 
	 * */
	
	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO VENDA (CPF_USUARIO,DATA_VENDA,DESCONTO,CUSTO_TOTAL,PRECO_VENDA,LUCRO,T_PAGAMENTO) VALUES (?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 7; i++) {
				pstm.setString(i + 1, form[i]);
			}
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Venda Inserida com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro  " + e);
		}
		
	}	

}
