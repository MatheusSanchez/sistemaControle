package panels;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Telas.TelaConsulta;

public class panelConsultaProduto {
	
	public JLabel lblTitulo_ConsultaProduto;
	
	public panelConsultaProduto(JFrame frame,JScrollPane consultaProduto){
		
		//Panel de Consulta de Produto
		//consultaProduto = new JScrollPane();
		consultaProduto.setVisible(false);
		consultaProduto.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(consultaProduto);
					
				
		lblTitulo_ConsultaProduto = new JLabel("CONSULTA - PRODUTO");
		lblTitulo_ConsultaProduto.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_ConsultaProduto.setBounds(209, 10, 257, 45);
		consultaProduto.add(lblTitulo_ConsultaProduto);
		
		String[] col = new String[5];
		col[0] = "COD_PRODUTO";
		col[1] = "NOME";
		col[2] = "DESCRICAO";
		col[3] = "LUCRO_ESPERADO";
		col[4] = "QNTD_ESTOQUE";
		String sql = "SELECT*FROM PRODUTO";
		TelaConsulta t = new TelaConsulta(consultaProduto,"Produto","","SELECT*FROM PRODUTO",col);
		consultaProduto.setViewportView(t.table);
		
		consultaProduto.setVisible(true);
	}

}
