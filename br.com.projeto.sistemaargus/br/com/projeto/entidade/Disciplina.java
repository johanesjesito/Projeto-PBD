package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina extends Entidade {

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int cargaHoraria;
	@Column(nullable = false)
	private String status_disciplina;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getStatus_disciplina() {
		return status_disciplina;
	}
	public void setStatus_disciplina(String status_disciplina) {
		this.status_disciplina = status_disciplina;
	}
	
}
