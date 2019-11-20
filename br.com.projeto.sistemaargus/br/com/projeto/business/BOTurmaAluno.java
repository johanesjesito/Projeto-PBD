package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOTurmaAluno;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOTurmaAluno extends BO<TurmaAluno> {

	public BOTurmaAluno() {
		super(new DAOTurmaAluno(), TurmaAluno.class);
	}

	public List<TurmaAluno> buscarListaTurmaAluno(String turma, int ano_letivo) throws BOException, DAOException {

		return ((DAOTurmaAluno) this.daoT).buscaListaHQLGenerica(TurmaAluno.class,
				"select u from TurmaAluno as u where u.turma like '" + turma + "' and ano_letivo = '"
						+ ano_letivo + "' and u.ativado = true");
	}

	public TurmaAluno buscarTurma(int aluno_id, int ano_letivo) throws BOException, DAOException {

		TurmaAluno u = ((DAOTurmaAluno) this.daoT).buscaHQLGenerica(TurmaAluno.class,
				"select u from TurmaAluno as u where u.aluno.id = '" + aluno_id + "' and ano_letivo = '" + ano_letivo
						+ "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado uma Turma");

		return u;
	}

}
