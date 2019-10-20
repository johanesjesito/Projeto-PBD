package br.com.projeto.business;

import br.com.projeto.dao.DAONotas;
import br.com.projeto.entidade.Notas;

public class BONotas extends BO<Notas>{

	public BONotas() {
		super(new DAONotas(), Notas.class);
	}

	
	
}
