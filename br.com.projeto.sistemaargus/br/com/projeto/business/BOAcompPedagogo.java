package br.com.projeto.business;

import java.time.LocalDate;
import java.util.List;

import br.com.projeto.dao.DAOAcompPedagogo;
import br.com.projeto.dao.DAOAcompPedagogo;
import br.com.projeto.entidade.AcompPedagogo;
import br.com.projeto.entidade.AcompPedagogo;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;

public class BOAcompPedagogo extends BO<AcompPedagogo> {

	public BOAcompPedagogo() {
		super(new DAOAcompPedagogo(), AcompPedagogo.class);
		// TODO Auto-generated constructor stub
	}

	public List<AcompPedagogo> buscarAcompPedagogo(int pedagogo_id) throws BOException, DAOException {
		
		return 	((DAOAcompPedagogo) this.daoT).buscaListaHQLGenerica(AcompPedagogo.class,
				"select u from AcompPedagogo as u where u.pedagogo.id = '" + pedagogo_id + "' and u.ativado = true");
	}
	
	public List<AcompPedagogo> buscarAcompPedagogo(int pedagogo_id, int aluno_id) throws BOException, DAOException {
		
		return 	((DAOAcompPedagogo) this.daoT).buscaListaHQLGenerica(AcompPedagogo.class,
				"select u from AcompPedagogo as u where u.pedagogo.id = '" + pedagogo_id + "' and u.aluno.id = '" + aluno_id + "' and u.ativado = true");
	}
	
	public AcompPedagogo buscarAcompPedagogoPorNomeTipo(int aluno_id, LocalDate data) throws BOException, DAOException {

		AcompPedagogo u = ((DAOAcompPedagogo) this.daoT).buscaHQLGenerica(AcompPedagogo.class,
				"select u from AcompPedagogo as u where u.aluno.id = '" + aluno_id + "' and u.data = '" + data
						+ "' and u.ativado = true");

		if (u == null)
			throw new BOException("Erro");

		return u;
	}
	
}
