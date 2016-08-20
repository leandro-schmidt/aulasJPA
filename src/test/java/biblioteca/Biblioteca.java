package biblioteca;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import domain.biblioteca.Autor;
import domain.biblioteca.Livro;
import repositorio.biblioteca.BibliotecaRepositorio;

public class Biblioteca {
	
	private BibliotecaRepositorio rep = new BibliotecaRepositorio();
	
	@Test	
	public void testesOperacoes(){
		Livro l = new Livro().setTitulo("Livro teste")
					.setDataPublicacao(new Date())
						.setCategoria("Legais")
							.setEmprestado(Boolean.FALSE)
								.setAutor(new Autor()
									.setDataNascimento(new Date())
										.setNome("João"));
		
		l = adicionarLivro(l);
		// Deve dar erro
		Livro l2 = adicionarLivro(l);
		//Testa busca por titulo e adicionar livro
		assertEquals("Livro teste", consultarLivro("Livro teste").get(0).getTitulo());
		// Empresta livro
		emprestarLivro(l);
		//Deve dar aviso que não pode emprestar
		emprestarLivro(l);
		//Não deve deixar
		removerLivro(l);
		//Devolve livro
		devolverLivro(l);
		//Agora deve deixar
		removerLivro(l);
	}

	public Livro adicionarLivro(Livro l){
		if (rep.buscaPorTituloEAutor(l.getTitulo(),l.getAutor()).isEmpty()){
			l = rep.salvaOuAtualizaLivro(l);	
		} else {
			System.out.println(new StringBuilder().append("Livro duplicado não inserido! Titulo = ") 
					.append(l.getTitulo()).append(" | Autor = ").append(l.getAutor().getId()));
		}
		return l;
	}
	
	public void emprestarLivro(Livro l){
		if (!l.isEmprestado()){
			l.setEmprestado(Boolean.TRUE);
			rep.salvaOuAtualizaLivro(l);
		 } else {
			System.out.println(new StringBuilder().append("Livro já emprestado!"));
		}
	}
	
	public List<Livro> consultarLivro(String titulo){
		return rep.buscaLivroPorTitulo(titulo);
	}
	
	public void removerLivro(Livro l){
		if (!l.isEmprestado()){
			rep.removeLivro(l);
		} else {
			System.out.println(new StringBuilder().append("Livro emprestado não pode ser removido!"));
		}
	}
	
	public void devolverLivro(Livro l){
		if (l.isEmprestado()){
			l.setEmprestado(Boolean.FALSE);
			rep.salvaOuAtualizaLivro(l);
		}
	}

}
