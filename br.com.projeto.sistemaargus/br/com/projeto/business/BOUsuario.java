package br.com.projeto.business;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.com.projeto.dao.DAOUsuario;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.util.SecurityUtil;

public class BOUsuario extends BO<Usuario> {

	public BOUsuario() {
		super(new DAOUsuario(), Usuario.class);
	}

	@Override
	protected void validacaoInsercao(Usuario t) throws BOException {
		super.validacaoInsercao(t);
		if (t.getTipo().equals("Professor") || t.getTipo().equals("Aluno") || t.getTipo().equals("Pedagogo")
				|| t.getTipo().equals("Responsavel")) {
			if (t.getNome().equals("") || t.getNaturalidade().equals(""))
				throw new BOException("Os campos devem ser preenchidos");
		} else {
			if (t.getNome().equals("") || t.getLogin().equals("") || t.getSenha().equals("")
					|| t.getNaturalidade().equals(""))
				throw new BOException("Os campos devem ser preenchidos");
			if (t.getSenha().length() < 6 || t.getSenha().length() > 11)
				throw new BOException("A senha deve ter maior que 6 e menor que 11");
			try {
				t.setSenha(SecurityUtil.criptografarSHA2(t.getSenha()));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				throw new BOException("Erro ao Inserir Usu�rio");
			}
		}
	}

	@Override
	protected void validacaoAtualizacao(Usuario t) throws BOException {
		super.validacaoAtualizacao(t);
		if (t.getNome().equals("") || t.getLogin().equals("") || t.getSenha().equals("") || t.getNome().equals("")
				|| t.getNaturalidade().equals(""))
			throw new BOException("Os campos devem ser preenchidos");

		if (t.getSenha().length() != 40) {
			if (t.getSenha().length() < 6 || t.getSenha().length() > 11)
				throw new BOException("A senha deve ter maior que 6 e menor que 11");
			try {
				t.setSenha(SecurityUtil.criptografarSHA2(t.getSenha()));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				throw new BOException("Erro ao atualizar Usu�rio");
			}
		}
	}

	public Usuario buscarUsuario(String login, String senha) throws BOException, DAOException {
		String senhaHash = "";
		try {
			senhaHash = SecurityUtil.criptografarSHA2(senha);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new BOException("Erro ao atualizar Usu�rio");
		}

		Usuario u = ((DAOUsuario) this.daoT).buscaHQLGenerica(Usuario.class,
				"select u from Usuario as u where u.login like '" + login + "' and " + "u.senha like '" + senhaHash
						+ "' and u.ativado = true");

		if (u == null)
			throw new BOException("N�o foram encontrado um usuario com esse login e senha");

		return u;
	}

	public Usuario buscarUsuario(String login) throws BOException, DAOException {

		Usuario u = ((DAOUsuario) this.daoT).buscaHQLGenerica(Usuario.class,
				"select u from Usuario as u where u.login like '" + login + "' and u.ativado = true");

		if (u == null)
			throw new BOException("N�o foram encontrado um usuario com esse login");

		return u;
	}
	
//	public Usuario buscarUsuarioPorNome(String nome) throws BOException, DAOException {
//
//		Usuario u = ((DAOUsuario) this.daoT).buscaHQLGenerica(Usuario.class,
//				"select u from Usuario as u where u.nome like '" + nome + "' and u.ativado = true");
//
//		if (u == null)
//			throw new BOException("N�o foram encontrado um usuario com esse login");
//
//		return u;
//	}
	
	public Usuario buscarUsuarioPorNomeTipo(String nome, String tipo) throws BOException, DAOException {

		Usuario u = ((DAOUsuario) this.daoT).buscaHQLGenerica(Usuario.class,
				"select u from Usuario as u where u.nome like '" + nome + "' and u.tipo like '" + tipo
						+ "' and u.ativado = true");

		if (u == null)
			throw new BOException("N�o foram encontrado um usuario com esse login");

		return u;
	}
	
	public List<Usuario> buscarUsuarioPorTipo(String tipo) throws BOException, DAOException {
		
		return 	((DAOUsuario) this.daoT).buscaListaHQLGenerica(Usuario.class,
				"select u from Usuario as u where u.tipo like '" + tipo + "' and u.ativado = true");
	}
	
	public List<Usuario> buscarUsuarioPorResertSenha() throws BOException, DAOException {
		
		return 	((DAOUsuario) this.daoT).buscaListaHQLGenerica(Usuario.class,
				"select u from Usuario as u where u.resetSenha = true and u.ativado = true");
	}
}
