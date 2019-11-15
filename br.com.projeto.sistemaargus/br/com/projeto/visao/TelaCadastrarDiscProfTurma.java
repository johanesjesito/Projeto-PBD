package br.com.projeto.visao;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastrarDiscProfTurma extends JInternalFrame {

	private JPanel contentPane;
	private JButton btnConfirmar;
	private JComboBox txtTurma;
	private JComboBox txtDisciplina;
	private JComboBox txtProfessor;
	
	public TelaCadastrarDiscProfTurma() {
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
		contentPane.setBounds(0, 0, 370, 120);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(204, 78, 89, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblTurma = new JLabel("   Turma:");
		lblTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTurma.setBounds(20, 80, 55, 16);
		contentPane.add(lblTurma);
		
		txtTurma = new JComboBox();
		txtTurma.setModel(new DefaultComboBoxModel(new String[] {"EF1-1", "EF1-2", "EF1-3", "EF1-4", "EF1-5", "EF2-6", "EF2-7", "EF2-8", "EF2-9", "EM-1", "EM-2", "EM-3"}));
		txtTurma.setBounds(77, 75, 72, 26);
		contentPane.add(txtTurma);
		
		JLabel lblDisciplina = new JLabel(" Disciplina:");
		lblDisciplina.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDisciplina.setBounds(10, 16, 65, 16);
		contentPane.add(lblDisciplina);
		
		txtDisciplina = new JComboBox();
		txtDisciplina.setBounds(77, 11, 279, 26);
		contentPane.add(txtDisciplina);
		
		txtProfessor = new JComboBox();
		txtProfessor.setBounds(77, 43, 279, 26);
		contentPane.add(txtProfessor);
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblProfessor.setBounds(10, 48, 65, 16);
		contentPane.add(lblProfessor);
				
        pack();
        
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JComboBox getTxtTurma() {
		return txtTurma;
	}

	public JComboBox getTxtDisciplina() {
		return txtDisciplina;
	}

	public JComboBox getTxtProfessor() {
		return txtProfessor;
	}

}
