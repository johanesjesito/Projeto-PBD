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

public class TelaCadastro extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtNome;
	private JTextField txtNaturalidade;
	private JRadioButton rdbtnResponsavel;
	private JRadioButton rdbtnAluno;
	private JRadioButton rdbtnProfessor;
	private JRadioButton rdbtnPedagogo;
	private JLabel lblDataDeNascimento;
	private JButton btnVolta, btnConfirmar;
	private ButtonGroup buttonGroup;
	private JDateChooser txtDataNascimento;
	
    public TelaCadastro() {

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
		
		rdbtnResponsavel = new JRadioButton("Responsavel");
		rdbtnResponsavel.setBounds(6, 159, 97, 23);
		contentPane.add(rdbtnResponsavel);
		rdbtnResponsavel.setSelected(true);
		
		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setBounds(105, 159, 53, 23);
		contentPane.add(rdbtnAluno);
		
		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setBounds(160, 159, 86, 23);
		contentPane.add(rdbtnProfessor);
		
		rdbtnPedagogo = new JRadioButton("Pedagogo");
		rdbtnPedagogo.setBounds(248, 159, 91, 23);
		contentPane.add(rdbtnPedagogo);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeNascimento.setBounds(27, 207, 116, 14);
		contentPane.add(lblDataDeNascimento);

		txtDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtDataNascimento.setDate(new Date());
		txtDataNascimento.setBounds(153, 200, 165, 29);
		contentPane.add(txtDataNascimento);
		
		btnVolta = new JButton("Volta");
		btnVolta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolta.setBounds(178, 240, 89, 23);
		contentPane.add(btnVolta);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(70, 240, 89, 23);
		contentPane.add(btnConfirmar);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnResponsavel);
		buttonGroup.add(rdbtnAluno);
		buttonGroup.add(rdbtnPedagogo);
		buttonGroup.add(rdbtnProfessor);
		
        pack();
    }

	public JButton getBtnVolta() {
		return btnVolta;
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

	public JRadioButton getRdbtnAluno() {
		return rdbtnAluno;
	}

	public JRadioButton getRdbtnProfessor() {
		return rdbtnProfessor;
	}

	public JRadioButton getRdbtnPedagogo() {
		return rdbtnPedagogo;
	}

	public JRadioButton getRdbtnResponsavel() {
		return rdbtnResponsavel;
	}
	
}
