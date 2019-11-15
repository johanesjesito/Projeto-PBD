package br.com.projeto.visao;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
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
		
		setBounds(320, 90, 375, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 370, 270);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAluno = new JComboBox();
		txtAluno.setBounds(54, 13, 304, 26);
		contentPane.add(txtAluno);
		
		JLabel lblNewLabel = new JLabel("Aluno:");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 18, 43, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
		lblAnoLetivo.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAnoLetivo.setBounds(12, 46, 72, 16);
		contentPane.add(lblAnoLetivo);
		
		txtAnoLetivo = new JTextField();
		txtAnoLetivo.setBounds(80, 40, 86, 28);
		contentPane.add(txtAnoLetivo);
		txtAnoLetivo.setColumns(10);
		
		tblNotaDisciplina = new JTable();
		tblNotaDisciplina.setBounds(12, 74, 346, 150);
		contentPane.add(tblNotaDisciplina);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o:");
		lblSituao.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSituao.setBounds(12, 236, 61, 16);
		contentPane.add(lblSituao);
		
		txtSituacao = new JTextField();
		txtSituacao.setColumns(10);
		txtSituacao.setBounds(70, 230, 72, 28);
		contentPane.add(txtSituacao);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCadastrar.setBounds(268, 230, 90, 28);
		contentPane.add(btnCadastrar);
		
		lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(178, 45, 43, 16);
		contentPane.add(lblTurma);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1-1", "EF1-2", "EF1-3", "EF1-4", "EF1-5", "EF2-6", "EF2-7", "EF2-8", "EF2-9", "EM-1", "EM-2", "EM-3"}));
		txtTurma.setBounds(220, 40, 72, 26);
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
