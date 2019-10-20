package br.com.projeto.business;

import br.com.projeto.dao.DAOPedagogo;
import br.com.projeto.entidade.Pedagogo;

public class BOPedagogo extends BO<Pedagogo> {

	public BOPedagogo() {
		super(new DAOPedagogo(), Pedagogo.class);
	}

}
