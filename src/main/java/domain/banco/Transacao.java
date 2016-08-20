package domain.banco;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorColumn(name = "tipo_transacao")
public abstract class Transacao {
	
	public Transacao(){
		
	}
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "conta")
	private ContaCorrente conta;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private ContaCorrente contaDestino;
	
	public ContaCorrente getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(ContaCorrente contaDestino) {
		this.contaDestino = contaDestino;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column
	private Date data;
	
	@Column
	private BigDecimal valor;

	public ContaCorrente getConta() {
		return conta;
	}

	public void setConta(ContaCorrente conta) {
		this.conta = conta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public abstract BigDecimal calculaTransacao();

}
