package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaResetarSenha extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtSenha;
	
    public TelaResetarSenha(String nome) {
    	setClosable(true);
		setTitle("Resetar Senha");

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
	
		setBounds(790, 10, 185, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 185, 160);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(52, 11, 71, 19);
		contentPane.add(lblUsuario);
		
		JLabel lblNome = new JLabel(nome);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNome.setBounds(26, 41, 126, 19);
		contentPane.add(lblNome);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(26, 71, 126, 32);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarSenha.setBounds(26, 115, 126, 23);
		contentPane.add(btnAlterarSenha);
		
        pack();
    }
}
