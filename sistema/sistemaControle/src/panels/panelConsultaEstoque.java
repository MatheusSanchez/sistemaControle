package panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelConsultaEstoque {
	
	private JTable table;
	
	public panelConsultaEstoque(JFrame frame,JScrollPane consultaEstoque){
		//-----Panel de consulta de estoque-----	
		//consultaEstoque = new JScrollPane();
		consultaEstoque.setVisible(false);
		consultaEstoque.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(consultaEstoque);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Nro Pedido", "C\u00F3digo", "Pre\u00E7o Compra", "Pre\u00E7o Venda", "Quantidade Repo", "Data Reposi\u00E7\u00E3o", "Quantidade Dispo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(62);
		table.getColumnModel().getColumn(1).setPreferredWidth(51);
		table.getColumnModel().getColumn(2).setPreferredWidth(77);
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);
		table.getColumnModel().getColumn(5).setPreferredWidth(86);
		table.getColumnModel().getColumn(6).setPreferredWidth(98);
		consultaEstoque.setViewportView(table);
		
		consultaEstoque.setVisible(true);
		
	}

}
