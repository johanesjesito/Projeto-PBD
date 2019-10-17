package br.com.projeto.business;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.com.projeto.dao.DAOUsuario;
import br.com.projeto.entidade.Usuario;
import br.com.projeto.exceptions.BOException;
import br.com.projeto.exceptions.DAOException;
import br.com.projeto.util.SecurityUtil;
import br.com.projeto.visao.Mensagem;

public class BOUsuario extends BO<Usuario>{

	public BOUsuario() {
		super(new DAOUsuario(), Usuario.class);
	}
	
	@Override
	protected void validacaoInsercao(Usuario t) throws BOException {
		super.validacaoInsercao(t);
		if(t.getNome().equals("") 
				|| t.getLogin().equals("") 
				|| t.getSenha().equals(""))
			throw new BOException("Os campos devem ser preenchidos");
		if(t.getSenha().length() < 6 || t.getSenha().length() > 11) 
			throw new BOException("A senha deve ter maior que 6 e menor que 11");
		try 
		{
			t.setSenha(SecurityUtil.criptografarSHA2(t.getSenha()));
		} 
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			throw new BOException("Erro ao Inserir Usuário");
		}
	}
	
	@Override
	protected void validacaoAtualizacao(Usuario t) throws BOException {
		super.validacaoAtualizacao(t);
		if(t.getNome().equals("") 
				|| t.getLogin().equals("") 
				|| t.getSenha().equals(""))
			throw new BOException("Os campos devem ser preenchidos");
		
		if(t.getSenha().length() != 40)
		{
			if(t.getSenha().length() < 6 || t.getSenha().length() > 11)
				throw new BOException("A senha deve ter maior que 6 e menor que 11");
			try 
			{
				t.setSenha(SecurityUtil.criptografarSHA2(t.getSenha()));
			} 
			catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
			{
				throw new BOException("Erro ao atualizar Usuário");
			}
		}
	}
	
	public Usuario buscarUsuario(String login, String senha) throws BOException, DAOException
	{
		String senhaHash = "";
		try 
		{
			senhaHash = SecurityUtil.criptografarSHA2(senha);
		} 
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			throw new BOException("Erro ao atualizar Usuário");
		}
		
		Usuario u = ((DAOUsuario)this.daoT).buscaHQLGenerica(Usuario.class, 
				"select u from Usuario as u where u.login like '" + login + "' and " +
				"u.senha like '" + senhaHash + "' and u.ativado = true");
		
		if(u == null) throw new BOException("Não foram encontrado um usuario com esse login e senha");
		
		return u;
	}
}
