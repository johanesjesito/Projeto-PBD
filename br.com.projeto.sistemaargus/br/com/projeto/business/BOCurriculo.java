package br.com.projeto.business;

import br.com.projeto.dao.DAO;
import br.com.projeto.dao.DAOCurriculo;
import br.com.projeto.entidade.Curriculo;

public class BOCurriculo extends BO<Curriculo> {

	public BOCurriculo() {
		super(new DAOCurriculo(), Curriculo.class);
	}

}
