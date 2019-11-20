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
	private JButton btnAlterarSenha;
	private JTextField txtUsuario;
	
    public TelaResetarSenha() {
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
		
		txtSenha = new JTextField();
		txtSenha.setBounds(26, 87, 126, 32);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterarSenha.setBounds(26, 130, 126, 23);
		contentPane.add(btnAlterarSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(26, 44, 126, 32);
		contentPane.add(txtUsuario);
		
        pack();
    }

	public JTextField getTxtSenha() {
		return txtSenha;
	}

	public JButton getBtnAlterarSenha() {
		return btnAlterarSenha;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

}
