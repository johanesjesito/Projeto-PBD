package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOCurriculo;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOCurriculo extends BO<Curriculo> {

	public BOCurriculo() {
		super(new DAOCurriculo(), Curriculo.class);
	}

	public Curriculo buscarCurriculo(int turmaaluno_id, int ano_letivo) throws BOException, DAOException {

		Curriculo u = ((DAOCurriculo) this.daoT).buscaHQLGenerica(Curriculo.class, "select u from Curriculo as u where u.turmaAluno.id = '"
						+ turmaaluno_id + "' and u.ano_letivo = '" + ano_letivo + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado um Curriculo");

		return u;
	}
	
	public List<Curriculo> buscarCurriculoListaDeAlunos(int turmaaluno_id, int ano_letivo) throws BOException, DAOException {

		return ((DAOCurriculo) this.daoT).buscaListaHQLGenerica(Curriculo.class, "select u from Curriculo as u where u.turmaAluno.id = '"
				+ turmaaluno_id + "' and u.ano_letivo = '" + ano_letivo + "' and u.ativado = true");
	}
	
}
