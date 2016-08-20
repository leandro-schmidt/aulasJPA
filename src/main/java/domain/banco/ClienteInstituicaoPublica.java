package domain.banco;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClienteInstituicaoPublica extends Cliente {
	
	public ClienteInstituicaoPublica(){
		
	}
	
	@Column
	private String telefone1;
	
	@Column
	private String telefone2;
	
	@Column
	private String estado;

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	

}
