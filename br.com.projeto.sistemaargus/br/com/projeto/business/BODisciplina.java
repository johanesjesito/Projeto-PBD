package br.com.projeto.business;

import br.com.projeto.dao.DAODisciplina;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BODisciplina extends BO<Disciplina> {

	public BODisciplina() {
		super(new DAODisciplina(), Disciplina.class);
	}

	public Disciplina buscarDisciplina(String nome) throws BOException, DAOException {

		Disciplina u = ((DAODisciplina) this.daoT).buscaHQLGenerica(Disciplina.class,
				"select u from Disciplina as u where u.nome like '" + nome + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado um Disciplina com esse nome");

		return u;
	}
}
