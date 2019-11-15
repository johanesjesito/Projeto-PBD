package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		areaDeTrabalho.getMnCoordenador().setVisible(false);
		areaDeTrabalho.getMnDiretor().setVisible(false);
		areaDeTrabalho.getMnFuncionario().setVisible(false);
		areaDeTrabalho.getMnSecretario().setVisible(false);
		
		areaDeTrabalho.getMntmSair().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				telaLogin.setVisible(true);
				areaDeTrabalho.getMnArquivos().setVisible(false);
				areaDeTrabalho.getMnAdministrador().setVisible(false);
				areaDeTrabalho.getMnCoordenador().setVisible(false);
				areaDeTrabalho.getMnDiretor().setVisible(false);
				areaDeTrabalho.getMnFuncionario().setVisible(false);
				areaDeTrabalho.getMnSecretario().setVisible(false);
			}
		});
	}

}
