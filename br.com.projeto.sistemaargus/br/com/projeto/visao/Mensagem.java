package br.com.projeto.visao;

import javax.swing.JOptionPane;

public class Mensagem {
	
	public static void exibir(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
	
	public static int confirmacao(String text1, String text2) {
		return JOptionPane.showConfirmDialog(null, text1, text2, JOptionPane.YES_OPTION);
	}

}
