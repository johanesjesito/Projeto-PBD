package br.com.projeto.business;

import java.util.List;

import br.com.projeto.dao.DAOView;
import br.com.projeto.entidade.View;
import br.com.projeto.exceptions.DAOException;

public class BOView<T extends View>{

	protected DAOView<T> daoT;
	protected Class<T> classe;
	
	public BOView(DAOView<T> daoT, Class<T> classe) {
		this.daoT = daoT;
		this.classe = classe;
	}
	
	public T buscaHQLGenerica(String sql) throws DAOException{
		return this.daoT.buscaHQLGenerica(classe, sql);
	}
	
	public List<T> buscaListaHQLGenerica(String sql) throws DAOException{
		return this.daoT.buscaListaHQLGenerica(classe, sql);
	}
	
}
