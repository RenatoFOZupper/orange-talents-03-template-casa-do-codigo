package br.com.zupacademy.renato.casadocodigo.pais;

public class PaisResponse {

	private Long id;
	private String nome;

	public PaisResponse(Pais pais) {
		super();
		this.id = pais.getId();
		this.nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
