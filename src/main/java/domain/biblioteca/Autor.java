package domain.biblioteca;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Autor {
	
	public Autor(){}
	
	@Version
	private long versao;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private String nome;
	
	private Date dataNascimento;
	
	public long getId() {
		return id;
	}
	public Autor setId(long id) {
		this.id = id;
		return this;
	}
	public String getNome() {
		return nome;
	}
	public Autor setNome(String nome) {
		this.nome = nome;
		return this;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public Autor setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	public long getVersao() {
		return versao;
	}
	public void setVersao(long versao) {
		this.versao = versao;
	}

}
