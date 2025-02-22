package br.com.projeto.fachada;

import br.com.projeto.business.BOAcompPedagogo;
import br.com.projeto.business.BOAluno;
import br.com.projeto.business.BOContato;
import br.com.projeto.business.BOCurriculo;
import br.com.projeto.business.BODisciplina;
import br.com.projeto.business.BOEndereco;
import br.com.projeto.business.BONota;
import br.com.projeto.business.BOResponsavel;
import br.com.projeto.business.BOTurmaAluno;
import br.com.projeto.business.BOTurmaDisciplina;
import br.com.projeto.business.BOParcela;
import br.com.projeto.business.BOPedagogo;
import br.com.projeto.business.BOProfessor;
import br.com.projeto.business.BOUsuario;
import br.com.projeto.business.BOViewInfoAluno;
import br.com.projeto.business.BOViewInfoPedagogo;
import br.com.projeto.business.BOViewInfoProfessor;
import br.com.projeto.entidade.AcompPedagogo;
import br.com.projeto.entidade.Aluno;
import br.com.projeto.entidade.Contato;
import br.com.projeto.entidade.Curriculo;
import br.com.projeto.entidade.Disciplina;
import br.com.projeto.entidade.Endereco;
import br.com.projeto.entidade.Entidade;
import br.com.projeto.entidade.Nota;
import br.com.projeto.entidade.Responsavel;
import br.com.projeto.entidade.TurmaAluno;
import br.com.projeto.entidade.TurmaDisciplina;
import br.com.projeto.entidade.Parcela;
import br.com.projeto.entidade.Pedagogo;
import br.com.projeto.entidade.Professor;
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
	private final BOCurriculo boCurriculos;
	private final BODisciplina boDisciplina;
	private final BOEndereco boEndereco;
	private final BONota boNotas;
	private final BOResponsavel boResponsavel;
	private final BOParcela boParcela;
	private final BOPedagogo boPedagogo;
	private final BOProfessor boProfessor;
	private final BOUsuario boUsuario;
	private final BOContato boContato;
	private final BOTurmaDisciplina boTurmaDisciplina;
	private final BOTurmaAluno boTurmaAluno;
	
	private final BOViewInfoProfessor boViewInfoProfessor;
	private final BOViewInfoAluno boViewInfoAluno;
	private final BOViewInfoPedagogo boViewInfoPedagogo;

	private Facade() 
	{
		boAcompPedagogo = new BOAcompPedagogo();
		boAluno = new BOAluno();
		boCurriculos = new BOCurriculo();
		boDisciplina = new BODisciplina();
		boEndereco = new BOEndereco();
		boNotas = new BONota();
		boResponsavel = new BOResponsavel();
		boParcela = new BOParcela();
		boPedagogo = new BOPedagogo();
		boProfessor = new BOProfessor();
		boUsuario = new BOUsuario();
		boContato = new BOContato();
		boTurmaDisciplina = new BOTurmaDisciplina();
		boTurmaAluno = new BOTurmaAluno();
		
		boViewInfoPedagogo = new BOViewInfoPedagogo();
		boViewInfoProfessor = new BOViewInfoProfessor();
		boViewInfoAluno = new BOViewInfoAluno();
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
		else if(entidade instanceof Curriculo)
		{
			boCurriculos.inserir((Curriculo)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.inserir((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.inserir((Endereco)entidade);
		}
		else if(entidade instanceof Nota)
		{
			boNotas.inserir((Nota)entidade);
		}
		else if(entidade instanceof Responsavel)
		{
			boResponsavel.inserir((Responsavel)entidade);
		}
		else if(entidade instanceof Parcela)
		{
			boParcela.inserir((Parcela)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.inserir((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.inserir((Professor)entidade);
		}
		else if(entidade instanceof Contato)
		{
			boContato.inserir((Contato)entidade);
		}
		else if(entidade instanceof TurmaDisciplina)
		{
			boTurmaDisciplina.inserir((TurmaDisciplina)entidade);
		}
		else if(entidade instanceof TurmaAluno)
		{
			boTurmaAluno.inserir((TurmaAluno)entidade);
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
		else if(entidade instanceof Curriculo)
		{
			boCurriculos.atualizar((Curriculo)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.atualizar((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.atualizar((Endereco)entidade);
		}
		else if(entidade instanceof Nota)
		{
			boNotas.atualizar((Nota)entidade);
		}
		else if(entidade instanceof Responsavel)
		{
			boResponsavel.atualizar((Responsavel)entidade);
		}
		else if(entidade instanceof Parcela)
		{
			boParcela.atualizar((Parcela)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.atualizar((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.atualizar((Professor)entidade);
		}
		else if(entidade instanceof Contato)
		{
			boContato.atualizar((Contato)entidade);
		}
		else if(entidade instanceof TurmaDisciplina)
		{
			boTurmaDisciplina.atualizar((TurmaDisciplina)entidade);
		}
		else if(entidade instanceof TurmaAluno)
		{
			boTurmaAluno.atualizar((TurmaAluno)entidade);
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
		else if(classe.getSimpleName().equals(Curriculo.class.getSimpleName()))
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
		else if(classe.getSimpleName().equals(Nota.class.getSimpleName()))
		{
			return boNotas.buscar(id);
		}
		else if(classe.getSimpleName().equals(Responsavel.class.getSimpleName()))
		{
			return boResponsavel.buscar(id);
		}
		else if(classe.getSimpleName().equals(Parcela.class.getSimpleName()))
		{
			return boParcela.buscar(id);
		}
		else if(classe.getSimpleName().equals(Pedagogo.class.getSimpleName()))
		{
			return boPedagogo.buscar(id);
		}
		else if(classe.getSimpleName().equals(Professor.class.getSimpleName()))
		{
			return boProfessor.buscar(id);
		}
		else if(classe.getSimpleName().equals(Contato.class.getSimpleName()))
		{
			return boContato.buscar(id);
		}
		else if(classe.getSimpleName().equals(TurmaDisciplina.class.getSimpleName()))
		{
			return boTurmaDisciplina.buscar(id);
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
		else if(entidade instanceof Curriculo)
		{
			boCurriculos.remover((Curriculo)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.remover((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.remover((Endereco)entidade);
		}
		else if(entidade instanceof Nota)
		{
			boNotas.remover((Nota)entidade);
		}
		else if(entidade instanceof Responsavel)
		{
			boResponsavel.remover((Responsavel)entidade);
		}
		else if(entidade instanceof Parcela)
		{
			boParcela.remover((Parcela)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.remover((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.remover((Professor)entidade);
		}
		else if(entidade instanceof Contato)
		{
			boContato.remover((Contato)entidade);
		}
		else if(entidade instanceof TurmaDisciplina)
		{
			boTurmaDisciplina.remover((TurmaDisciplina)entidade);
		}
		else if(entidade instanceof TurmaAluno)
		{
			boTurmaAluno.remover((TurmaAluno)entidade);
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
		else if(entidade instanceof Curriculo)
		{
			boCurriculos.deletar((Curriculo)entidade);
		}
		else if(entidade instanceof Disciplina)
		{
			boDisciplina.deletar((Disciplina)entidade);
		}
		else if(entidade instanceof Endereco)
		{
			boEndereco.deletar((Endereco)entidade);
		}
		else if(entidade instanceof Nota)
		{
			boNotas.deletar((Nota)entidade);
		}
		else if(entidade instanceof Responsavel)
		{
			boResponsavel.deletar((Responsavel)entidade);
		}
		else if(entidade instanceof Parcela)
		{
			boParcela.deletar((Parcela)entidade);
		}
		else if(entidade instanceof Pedagogo)
		{
			boPedagogo.deletar((Pedagogo)entidade);
		}
		else if(entidade instanceof Professor)
		{
			boProfessor.deletar((Professor)entidade);
		}
		else if(entidade instanceof Contato)
		{
			boContato.deletar((Contato)entidade);
		}
		else if(entidade instanceof TurmaDisciplina)
		{
			boTurmaDisciplina.deletar((TurmaDisciplina)entidade);
		}
		else if(entidade instanceof TurmaAluno)
		{
			boTurmaAluno.deletar((TurmaAluno)entidade);
		}
	}
	
	
	public BOUsuario getBoUsuario() {return boUsuario;}
	public BOProfessor getBoProfessor() {return boProfessor;}
	public BOPedagogo getBoPedagogo() {return boPedagogo;}
	public BOResponsavel getBoResponsavel() {return boResponsavel;}
	public BOAluno getBoAluno() {return boAluno;}
	public BOEndereco getBoEndereco() {return boEndereco;}
	public BOContato getBoContato() {return boContato;}
	public BOAcompPedagogo getBoAcompPedagogo() {return boAcompPedagogo;}
	public BODisciplina getBoDisciplina() {return boDisciplina;}
	public BONota getBoNota() {return boNotas;}
	public BOCurriculo getBoCurriculo() {return boCurriculos;}
	public BOTurmaDisciplina getboTurmaDisciplina() {return boTurmaDisciplina;}
	public BOTurmaAluno getboTurmaAluno() {return boTurmaAluno;}
	public BOParcela getBoParcela() {return boParcela;}
	
	public BOViewInfoAluno getBoViewInfoAluno() {return boViewInfoAluno;}
	public BOViewInfoPedagogo getBoViewInfoPedagogo() {return boViewInfoPedagogo;}
	public BOViewInfoProfessor getBoViewInfoProfessor() {return boViewInfoProfessor;}
	
}
