package br.com.projeto.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
//@NamedQuery(name = "Pesquisa.pessoa", query = "select p from Pesquisa as p where p.ativado = true and p.usuario = :usuario")
public class Nota extends Entidade {

	@Column(nullable = false)
	private double media_parcial;
	@Column(nullable = false)
	private double media_geral;
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
	
}
