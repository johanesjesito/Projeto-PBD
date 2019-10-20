package br.com.projeto.entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "acomp_pedagogo")
//@NamedQuery(name = "Pesquisa.pessoa", query = "select p from Pesquisa as p where p.ativado = true and p.usuario = :usuario")
public class AcompPedagogo extends Entidade {

	@Column(nullable = false)
	private String situacao;
	@Column(nullable = false)
	private String relatorio_Acomp;
	@Column(nullable = false)
	private String relatoriosecao;
	@Column(name = "data", nullable = false)
	private LocalDate data;
	
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
	public String getRelatoriosecao() {
		return relatoriosecao;
	}
	public void setRelatoriosecao(String relatoriosecao) {
		this.relatoriosecao = relatoriosecao;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
