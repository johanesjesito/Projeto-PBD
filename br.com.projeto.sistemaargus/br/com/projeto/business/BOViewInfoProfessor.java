package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOViewInfoProfessor;
import br.com.projeto.entidade.ViewInfoProfessor;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOViewInfoProfessor extends BOView<ViewInfoProfessor> {

	public BOViewInfoProfessor() {
		super(new DAOViewInfoProfessor(), ViewInfoProfessor.class);
		// TODO Auto-generated constructor stub
	}
	
	public List<ViewInfoProfessor> getLista() throws DAOException, BOException
	{
		String sql = "";
			sql = "select u from ViewInfoProfessor as u ORDER BY u.nome ASC";
		return buscaListaHQLGenerica(sql);
	}

}
