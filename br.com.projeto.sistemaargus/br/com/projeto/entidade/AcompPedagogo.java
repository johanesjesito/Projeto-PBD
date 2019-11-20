package br.com.projeto.entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acomp_pedagogo")
public class AcompPedagogo extends Entidade {

	@Column(nullable = false)
	private String relatorio_acomp_aluno;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@Column(nullable = false)
	private String situacao;
	@Column(nullable = false)
	private String secao;
	@OneToOne
	@JoinColumn(name = "pedagogo_id", nullable = false)
	private Pedagogo pedagogo;
	@OneToOne
	@JoinColumn(name = "aluno_id", nullable = false)
	private Aluno aluno;
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Pedagogo getPedagogo() {
		return pedagogo;
	}
	public void setPedagogo(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public String getRelatorio_Acomp_Aluno() {
		return relatorio_acomp_aluno;
	}
	public void setRelatorio_Acomp_Aluno(String relatorio_acomp_aluno) {
		this.relatorio_acomp_aluno = relatorio_acomp_aluno;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
