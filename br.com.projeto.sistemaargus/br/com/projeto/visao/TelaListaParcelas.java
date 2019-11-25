package br.com.projeto.visao;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTable;

public class TelaListaParcelas extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtAnoLetivo;
	private JComboBox txtAluno;
	private JLabel lblTurma;
	private JComboBox txtTurma;
	private JTable txtAcompanhamento;
	
	public TelaListaParcelas() {
    	setTitle("Lista de Parcelas");
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
		contentPane.setBounds(0, 0, 370, 250);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(53, 45, 304, 26);
		contentPane.add(txtAluno);
		
		JLabel lblNewLabel = new JLabel("Aluno:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(11, 50, 43, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoLetivo.setBounds(11, 17, 72, 16);
		contentPane.add(lblAnoLetivo);
		
		txtAnoLetivo = new JTextField();
		try {
			txtAnoLetivo = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtAnoLetivo.setText("2019");
		txtAnoLetivo.setBounds(80, 11, 86, 28);
		contentPane.add(txtAnoLetivo);
		txtAnoLetivo.setColumns(10);
		
		lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(178, 17, 43, 16);
		contentPane.add(lblTurma);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1 - 1º Ano", "EF1 - 2º Ano", "EF1 - 3º Ano", "EF1 - 4º Ano", "EF1 - 5º Ano", "EF2 - 6º Ano", "EF2 - 7º Ano", "EF2 - 8º Ano", "EF2 - 9º Ano", "EM - 1º Ano", "EM - 2º Ano", "EM - 3º Ano"}));
		txtTurma.setBounds(233, 11, 110, 26);
		contentPane.add(txtTurma);
		
		txtAcompanhamento = new JTable();
		txtAcompanhamento.setBounds(11, 82, 346, 149);
		contentPane.add(txtAcompanhamento);

		pack();
		}

	public JTextField getTxtAnoLetivo() {
		return txtAnoLetivo;
	}

	public JComboBox getTxtAluno() {
		return txtAluno;
	}

	public JComboBox getTxtTurma() {
		return txtTurma;
	}

	public JTable getTxtAcompanhamento() {
		return txtAcompanhamento;
	}
	
}
