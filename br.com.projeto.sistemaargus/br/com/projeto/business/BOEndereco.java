package br.com.projeto.business;


import br.com.projeto.dao.DAOEndereco;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOEndereco extends BO<Endereco> {

	public BOEndereco() {
		super(new DAOEndereco(), Endereco.class);
	}

//	public Endereco buscarEndereco(int login) throws BOException, DAOException {
//
//		Endereco u = ((DAOEndereco) this.daoT).buscaHQLGenerica(Endereco.class,
//				"select u from Endereco as u where u.usuario_id = '" + login + "' and u.ativado = true");
//
//		if (u == null)
//			throw new BOException("Não foram encontrado um Endereco com esse login");
//
//		return u;
//	}
	
}
