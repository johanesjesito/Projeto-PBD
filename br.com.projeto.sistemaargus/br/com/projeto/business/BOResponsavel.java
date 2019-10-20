package br.com.projeto.business;

import br.com.projeto.dao.DAOResponsavel;
import br.com.projeto.entidade.Responsavel;

public class BOResponsavel extends BO<Responsavel> {

	public BOResponsavel() {
		super(new DAOResponsavel(), Responsavel.class);
		// TODO Auto-generated constructor stub
	}

}
