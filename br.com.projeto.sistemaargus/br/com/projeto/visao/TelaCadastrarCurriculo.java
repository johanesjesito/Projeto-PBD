package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastrarCurriculo extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtAnoLetivo;
	private JTable tblNotaDisciplina;
	private JTextField txtSituacao;
	private JButton btnCadastrar;
	private JComboBox txtAluno;
	private JLabel lblTurma;
	private JComboBox txtTurma;
	
	public TelaCadastrarCurriculo() {
    	setTitle("Cadastrar Curriculo");
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
		
		setBounds(150, 90, 375, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 700, 270);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(217, 6, 304, 26);
		contentPane.add(txtAluno);
		
		JLabel lblNewLabel = new JLabel("Aluno:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(175, 11, 43, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoLetivo.setBounds(175, 39, 72, 16);
		contentPane.add(lblAnoLetivo);
		
		txtAnoLetivo = new JTextField();
		try {
			txtAnoLetivo = new JFormattedTextField(new MaskFormatter("####"));
			txtAnoLetivo.setText("2019");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtAnoLetivo.setBounds(243, 33, 86, 28);
		contentPane.add(txtAnoLetivo);
		txtAnoLetivo.setColumns(10);
		
		tblNotaDisciplina = new JTable();
		tblNotaDisciplina.setBounds(12, 68, 671, 156);
		contentPane.add(tblNotaDisciplina);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSituao.setBounds(185, 235, 61, 16);
		contentPane.add(lblSituao);
		
		txtSituacao = new JTextField();
		txtSituacao.setColumns(10);
		txtSituacao.setBounds(254, 229, 72, 28);
		contentPane.add(txtSituacao);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCadastrar.setBounds(384, 229, 90, 28);
		contentPane.add(btnCadastrar);
		
		lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(341, 38, 43, 16);
		contentPane.add(lblTurma);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1 - 1� Ano", "EF1 - 2� Ano", "EF1 - 3� Ano", "EF1 - 4� Ano", "EF1 - 5� Ano", "EF2 - 6� Ano", "EF2 - 7� Ano", "EF2 - 8� Ano", "EF2 - 9� Ano", "EM - 1� Ano", "EM - 2� Ano", "EM - 3� Ano"}));
		txtTurma.setBounds(383, 33, 100, 26);
		contentPane.add(txtTurma);

		pack();
	}

	public JTextField getTxtAnoLetivo() {
		return txtAnoLetivo;
	}

	public JTable getTblNotaDisciplina() {
		return tblNotaDisciplina;
	}

	public JTextField getTxtSituacao() {
		return txtSituacao;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JComboBox getTxtAluno() {
		return txtAluno;
	}

	public JComboBox getTxtTurma() {
		return txtTurma;
	}
	
}
