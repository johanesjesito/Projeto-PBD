package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import sun.util.calendar.JulianCalendar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaCadastroAdministrador extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtNome;
	private JTextField txtNaturalidade;
	private JRadioButton rdbtnCoordenador;
	private JRadioButton rdbtnDiretor;
	private JRadioButton rdbtnSecretario;
	private JRadioButton rdbtnFuncionario;
	private JLabel lblDataDeNascimento;
	private JButton btnConfirmar;
	private ButtonGroup buttonGroup;
	private JDateChooser txtDataNascimento;
	
    public TelaCadastroAdministrador() {
    	setTitle("Cadastro Administrativo");
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
		
		setBounds(300, 90, 345, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 345, 270);
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
		
		rdbtnCoordenador = new JRadioButton("Coordenador");
		rdbtnCoordenador.setBounds(6, 159, 97, 23);
		contentPane.add(rdbtnCoordenador);
		rdbtnCoordenador.setSelected(true);
		
		rdbtnDiretor = new JRadioButton("Diretor");
		rdbtnDiretor.setBounds(104, 159, 59, 23);
		contentPane.add(rdbtnDiretor);
		
		rdbtnSecretario = new JRadioButton("Secretario");
		rdbtnSecretario.setBounds(165, 159, 80, 23);
		contentPane.add(rdbtnSecretario);
		
		rdbtnFuncionario = new JRadioButton("Funcionario");
		rdbtnFuncionario.setBounds(248, 159, 91, 23);
		contentPane.add(rdbtnFuncionario);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeNascimento.setBounds(27, 207, 116, 14);
		contentPane.add(lblDataDeNascimento);

		txtDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtDataNascimento.setDate(new Date());
		txtDataNascimento.setBounds(153, 200, 165, 29);
		contentPane.add(txtDataNascimento);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(127, 240, 89, 23);
		contentPane.add(btnConfirmar);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnCoordenador);
		buttonGroup.add(rdbtnDiretor);
		buttonGroup.add(rdbtnFuncionario);
		buttonGroup.add(rdbtnSecretario);
		
        pack();
    }

	public JButton getBtnConfirmar() {
		return btnConfirmar;
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

	public JRadioButton getRdbtnCoordenador() {
		return rdbtnCoordenador;
	}

	public JRadioButton getRdbtnDiretor() {
		return rdbtnDiretor;
	}

	public JRadioButton getRdbtnSecretario() {
		return rdbtnSecretario;
	}

	public JRadioButton getRdbtnFuncionario() {
		return rdbtnFuncionario;
	}
	
}
