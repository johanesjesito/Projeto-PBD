package br.com.projeto.business;

import br.com.projeto.dao.DAONota;
import br.com.projeto.entidade.Nota;

public class BONota extends BO<Nota>{

	public BONota() {
		super(new DAONota(), Nota.class);
	}

	
	
}
