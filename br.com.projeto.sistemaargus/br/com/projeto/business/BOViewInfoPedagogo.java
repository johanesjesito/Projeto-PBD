package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOViewInfoPedagogo;
import br.com.projeto.entidade.ViewInfoPedagogo;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOViewInfoPedagogo extends BOView<ViewInfoPedagogo> {

	public BOViewInfoPedagogo() {
		super(new DAOViewInfoPedagogo(), ViewInfoPedagogo.class);
		// TODO Auto-generated constructor stub
	}

	public List<ViewInfoPedagogo> getLista() throws DAOException, BOException
	{
		String sql = "";
			sql = "SELECT * FROM ViewInfoPedagogo";
		return buscaListaHQLGenerica(sql);
	}
	
}
