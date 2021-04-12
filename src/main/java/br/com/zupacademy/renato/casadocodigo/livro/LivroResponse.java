package br.com.zupacademy.renato.casadocodigo.livro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zupacademy.renato.casadocodigo.autor.Autor;
import br.com.zupacademy.renato.casadocodigo.categoria.Categoria;

public class LivroResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroDePaginas;
	private String isbn;
	private LocalDate dataDePublicacao;
	private Autor autor;
	private Categoria categoria;

	// @Deprecated
	public LivroResponse() {
	}
	
	//Construtor para converter um objeto tipo Livro para LivroResponse

	public LivroResponse(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.dataDePublicacao = livro.getDataDePublicacao();
		this.autor = livro.getAutor();
		this.categoria = livro.getCategoria();
	}

	public Long getId() {
		return id;
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

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
