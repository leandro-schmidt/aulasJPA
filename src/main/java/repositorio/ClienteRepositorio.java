package repositorio;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.banco.Agencia;
import domain.banco.ClientePessoaFisica;
import persistence.EntityManagerFacade;

public class ClienteRepositorio {

	private EntityManager em = EntityManagerFacade.em();
	
	public List<ClientePessoaFisica> findAll(){
		String jpql = String.format(" FROM %s", ClientePessoaFisica.class.getName());
		TypedQuery<ClientePessoaFisica> tp = em.createQuery(jpql, ClientePessoaFisica.class);
		return tp.getResultList();
	}
	
	public List<ClientePessoaFisica> findByCity(String cidade){
		String jpql = String.format(" FROM %s where endereco.cidade = :cidade", ClientePessoaFisica.class.getName());
		TypedQuery<ClientePessoaFisica> tp = em.createQuery(jpql, ClientePessoaFisica.class);
		tp.setParameter("cidade", cidade);
		return tp.getResultList();
	}
	
	public List<ClientePessoaFisica> findByAgency(int numero){
		String jpql = String.format(" FROM %s where agencia.numero = :numero", ClientePessoaFisica.class.getName());
		TypedQuery<ClientePessoaFisica> tp = em.createQuery(jpql, ClientePessoaFisica.class);
		tp.setParameter("numero", numero);
		return tp.getResultList();
	}

	public List<String> findAllManagers(){
		List<String> ret = new ArrayList<String>();
		String jpql = String.format(" SELECT o.agencia.nomeGerente FROM %s o order by o.agencia.nomeGerente desc ", ClientePessoaFisica.class.getName());
		TypedQuery<String> tp = em.createQuery(jpql, String.class);
		ret = tp.getResultList();
		return ret;
	} 
	
}
