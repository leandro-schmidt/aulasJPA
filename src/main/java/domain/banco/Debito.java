package domain.banco;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public abstract class Debito extends Transacao {
	
	public BigDecimal calculaTransacao(){
		return super.getValor().multiply(BigDecimal.valueOf(-1l));
	}

}
