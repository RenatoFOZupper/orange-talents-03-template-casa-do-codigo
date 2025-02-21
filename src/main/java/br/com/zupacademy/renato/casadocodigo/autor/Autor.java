package br.com.zupacademy.renato.casadocodigo.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

@Entity
@Table(name = "Autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank 
	private String nome;
	
	@NotBlank 
	@Email 
	@Column(unique = true)
	private String email;
	
	@NotBlank 
	@Size(max = 400)
	private  String descricao;
	
	private LocalDateTime instante = LocalDateTime.now();
	
	public Long getId() {
		return id;
	}
	
	//@Deprecated - HIBERNATE ONLY
	public Autor() { }

	public Autor(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		Assert.hasLength(nome, "O nome é obrigatório");
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor [id = " + id + ", nome = " + nome + ", email = " + email + ", descricao = " + descricao + ", instante = "
				+ instante + "]";
	}
}
