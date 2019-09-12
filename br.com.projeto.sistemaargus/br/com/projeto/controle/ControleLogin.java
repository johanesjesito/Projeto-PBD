package br.com.projeto.controle;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaLogin;

public class ControleLogin {

	TelaLogin telaLogin;
	TelaAreaDeTrabalho areaDeTrabalho;

	public ControleLogin(TelaLogin telaLogin, TelaAreaDeTrabalho areaDeTrabalho) {
		this.telaLogin = telaLogin;
		this.areaDeTrabalho = areaDeTrabalho;
		
		telaLogin.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				telaLogin.dispose();
				areaDeTrabalho.getMnArquivos().setVisible(true);

			}
		});
	}
	
	
	
}
