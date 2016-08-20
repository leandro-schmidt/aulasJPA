package repositorio.biblioteca;

import java.util.List;

import javax.persistence.EntityManager;

import domain.biblioteca.Autor;
import domain.biblioteca.Livro;
import persistence.EntityManagerFacade;

public class BibliotecaRepositorio {
	EntityManager em = EntityManagerFacade.em();
	
	public Livro salvaOuAtualizaLivro(Livro l){
		em.getTransaction().begin();
		l = em.merge(l);
		em.getTransaction().commit();
		return l;
	
	}
	
	public List<Livro> buscaPorTituloEAutor(String titulo, Autor autor){
		return em.createQuery("select l from Livro l where l.titulo = :titulo and l.autor.id = :autorId", Livro.class)
				.setParameter("titulo", titulo).setParameter("autorId", autor.getId()).getResultList();
	}
	
	public List<Livro> buscaLivroPorTitulo(String titulo){
		return em.createQuery("select l from Livro l where l.titulo = :titulo", Livro.class).setParameter("titulo", titulo).getResultList();	
	}
	
	public Livro buscaLivroPorId(long id){
		return em.find(Livro.class, id);	
	}
	
	public void removeLivro(Livro l){
		em.getTransaction().begin();
		em.remove(l);
		em.getTransaction().commit();
	}

	
}
