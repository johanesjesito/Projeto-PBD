package br.com.projeto.visao;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class TelaPerfil extends JInternalFrame {
	
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtNome;
	private JTextField txtNaturalidade;
	private JLabel lblDataDeNascimento;
	private JButton btnEditar;
	private JDateChooser txtDataNascimento;
	
    public TelaPerfil() {
    	setClosable(true);
    	
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
		
		setBounds(300, 90, 377, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 345, 230);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(27, 22, 33, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(70, 15, 248, 29);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(27, 55, 44, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(76, 48, 242, 29);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(27, 88, 44, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(70, 81, 248, 29);
		contentPane.add(txtNome);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade:");
		lblNaturalidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNaturalidade.setBounds(27, 121, 75, 14);
		contentPane.add(lblNaturalidade);
		
		txtNaturalidade = new JTextField();
		txtNaturalidade.setColumns(10);
		txtNaturalidade.setBounds(112, 114, 206, 29);
		contentPane.add(txtNaturalidade);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeNascimento.setBounds(27, 153, 116, 14);
		contentPane.add(lblDataDeNascimento);

		txtDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtDataNascimento.setDate(new Date());
		txtDataNascimento.setBounds(153, 146, 165, 29);
		contentPane.add(txtDataNascimento);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEditar.setBounds(125, 187, 89, 23);
		contentPane.add(btnEditar);
				
        pack();
    }

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public JTextField getTxtSenha() {
		return txtSenha;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtNaturalidade() {
		return txtNaturalidade;
	}

	public JDateChooser getTxtDataNascimento() {
		return txtDataNascimento;
	}

	public JLabel getLblDataDeNascimento() {
		return lblDataDeNascimento;
	}
	
}
