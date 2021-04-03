package br.com.zupacademy.renato.casadocodigo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

	@NotBlank
	private String nome;

	@NotBlank
	@Email(message = "Digite um email válido...")
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
