package br.com.projeto.controle;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaLogin;

public class ControleLogin {

	TelaLogin telaLogin;

	public ControleLogin(TelaLogin telaLogin) {
		this.telaLogin = telaLogin;
		
		telaLogin.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TelaAreaDeTrabalho frame = new TelaAreaDeTrabalho();
							frame.setVisible(true);
							ControleAreaDeTrabalho areaDeTrabalho = new ControleAreaDeTrabalho(frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});
	}
	
	
	
}
