package br.com.projeto.visao;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private JTextField txtEstado;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JTextField txtCelular;
	private JLabel lblCelular;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	
    public TelaPerfil() {
    	setTitle("Perfil");
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
		
		setBounds(145, 70, 700, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 700, 270);
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
		
		txtSenha = new JPasswordField();
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
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(345, 0, 2, 274);
		contentPane.add(separator);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(375, 22, 33, 14);
		contentPane.add(lblCep);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(434, 81, 232, 29);
		contentPane.add(txtEstado);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(418, 15, 248, 29);
		contentPane.add(txtCep);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(424, 48, 242, 29);
		contentPane.add(txtCidade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(375, 55, 44, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(375, 88, 52, 14);
		contentPane.add(lblEstado);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(375, 121, 52, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(434, 114, 232, 29);
		contentPane.add(txtNumero);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(346, 159, 354, 2);
		contentPane.add(separator_1);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(434, 205, 232, 29);
		contentPane.add(txtCelular);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCelular.setBounds(375, 212, 52, 14);
		contentPane.add(lblCelular);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(375, 179, 52, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(434, 172, 232, 29);
		contentPane.add(txtTelefone);
				
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

	public JTextField getTxtEstado() {
		return txtEstado;
	}

	public JTextField getTxtCep() {
		return txtCep;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public JTextField getTxtCelular() {
		return txtCelular;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}
	
}
