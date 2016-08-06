package domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Agencia {
	
	public Agencia(){
		
	}
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "agencia")
	private Collection<ClientePessoaFisica> clientesPf;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Collection<ClientePessoaJuridica> clientesJu;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Collection<ClienteInstituicaoPublica> clientesIp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	private String nomeGerente;
	private int numero;
	private String telefone;



	public Collection<ClientePessoaFisica> getClientesPf() {
		return clientesPf;
	}

	public void setClientesPf(Collection<ClientePessoaFisica> clientesPf) {
		this.clientesPf = clientesPf;
	}

	public Collection<ClientePessoaJuridica> getClientesJu() {
		return clientesJu;
	}

	public void setClientesJu(Collection<ClientePessoaJuridica> clientesJu) {
		this.clientesJu = clientesJu;
	}

	public Collection<ClienteInstituicaoPublica> getClientesIp() {
		return clientesIp;
	}

	public void setClientesIp(Collection<ClienteInstituicaoPublica> clientesIp) {
		this.clientesIp = clientesIp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	

}
