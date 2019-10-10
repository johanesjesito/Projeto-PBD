/**
 * 
 */
package br.com.projeto.entidade;

import java.time.LocalDate;

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
	@Column(name = "data_Nascimento", nullable = false)
	private LocalDate dataDeNascimento;
	@Column(nullable = false)
	private String Naturalidade;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private boolean resetSenha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getNaturalidade() {
		return Naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		Naturalidade = naturalidade;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isResetSenha() {
		return resetSenha;
	}
	public void setResetSenha(boolean resetSenha) {
		this.resetSenha = resetSenha;
	}			
	
}
