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

public class TelaDiretor extends JInternalFrame {

	private JPanel contentPane;
	private JComboBox txtUsuarios;
	private JTable txtLista;
	
	public TelaDiretor() {
    	setTitle("Lista de Usuarios");
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
				
		txtUsuarios = new JComboBox();
		txtUsuarios.setModel(new DefaultComboBoxModel(new String[] {"Professores", "Pedagogos", "Alunos"}));
		txtUsuarios.setBounds(77, 10, 280, 26);
		contentPane.add(txtUsuarios);
		
		JLabel lblUsuarios = new JLabel("Usuarios:");
		lblUsuarios.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblUsuarios.setBounds(11, 15, 65, 16);
		contentPane.add(lblUsuarios);
		
		txtLista = new JTable();
		txtLista.setBounds(11, 47, 346, 184);
		contentPane.add(txtLista);

		pack();
		}

	public JComboBox getTxtUsuarios() {
		return txtUsuarios;
	}

	public JTable getTxtLista() {
		return txtLista;
	}
	
}
