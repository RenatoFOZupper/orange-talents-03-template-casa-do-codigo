package br.com.zupacademy.renato.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.renato.casadocodigo.compartilhado.UniqueValue;

public class PaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	@JsonCreator
	public PaisRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
		
	public Pais toModel() {
		return new Pais(this.nome);
	}
	
}
