package persistence;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;

import domain.ClienteInstituicaoPublica;
import domain.ClientePessoaFisica;
import domain.ClientePessoaJuridica;
import domain.Endereco;

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
			//Pessoa Juridica
			cj.setCnpj((long) i);
			cj.setFaturamento(new BigDecimal(500000));
			cj.setRamoAtuacao("Imobiliario");
			cj.setNome("Empresa teste " + i);
			em.persist(c);
			em.persist(cj);
		}

		em.getTransaction().commit();
		
	}
	
	@Test
	@Ignore
	public void criaMaisMassa(){
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		for (int i = 0; i < 50; i++){
			ClienteInstituicaoPublica c = new ClienteInstituicaoPublica();
			c.setNome("Instituicao " + i);
			c.setEstado("SP");
			c.setTelefone1("38552542");
			c.setTelefone2("38552545");
			em.persist(c);
		}
		em.getTransaction().commit();
	}
	
	@Test
	public void testEndereco(){
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		ClientePessoaFisica c = new ClientePessoaFisica();
		Endereco e = new Endereco();
		
		c.setNome("João");
		c.setCpf(4444444444444l);
		c.setRg(5555555555l);
		e.setBairro("bairro teste");
		e.setCidade("cidade teste");
		e.setRua("rua teste");
		e.setCep("33333333333");
		e.setNumero(2);
		c.setEndereco(e);
		
		em.merge(c);
		
	
		
		
		em.getTransaction().commit();
		
		
	}
	
	

}
