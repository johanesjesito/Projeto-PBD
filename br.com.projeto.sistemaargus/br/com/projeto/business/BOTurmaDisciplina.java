package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOTurmaDisciplina;
import br.com.projeto.entidade.TurmaDisciplina;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOTurmaDisciplina extends BO<TurmaDisciplina>{

	public BOTurmaDisciplina() {
		super(new DAOTurmaDisciplina(), TurmaDisciplina.class);
	}
	
	public TurmaDisciplina buscarTurma(String turma) throws BOException, DAOException {

		TurmaDisciplina u = ((DAOTurmaDisciplina) this.daoT).buscaHQLGenerica(TurmaDisciplina.class,
				"select u from TurmaDisciplina as u where u.turma like '" + turma + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public TurmaDisciplina buscarTurma(String turma, int disciplina_id) throws BOException, DAOException {

		TurmaDisciplina u = ((DAOTurmaDisciplina) this.daoT).buscaHQLGenerica(TurmaDisciplina.class, "select u from TurmaDisciplina as u where u.disciplina.id = '"
						+ disciplina_id + "' and u.turma = '" + turma + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public List<TurmaDisciplina> buscarListaTurma(String turma) throws BOException, DAOException {

		return ((DAOTurmaDisciplina) this.daoT).buscaListaHQLGenerica(TurmaDisciplina.class,
				"select u from TurmaDisciplina as u where u.turma like '" + turma + "' and u.ativado = true");
	}
	
	public TurmaDisciplina buscarTurmaProfessor(int professor_id) throws BOException, DAOException {

		TurmaDisciplina u = ((DAOTurmaDisciplina) this.daoT).buscaHQLGenerica(TurmaDisciplina.class,
				"select u from TurmaDisciplina as u where u.professor.id = '" + professor_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public List<TurmaDisciplina> buscarListaTurmaProfessor(int professor_id) throws BOException, DAOException {

		return ((DAOTurmaDisciplina) this.daoT).buscaListaHQLGenerica(TurmaDisciplina.class,
				"select u from TurmaDisciplina as u where u.professor.id like '" + professor_id + "' and u.ativado = true");
	}
	
	public TurmaDisciplina buscarTurmaDisciplina(int disciplina_id) throws BOException, DAOException {

		TurmaDisciplina u = ((DAOTurmaDisciplina) this.daoT).buscaHQLGenerica(TurmaDisciplina.class,
				"select u from TurmaDisciplina as u where u.disciplina.id = '" + disciplina_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}
	
	public List<TurmaDisciplina> buscarListaTurmaDisciplina(int disciplina_id) throws BOException, DAOException {

		return ((DAOTurmaDisciplina) this.daoT).buscaListaHQLGenerica(TurmaDisciplina.class,
				"select u from TurmaDisciplina as u where u.disciplina.id like '" + disciplina_id + "' and u.ativado = true");
	}
	
	public TurmaDisciplina buscarTurma(int professor_id, int disciplina_id) throws BOException, DAOException {

		TurmaDisciplina u = ((DAOTurmaDisciplina) this.daoT).buscaHQLGenerica(TurmaDisciplina.class, "select u from TurmaDisciplina as u where u.disciplina.id = '"
						+ disciplina_id + "' and u.professor.id = '" + professor_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}

}
