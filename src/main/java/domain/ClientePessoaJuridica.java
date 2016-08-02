package domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClientePessoaJuridica extends Cliente{
	
	public ClientePessoaJuridica(){
		
	}
	
	@Column(unique=true)
	private long cnpj;
	
	@Column
	private BigDecimal faturamento;
	
	@Column
	private String ramoAtuacao;

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public BigDecimal getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(BigDecimal faturamento) {
		this.faturamento = faturamento;
	}

	public String getRamoAtuacao() {
		return ramoAtuacao;
	}

	public void setRamoAtuacao(String ramoAtuacao) {
		this.ramoAtuacao = ramoAtuacao;
	}
	

}
