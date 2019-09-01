package br.com.projeto.visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import br.com.projeto.controle.ControleAreaDeTrabalho;

import javax.swing.JDesktopPane;
import javax.swing.JButton;

public class TelaAreaDeTrabalho extends JFrame {
	
	private JPanel contentPane;

	private JButton btnButao;
	private JDesktopPane jAreaTrabalho;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAreaDeTrabalho frame = new TelaAreaDeTrabalho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAreaDeTrabalho() {
		setResizable(false);
		setTitle("Area De Trabalho");
				
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jAreaTrabalho = new JDesktopPane();
		jAreaTrabalho.setBounds(10, 11, 474, 413);
		contentPane.add(jAreaTrabalho);
		
		btnButao = new JButton("butao");
		btnButao.setBounds(203, 438, 89, 23);
		contentPane.add(btnButao);
	}

	public JButton getBtnButao() {
		return btnButao;
	}

	public JDesktopPane getjAreaTrabalho() {
		return jAreaTrabalho;
	}
	
}
