package domain.banco;

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
	private RamoAtuacao ramoAtuacao;
	
	public enum RamoAtuacao { DIGITAL, IMOBILIARIO, VAREJO };

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

	public RamoAtuacao getRamoAtuacao() {
		return ramoAtuacao;
	}

	public void setRamoAtuacao(RamoAtuacao ramoAtuacao) {
		this.ramoAtuacao = ramoAtuacao;
	}
	

}
