package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import back.Usuario;

public class panelConsultaUsuario {
	
	public panelConsultaUsuario(JFrame frame, JScrollPane consultaUsuario){
		//-----Panel de consulta de usuario-----	
		//consultaUsuario = new JPanel();
		consultaUsuario.setVisible(false);
		consultaUsuario.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(consultaUsuario);
		consultaUsuario.setLayout(null);
		
		JLabel lblConsultaUsuarios = new JLabel("CONSULTA - USUARIOS");
		lblConsultaUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConsultaUsuarios.setBounds(232, 11, 233, 14);
		consultaUsuario.add(lblConsultaUsuarios);
		
		JComboBox cBUsuarios = new JComboBox(Usuario.getNames());
		cBUsuarios.setBounds(39, 123, 248, 20);
		consultaUsuario.add(cBUsuarios);
		
		JLabel lblNome_C = new JLabel("Nome:");
		lblNome_C.setBounds(356, 72, 46, 14);
		consultaUsuario.add(lblNome_C);
		
		JLabel lblRg_C = new JLabel("RG:");
		lblRg_C.setBounds(356, 104, 46, 14);
		consultaUsuario.add(lblRg_C);
		
		JLabel lblCpf_C = new JLabel("CPF:");
		lblCpf_C.setBounds(356, 139, 46, 14);
		consultaUsuario.add(lblCpf_C);
		
		JLabel lblEmail_C = new JLabel("Email:");
		lblEmail_C.setBounds(356, 176, 46, 14);
		consultaUsuario.add(lblEmail_C);
		
		JLabel lblDadoAquiNo = new JLabel("Nome do usu\u00E1rio");
		lblDadoAquiNo.setVerticalAlignment(SwingConstants.TOP);
		lblDadoAquiNo.setBounds(426, 72, 156, 14);
		consultaUsuario.add(lblDadoAquiNo);
		
		JLabel lblRgDoUsurio = new JLabel("RG do usu\u00E1rio");
		lblRgDoUsurio.setVerticalAlignment(SwingConstants.TOP);
		lblRgDoUsurio.setBounds(426, 104, 156, 14);
		consultaUsuario.add(lblRgDoUsurio);
		
		JLabel lblCpfDoUsurio = new JLabel("CPF do usu\u00E1rio");
		lblCpfDoUsurio.setVerticalAlignment(SwingConstants.TOP);
		lblCpfDoUsurio.setBounds(426, 139, 156, 14);
		consultaUsuario.add(lblCpfDoUsurio);
		
		JLabel lblEmailDoUsurio = new JLabel("Email do usu\u00E1rio");
		lblEmailDoUsurio.setVerticalAlignment(SwingConstants.TOP);
		lblEmailDoUsurio.setBounds(426, 176, 156, 14);
		consultaUsuario.add(lblEmailDoUsurio);
		
		JLabel lblSelecioneOUsurio = new JLabel("Selecione o usu\u00E1rio que deseja consultar:");
		lblSelecioneOUsurio.setBounds(40, 104, 248, 14);
		consultaUsuario.add(lblSelecioneOUsurio);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(356, 209, 46, 14);
		consultaUsuario.add(lblTipo);
		
		JLabel lblTipoDoUsurio = new JLabel("Tipo do usu\u00E1rio");
		lblTipoDoUsurio.setVerticalAlignment(SwingConstants.TOP);
		lblTipoDoUsurio.setBounds(426, 209, 156, 14);
		consultaUsuario.add(lblTipoDoUsurio);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeSelecionado = (String)cBUsuarios.getSelectedItem(); // pega o item selecionado no comboBox
				 String [] result =  Usuario.getInfos(nomeSelecionado);
				 if(result != null){
					 lblCpfDoUsurio.setText(result[0]);
					 lblRgDoUsurio.setText(result[1]);
					 lblDadoAquiNo.setText(result[2]);
					 lblEmailDoUsurio.setText(result[3]);
					 result[4] = Usuario.getTipo(result[0]);
					 if(result[4] != null){
						 lblTipoDoUsurio.setText(result[4]);
					 }
					 else lblTipoDoUsurio.setText("Tipo não cadastrado");
				 }
			}
		});
		btnVisualizar.setBounds(100, 154, 133, 36);
		consultaUsuario.add(btnVisualizar);
		
		consultaUsuario.setVisible(true);
	}

}
