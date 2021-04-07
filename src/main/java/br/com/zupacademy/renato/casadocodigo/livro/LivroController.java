package br.com.zupacademy.renato.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.Autor.AutorRepository;
import br.com.zupacademy.renato.casadocodigo.Categoria.CategoriaRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	private AutorRepository autorRepository;
	private CategoriaRepository categoriaRepository;
	private LivroRepository livroRepository;
	
	//Injecao de Dependencia via construtor

	public LivroController(AutorRepository autorRepository, CategoriaRepository categoriaRepository,
			LivroRepository livroRepository) {
		this.autorRepository = autorRepository;
		this.categoriaRepository = categoriaRepository;
		this.livroRepository = livroRepository;
	}

	@PostMapping
	@Transactional
	public String cadastraLivro(@RequestBody @Valid LivroRequest livroRequest) {
		Livro livro = livroRequest.toModel(autorRepository, categoriaRepository);
		livro = livroRepository.save(livro);
		return livro.toString();
	}
	
	@GetMapping
	public ResponseEntity<List<LivroResponse>> buscaTodosLivros() {
		List<Livro> lista = livroRepository.findAll();
		List<LivroResponse> listaResponse = lista.stream().map(LivroResponse :: new).collect(Collectors.toList());
		return ResponseEntity.ok(listaResponse);
	}
	
	

}
