package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma extends Entidade {

	@Column(nullable = false)
	private String turma;
	@OneToOne
	@JoinColumn(name = "disciplina_id", nullable = false)
	private Disciplina disciplina;
	@OneToOne
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
