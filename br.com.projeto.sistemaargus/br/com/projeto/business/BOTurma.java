package br.com.projeto.business;

import br.com.projeto.dao.DAOTurma;
import br.com.projeto.entidade.Turma;

public class BOTurma extends BO<Turma> {

	public BOTurma() {
		super(new DAOTurma(), Turma.class);
	}

}
