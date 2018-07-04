package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import back.Usuario;

public class panelRemocaoUsuario {
	
	public panelRemocaoUsuario(JFrame frame, JPanel remocaoUsuario){
		//-----Panel de remocao de usuario-----
		//remocaoUsuario = new JPanel();
		remocaoUsuario.setVisible(false);
		remocaoUsuario.setBounds(281, 129, 638, 281);
		frame.getContentPane().add(remocaoUsuario);
		remocaoUsuario.setLayout(null);
		
		JLabel lblRemooUsuarios = new JLabel("REMO\u00C7\u00C3O - USUARIOS");
		lblRemooUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRemooUsuarios.setBounds(208, 11, 264, 14);
		remocaoUsuario.add(lblRemooUsuarios);
		
		JComboBox comboBoxRemocao_U = new JComboBox(Usuario.getNames());
		comboBoxRemocao_U.setBounds(185, 116, 264, 20);
		remocaoUsuario.add(comboBoxRemocao_U);
		
		JLabel lblEscolhaOUsurio = new JLabel("Escolha o usu\u00E1rio que deseja remover :");
		lblEscolhaOUsurio.setBounds(205, 95, 257, 14);
		remocaoUsuario.add(lblEscolhaOUsurio);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Deseja realmente excluir ?") == JOptionPane.YES_OPTION) {
					Usuario.delete((String)comboBoxRemocao_U.getSelectedItem());
				}
					
			}
		});
		btnRemover.setBounds(250, 147, 119, 30);
		remocaoUsuario.add(btnRemover);
		
		JLabel lblRemocaoUsuarios = new JLabel("REMO\u00C7\u00C3O - USUARIOS");
		lblRemocaoUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRemocaoUsuarios.setBounds(208, 11, 264, 14);
		remocaoUsuario.add(lblRemocaoUsuarios);
		
		remocaoUsuario.setVisible(true);
	}

}
