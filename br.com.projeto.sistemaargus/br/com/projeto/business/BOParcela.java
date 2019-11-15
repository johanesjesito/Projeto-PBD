package br.com.projeto.business;

import br.com.projeto.dao.DAOParcela;
import br.com.projeto.entidade.Parcela;

public class BOParcela extends BO<Parcela>{

	public BOParcela() {
		super(new DAOParcela(), Parcela.class);
	}
	
}
