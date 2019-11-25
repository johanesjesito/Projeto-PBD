package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
public class Curriculo extends Entidade {

	@Column(nullable = false)
	private int ano_letivo;
	@Column(nullable = false)
	private String situacao;
	@Column(nullable = false)
	private String turma;
	@OneToOne
	@JoinColumn(name = "turmaAluno_id", nullable = false, unique=true)
	private TurmaAluno turmaAluno;

	public int getAno_letivo() {
		return ano_letivo;
	}
	public void setAno_letivo(int ano_letivo) {
		this.ano_letivo = ano_letivo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public TurmaAluno getTurmaAluno() {
		return turmaAluno;
	}
	public void setTurmaAluno(TurmaAluno turmaAluno) {
		this.turmaAluno = turmaAluno;
	}
	
}
