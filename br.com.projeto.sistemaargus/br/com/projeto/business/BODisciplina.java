package br.com.projeto.business;

import br.com.projeto.dao.DAODisciplina;
import br.com.projeto.entidade.Disciplina;

public class BODisciplina extends BO<Disciplina> {

	public BODisciplina() {
		super(new DAODisciplina(), Disciplina.class);
	}

	
}
