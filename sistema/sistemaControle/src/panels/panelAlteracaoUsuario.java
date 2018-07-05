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
import javax.swing.JTextField;

import back.Usuario;

public class panelAlteracaoUsuario {
	
	private JTextField textNomeUsuario_A;
	private JTextField textEmailUsuario_A;
	private JTextField textSenhaUsuario_A;
	private JTextField textConfirmacao_A;
	private JLabel lblNome_A;
	private JLabel lblEmail_A;
	private JLabel lblSenha_A;
	private JLabel lblConfirmeASenha_A;
	private JButton btnAlterarUsuario;
	
	public void someBotoes() {
		textNomeUsuario_A.setVisible(false);
		textEmailUsuario_A.setVisible(false);
		textSenhaUsuario_A.setVisible(false);
		textConfirmacao_A.setVisible(false);
		lblNome_A.setVisible(false);
		lblEmail_A.setVisible(false);
		lblSenha_A.setVisible(false);
		lblConfirmeASenha_A.setVisible(false);
		btnAlterarUsuario.setVisible(false);
	}
	
	public void exibeBotoes() {
		textNomeUsuario_A.setVisible(true);
		textEmailUsuario_A.setVisible(true);
		textSenhaUsuario_A.setVisible(true);
		textConfirmacao_A.setVisible(true);
		lblNome_A.setVisible(true);
		lblEmail_A.setVisible(true);
		lblSenha_A.setVisible(true);
		lblConfirmeASenha_A.setVisible(true);
		btnAlterarUsuario.setVisible(true);
		
	}

	public panelAlteracaoUsuario(JFrame frame, JPanel alteracaoUsuario){
		//-----Panel de alteracao de usuario-----
		//alteracaoUsuario = new JPanel();
		alteracaoUsuario.setVisible(false);
		alteracaoUsuario.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(alteracaoUsuario);
		alteracaoUsuario.setLayout(null);
		
		JLabel lblAlteraoUsuarios = new JLabel("ALTERA\u00C7\u00C3O - USUARIOS");
		lblAlteraoUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAlteraoUsuarios.setBounds(220, 11, 289, 14);
		alteracaoUsuario.add(lblAlteraoUsuarios);
		
		JComboBox comboBoxUsuario_A = new JComboBox(Usuario.getNames());
		comboBoxUsuario_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					 someBotoes();	
			}
		});
		
		comboBoxUsuario_A.setBounds(23, 133, 209, 19);
		alteracaoUsuario.add(comboBoxUsuario_A);
		
		btnAlterarUsuario = new JButton("Alterar");
		btnAlterarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String [] form = new String[4];
				
				form[0] = textNomeUsuario_A.getText();
				form[1] = textEmailUsuario_A.getText();
				form[2] = textSenhaUsuario_A.getText();
				form[3] = textConfirmacao_A.getText();
				
				if(form[2].equals(form[3])){
					Usuario.update(form,(String)comboBoxUsuario_A.getSelectedItem());	
				}else{
					JOptionPane.showMessageDialog(null, "As senhas estão diferetes !");
				}
				
				
			}
		});
		
		
		btnAlterarUsuario.setBounds(519, 125, 85, 46);
		alteracaoUsuario.add(btnAlterarUsuario);
		
		textNomeUsuario_A = new JTextField();
		textNomeUsuario_A.setBounds(269, 66, 209, 19);
		alteracaoUsuario.add(textNomeUsuario_A);
		textNomeUsuario_A.setColumns(10);
		
		textEmailUsuario_A = new JTextField();
		textEmailUsuario_A.setBounds(269, 112, 209, 19);
		alteracaoUsuario.add(textEmailUsuario_A);
		textEmailUsuario_A.setColumns(10);
		
		textSenhaUsuario_A = new JTextField();
		textSenhaUsuario_A.setBounds(269, 152, 209, 19);
		alteracaoUsuario.add(textSenhaUsuario_A);
		textSenhaUsuario_A.setColumns(10);
		
		textConfirmacao_A = new JTextField();
		textConfirmacao_A.setBounds(269, 196, 209, 19);
		alteracaoUsuario.add(textConfirmacao_A);
		textConfirmacao_A.setColumns(10);
		
		/*JComboBox comboBoxTipoUsuario_A = new JComboBox(Usuario.get);
		comboBoxTipoUsuario_A.setBounds(269, 234, 209, 19);
		alteracaoUsuario.add(comboBoxTipoUsuario_A);*/
		
		lblNome_A = new JLabel("Nome:");
		lblNome_A.setBounds(269, 54, 209, 13);
		alteracaoUsuario.add(lblNome_A);
		
		lblEmail_A = new JLabel("Email:");
		lblEmail_A.setBounds(269, 95, 209, 13);
		alteracaoUsuario.add(lblEmail_A);
		
		lblSenha_A = new JLabel("Senha:");
		lblSenha_A.setBounds(269, 141, 45, 13);
		alteracaoUsuario.add(lblSenha_A);
		
		lblConfirmeASenha_A = new JLabel("Confirme a Senha:");
		lblConfirmeASenha_A.setBounds(269, 181, 209, 13);
		alteracaoUsuario.add(lblConfirmeASenha_A);
		
		/*JLabel lblTipo_A = new JLabel("Tipo:");
		lblTipo_A.setBounds(269, 219, 45, 13);
		alteracaoUsuario.add(lblTipo_A);*/
		
		textNomeUsuario_A.setVisible(false);
		textEmailUsuario_A.setVisible(false);
		textSenhaUsuario_A.setVisible(false);
		textConfirmacao_A.setVisible(false);
		lblNome_A.setVisible(false);
		lblEmail_A.setVisible(false);
		lblSenha_A.setVisible(false);
		lblConfirmeASenha_A.setVisible(false);
		btnAlterarUsuario.setVisible(false);
		
		JButton btnConsultaAlteracao_U = new JButton("Consulta");
		btnConsultaAlteracao_U.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeSelecionado = (String)comboBoxUsuario_A.getSelectedItem();
				String []result = Usuario.getInfos(nomeSelecionado);
				if(result != null){
					textNomeUsuario_A.setText(result[2]);
					textEmailUsuario_A.setText(result[3]);
					textSenhaUsuario_A.setText(result[4]);
					exibeBotoes();
				}
			}
		});
		btnConsultaAlteracao_U.setBounds(82, 163, 89, 23);
		alteracaoUsuario.add(btnConsultaAlteracao_U);
		
		JLabel lblNewLabelA = new JLabel("Selecione o usu\u00E1rio que deseja alterar:");
		lblNewLabelA.setBounds(35, 112, 209, 14);
		alteracaoUsuario.add(lblNewLabelA);
		
		alteracaoUsuario.setVisible(true);
	}
}
