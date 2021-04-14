package br.com.zupacademy.renato.casadocodigo.cliente;

public class ClienteResponse {

	private Long id;
	
	//@Deprecated
	public ClienteResponse() { }; 
	
	public ClienteResponse(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}	
	
	
}
