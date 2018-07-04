package panels;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class panelConsultaVenda {
	
	public panelConsultaVenda(JFrame frame, JScrollPane consultaVenda){
		//-----Panel de consulta de venda-----
		//consultaVenda = new JScrollPane();
		consultaVenda.setVisible(false);
		consultaVenda.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(consultaVenda);
		
		JTable tableVenda = new JTable();
		tableVenda.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Data", "CPF", "C\u00F3digo Venda", "C\u00F3digo Prod.", "Pre\u00E7o", "Pre\u00E7o Venda", "Lucro"
			}
		));
		consultaVenda.setViewportView(tableVenda);
		
		consultaVenda.setVisible(true);
	}

}
