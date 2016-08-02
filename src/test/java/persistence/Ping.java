package persistence;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;

import domain.ClienteInstituicaoPublica;
import domain.ClientePessoaFisica;
import domain.ClientePessoaJuridica;

public class Ping {
	
	@Test
	@Ignore
	public void CriaMassa(){
		
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		
		for (int i = 0; i < 50; i++){
			ClientePessoaFisica c = new ClientePessoaFisica();
			ClientePessoaJuridica cj = new ClientePessoaJuridica();			
			//Pessoa fisica
			c.setCpf((long) i);
			c.setDataNascimento(new Date());
			c.setRenda(new BigDecimal(2000));
			c.setRg((long) i);
			c.setTelefone("981016173");
			c.setNome("Pessoa teste " + i);
			c.setCidade("Campinas");
			//Pessoa Juridica
			cj.setCnpj((long) i);
			cj.setFaturamento(new BigDecimal(500000));
			cj.setRamoAtuacao("Imobiliario");
			cj.setNome("Empresa teste " + i);
			cj.setCidade("São Paulo");
			em.persist(c);
			em.persist(cj);
		}

		em.getTransaction().commit();
		
	}
	
	@Test
	public void criaMaisMassa(){
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		for (int i = 0; i < 50; i++){
			ClienteInstituicaoPublica c = new ClienteInstituicaoPublica();
			c.setNome("Instituicao " + i);
			c.setCidade("São Paulo");
			c.setEstado("SP");
			c.setTelefone1("38552542");
			c.setTelefone2("38552545");
			em.persist(c);
		}
		em.getTransaction().commit();
	}
	

}
