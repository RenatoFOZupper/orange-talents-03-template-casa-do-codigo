package br.com.zupacademy.renato.casadocodigo.livro;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.renato.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.renato.casadocodigo.categoria.CategoriaRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	private AutorRepository autorRepository;
	private CategoriaRepository categoriaRepository;
	private LivroRepository livroRepository;

	// Injecao de Dependencia via construtor

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
	@Transactional
	public ResponseEntity<List<LivroResponse>> buscaTodosLivros() {
		List<Livro> lista = livroRepository.findAll();
		List<LivroResponse> listaResponse = lista.stream().map(LivroResponse::new).collect(Collectors.toList());
		return ResponseEntity.ok(listaResponse);
	}

	@GetMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<DetalhesLivroResponse> detalhesDoLivro(@PathVariable Long id) {
		Optional<Livro> optional = livroRepository.findById(id);
		if (optional.isPresent()) {
			Livro livro = optional.get();
			DetalhesLivroResponse response = new DetalhesLivroResponse(livro);
			return ResponseEntity.ok().body(response);
		}
		return ResponseEntity.notFound().build();
	}

}
