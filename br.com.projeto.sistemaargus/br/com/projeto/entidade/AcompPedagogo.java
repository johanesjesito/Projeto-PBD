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
	private String situacao;
	@Column(nullable = false)
	private String relatorio_Acomp;
	@Column(nullable = false)
	private String relatorio_Profissional;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	@Column(nullable = false)
	private String secao;
	@OneToOne
	@JoinColumn(name = "Pedagogo_id", nullable = false)
	private Pedagogo pedagogo;
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getRelatorio_Acomp() {
		return relatorio_Acomp;
	}
	public void setRelatorio_Acomp(String relatorio_Acomp) {
		this.relatorio_Acomp = relatorio_Acomp;
	}
	public String getRelatorio_Profissional() {
		return relatorio_Profissional;
	}
	public void setRelatorio_Profissional(String relatorio_Profissional) {
		this.relatorio_Profissional = relatorio_Profissional;
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
	
}
