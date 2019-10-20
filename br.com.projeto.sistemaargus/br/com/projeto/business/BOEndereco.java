package br.com.projeto.business;

import br.com.projeto.dao.DAOEndereco;
import br.com.projeto.entidade.Endereco;

public class BOEndereco extends BO<Endereco> {

	public BOEndereco() {
		super(new DAOEndereco(), Endereco.class);
	}

}
