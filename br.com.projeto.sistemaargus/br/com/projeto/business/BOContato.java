package br.com.projeto.business;

import br.com.projeto.dao.DAOContato;
import br.com.projeto.entidade.Contato;

public class BOContato extends BO<Contato> {

	public BOContato() {
		super(new DAOContato(), Contato.class);
		// TODO Auto-generated constructor stub
	}	

}
