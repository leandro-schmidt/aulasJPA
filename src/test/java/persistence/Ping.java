package persistence;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Ignore;
import org.junit.Test;

import domain.Agencia;
import domain.ClienteInstituicaoPublica;
import domain.ClientePessoaFisica;
import domain.ClientePessoaJuridica;
import domain.ContaCorrente;
import domain.Debito;
import domain.Deposito;
import domain.Endereco;
import domain.Pacote;
import domain.Saque;
import domain.Transferencia;
import junit.framework.Assert;

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
	@Ignore
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
	
	
	@Test
	@Ignore
	public void testAgencia(){
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		ClientePessoaFisica c = new ClientePessoaFisica();
		Endereco e = new Endereco();
		Endereco e2 = new Endereco();
		Agencia a = new Agencia();
		
		
		c.setNome("João");
		c.setCpf(4444444444444l);
		c.setRg(5555555555l);
		e.setBairro("bairro teste");
		e.setCidade("cidade teste");
		e.setRua("rua teste");
		e.setCep("33333333333");
		e.setNumero(2);
		c.setEndereco(e);
		
		e2.setBairro("bairro teste agencia");
		e2.setCidade("cidade teste agencia");
		e2.setRua("rua teste agencia");
		e2.setCep("33333333333 agencia");
		e2.setNumero(2);
		
		a.setEndereco(e2);
		a.setNomeGerente("nome teste");
		a.setClientesPf(Arrays.asList(c));
		c.setAgencia(a);
		em.merge(a);
		
		em.getTransaction().commit();	
	}
	

	@Test
	@Ignore
	public void testPacote(){
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		ClientePessoaFisica c = new ClientePessoaFisica();
		Endereco e = new Endereco();
		
		Pacote p = new Pacote();
		Pacote p2 = new Pacote();
		p.setCusto(new BigDecimal(1000));
		p.setData(new Date());
		p.setDescricao("pacote BÃO");
		p.setNome("teste pacote");
		
		p2.setCusto(new BigDecimal(10000));
		p2.setData(new Date());
		p2.setDescricao("pacote MAIS BÃO");
		p2.setNome("teste pacote 2");

		
		c.setNome("João");
		c.setCpf(4444444444444l);
		c.setRg(5555555555l);
		e.setBairro("bairro teste");
		e.setCidade("cidade teste");
		e.setRua("rua teste");
		e.setCep("33333333333");
		e.setNumero(2);
		c.setEndereco(e);
		c.setPacotes(Arrays.asList(p, p2));
		em.merge(c);
		
		em.getTransaction().commit();	
	}

	@Test
	public void testeTransacoes(){
		EntityManager em = EntityManagerFacade.em();
		em.getTransaction().begin();
		ClientePessoaFisica c = new ClientePessoaFisica();
		Endereco e = new Endereco();
		Endereco e2 = new Endereco();
		Agencia a = new Agencia();
		ContaCorrente cc = new ContaCorrente();
		Deposito d = new Deposito();
		Saque s = new Saque();
		Transferencia t = new Transferencia();
		
		
		c.setNome("João");
		c.setCpf(4444444444444l);
		c.setRg(5555555555l);
		e.setBairro("bairro teste");
		e.setCidade("cidade teste");
		e.setRua("rua teste");
		e.setCep("33333333333");
		e.setNumero(2);
		c.setEndereco(e);
		
		e2.setBairro("bairro teste agencia");
		e2.setCidade("cidade teste agencia");
		e2.setRua("rua teste agencia");
		e2.setCep("33333333333 agencia");
		e2.setNumero(2);
		
		a.setEndereco(e2);
		a.setNomeGerente("nome teste");
		a.setClientesPf(Arrays.asList(c));
		c.setAgencia(a);
		
		cc.setDataCriacao(new Date());
		cc.setNumero("33333");
		
		d.setValor(new BigDecimal(3000));
		d.setConta(cc);
		s.setValor(new BigDecimal(500));
		s.setConta(cc);
		t.setValor(new BigDecimal(500));
		t.setConta(cc);
		t.setContaDestino(new ContaCorrente());
		
		cc.setTransacoes(Arrays.asList(d, s, t));
		em.merge(a);
		em.merge(cc);
		
		em.getTransaction().commit();
		
		assertEquals(new BigDecimal(2000), cc.getSaldo());
		
		
	}
}