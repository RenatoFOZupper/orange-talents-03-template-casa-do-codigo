package br.com.zupacademy.renato.casadocodigo.Autor;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime instante = LocalDateTime.now();

	public Autor(String nome, String email, String descricao) {
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
