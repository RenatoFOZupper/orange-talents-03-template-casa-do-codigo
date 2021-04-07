package br.com.zupacademy.renato.casadocodigo.livro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.renato.casadocodigo.Autor.Autor;
import br.com.zupacademy.renato.casadocodigo.Categoria.Categoria;

public class LivroRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataDePublicacao;
	private Long autorId;
	private Long categoriaId;

	// @Deprecated
	public LivroRequest() {
	}

	public LivroRequest(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroDePaginas,
			String isbn, LocalDate dataDePublicacao, Long autorId, Long categoriaId) {
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

	public Livro toModel(Autor autor, Categoria categoria) {

		return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.numeroDePaginas, this.isbn,
				dataDePublicacao, autor, categoria);
	}

}
