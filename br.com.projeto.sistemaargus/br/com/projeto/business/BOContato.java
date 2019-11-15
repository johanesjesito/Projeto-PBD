package br.com.projeto.business;

import br.com.projeto.dao.DAOContato;
import br.com.projeto.entidade.Contato;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOContato extends BO<Contato> {

	public BOContato() {
		super(new DAOContato(), Contato.class);
		// TODO Auto-generated constructor stub
	}	
	
	public Contato buscarContato(int usuario_id) throws BOException, DAOException {

		Contato u = ((DAOContato) this.daoT).buscaHQLGenerica(Contato.class,
				"select u from Contato as u where u.usuario.id = '" + usuario_id + "' and u.ativado = true");

		if (u == null)
			throw new BOException("Não foram encontrado um Contato com esse login");

		return u;
	}

}
