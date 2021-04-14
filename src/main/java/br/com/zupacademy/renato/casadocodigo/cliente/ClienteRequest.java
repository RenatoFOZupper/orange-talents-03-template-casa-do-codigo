package br.com.zupacademy.renato.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.renato.casadocodigo.compartilhado.EntityIdMustExist;
import br.com.zupacademy.renato.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.renato.casadocodigo.estado.Estado;
import br.com.zupacademy.renato.casadocodigo.pais.Pais;


public class ClienteRequest {
	
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	@NotBlank private String email;
	
	@NotBlank private String nome;
	
	@NotBlank private String sobrenome;
	
	//@CpfOuCnpjValidation
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@NotBlank private String documento;
	
	@NotBlank private String endereco;
	
	@NotBlank private String complemento;
	
	@NotBlank private String cidade;
	
	@EntityIdMustExist(domainClass = Pais.class, fieldName = "id")
	@NotNull private Long idPais;
	
	private Long idEstado;
	
	@NotBlank private String telefone;
	
	@NotBlank private String cep;

	public ClienteRequest(@Valid @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	public Cliente toModel(EntityManager em) {				
		Pais pais = em.find(Pais.class, idPais);
		
		Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
		
		if (this.idEstado != null) {
			Estado estado = em.find(Estado.class, idEstado);
			
			if (estado.getPais() != pais) {
				throw new ResponseStatusException(HttpStatus.CONFLICT ,"verifique se esse"+ estado.getNome() + "pertence relamente a "+ pais.getNome());
			}
			
			cliente.setEstado(estado);
		}
		
		return cliente;
	}

}
