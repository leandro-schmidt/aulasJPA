package domain.banco;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public abstract class Credito extends Transacao {

	public BigDecimal calculaTransacao(){
		return super.getValor();
	}


}
