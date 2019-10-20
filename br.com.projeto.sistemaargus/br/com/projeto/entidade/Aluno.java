package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
//@NamedQuery(name = "Pesquisa.pessoa", query = "select p from Pesquisa as p where p.ativado = true and p.usuario = :usuario")
public class Aluno extends Entidade {
	
	@Column(nullable = false)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

