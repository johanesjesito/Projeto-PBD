package br.com.projeto.principal;

import java.awt.EventQueue;

import br.com.projeto.controle.ControleAreaDeTrabalho;
import br.com.projeto.fachada.Facade;
import br.com.projeto.visao.TelaAreaDeTrabalho;

public class Main {

	public static void main(String[] args) {
				
//		Facade.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAreaDeTrabalho frame = new TelaAreaDeTrabalho();
					frame.setVisible(true);
					ControleAreaDeTrabalho controleAreaDeTrabalho = new ControleAreaDeTrabalho(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
