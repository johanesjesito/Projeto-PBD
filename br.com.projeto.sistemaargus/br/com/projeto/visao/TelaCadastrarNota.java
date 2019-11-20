package br.com.projeto.visao;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastrarNota extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JButton btnConfirmar;
	private JComboBox txtAluno;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNota4;
	private JLabel lblMediaParcial;
	private JTextField txtMediaParcial;
	private JTextField txtNotaFinal;
	private JLabel lblNotaFinal;
	private JLabel lblMediaFinal;
	private JTextField txtMediaFinal;
	private JRadioButton rdbtnBimestral;
	private JLabel lblNota4;
	private JComboBox txtDisciplina;
	private JRadioButton rdbtnTrimestral;
	private ButtonGroup buttonGroup;
	private JLabel lblAnoLetivo;
	private JTextField txtAnoLetivo;
	private JComboBox txtTurma;
	
	public TelaCadastrarNota() {
    	setTitle("Cadastrar Nota");
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
		
		setBounds(305, 90, 383, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 400, 250);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		lblNota1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota1.setBounds(26, 85, 44, 14);
		contentPane.add(lblNota1);
		
		txtNota1 = new JTextField();
		txtNota1.setBounds(69, 78, 89, 29);
		contentPane.add(txtNota1);
		txtNota1.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(144, 211, 89, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAluno.setBounds(26, 20, 44, 14);
		contentPane.add(lblAluno);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(69, 12, 149, 29);
		contentPane.add(txtAluno);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		lblNota2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota2.setBounds(26, 118, 44, 14);
		contentPane.add(lblNota2);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(69, 111, 89, 29);
		contentPane.add(txtNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		lblNota3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota3.setBounds(26, 151, 44, 14);
		contentPane.add(lblNota3);
		
		txtNota3 = new JTextField();
		txtNota3.setColumns(10);
		txtNota3.setBounds(69, 144, 89, 29);
		contentPane.add(txtNota3);
		
		lblNota4 = new JLabel("Nota 4:");
		lblNota4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNota4.setBounds(26, 184, 44, 14);
		contentPane.add(lblNota4);
		
		txtNota4 = new JTextField();
		txtNota4.setColumns(10);
		txtNota4.setBounds(69, 177, 89, 29);
		contentPane.add(txtNota4);
		
		JLabel lblDisciplina = new JLabel("Disciplina:");
		lblDisciplina.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDisciplina.setBounds(208, 53, 61, 14);
		contentPane.add(lblDisciplina);
		
		txtDisciplina = new JComboBox();
		txtDisciplina.setBounds(268, 45, 107, 29);
		contentPane.add(txtDisciplina);
		
		lblMediaParcial = new JLabel("Media Parcial:");
		lblMediaParcial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMediaParcial.setBounds(198, 85, 89, 14);
		contentPane.add(lblMediaParcial);
		
		txtMediaParcial = new JTextField();
		txtMediaParcial.setEditable(false);
		txtMediaParcial.setColumns(10);
		txtMediaParcial.setBounds(286, 78, 89, 29);
		contentPane.add(txtMediaParcial);
		
		txtNotaFinal = new JTextField();
		txtNotaFinal.setEditable(false);
		txtNotaFinal.setColumns(10);
		txtNotaFinal.setBounds(286, 111, 89, 29);
		contentPane.add(txtNotaFinal);
		
		lblNotaFinal = new JLabel("Nota Final:");
		lblNotaFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotaFinal.setBounds(198, 118, 89, 14);
		contentPane.add(lblNotaFinal);
		
		lblMediaFinal = new JLabel("Media Final:");
		lblMediaFinal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMediaFinal.setBounds(198, 151, 89, 14);
		contentPane.add(lblMediaFinal);
		
		txtMediaFinal = new JTextField();
		txtMediaFinal.setEditable(false);
		txtMediaFinal.setColumns(10);
		txtMediaFinal.setBounds(286, 144, 89, 29);
		contentPane.add(txtMediaFinal);
		
		rdbtnBimestral = new JRadioButton("Bimestral");
		rdbtnBimestral.setSelected(true);
		rdbtnBimestral.setFont(new Font("SansSerif", Font.BOLD, 12));
		rdbtnBimestral.setBounds(26, 53, 83, 18);
		contentPane.add(rdbtnBimestral);
		
		rdbtnTrimestral = new JRadioButton("Trimestral");
		rdbtnTrimestral.setFont(new Font("SansSerif", Font.BOLD, 12));
		rdbtnTrimestral.setBounds(107, 53, 89, 18);
		contentPane.add(rdbtnTrimestral);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnBimestral);
		buttonGroup.add(rdbtnTrimestral);
		
		lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnoLetivo.setBounds(198, 184, 89, 14);
		contentPane.add(lblAnoLetivo);
		
		txtAnoLetivo = new JTextField();
		txtAnoLetivo.setColumns(10);
		try {
			txtAnoLetivo = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtAnoLetivo.setText("2019");
		txtAnoLetivo.setBounds(286, 177, 89, 29);
		contentPane.add(txtAnoLetivo);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1 - 1º Ano", "EF1 - 2º Ano", "EF1 - 3º Ano", "EF1 - 4º Ano", "EF1 - 5º Ano", "EF2 - 6º Ano", "EF2 - 7º Ano", "EF2 - 8º Ano", "EF2 - 9º Ano", "EM - 1º Ano", "EM - 2º Ano", "EM - 3º Ano"}));
		txtTurma.setBounds(275, 12, 100, 26);
		contentPane.add(txtTurma);
		
		JLabel label = new JLabel("   Turma:");
		label.setFont(new Font("SansSerif", Font.BOLD, 12));
		label.setBounds(218, 17, 55, 16);
		contentPane.add(label);
		
        pack();        
	}

	public JTextField getTxtNota1() {
		return txtNota1;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JComboBox getTxtAluno() {
		return txtAluno;
	}

	public JTextField getTxtNota2() {
		return txtNota2;
	}

	public JTextField getTxtNota3() {
		return txtNota3;
	}

	public JTextField getTxtNota4() {
		return txtNota4;
	}

	public JTextField getTxtMediaParcial() {
		return txtMediaParcial;
	}

	public JTextField getTxtNotaFinal() {
		return txtNotaFinal;
	}

	public JTextField getTxtMediaFinal() {
		return txtMediaFinal;
	}

	public JRadioButton getRdbtnBimestral() {
		return rdbtnBimestral;
	}

	public JLabel getLblNota4() {
		return lblNota4;
	}

	public JComboBox getTxtDisciplina() {
		return txtDisciplina;
	}

	public JRadioButton getRdbtnTrimestral() {
		return rdbtnTrimestral;
	}

	public JTextField getTxtAnoLetivo() {
		return txtAnoLetivo;
	}

	public JComboBox getTxtTurma() {
		return txtTurma;
	}
	
}
