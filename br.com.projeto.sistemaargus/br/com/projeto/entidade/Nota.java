package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota extends Entidade {

	@Column(nullable = false)
	private double media_parcial;
	@Column(nullable = false)
	private double media_geral;
	@Column(nullable = false)
	private int ano_letivo;
	@OneToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;
	@OneToOne
	@JoinColumn(name = "disciplina_id", nullable = false)
	private Disciplina disciplina;
	
	public double getMedia_parcial() {
		return media_parcial;
	}
	public void setMedia_parcial(double media_parcial) {
		this.media_parcial = media_parcial;
	}
	public double getMedia_geral() {
		return media_geral;
	}
	public void setMedia_geral(double media_geral) {
		this.media_geral = media_geral;
	}
	public int getAno_letivo() {
		return ano_letivo;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
}
