package br.com.projeto.visao;

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

public class TelaCadastrarDisciplina extends JInternalFrame {

	private JPanel contentPane;
	private JButton btnConfirmar;
	private JTextField txtNome;
	private JTextField txtCargaHoraria;
	private JTextField txtStatus;
	private JLabel lblStatus;

	public TelaCadastrarDisciplina() {
    	setTitle("Cadastrar Disciplina");
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
		contentPane.setBounds(0, 0, 370, 170);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(141, 120, 89, 23);
		contentPane.add(btnConfirmar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(23, 20, 44, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(66, 13, 276, 29);
		contentPane.add(txtNome);
		
		JLabel lblCargaHoraria = new JLabel("Carga Horaria:");
		lblCargaHoraria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCargaHoraria.setBounds(23, 53, 89, 14);
		contentPane.add(lblCargaHoraria);
		
		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setColumns(10);
		txtCargaHoraria.setBounds(115, 45, 227, 29);
		contentPane.add(txtCargaHoraria);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(23, 86, 44, 14);
		contentPane.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(66, 79, 276, 29);
		contentPane.add(txtStatus);
				
        pack();
        
        }

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtCargaHoraria() {
		return txtCargaHoraria;
	}

	public JTextField getTxtStatus() {
		return txtStatus;
	}

}
