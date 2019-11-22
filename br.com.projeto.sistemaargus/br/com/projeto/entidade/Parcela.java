package br.com.projeto.entidade;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parcela")
public class Parcela extends Entidade {

	@Column(unique = true, nullable = false)
	private String codigo;
	@Column(nullable = false)
	private double valor;
	@Column(name = "data_inicial", nullable = false)
	private LocalDate dataInicial;
	@Column(name = "data_vencimento", nullable = false)
	private LocalDate dataVencimento;
	@Column(nullable = false)
	private String pedente;
	@OneToOne
	@JoinColumn(name = "turmaaluno_id", nullable = false)
	private TurmaAluno turmaAluno;
	@OneToOne
	@JoinColumn(name = "responsavel_id", nullable = false)
	private Responsavel responsavel;
		
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public TurmaAluno getTurmaAluno() {
		return turmaAluno;
	}
	public void setTurmaAluno(TurmaAluno turmaAluno) {
		this.turmaAluno = turmaAluno;
	}
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public String getPedente() {
		return pedente;
	}
	public void setPedente(String pedente) {
		this.pedente = pedente;
	}

}
