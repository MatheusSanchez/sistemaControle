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
			updateProduto(form[0]); // da um update na tabela de produtos
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	static public String getCodProduto (String numPed){
		
		String result = null;
		Connection c = Conexao.getInstance();	
		String sql = "SELECT COD_PRODUTO FROM REPOSICAO WHERE N_PEDIDO LIKE (?) ";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			
			pstm.setString(1, numPed);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()){
					result = (rs.getString(1));			
			}else{
				result = null;
			}
		
			
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Result " + result);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return result;
		
	}
	
	
	static public void updateProduto(String n_pedido){  // atualiza a quantidade disponivel na tabela de produto
		Connection c = Conexao.getInstance();
		
		String cod_produto = getCodProduto(n_pedido);
		
		String sql = "UPDATE PRODUTO SET QNTD_ESTOQUE = (SELECT SUM(QNTD_DISPONIVEL) FROM REPOSICAO WHERE COD_PRODUTO = "+cod_produto+") WHERE COD_PRODUTO = (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			//pstm.setString(1, qntd);
			pstm.setString(1, cod_produto);
			
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso (update quantidade)");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Produto (update quantidade)");
		}
		
	}
	
	static public void updateProduto(String n_pedido,String cod_produto){  // atualiza a quantidade disponivel na tabela de produto
		Connection c = Conexao.getInstance();
		

		
		String sql = "UPDATE PRODUTO SET QNTD_ESTOQUE = (SELECT SUM(QNTD_DISPONIVEL) FROM REPOSICAO WHERE COD_PRODUTO = "+cod_produto+") WHERE COD_PRODUTO = (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			//pstm.setString(1, qntd);
			pstm.setString(1, cod_produto);
			
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso (update quantidade)");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar Produto (update quantidade)");
		}
		
	}
	
	static public void update(String n_pedido,String qntdRetirada){  // atualiza a quantidade disponivel na tabela de produto
		Connection c = Conexao.getInstance();
		

		
		String sql = "UPDATE REPOSICAO SET QNTD_DISPONIVEL = QNTD_DISPONIVEL - "+qntdRetirada+" WHERE N_PEDIDO = "+n_pedido+ "";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
					
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			updateProduto(n_pedido); 
			pstm.close();
			
			JOptionPane.showMessageDialog(null, "aTUALIZACAO DE ESTOQUE (SANCHEZ)");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "EROU SANCHITOS "+ e);
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
		String sql = "SELECT COD_PRODUTO,P_COMPRA, P_VENDA, QNTD_REPOSICAO,to_date(DATA_REPOSICAO,'dd/mm/yyyy') AS DATA FROM REPOSICAO WHERE N_PEDIDO LIKE (?) ";
		
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
			JOptionPane.showMessageDialog(null, e);
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
		
		// ATUALIZANDO O CAMPO DE QUANTIDADE DISPONIVEL
		
		String qntd_disponivel = "UPDATE REPOSICAO SET QNTD_DISPONIVEL = QNTD_DISPONIVEL + (SELECT "+form[2]+" - QNTD_REPOSICAO FROM REPOSICAO WHERE N_PEDIDO = "+numPed+")  WHERE N_PEDIDO = " +numPed;
		System.out.println(qntd_disponivel);
		
		
		try {
			PreparedStatement pstm = c.prepareStatement(qntd_disponivel);
			
			System.out.println("Executanto a query " + qntd_disponivel);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();
			updateProduto(numPed); // atualiza quantidade disponivel na tabela produto
			JOptionPane.showMessageDialog(null, "foi");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		String sql = "UPDATE REPOSICAO SET P_COMPRA = (?), P_VENDA = (?), QNTD_REPOSICAO = (?),DATA_REPOSICAO =  to_date(?,'dd/mm/yyyy') WHERE N_PEDIDO = (?)";
		
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
		
			for (int i = 0; i < 4; i++) {
				pstm.setString(i + 1, form[i]);
			}
			pstm.setString(5, numPed);
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Estoque alterado com sucesso");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
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

			/*JOptionPane.showMessageDialog(null, "gET N PEDIDO FUNCIONANDO");*/
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro  get n pedido de Estoque !");
		}
		
		return result;
			
	}
	
	static public Vector getNpedidos(String cod_produto){
		Connection c = Conexao.getInstance();
		
		Vector result = new Vector();

		String sql = "SELECT N_PEDIDO FROM REPOSICAO WHERE COD_PRODUTO = (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			pstm.setString(1, cod_produto);
			ResultSet rs = pstm.executeQuery();
			
			
			while (rs.next()){
				result.add(rs.getString(1));
			}
	
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "Get n pedido with cod produto = "  + cod_produto);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR Get n pedido with cod produto = "  + cod_produto);
		}
		
		return result;
			
	}
	
	static public String getMax(String nPedido){
		Connection c = Conexao.getInstance();
		
		String result = "";

		String sql = "SELECT QNTD_DISPONIVEL FROM REPOSICAO WHERE N_PEDIDO = (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			System.out.println("Executanto a query " + sql);
			pstm.setString(1, nPedido);
			ResultSet rs = pstm.executeQuery();
			
			
			if (rs.next()){
				
				result = (rs.getString(1));
						
			}else{
				result = null;
			}
	
			System.out.println("Fim a query ");
			pstm.close();

			JOptionPane.showMessageDialog(null, "getMax RODOU");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "getMax DEU ERRO " + e);
		}
		
		return result;
			
	}
	
	static public void delete(String numPed){
		Connection c = Conexao.getInstance();
		
		String cod_produto = getCodProduto(numPed);
		
		String sql = "DELETE FROM REPOSICAO WHERE N_PEDIDO = (?)";
		
		try {
			PreparedStatement pstm = c.prepareStatement(sql);
			System.out.println("preparando");
			
			pstm.setString(1, numPed);
			
			System.out.println("Executanto a query " + sql);
			pstm.execute();
			System.out.println("Fim a query ");
			pstm.close();
			updateProduto(numPed,cod_produto);
			JOptionPane.showMessageDialog(null, "Estoque deletado");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	

}
