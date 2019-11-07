package br.com.projeto.business;

import br.com.projeto.dao.DAOProfessor;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.BOException;

public class BOProfessor extends BO<Professor> {

	public BOProfessor() {
		super(new DAOProfessor(), Professor.class);
	}
	
}
