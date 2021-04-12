package br.com.zupacademy.renato.casadocodigo.estado;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.renato.casadocodigo.compartilhado.EstadoPais;
import br.com.zupacademy.renato.casadocodigo.pais.Pais;
import br.com.zupacademy.renato.casadocodigo.pais.PaisRepository;

@EstadoPais
public class EstadoRequest {

	@NotBlank
	private String nome;
	
	
	@NotNull
	private Long idPais;


	public EstadoRequest(@NotBlank String nome, Long idPais) {
		super();
		this.nome = nome;
		this.idPais = idPais;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdPais() {
		return idPais;
	}
	
	public Estado toModel(PaisRepository paisRepository) {
		Optional<Pais> pais = paisRepository.findById(idPais);
		if (pais.isPresent()) {
			return new Estado(nome, pais.get());
		}
		
		throw new IllegalArgumentException("Por favor passe um id válido...");
	}
	
}
