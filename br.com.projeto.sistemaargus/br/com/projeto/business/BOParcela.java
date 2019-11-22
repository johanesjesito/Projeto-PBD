package br.com.projeto.business;

import br.com.projeto.dao.DAOParcela;
import br.com.projeto.dao.DAOParcela;
import br.com.projeto.entidade.Parcela;
import br.com.projeto.entidade.Parcela;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOParcela extends BO<Parcela>{

	public BOParcela() {
		super(new DAOParcela(), Parcela.class);
	}
	
	public Parcela buscarParcela(String codigo) throws BOException, DAOException {

		Parcela u = ((DAOParcela) this.daoT).buscaHQLGenerica(Parcela.class,
				"select u from Parcela as u where u.codigo like '" + codigo + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Erro");

		return u;
	}
	
}
