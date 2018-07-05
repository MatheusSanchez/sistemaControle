package back;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import conexao.Conexao;

/**
 *Classe com os métodos referentes à Venda
 *@author Eduardo Baratela
 *@author Mateus Virginio
 *@author Matheus Sanchez
 *@author Pedro Brando 
 */
public class Venda {
	
	/**
	 *  posições do array
	 *  
	 *  [0] cpf_vendedor
	 *  [1] data_venda
	 *  [2] Desconto
	 *  [3] Custo_total
	 *  [4] Preco_venda
	 *  [5] Lucro_t
	 *  [6] t_pagamento	
	 *   
	 * 
	 * 
	 *
	 *  FORM2
	 *  
	 *	[0] COD_PRODUTO
	 *  [1] QNTD_PRODUTO
	 *  [2] PRECO_REPOSICAO
	 *  [3] PRECO_VENDA
	 *  [4] LUCRO
	 *   
	 * 
	 * */
	
	/**
	 * Método estático responsável pelo cadastro
	 * @param form - array, sendo as posiçoes referentes a reposição
	 * @param form2 - array, sendo as posiçoes referentes a tabela de itens venda
	 * @param n_pedido - numero do pedido
	 */
	static public void cadastro(String [] form,String [] form2, String n_pedido){
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
			
			ItensVenda.cadastro(form2);
			Estoque.update(n_pedido, form2[1]);
			pstm.close();

			JOptionPane.showMessageDialog(null, "Venda Inserida com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro  " + e);
		}
		
	}	

}
