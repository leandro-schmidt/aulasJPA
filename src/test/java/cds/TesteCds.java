package cds;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import domain.cds.Artista;
import domain.cds.CD;
import domain.cds.Faixa;
import persistence.EntityManagerFacade;

public class TesteCds {
	
	EntityManager em = EntityManagerFacade.em();
	CD cd = new CD();
	
	@Before
	public void before(){
		em.getTransaction().begin();
	}
	
	@After
	public void after(){
		em.getTransaction().commit();
	}
	
	@Test
	@Ignore
	public void testeDeCds(){
		em.merge(cd.setArtista(new Artista().setNome("João")).setFaixas(criaFaixas()));
	}

	private List<Faixa> criaFaixas() {
		List<Faixa> faixas = new ArrayList<Faixa>();
		for (int i = 1; i < 17 ; i++){
			faixas.add(new Faixa().setCd(cd).setNome("Faixa " + i).setNumero(i));
		}
		return faixas;
	}
}
