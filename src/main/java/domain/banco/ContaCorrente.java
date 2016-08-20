package domain.banco;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ContaCorrente {
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Transacao> transacoes;
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<ClientePessoaFisica> clientesPessoaFisica;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<ClientePessoaJuridica> clientesPessoaJuridica;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private List<ClienteInstituicaoPublica> clientesInstituicaoPublica;
	
	@Column
	private String numero;
	
	@Column
	private Date dataCriacao;

	
	public List<ClientePessoaFisica> getClientesPessoaFisica() {
		return clientesPessoaFisica;
	}

	public void setClientesPessoaFisica(List<ClientePessoaFisica> clientesPessoaFisica) {
		this.clientesPessoaFisica = clientesPessoaFisica;
	}

	public List<ClientePessoaJuridica> getClientesPessoaJuridica() {
		return clientesPessoaJuridica;
	}

	public void setClientesPessoaJuridica(List<ClientePessoaJuridica> clientesPessoaJuridica) {
		this.clientesPessoaJuridica = clientesPessoaJuridica;
	}

	public List<ClienteInstituicaoPublica> getClientesInstituicaoPublica() {
		return clientesInstituicaoPublica;
	}

	public void setClientesInstituicaoPublica(List<ClienteInstituicaoPublica> clientesInstituicaoPublica) {
		this.clientesInstituicaoPublica = clientesInstituicaoPublica;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	public BigDecimal getSaldo(){
		BigDecimal saldo = new BigDecimal(0);
		for (Transacao t : this.transacoes){
			saldo = saldo.add(t.calculaTransacao());
		}
		return saldo;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	
}
