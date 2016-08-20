package domain.cds;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CD {
	
	public CD(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Artista artista;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy="cd")
	private List<Faixa> faixas;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Artista getArtista() {
		return artista;
	}

	public CD setArtista(Artista artista) {
		this.artista = artista;
		return this;
	}

	public List<Faixa> getFaixas() {
		return faixas;
	}

	public CD setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
		return this;
	}

}
