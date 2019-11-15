package br.com.projeto.business;

import br.com.projeto.dao.DAOAcompPedagogo;
import br.com.projeto.entidade.AcompPedagogo;

public class BOAcompPedagogo extends BO<AcompPedagogo> {

	public BOAcompPedagogo() {
		super(new DAOAcompPedagogo(), AcompPedagogo.class);
		// TODO Auto-generated constructor stub
	}

}
