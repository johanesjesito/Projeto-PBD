package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turmaaluno")
public class TurmaAluno extends Entidade{
	
	@Column(nullable = false)
	private String turma;
	@Column(nullable = false)
	private int ano_letivo;
	@OneToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;
	
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public int getAno_letivo() {
		return ano_letivo;
	}
	public void setAno_letivo(int ano_letivo) {
		this.ano_letivo = ano_letivo;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
