package br.com.zupacademy.renato.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	
	private final EntityManager em;
	
	
	public ClienteController(EntityManager em) {
		super();
		this.em = em;
	}



	@PostMapping(value = "/clientes")
	@Transactional
	public ResponseEntity<Long> cadastra(@RequestBody @Valid ClienteRequest request) {
		Cliente cliente = request.toModel(em);
		em.persist(cliente);
		return ResponseEntity.ok(cliente.getId());
	}
}
