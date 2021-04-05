package br.com.zupacademy.renato.casadocodigo.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager em;

	@PostMapping
	@Transactional
	public String cadastraCategoria(@RequestBody @Valid CategoriaRequest request) {
		Categoria categoria = request.toModel();
		em.persist(categoria);
		return categoria.toString();
	}
	
}
