package br.com.projeto.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.projeto.visao.GUITeste;
import br.com.projeto.visao.TelaAreaDeTrabalho;

public class ControleAreaDeTrabalho {
	
	TelaAreaDeTrabalho areaDeTrabalho;

	public ControleAreaDeTrabalho(TelaAreaDeTrabalho areaDeTrabalho) {
		this.areaDeTrabalho = areaDeTrabalho;
		
		areaDeTrabalho.getBtnButao().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				GUITeste guiTeste = new GUITeste();
				areaDeTrabalho.getjAreaTrabalho().add(guiTeste);
				guiTeste.setVisible(true);
			}
		});
	}

}
