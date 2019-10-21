package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
//@NamedQuery(name = "Pesquisa.pessoa", query = "select p from Pesquisa as p where p.ativado = true and p.usuario = :usuario")
public class Curriculo extends Entidade {

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private boolean BiTreMestre;
	@Column(nullable = false)
	private int anoLetivo;
	@Column(nullable = false)
	private String disciplinas_alocadas;
	@Column(nullable = false)
	private String status;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isBiTreMestre() {
		return BiTreMestre;
	}
	public void setBiTreMestre(boolean biTreMestre) {
		BiTreMestre = biTreMestre;
	}
	public int getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public String getDisciplinas_alocadas() {
		return disciplinas_alocadas;
	}
	public void setDisciplinas_alocadas(String disciplinas_alocadas) {
		this.disciplinas_alocadas = disciplinas_alocadas;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
