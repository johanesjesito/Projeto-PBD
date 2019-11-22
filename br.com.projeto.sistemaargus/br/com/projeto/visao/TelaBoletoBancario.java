package br.com.projeto.visao;

import java.awt.Font;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class TelaBoletoBancario extends JInternalFrame {

	private JPanel contentPane;
	private JButton btnConfirmar;
	private JComboBox txtTurma;
	private JComboBox txtAluno;
	private JTextField txtAnoLetivo;
	private JDateChooser txtDataInicial;
	private JDateChooser txtDataFinal;
	private JButton btnGerarBoleto;
	private JTextField txtCodigo;
	private JButton btnPago;
	
	public TelaBoletoBancario() {
    	setTitle("Parcela do Aluno");
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
		
		setBounds(320, 90, 375, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 380, 220);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirmar = new JButton("Cadastrar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(92, 135, 89, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(51, 11, 47, 16);
		contentPane.add(lblTurma);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1 - 1º Ano", "EF1 - 2º Ano", "EF1 - 3º Ano", "EF1 - 4º Ano", "EF1 - 5º Ano", "EF2 - 6º Ano", "EF2 - 7º Ano", "EF2 - 8º Ano", "EF2 - 9º Ano", "EM - 1º Ano", "EM - 2º Ano", "EM - 3º Ano"}));
		txtTurma.setBounds(96, 7, 107, 26);
		contentPane.add(txtTurma);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(51, 40, 315, 26);
		contentPane.add(txtAluno);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAluno.setBounds(17, 45, 41, 16);
		contentPane.add(lblAluno);
		
		btnGerarBoleto = new JButton("Gerar Boleto");
		btnGerarBoleto.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGerarBoleto.setBounds(193, 135, 107, 23);
		contentPane.add(btnGerarBoleto);
		
		JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoLetivo.setBounds(209, 11, 65, 16);
		contentPane.add(lblAnoLetivo);
		
		txtAnoLetivo = new JTextField();
		try {
			txtAnoLetivo = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtAnoLetivo.setText("2019");
		txtAnoLetivo.setBounds(271, 6, 48, 26);
		contentPane.add(txtAnoLetivo);
		txtAnoLetivo.setColumns(10);		
		
		txtDataInicial = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtDataInicial.setDate(new Date());
		txtDataInicial.setBounds(51, 94, 125, 29);
		contentPane.add(txtDataInicial);
		
		txtDataFinal = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtDataFinal.setDate(new Date());
		txtDataFinal.setBounds(194, 94, 125, 29);
		contentPane.add(txtDataFinal);
		
		JLabel lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDataInicial.setBounds(76, 78, 71, 16);
		contentPane.add(lblDataInicial);
		
		JLabel lblVencimento = new JLabel("Vencimento");
		lblVencimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblVencimento.setBounds(216, 78, 71, 16);
		contentPane.add(lblVencimento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 163, 380, 7);
		contentPane.add(separator);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCodigo.setBounds(17, 182, 48, 16);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(65, 176, 222, 28);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnPago = new JButton("Pago");
		btnPago.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPago.setBounds(295, 176, 65, 23);
		contentPane.add(btnPago);
		
        pack();
        
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JComboBox getTxtTurma() {
		return txtTurma;
	}

	public JComboBox getTxtAluno() {
		return txtAluno;
	}

	public JTextField getTxtAnoLetivo() {
		return txtAnoLetivo;
	}

	public JDateChooser getTxtDataInicial() {
		return txtDataInicial;
	}

	public JDateChooser getTxtDataFinal() {
		return txtDataFinal;
	}

	public JButton getBtnGerarBoleto() {
		return btnGerarBoleto;
	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public JButton getBtnPago() {
		return btnPago;
	}
	
}
