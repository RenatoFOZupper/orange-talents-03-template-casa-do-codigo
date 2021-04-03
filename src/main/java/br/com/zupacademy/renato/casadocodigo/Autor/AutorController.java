package br.com.zupacademy.renato.casadocodigo.Autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	@PersistenceContext
	EntityManager em;

	@PostMapping
	@Transactional
	public String criaAutor(@RequestBody @Valid AutorRequest request) {
		Autor autor = request.toModel();
		em.persist(autor);
		return autor.toString();
	}
	
}
