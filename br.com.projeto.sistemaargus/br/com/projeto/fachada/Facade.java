package br.com.projeto.fachada;

import br.com.projeto.business.BOAcompPedagogo;
import br.com.projeto.business.BOAluno;
import br.com.projeto.business.BOCurriculos;
import br.com.projeto.business.BODisciplina;
import br.com.projeto.business.BOEndereco;
import br.com.projeto.business.BONotas;
import br.com.projeto.business.BOPais;
import br.com.projeto.business.BOParcelas;
import br.com.projeto.business.BOPedagogo;
import br.com.projeto.business.BOProfessor;
import br.com.projeto.business.BOTurma;
import br.com.projeto.business.BOUsuario;
import br.com.projeto.entidade.AcompPedagogo;
import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Curriculos;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.entidade.Entidade;
import br.com.projeto.entidade.Notas;
import br.com.projeto.entidade.Pais;
import br.com.projeto.entidade.Parcelas;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.Professor;
import br.com.projeto.entidade.Turma;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.ValidacaoException;

public class Facade {

	private static Facade instance;
	
	public static Facade getInstance()
	{
		if(instance == null)
			instance = new Facade();
		return instance;
	}
	
	private final BOAcompPedagogo boAcompPedagogo;
	private final BOAluno boAluno;
	private final BOCurriculos boCurriculos;
	private final BODisciplina boDisciplina;
	private final BOEndereco boEndereco;
	private final BONotas boNotas;
	private final BOPais boPais;
	private final BOParcelas boParcelas;
	private final BOPedagogo boPedagogo;
	private final BOProfessor boProfessor;
	private final BOTurma boTurma;
	private final BOUsuario boUsuario;

	private Facade() 
	{
		boAcompPedagogo = new BOAcompPedagogo();
		boAluno = new BOAluno();
		boCurriculos = new BOCurriculos();
		boDisciplina = new BODisciplina();
		boEndereco = new BOEndereco();
		boNotas = new BONotas();
		boPais = new BOPais();
		boParcelas = new BOParcelas();
		boPedagogo = new BOPedagogo();
		boProfessor = new BOProfessor();
		boTurma = new BOTurma();
		boUsuario = new BOUsuario();
	}

	public <T extends Entidade> void inserir(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.inserir((Usuario)entidade);
		}
		else if(entidade instanceof AcompPedagogo)
		{
			boAcompPedagogo.inserir((AcompPedagogo)entidade);
		}
		else if(entidade instanceof Aluno)
		{
			boAluno.inserir((Aluno)entidade);
		}
		else if(entidade instanceof Curriculos)
		{
			boCurriculos.inserir((Curriculos)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.inserir((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.inserir((Endereco)entidade);
		}
		else if(entidade instanceof Notas)
		{
			boNotas.inserir((Notas)entidade);
		}
		else if(entidade instanceof Pais)
		{
			boPais.inserir((Pais)entidade);
		}
		else if(entidade instanceof Parcelas)
		{
			boParcelas.inserir((Parcelas)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.inserir((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.inserir((Professor)entidade);
		}
		else if(entidade instanceof Turma)
		{
			boTurma.inserir((Turma)entidade);
		}
	}
	
	public <T extends Entidade> void atualizar(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.atualizar((Usuario)entidade);
		}
		else if(entidade instanceof AcompPedagogo)
		{
			boAcompPedagogo.atualizar((AcompPedagogo)entidade);
		}
		else if(entidade instanceof Aluno)
		{
			boAluno.atualizar((Aluno)entidade);
		}
		else if(entidade instanceof Curriculos)
		{
			boCurriculos.atualizar((Curriculos)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.atualizar((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.atualizar((Endereco)entidade);
		}
		else if(entidade instanceof Notas)
		{
			boNotas.atualizar((Notas)entidade);
		}
		else if(entidade instanceof Pais)
		{
			boPais.atualizar((Pais)entidade);
		}
		else if(entidade instanceof Parcelas)
		{
			boParcelas.atualizar((Parcelas)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.atualizar((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.atualizar((Professor)entidade);
		}
		else if(entidade instanceof Turma)
		{
			boTurma.atualizar((Turma)entidade);
		}
	}
	
	public <T extends Entidade> Entidade buscar(Class<T> classe, int id) throws ValidacaoException
	{
		if(classe.getSimpleName().equals(Usuario.class.getSimpleName()))
		{
			return boUsuario.buscar(id);
		}
		else if(classe.getSimpleName().equals(AcompPedagogo.class.getSimpleName()))
		{
			return boAcompPedagogo.buscar(id);
		}
		else if(classe.getSimpleName().equals(Aluno.class.getSimpleName()))
		{
			return boAluno.buscar(id);
		}
		else if(classe.getSimpleName().equals(Curriculos.class.getSimpleName()))
		{
			return boCurriculos.buscar(id);
		}
		else if(classe.getSimpleName().equals(Disciplina.class.getSimpleName()))
		{
			return boDisciplina.buscar(id);
		}
		else if(classe.getSimpleName().equals(Endereco.class.getSimpleName()))
		{
			return boEndereco.buscar(id);
		}
		else if(classe.getSimpleName().equals(Notas.class.getSimpleName()))
		{
			return boNotas.buscar(id);
		}
		else if(classe.getSimpleName().equals(Pais.class.getSimpleName()))
		{
			return boPais.buscar(id);
		}
		else if(classe.getSimpleName().equals(Parcelas.class.getSimpleName()))
		{
			return boParcelas.buscar(id);
		}
		else if(classe.getSimpleName().equals(Pedagogo.class.getSimpleName()))
		{
			return boPedagogo.buscar(id);
		}
		else if(classe.getSimpleName().equals(Professor.class.getSimpleName()))
		{
			return boProfessor.buscar(id);
		}
		else if(classe.getSimpleName().equals(Turma.class.getSimpleName()))
		{
			return boTurma.buscar(id);
		}
		return null;
	}
	
	public <T extends Entidade> void remover(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.remover((Usuario)entidade);
		}
		else if(entidade instanceof AcompPedagogo)
		{
			boAcompPedagogo.remover((AcompPedagogo)entidade);
		}
		else if(entidade instanceof Aluno)
		{
			boAluno.remover((Aluno)entidade);
		}
		else if(entidade instanceof Curriculos)
		{
			boCurriculos.remover((Curriculos)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.remover((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.remover((Endereco)entidade);
		}
		else if(entidade instanceof Notas)
		{
			boNotas.remover((Notas)entidade);
		}
		else if(entidade instanceof Pais)
		{
			boPais.remover((Pais)entidade);
		}
		else if(entidade instanceof Parcelas)
		{
			boParcelas.remover((Parcelas)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.remover((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.remover((Professor)entidade);
		}
		else if(entidade instanceof Turma)
		{
			boTurma.remover((Turma)entidade);
		}	
	}
	
	public <T extends Entidade> void deletar(T entidade) throws ValidacaoException
	{
		if(entidade instanceof Usuario)
		{
			boUsuario.deletar((Usuario)entidade);
		}
		else if(entidade instanceof AcompPedagogo)
		{
			boAcompPedagogo.deletar((AcompPedagogo)entidade);
		}
		else if(entidade instanceof Aluno)
		{
			boAluno.deletar((Aluno)entidade);
		}
		else if(entidade instanceof Curriculos)
		{
			boCurriculos.deletar((Curriculos)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.deletar((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.deletar((Endereco)entidade);
		}
		else if(entidade instanceof Notas)
		{
			boNotas.deletar((Notas)entidade);
		}
		else if(entidade instanceof Pais)
		{
			boPais.deletar((Pais)entidade);
		}
		else if(entidade instanceof Parcelas)
		{
			boParcelas.deletar((Parcelas)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.deletar((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.deletar((Professor)entidade);
		}
		else if(entidade instanceof Turma)
		{
			boTurma.deletar((Turma)entidade);
		}	
	}
	
	
	public BOUsuario getBoUsuario() {return boUsuario;}
//	public BOPesquisa getBoPesquisa() {return boPesquisa;}
	
}
