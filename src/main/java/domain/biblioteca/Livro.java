package domain.biblioteca;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Livro {
	
	public Livro(){}
	
	private boolean emprestado;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Autor autor;
	
	private String titulo;
	
	private String categoria;
	
	private Date dataPublicacao;

	public long getId() {
		return id;
	}

	public Livro setId(long id) {
		this.id = id;
		return this;
	}

	public Autor getAutor() {
		return autor;
	}

	public Livro setAutor(Autor autor) {
		this.autor = autor;
		return this;
	}

	public String getTitulo() {
		return titulo;
	}

	public Livro setTitulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public String getCategoria() {
		return categoria;
	}

	public Livro setCategoria(String categoria) {
		this.categoria = categoria;
		return this;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public Livro setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
		return this;
	}

	public boolean isEmprestado() {
		return emprestado;
	}

	public Livro setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
		return this;
	}

}
