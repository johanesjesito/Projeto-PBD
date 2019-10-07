/**
 * 
 */
package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Entidade{

	@Column(nullable = false)
	private String nome;
	@Column(unique = true, nullable = false)
	private String login;
	@Column(nullable = false)
	private String senha;
	
	public String getNome() {return nome;}
	public String getLogin() {return login;}
	public String getSenha() {return senha;}

	public void setNome(String nome) {this.nome = nome;}
	public void setLogin(String login) {this.login = login;}
	public void setSenha(String senha) {this.senha = senha;}
		
	
}
