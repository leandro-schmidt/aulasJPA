package domain.banco;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClientePessoaFisica extends Cliente {
	
	public ClientePessoaFisica(){
		
	}
	
	@Column
	private String telefone;
	
	@Column
	private BigDecimal renda;
	
	@Column(unique=true)
	private long cpf;
	
	@Column(unique=true)
	private long rg;
	
	@Column
	private Date dataNascimento;
		
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public BigDecimal getRenda() {
		return renda;
	}
	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getRg() {
		return rg;
	}
	public void setRg(long rg) {
		this.rg = rg;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
