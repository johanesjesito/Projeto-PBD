package br.com.projeto.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.sun.xml.internal.ws.api.server.Container;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class TelaLogin extends JInternalFrame {
		
	private JButton btnLogin, btnCriar;
	
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	public TelaLogin() {
		
		((BasicInternalFrameUI) getUI()).setNorthPane(null);
		
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
		setBounds(380, 90, 230, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 230, 230);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Ebrima", Font.BOLD, 14));
		btnLogin.setBounds(65, 127, 89, 37);
		contentPane.add(btnLogin);
		
		btnCriar = new JButton("CRIAR");
		btnCriar.setFont(new Font("Ebrima", Font.BOLD, 14));
		btnCriar.setBounds(65, 175, 89, 37);
		contentPane.add(btnCriar);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblLogin.setBounds(10, 37, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(65, 30, 146, 26);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblSenha.setBounds(10, 74, 47, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(66, 67, 146, 26);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
				
		pack();
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnCriar() {
		return btnCriar;
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public JTextField getTxtSenha() {
		return txtSenha;
	}

}
