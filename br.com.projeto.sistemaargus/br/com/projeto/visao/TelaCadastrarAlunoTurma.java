package br.com.projeto.visao;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class TelaCadastrarAlunoTurma extends JInternalFrame {

	private JPanel contentPane;
	private JButton btnConfirmar;
	private JComboBox txtTurma;
	private JComboBox txtAluno;
	private JLabel lblAnoLetivo;
	private JTextField txtAnoLetivo;
	
	public TelaCadastrarAlunoTurma() {
    	setTitle("Cadastrar Disciplinas na Turma");
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
		contentPane.setBounds(0, 0, 380, 80);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(281, 46, 89, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(10, 48, 47, 16);
		contentPane.add(lblTurma);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1 - 1º Ano", "EF1 - 2º Ano", "EF1 - 3º Ano", "EF1 - 4º Ano", "EF1 - 5º Ano", "EF2 - 6º Ano", "EF2 - 7º Ano", "EF2 - 8º Ano", "EF2 - 9º Ano", "EM - 1º Ano", "EM - 2º Ano", "EM - 3º Ano"}));
		txtTurma.setBounds(55, 44, 107, 26);
		contentPane.add(txtTurma);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(55, 11, 315, 26);
		contentPane.add(txtAluno);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAluno.setBounds(10, 16, 41, 16);
		contentPane.add(lblAluno);
		
		lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoLetivo.setBounds(168, 48, 65, 16);
		contentPane.add(lblAnoLetivo);
		
		txtAnoLetivo = new JTextField();
		try {
			txtAnoLetivo = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtAnoLetivo.setText("2019");
		txtAnoLetivo.setBounds(230, 43, 48, 26);
		contentPane.add(txtAnoLetivo);
		txtAnoLetivo.setColumns(10);
				
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

}
