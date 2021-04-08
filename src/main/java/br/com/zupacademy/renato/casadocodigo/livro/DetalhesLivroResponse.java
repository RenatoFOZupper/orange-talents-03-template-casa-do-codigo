package br.com.zupacademy.renato.casadocodigo.livro;

import br.com.zupacademy.renato.casadocodigo.Autor.Autor;
import br.com.zupacademy.renato.casadocodigo.Categoria.Categoria;

public class DetalhesLivroResponse {

	private String titulo;
	private String resumo;
	private String sumario;
	private Integer numeroDePaginas;
	private String isbn;
	private Autor autor;
	private Categoria categoria;

	public DetalhesLivroResponse(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.autor = livro.getAutor();
		this.categoria = livro.getCategoria();
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

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
