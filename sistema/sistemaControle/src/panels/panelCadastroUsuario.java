package panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import back.Usuario;

public class panelCadastroUsuario {
	
	public JTextField textFieldNomeUsuario;
	public JTextField textFieldRGUsuario;
	public JTextField textFieldCPFUsuario;
	public JTextField textFieldEmailUsuario;
	public JTextField textFieldSenhaUsuario;
	public JTextField textFieldConfirmacaoUsuario;
	public JTextField textFieldProduto;
	public JTextField textFieldConfirmacaoProduto;
	public JComboBox boxTipoFuncionario;
	
	public panelCadastroUsuario(JFrame frame,JPanel cadastroUsuario){
		//-----Panel de cadastro de usuario-----
		//cadastroUsuario = new JPanel();
		cadastroUsuario.setVisible(false);
		cadastroUsuario.setBounds(282, 129, 638, 281);
		frame.getContentPane().add(cadastroUsuario);
		cadastroUsuario.setLayout(null);
			
		textFieldNomeUsuario = new JTextField();
		textFieldNomeUsuario.setToolTipText("Ex: Matheus Sanchez");
		textFieldNomeUsuario.setBounds(204, 33, 288, 20);
		cadastroUsuario.add(textFieldNomeUsuario);
		textFieldNomeUsuario.setColumns(10);
			
		textFieldRGUsuario = new JTextField();
		textFieldRGUsuario.setToolTipText("12.345.678");
		textFieldRGUsuario.setBounds(204, 64, 288, 20);
		cadastroUsuario.add(textFieldRGUsuario);
		textFieldRGUsuario.setColumns(10);
			
		textFieldCPFUsuario = new JTextField();
		textFieldCPFUsuario.setToolTipText("123.456.789-10");
		textFieldCPFUsuario.setBounds(204, 95, 288, 20);
		cadastroUsuario.add(textFieldCPFUsuario);
		textFieldCPFUsuario.setColumns(10);
			
		textFieldEmailUsuario = new JTextField();
		textFieldEmailUsuario.setToolTipText("matheussanchez.gmail.com");
		textFieldEmailUsuario.setBounds(204, 126, 288, 20);
		cadastroUsuario.add(textFieldEmailUsuario);
		textFieldEmailUsuario.setColumns(10);
			
		textFieldSenhaUsuario = new JTextField();
		textFieldSenhaUsuario.setBounds(204, 157, 288, 20);
		cadastroUsuario.add(textFieldSenhaUsuario);
		textFieldSenhaUsuario.setColumns(10);
			
		textFieldConfirmacaoUsuario = new JTextField();
		textFieldConfirmacaoUsuario.setBounds(204, 194, 288, 20);
		cadastroUsuario.add(textFieldConfirmacaoUsuario);
		textFieldConfirmacaoUsuario.setColumns(10);
			
		JLabel lblNome_U = new JLabel("Nome :");
		lblNome_U.setBounds(72, 36, 46, 14);
		cadastroUsuario.add(lblNome_U);
			
		JLabel lblRG = new JLabel("RG :");
		lblRG.setBounds(72, 67, 46, 14);
		cadastroUsuario.add(lblRG);
			
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setBounds(72, 98, 46, 14);
		cadastroUsuario.add(lblCpf);
			
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(72, 129, 46, 14);
		cadastroUsuario.add(lblEmail);
			
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(72, 160, 46, 14);
		cadastroUsuario.add(lblSenha);
			
		JLabel lblConfirmeASenha = new JLabel("Confirme a senha:");
		lblConfirmeASenha.setBounds(72, 197, 122, 14);
		cadastroUsuario.add(lblConfirmeASenha);
			
		JLabel lblTipoDeFuncionrio = new JLabel("Tipo de funcion\u00E1rio:");
		lblTipoDeFuncionrio.setBounds(72, 232, 122, 14);
		cadastroUsuario.add(lblTipoDeFuncionrio);
			
		JLabel lblTitulo_CadastroUsuario = new JLabel("CADASTRO - USUARIO");
		lblTitulo_CadastroUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo_CadastroUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo_CadastroUsuario.setBounds(209, 0, 257, 45);
		cadastroUsuario.add(lblTitulo_CadastroUsuario);
			
		boxTipoFuncionario = new JComboBox();
		boxTipoFuncionario.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Funcionario", "Outro"}));
		boxTipoFuncionario.setToolTipText("");
		boxTipoFuncionario.setBounds(204, 229, 288, 20);
		cadastroUsuario.add(boxTipoFuncionario);
			
		//Botão responsavel pelo cadastro de usuario
		JButton btnCadastrarUsuario = new JButton("Cadastrar");
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String [] form_U = new String[7];
				String aux = new String();
					form_U[0] = textFieldCPFUsuario.getText();
					form_U[1] = textFieldRGUsuario.getText();
					form_U[2] = textFieldNomeUsuario.getText();
					form_U[3] = textFieldEmailUsuario.getText();
					form_U[4] = textFieldSenhaUsuario.getText();
					form_U[5] = textFieldConfirmacaoUsuario.getText();
					form_U[6] = boxTipoFuncionario.getToolTipText();
					if(form_U[6].equals("Administrador")) {
						aux = "A";
					}
					if(form_U[6].equals("Funcionario")) {
						aux = "F";
					}
					if(form_U[6].equals("Outro")) {
						aux = "O";
					}
					System.out.println(form_U[0] + " " + form_U[1] + " " + form_U[2] + " " + form_U[3] + " " + form_U[4] + " " + form_U[5] + " " + form_U[6] + " " + aux);
					if(form_U[4].equals(form_U[5])){
						Usuario.cadastro(form_U, form_U[6]);
					}
			}
		});
		btnCadastrarUsuario.setBounds(518, 114, 95, 45);
		cadastroUsuario.add(btnCadastrarUsuario);
		
		cadastroUsuario.setVisible(true);
	}

}
