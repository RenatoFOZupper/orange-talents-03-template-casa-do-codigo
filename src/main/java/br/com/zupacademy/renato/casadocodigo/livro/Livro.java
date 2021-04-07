package br.com.zupacademy.renato.casadocodigo.livro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.renato.casadocodigo.Autor.Autor;
import br.com.zupacademy.renato.casadocodigo.Categoria.Categoria;

@Entity
@Table(name = "livros")
public class Livro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String titulo;
	
	@NotBlank
	@Size(min=5, max=500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Min(20)
	private BigDecimal preco;
	
	@NotNull
	@Min(100)
	private Integer numeroDePaginas;
	
	@Column(unique = true)
	private String isbn;
	
	@Future
	private LocalDate dataDePublicacao;

	@NotNull
	@ManyToOne
	private Autor autor;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	// @Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(min = 5, max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroDePaginas, String isbn,
			@Future LocalDate dataDePublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroDePaginas=" + numeroDePaginas + ", isbn=" + isbn + ", dataDePublicacao="
				+ dataDePublicacao + ", autor=" + autor + ", categoria=" + categoria + "]";
	}

}
