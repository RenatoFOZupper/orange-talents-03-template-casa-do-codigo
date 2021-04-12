package br.com.zupacademy.renato.casadocodigo.livro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import br.com.zupacademy.renato.casadocodigo.autor.Autor;
import br.com.zupacademy.renato.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.renato.casadocodigo.categoria.Categoria;
import br.com.zupacademy.renato.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.renato.casadocodigo.compartilhado.EntityIdMustExist;
import br.com.zupacademy.renato.casadocodigo.compartilhado.UniqueValue;

public class LivroRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;

	@NotBlank
	@Size(min = 5, max = 500)
	private String resumo;

	private String sumario;

	@NotNull
	@Min(20)
	private BigDecimal preco;

	@NotNull
	@Min(100)
	private Integer numeroDePaginas;

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDePublicacao;

	@NotNull
	@EntityIdMustExist(domainClass = Autor.class, fieldName = "id")
	private Long autorId;

	@NotNull
	@EntityIdMustExist(domainClass = Categoria.class, fieldName = "id")
	private Long categoriaId;

	// @Deprecated
	public LivroRequest() {	}

	public LivroRequest(@NotBlank String titulo, @NotBlank @Size(min = 5, max = 500) String resumo, String sumario,
			@Min(20) BigDecimal preco, @Min(100) Integer numeroDePaginas, @NotBlank String isbn,
			@Future LocalDate dataDePublicacao, Long autorId, Long categoriaId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.autorId = autorId;
		this.categoriaId = categoriaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}
	
	//Método que converte um objeto tipo LivroRequest em Livro atrelando o autor e categoria pelo id

	public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.getOne(autorId);
		Categoria categoria = categoriaRepository.getOne(categoriaId);

		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn,
				dataDePublicacao, autor, categoria);
	}

}
