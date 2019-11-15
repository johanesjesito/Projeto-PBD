package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOTurma;
import br.com.projeto.entidade.Turma;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOTurma extends BO<Turma>{

	public BOTurma() {
		super(new DAOTurma(), Turma.class);
	}
	
	public Turma buscarTurma(String turma) throws BOException, DAOException {

		Turma u = ((DAOTurma) this.daoT).buscaHQLGenerica(Turma.class,
				"select u from Turma as u where u.turma like '" + turma + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public List<Turma> buscarListaTurma(String turma) throws BOException, DAOException {

		return ((DAOTurma) this.daoT).buscaListaHQLGenerica(Turma.class,
				"select u from Turma as u where u.turma like '" + turma + "' and u.ativado = true");
	}
	
	public Turma buscarTurmaProfessor(int professor_id) throws BOException, DAOException {

		Turma u = ((DAOTurma) this.daoT).buscaHQLGenerica(Turma.class,
				"select u from Turma as u where u.professor.id = '" + professor_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public List<Turma> buscarListaTurmaProfessor(int professor_id) throws BOException, DAOException {

		return ((DAOTurma) this.daoT).buscaListaHQLGenerica(Turma.class,
				"select u from Turma as u where u.professor.id like '" + professor_id + "' and u.ativado = true");
	}
	
	public Turma buscarTurmaDisciplina(int disciplina_id) throws BOException, DAOException {

		Turma u = ((DAOTurma) this.daoT).buscaHQLGenerica(Turma.class,
				"select u from Turma as u where u.disciplina.id = '" + disciplina_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public List<Turma> buscarListaTurmaDisciplina(int disciplina_id) throws BOException, DAOException {

		return ((DAOTurma) this.daoT).buscaListaHQLGenerica(Turma.class,
				"select u from Turma as u where u.disciplina.id like '" + disciplina_id + "' and u.ativado = true");
	}
	
	public Turma buscarTurma(int professor_id, int disciplina_id) throws BOException, DAOException {

		Turma u = ((DAOTurma) this.daoT).buscaHQLGenerica(Turma.class, "select u from Turma as u where u.disciplina.id = '"
						+ disciplina_id + "' and u.professor.id = '" + professor_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}

}
