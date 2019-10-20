package br.com.projeto.business;

import br.com.projeto.dao.DAOAluno;
import br.com.projeto.entidade.Aluno;

public class BOAluno extends BO<Aluno> {

	public BOAluno() {
		super(new DAOAluno(), Aluno.class);
		// TODO Auto-generated constructor stub
	}

}
