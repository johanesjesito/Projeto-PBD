package br.com.projeto.business;

import br.com.projeto.dao.DAOParcelas;
import br.com.projeto.entidade.Parcelas;

public class BOParcelas extends BO<Parcelas>{

	public BOParcelas() {
		super(new DAOParcelas(), Parcelas.class);
	}
	
}
