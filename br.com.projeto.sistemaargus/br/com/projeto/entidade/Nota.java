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
	private double nota1;
	@Column(nullable = false)
	private double nota2;
	@Column(nullable = false)
	private double nota3;
	@Column
	private double nota4;
	@Column(nullable = false)
	private double media_parcial;
	@Column
	private double notaFinal;
	@Column(nullable = false)
	private double media_geral;
	@Column(nullable = false)
	private int ano_letivo;
	@Column(nullable = false)
	private String bimestral_trimestral;
	@OneToOne
	@JoinColumn(name = "turmaaluno_id", nullable = false)
	private TurmaAluno turmaaluno;
	@OneToOne
	@JoinColumn(name = "turmadisciplina_id", nullable = false)
	private TurmaDisciplina turmaDisciplina;
	@Column(nullable = false)
	private String situacao;
	
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
	public void setAno_letivo(int ano_letivo) {
		this.ano_letivo = ano_letivo;
	}
	public String getBimestral_trimestral() {
		return bimestral_trimestral;
	}
	public void setBimestral_trimestral(String bimestral_trimestral) {
		this.bimestral_trimestral = bimestral_trimestral;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	public TurmaAluno getTurmaaluno() {
		return turmaaluno;
	}
	public void setTurmaaluno(TurmaAluno turmaaluno) {
		this.turmaaluno = turmaaluno;
	}
	public TurmaDisciplina getTurmaDisciplina() {
		return turmaDisciplina;
	}
	public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
		this.turmaDisciplina = turmaDisciplina;
	}
}
