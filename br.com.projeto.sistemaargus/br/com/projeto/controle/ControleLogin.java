package br.com.projeto.controle;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaCadastro;
import br.com.projeto.visao.TelaLogin;

public class ControleLogin {

	TelaLogin telaLogin;
	TelaAreaDeTrabalho areaDeTrabalho;

	public ControleLogin(TelaLogin telaLogin, TelaAreaDeTrabalho areaDeTrabalho) {
		this.telaLogin = telaLogin;
		this.areaDeTrabalho = areaDeTrabalho;
		
		TelaCadastro telaCadastro = new TelaCadastro();
		areaDeTrabalho.getjAreaTrabalho().add(telaCadastro);
		
		telaLogin.getBtnLogin().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				telaLogin.setVisible(false);
				areaDeTrabalho.getMnArquivos().setVisible(true);

			}
		});
		
		telaLogin.getBtnCriar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telaLogin.setVisible(false);
				telaCadastro.setVisible(true);
			}
		});
		
		telaCadastro.getBtnVolta().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telaCadastro.setVisible(false);		
				telaLogin.setVisible(true);
			}
		});
	}
	
	
	
}
