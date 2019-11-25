package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOViewInfoAluno;
import br.com.projeto.entidade.ViewInfoAluno;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOViewInfoAluno extends BOView<ViewInfoAluno> {

	public BOViewInfoAluno() {
		super(new DAOViewInfoAluno(), ViewInfoAluno.class);
		// TODO Auto-generated constructor stub
	}

	public List<ViewInfoAluno> getLista() throws DAOException, BOException
	{
		String sql = "";
			sql = "SELECT * FROM ViewInfoAluno";
		return buscaListaHQLGenerica(sql);
	}
}
