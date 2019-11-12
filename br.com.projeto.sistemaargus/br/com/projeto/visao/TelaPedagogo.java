package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class TelaPedagogo extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtSecao;
	private JDateChooser txtData;
	private JTextArea txtRelatorio1;
	private JTextArea txtRelatorio2;
	private JComboBox txtPedagogo;
	private JButton btnConfirmar;
	private JTextField txtSituacao;
	
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
		
		setBounds(145, 70, 700, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 700, 280);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPedagogo = new JComboBox();
		txtPedagogo.setBounds(10, 11, 163, 27);
		contentPane.add(txtPedagogo);
		
		txtRelatorio1 = new JTextArea();
		JScrollPane jScrollPane1 = new JScrollPane(txtRelatorio1);
		jScrollPane1.setBounds(10, 72, 319, 154);
		contentPane.add(jScrollPane1);
		
		txtRelatorio2 = new JTextArea();
		JScrollPane jScrollPane2 = new JScrollPane(txtRelatorio2);
		jScrollPane2.setBounds(355, 72, 319, 154);
		contentPane.add(jScrollPane2);
		
		txtSecao = new JTextField();
		txtSecao.setBounds(229, 11, 98, 27);
		contentPane.add(txtSecao);
		txtSecao.setColumns(10);
		
		txtData = new JDateChooser("dd/MM/yyyy HH:mm:ss", "##/##/#### ##:##:##", '_');
		txtData.setDate(new Date());
		txtData.setBounds(539, 11, 135, 27);
		contentPane.add(txtData);
		
		JLabel lblSecao = new JLabel("Se\u00E7\u00E3o:");
		lblSecao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSecao.setBounds(183, 17, 46, 14);
		contentPane.add(lblSecao);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setBounds(500, 17, 40, 14);
		contentPane.add(lblData);
		
		JLabel lblRelatorio = new JLabel("Relatorio de Acompanhamento");
		lblRelatorio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelatorio.setBounds(56, 49, 196, 14);
		contentPane.add(lblRelatorio);
		
		JLabel lblRelatorioProfissional = new JLabel("Relatorio Profissional");
		lblRelatorioProfissional.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelatorioProfissional.setBounds(459, 47, 172, 14);
		contentPane.add(lblRelatorioProfissional);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(298, 240, 89, 23);
		contentPane.add(btnConfirmar);
		
		txtSituacao = new JTextField();
		txtSituacao.setColumns(10);
		txtSituacao.setBounds(396, 11, 94, 27);
		contentPane.add(txtSituacao);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(336, 17, 60, 14);
		contentPane.add(lblSituao);
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

	public JTextArea getTxtRelatorio2() {
		return txtRelatorio2;
	}

	public JComboBox getTxtPedagogo() {
		return txtPedagogo;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JTextField getTxtSituacao() {
		return txtSituacao;
	}

}
