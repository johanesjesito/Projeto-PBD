package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaCadastro extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtNaturalidade;
	private JRadioButton rdbtnProfessor;
	private JRadioButton rdbtnPedagogo;
	private JRadioButton rdbtnResponsavel;
	private JLabel lblDataDeNascimento;
	private JButton btnConfirmar;
	private ButtonGroup buttonGroup;
	private JDateChooser txtDataNascimento;
	private JTextField txtEstado;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JTextField txtCelular;
	private JLabel lblCelular;
	private JLabel lblTelefone;
	private JTextField txtTelefone;
	private JTextField txtRua;
	
    public TelaCadastro() {
    	setTitle("Cadastro");
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
		contentPane.setBounds(0, 0, 700, 280);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(27, 22, 44, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(70, 15, 248, 29);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(27, 62, 44, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCpf.setBounds(70, 55, 248, 29);
		contentPane.add(txtCpf);
		
		JLabel lblNaturalidade = new JLabel("Naturalidade:");
		lblNaturalidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNaturalidade.setBounds(27, 102, 75, 14);
		contentPane.add(lblNaturalidade);
		
		txtNaturalidade = new JTextField();
		txtNaturalidade.setColumns(10);
		txtNaturalidade.setBounds(112, 95, 206, 29);
		contentPane.add(txtNaturalidade);
		
		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setSelected(true);
		rdbtnProfessor.setBounds(27, 138, 83, 23);
		contentPane.add(rdbtnProfessor);
		
		rdbtnPedagogo = new JRadioButton("Pedagogo");
		rdbtnPedagogo.setBounds(112, 138, 80, 23);
		contentPane.add(rdbtnPedagogo);
		
		rdbtnResponsavel = new JRadioButton("Responsavel");
		rdbtnResponsavel.setBounds(195, 138, 110, 23);
		contentPane.add(rdbtnResponsavel);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataDeNascimento.setBounds(27, 175, 116, 14);
		contentPane.add(lblDataDeNascimento);

		txtDataNascimento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtDataNascimento.setDate(new Date());
		txtDataNascimento.setBounds(153, 168, 165, 29);
		contentPane.add(txtDataNascimento);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(112, 211, 89, 23);
		contentPane.add(btnConfirmar);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnProfessor);
		buttonGroup.add(rdbtnResponsavel);
		buttonGroup.add(rdbtnPedagogo);
		
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
		txtEstado.setBounds(428, 48, 238, 29);
		contentPane.add(txtEstado);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(418, 15, 248, 29);
		contentPane.add(txtCep);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(424, 81, 242, 29);
		contentPane.add(txtCidade);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(375, 88, 44, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(375, 55, 52, 14);
		contentPane.add(lblEstado);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(375, 153, 52, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(428, 146, 238, 29);
		contentPane.add(txtNumero);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(345, 186, 354, 2);
		contentPane.add(separator_1);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(434, 234, 232, 29);
		contentPane.add(txtCelular);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCelular.setBounds(375, 241, 52, 14);
		contentPane.add(lblCelular);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(375, 208, 52, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(434, 201, 232, 29);
		contentPane.add(txtTelefone);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setBounds(375, 121, 44, 14);
		contentPane.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(418, 114, 248, 29);
		contentPane.add(txtRua);
		
        pack();
    }

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtCpf() {
		return txtCpf;
	}

	public JTextField getTxtNaturalidade() {
		return txtNaturalidade;
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

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JDateChooser getTxtDataNascimento() {
		return txtDataNascimento;
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

	public JTextField getTxtRua() {
		return txtRua;
	}
    
}
