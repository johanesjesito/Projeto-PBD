package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.projeto.visao.GUITeste;
import br.com.projeto.visao.TelaAreaDeTrabalho;
import br.com.projeto.visao.TelaLogin;

public class ControleAreaDeTrabalho {
	
	TelaAreaDeTrabalho areaDeTrabalho;

	public ControleAreaDeTrabalho(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
		TelaLogin telaLogin = new TelaLogin();
		areaDeTrabalho.getjAreaTrabalho().add(telaLogin);
		ControleLogin controleLogin = new ControleLogin(telaLogin, areaDeTrabalho);
		telaLogin.setVisible(true);
		areaDeTrabalho.getMnArquivos().setVisible(false);
		areaDeTrabalho.getMnAdministrador().setVisible(false);
		
		areaDeTrabalho.getMntmTela().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GUITeste guiTeste = new GUITeste();
				areaDeTrabalho.getjAreaTrabalho().add(guiTeste);
				guiTeste.setVisible(true);
			}
		});
		
		areaDeTrabalho.getMntmSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telaLogin.setVisible(true);
				areaDeTrabalho.getMnArquivos().setVisible(false);	
				areaDeTrabalho.getMnAdministrador().setVisible(false);
			}
		});
	}

}
