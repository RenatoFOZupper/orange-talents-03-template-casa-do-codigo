package br.com.zupacademy.renato.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

	@PersistenceContext
	private EntityManager em;

	@PostMapping(value = "/clientes")
	@Transactional
	public ResponseEntity<ClienteResponse> cadastra(@RequestBody @Valid ClienteRequest request) {
		Cliente cliente = request.toModel(em);
		em.persist(cliente);
		ClienteResponse response = new ClienteResponse(cliente.getId());
		return ResponseEntity.ok(response);
	}
}
