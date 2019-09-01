package br.com.projeto.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {
	
	private JButton btnLogin, btnCriar;
	
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setResizable(false);
		setTitle("Sistema Simulado");
				
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Ebrima", Font.BOLD, 14));
		btnLogin.setBounds(200, 345, 89, 37);
		contentPane.add(btnLogin);
		
		btnCriar = new JButton("CRIAR");
		btnCriar.setFont(new Font("Ebrima", Font.BOLD, 14));
		btnCriar.setBounds(200, 393, 89, 37);
		contentPane.add(btnCriar);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblLogin.setBounds(145, 255, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(200, 248, 146, 26);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setFont(new Font("Ebrima", Font.BOLD, 14));
		lblSenha.setBounds(145, 292, 47, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(201, 285, 146, 26);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Johanes\\git\\Projeto-PBD\\files\\icone-perfil.png"));
		label.setBounds(165, 46, 188, 181);
		contentPane.add(label);
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
