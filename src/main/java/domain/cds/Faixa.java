package domain.cds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Faixa {
	
	public Faixa(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	private CD cd;
	
	private String nome;
	
	private int numero;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public Faixa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public int getNumero() {
		return numero;
	}

	public Faixa setNumero(int numero) {
		this.numero = numero;
		return this;
	}

	public CD getCd() {
		return cd;
	}

	public Faixa setCd(CD cd) {
		this.cd = cd;
		return this;
	}

}
