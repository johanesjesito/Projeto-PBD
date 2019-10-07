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
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class TelaAreaDeTrabalho extends JFrame {
	
	private JPanel contentPane;
	private JDesktopPane jAreaTrabalho;
	private JMenu mnArquivos;
	private JMenuItem mntmTela, mntmSair;
	
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
		setTitle("ARGUS");
				
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
		setBounds(10, 50, 1000, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jAreaTrabalho = new JDesktopPane();
		jAreaTrabalho.setBounds(0, 21, 994, 451);		
		contentPane.add(jAreaTrabalho);
		
		JMenuBar telaMenuBar = new JMenuBar();
		telaMenuBar.setBounds(0, 0, 994, 21);
		contentPane.add(telaMenuBar);
		
		mnArquivos = new JMenu("Arquivos");
		telaMenuBar.add(mnArquivos);
		
		mntmTela = new JMenuItem("Tela");
		mnArquivos.add(mntmTela);
		
		mntmSair = new JMenuItem("Sair");
		mnArquivos.add(mntmSair);
		
		JLabel lblAreaDeTrabalho = new JLabel("");
		lblAreaDeTrabalho.setBackground(Color.WHITE);
		lblAreaDeTrabalho.setIcon(new ImageIcon("files/Arena de Trabalho.png"));
		lblAreaDeTrabalho.setBounds(0, 0, 994, 451);
		jAreaTrabalho.add(lblAreaDeTrabalho);
	}

	public JDesktopPane getjAreaTrabalho() {
		return jAreaTrabalho;
	}

	public JMenu getMnArquivos() {
		return mnArquivos;
	}

	public JMenuItem getMntmTela() {
		return mntmTela;
	}

	public JMenuItem getMntmSair() {
		return mntmSair;
	}

}
