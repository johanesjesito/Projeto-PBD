package br.com.projeto.principal;

import java.awt.EventQueue;

import br.com.projeto.controle.ControleLogin;
import br.com.projeto.visao.TelaLogin;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					ControleLogin controleLogin = new ControleLogin(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
