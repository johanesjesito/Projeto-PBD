package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
@NamedQuery(name = "Endereco.usuario", query = "select e from Endereco as e where e.ativado = true and e.usuario = :usuario")
public class Endereco extends Entidade {
	
	@Column(nullable = false)
	private int numero;
	@Column(nullable = false)
	private String rua;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String estado;
	@Column(nullable = false)
	private String cep;
	@OneToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
