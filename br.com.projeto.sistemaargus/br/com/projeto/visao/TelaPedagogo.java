package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class TelaPedagogo extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtSecao;
	private JDateChooser txtData;
	private JTextArea txtRelatorio1;
	private JComboBox txtPedagogo;
	private JButton btnConfirmar;
	private JComboBox txtSituacao;
	private JComboBox txtAluno;
	private JLabel lblAluno;
	private JLabel lblPedagogo;
	private JTextField txtAnoLetivo;
	private JComboBox txtTurma;
	
	public TelaPedagogo() {
		setBounds(100, 100, 450, 300);
    	setTitle("Acompanhamento Pedagogo");
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
		
		setBounds(314, 30, 380, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 380, 380);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPedagogo = new JComboBox();
		txtPedagogo.setBounds(94, 29, 262, 27);
		contentPane.add(txtPedagogo);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(27, 206, 329, 116);
		contentPane.add(jScrollPane1);
		
		txtRelatorio1 = new JTextArea();
		jScrollPane1.setViewportView(txtRelatorio1);
		
		txtSecao = new JTextField();
		txtSecao.setBounds(316, 100, 40, 27);
		contentPane.add(txtSecao);
		txtSecao.setColumns(10);
		
		txtData = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		txtData.setDate(new Date());
		txtData.setBounds(221, 139, 135, 27);
		contentPane.add(txtData);
		
		JLabel lblSecao = new JLabel("Se\u00E7\u00E3o:");
		lblSecao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSecao.setBounds(268, 108, 46, 14);
		contentPane.add(lblSecao);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(183, 141, 40, 27);
		contentPane.add(lblData);
		
		JLabel lblRelatorio = new JLabel("Relatorio de Acompanhamento");
		lblRelatorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelatorio.setBounds(97, 180, 196, 14);
		contentPane.add(lblRelatorio);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(140, 334, 89, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(27, 139, 60, 27);
		contentPane.add(lblSituao);
		
		txtSituacao = new JComboBox();
		txtSituacao.setModel(new DefaultComboBoxModel(new String[] {"Pedente", "Concluindo"}));
		txtSituacao.setBounds(87, 139, 89, 27);
		contentPane.add(txtSituacao);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(66, 101, 174, 27);
		contentPane.add(txtAluno);
		
		lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAluno.setBounds(27, 108, 46, 14);
		contentPane.add(lblAluno);
		
		lblPedagogo = new JLabel("Pedagogo:");
		lblPedagogo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPedagogo.setBounds(27, 36, 67, 14);
		contentPane.add(lblPedagogo);
		
		txtAnoLetivo = new JTextField();
		try {
			txtAnoLetivo = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtAnoLetivo.setText("2019");
		txtAnoLetivo.setColumns(10);
		txtAnoLetivo.setBounds(296, 68, 60, 27);
		contentPane.add(txtAnoLetivo);
		
		JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnoLetivo.setBounds(221, 74, 75, 14);
		contentPane.add(lblAnoLetivo);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1 - 1\u00BA Ano", "EF1 - 2\u00BA Ano", "EF1 - 3\u00BA Ano", "EF1 - 4\u00BA Ano", "EF1 - 5\u00BA Ano", "EF2 - 6\u00BA Ano", "EF2 - 7\u00BA Ano", "EF2 - 8\u00BA Ano", "EF2 - 9\u00BA Ano", "EM - 1\u00BA Ano", "EM - 2\u00BA Ano", "EM - 3\u00BA Ano"}));
		txtTurma.setBounds(72, 68, 100, 26);
		contentPane.add(txtTurma);
		
		JLabel lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(27, 73, 46, 16);
		contentPane.add(lblTurma);
		
		pack();
	}

	public JTextField getTxtSecao() {
		return txtSecao;
	}

	public JDateChooser getTxtData() {
		return txtData;
	}

	public JTextArea getTxtRelatorio1() {
		return txtRelatorio1;
	}

	public JComboBox getTxtPedagogo() {
		return txtPedagogo;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JComboBox getTxtSituacao() {
		return txtSituacao;
	}

	public JComboBox getTxtAluno() {
		return txtAluno;
	}

	public JTextField getTxtAnoLetivo() {
		return txtAnoLetivo;
	}

	public JComboBox getTxtTurma() {
		return txtTurma;
	}

}
