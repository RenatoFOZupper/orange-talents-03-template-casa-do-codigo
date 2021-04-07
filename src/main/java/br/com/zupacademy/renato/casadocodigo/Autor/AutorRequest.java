package br.com.zupacademy.renato.casadocodigo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zupacademy.renato.casadocodigo.compartilhado.UniqueValue;

public class AutorRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email(message = "Digite um email válido...")
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;

	@NotBlank
	@Size(max = 400)
	private String descricao;

	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
