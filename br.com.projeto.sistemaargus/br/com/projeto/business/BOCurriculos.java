package br.com.projeto.business;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.DAOCurriculos;
import br.com.projeto.entidade.Curriculos;

public class BOCurriculos extends BO<Curriculos> {

	public BOCurriculos() {
		super(new DAOCurriculos(), Curriculos.class);
	}

}
