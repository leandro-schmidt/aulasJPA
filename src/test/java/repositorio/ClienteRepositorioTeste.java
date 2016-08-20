package repositorio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domain.banco.ClientePessoaFisica;

public class ClienteRepositorioTeste {

	@Test
	public void buscarTodosTest(){
		ClienteRepositorio rep = new ClienteRepositorio();
		List<ClientePessoaFisica> clientes = rep.findAll();
		assertEquals(1, clientes.size());
	} 
	
	@Test
	public void buscarClientePorCidade(){
		ClienteRepositorio rep = new ClienteRepositorio();
		List<ClientePessoaFisica> clientes = rep.findByCity("cidade teste");
		assertEquals(1, clientes.size());
	}
	
	@Test
	public void buscarTodosClientesDaAgencia(){
		ClienteRepositorio rep = new ClienteRepositorio();
		List<ClientePessoaFisica> clientes = rep.findByAgency(0);
		assertEquals(1, clientes.size());
	}
	
	@Test
	public void buscarTodosGerentes(){
		ClienteRepositorio rep = new ClienteRepositorio();
		List<String> clientes = rep.findAllManagers();
		assertEquals(1, clientes.size());
	}
	
	
}
