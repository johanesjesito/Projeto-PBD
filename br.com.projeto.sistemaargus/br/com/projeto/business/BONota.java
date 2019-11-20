package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAONota;
import br.com.projeto.entidade.Nota;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BONota extends BO<Nota> {

	public BONota() {
		super(new DAONota(), Nota.class);
	}

	public List<Nota> buscarNota(int turmaaluno_id, int ano_letivo) throws BOException, DAOException {

		return ((DAONota) this.daoT).buscaListaHQLGenerica(Nota.class, "select u from Nota as u where u.turmaaluno.id = '"
				+ turmaaluno_id + "' and u.ano_letivo = '" + ano_letivo + "' and u.ativado = true");
	}
	
}
