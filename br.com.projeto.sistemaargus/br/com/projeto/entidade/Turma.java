package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
//@NamedQuery(name = "Pesquisa.pessoa", query = "select p from Pesquisa as p where p.ativado = true and p.usuario = :usuario")
public class Turma extends Entidade {

	@Column(nullable = false)
	private String Alunos;
	@Column(nullable = false)
	private String professor;
	@Column(nullable = false)
	private String situacao;
	@Column(nullable = false)
	private int vagas;
	@Column(nullable = false)
	private String disciplina;
	public String getAlunos() {
		return Alunos;
	}
	public void setAlunos(String alunos) {
		Alunos = alunos;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public int getVagas() {
		return vagas;
	}
	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
}
