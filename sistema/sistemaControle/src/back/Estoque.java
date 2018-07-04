package back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;

import conexao.Conexao;

public class Estoque {
	
	/*
	 * form[0] ->cod_produto
	 * form[1] ->preco_compra
	 * form[2] ->preco_venda
	 * form[3] ->quantidade_preposicao
	 * form[4] ->data reposicao         dd/mm/yyy

	 * */
	
	static public void cadastro(String [] form){
		Connection c = Conexao.getInstance();
		
		String sql = "INSERT INTO REPOSICAO (COD_PRODUTO,P_COMPRA,P_VENDA,QNTD_REPOSICAO,DATA_REPOSICAO,QNTD_DISPONIVEL) VALUES (?,?,?,?,to_date(?,'dd/mm/yyyy'),?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 5; i++) {
				pstm.setString(i + 1, form[i]);
			}			
			pstm.setString(6, form[3]); // quantidade disponivel
			
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();
		
			
			JOptionPane.showMessageDialog(null, "Estoque inserido com sucesso");
			updateProduto(form[0],form[3]); // da um update na tabela de produtos
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	
	
	static public void updateProduto(String cod_produto, String qntd){  // atualiza a quantidade disponivel na tabela de produto
		Connection c = Conexao.getInstance();
		
		String sql = "UPDATE PRODUTO SET QNTD_ESTOQUE = QNTD_ESTOQUE+(?) WHERE NOME LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			pstm.setString(1, qntd);
			pstm.setString(2, cod_produto);
			
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso (update quantidade)");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Produto (update quantidade)");
		}
		
	}
	
	/*
	 * form[0] ->nome_produto
	 * form[1] ->preco_compra
	 * form[2] ->preco_venda
	 * form[3] ->quantidade_preposicao
	 * form[4] ->data reposicao         dd/mm/yyy

	 * */
	
	static public String[]  getInfos(String numPed){
		
		String[] result = new String[5];
		Connection c = Conexao.getInstance();	
		String sql = "SELECT COD_PRODUTO,P_COMPRA, P_VENDA, QNTD_REPOSICAO,DATA_REPOSICAO FROM REPOSICAO WHERE N_PEDIDO LIKE (?) ";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, numPed);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
				for(int i = 0; i < 5 ; i++){
					result[i] = (rs.getString(i+1));
				}			
			}else{
				result = null;
			}
			result[0] = Produto.getNames(result[0]);
		
			
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Get Infos suce Estoque");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Get Infos deu ruim Estoque");
		}
		
		return result;
		
	}
	
	/*
	 * 
	 * form[0] ->preco_compra
	 * form[1] ->preco_venda
	 * form[2] ->quantidade_preposicao
	 * form[3] ->data reposicao         dd/mm/yyy

	 * */
	
	/*nao esquecer de alterar na table do produto*/
	
	static public void update(String [] form, String numPed){
		Connection c = Conexao.getInstance();
		
		String sql = "UPDATE ESTOQUE SET P_COMPRA = (?), P_VENDA = (?), QNTD_REPOSICAO = (?), DATA_REPOSICAO = (?) WHERE N_PEDIDO LIKE (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 4; i++) {
				pstm.setString(i + 1, form[i]);
			}
			pstm.setString(4, numPed);
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Estoque alterado com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar estoque");
		}
		
	}
	
	static public Vector getNpedidos(){
		Connection c = Conexao.getInstance();
		
		Vector result = new Vector();

		String sql = "SELECT N_PEDIDO FROM REPOSICAO";
		
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

			JOptionPane.showMessageDialog(null, "gET N PEDIDO FUNCIONANDO");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "eRRO GET N PEDIDO");
		}
		
		return result;
			
	}

}
