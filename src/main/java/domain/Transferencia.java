package domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public final class Transferencia extends Transacao  {

	public BigDecimal calculaTransacao(){
			if (super.getContaDestino() == null){
				return super.getValor();
			} else {
				return (super.getValor().multiply(BigDecimal.valueOf(-1l)));
			}
	}
	
	
}
